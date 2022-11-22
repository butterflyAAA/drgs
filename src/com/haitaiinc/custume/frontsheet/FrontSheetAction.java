package com.haitaiinc.custume.frontsheet;

import java.util.ArrayList;
import java.util.List;

import com.haitaiinc.Util;
import com.haitaiinc.dao.EmrDao;
import com.haitaiinc.dao.HisDao;
import com.haitaiinc.hisdb.dictmanage.DictDepart;
import com.haitaiinc.hisdb.dictmanage.TplTemplate;
import com.haitaiinc.hisdb.drgs.BsBaseinfo;
import com.haitaiinc.hisdb.drgs.BsDiseinfo;
import com.haitaiinc.hisdb.drgs.BsOprninfo;
import com.haitaiinc.hisdb.drgs.FrontSheet;
import com.haitaiinc.hisdb.his.PatInpatDiagnosis;
import com.haitaiinc.hisdb.his.VInpatientinfo;
import com.haitaiinc.hisdb.his.VPatientinfo;
import com.haitaiinc.htdb.inpcase.dto.InpDiag;
import com.haitaiinc.servlet.ServletAction;
import com.haitaiinc.servlet.ServletActionMethod;
import com.haitaiinc.xml.XMLDocument;
import com.haitaiinc.xml.XMLNode;
import com.haitaiinc.xml.jaxb.JAXBUtil;

import util.Log;

public class FrontSheetAction  extends ServletAction{

	//http://192.168.3.151:8080/MIWebService/do?module=custume&action=FrontSheet&method=frontSheetMain&zylsh=16654
	@ServletActionMethod(verifyUser=false)
	public void frontSheetMain() throws Exception {
		String zylsh=getParameter("zylsh");
		HisDao hd= new HisDao();
		VInpatientinfo inp=hd.getVInpatientinfoByIpid(zylsh);
		
		if(inp!=null) {

			if(Util.isEmpty(inp.getD4401())||"-1".equals(inp.getD4401())) {

				VPatientinfo pat= hd.getVPatientinfoByPid(inp.getPid());
				setAttribute("inp", inp);
				setAttribute("pat", pat);

				//手术表
				List<BsOprninfo> boList=hd.featchBsOprninfo(zylsh,pat.getOrgid());
				String oprationInfoStr=getOperaAndMinorXmlStr(boList);
				setAttribute("oprationInfoStr", oprationInfoStr);
				//诊断表
				List<BsDiseinfo> bdList=hd.featchPatInpDiagnosis(zylsh,pat.getOrgid());
				String diagsXmlstr=getDiagXmlStr(zylsh,inp.getPid(),bdList);
				setAttribute("boList", boList);
				setAttribute("bdList", bdList);
				setAttribute("diagsXmlstr", toBase64(diagsXmlstr));


				String allInfo="<InpAllInfo/>";
				XMLDocument xd = XMLDocument.parse(allInfo);
				XMLNode xnode = xd.getDocumentElement().selectSingleNode("Patient");

				if (xnode != null) {
					xd.getDocumentElement().removeChild(xnode);
				}
				xnode = xd.getDocumentElement().selectSingleNode("Inpatient");
				if (xnode != null) {
					xd.getDocumentElement().removeChild(xnode);
				}
				XMLDocument xdoc = XMLDocument.parse(JAXBUtil.marshal(pat));
				xnode = xdoc.getDocumentElement();
				xnode.setAttribute("keyName", "Pid");
				xnode.setAttribute("keyValue", pat.getPid());
				xnode.setAttribute("schema", "MPI");
				xd.getDocumentElement().appendChild(xnode);

				xdoc = XMLDocument.parse(JAXBUtil.marshal(inp));
				xnode = xdoc.getDocumentElement();
				xnode.setAttribute("keyName", "Ipid");
				xnode.setAttribute("keyValue", inp.getIpid());
				xnode.setAttribute("schema", "ADT");
				xd.getDocumentElement().appendChild(xnode);

				allInfo=xd.getOuterXML();
				if(allInfo!=null) {
					allInfo=allInfo.replaceAll("VPatientinfo", "Patient");
					allInfo=allInfo.replaceAll("VInpatientinfo", "Inpatient");
				}
				setAttribute("inpAllInfo",allInfo);

				FrontSheet fs=new HisDao().getFrontSheetByIpid(inp.getIpid());
				if(fs!=null&&fs.getIpid()!=null) {

				}else {
					fs=new FrontSheet();
					//				com.haitaiinc.htdb.template.dto.TplTemplate emrtt= new EmrDao().getTplTemplateByTplId("7DFFFD2E7BC74B9A839CA979A0EF1E43");
					TplTemplate emrtt=hd.getTplTemplate();
					fs.setXmlCont(emrtt.getTplData());
					fs.setTplID(emrtt.getTplID());
					fs.setTplVersion(emrtt.getTplVersion());
				}
				setAttribute("fs", fs);
			}else {
				FrontSheet fs=new HisDao().getFrontSheetByIpid(inp.getIpid());
				setAttribute("fs", fs);
				setAttribute("D4401", inp.getD4401());
			}
			forward("frontsheet/front-sheet-main.jsp");
		}else {

		}

	}

	@ServletActionMethod(verifyUser=false)
	public String frontSheetSave() {

		String ret = "保存成功";
		try {
		String invarlidinfo = getParameter("invarlidinfo");
		String allInfo = getParameter("allInfo");
		if (allInfo != null && allInfo.trim().length() > 0) {
			allInfo = new String(Util.fromBASE64(allInfo)); 
		}
		String recordContent = getParameter("recordContent");
		if (recordContent != null && recordContent.trim().length() > 0) {
			recordContent = new String(Util.fromBASE64(recordContent));
			recordContent.replace("&#x0;", "&amp;#x0;");
		}
		String isAdd=getParameter("isAdd");
		FrontSheet fs=new FrontSheet();
		String ipid=getParameter("ipid");
		String pid=getParameter("pid");
		HisDao hd= new HisDao();
		VInpatientinfo inp=hd.getVInpatientinfoByIpid(ipid);
		VPatientinfo pat= hd.getVPatientinfoByPid(inp.getPid());
		fs.setIpid(ipid);
		fs.setPid(pid);
		fs.setXmlCont(recordContent);
		fs.setTplID(getParameter("tplId"));
		fs.setTplVersion(getParameter("tplVersion"));
		String currentDate=Util.getCurrentDate("yyyyMMddHHmmss");
		if("true".equals(isAdd)) {
			fs.setCreateTime(currentDate);
		}
		fs.setModifyTime(currentDate);

		//


		/**
		 * 医院科室对应医保科室
		 */
		List<DictDepart> hisDeptList= new HisDao().getDictDepart();
		/**
		 * 处理病案首页基本信息
		 */
		BsBaseinfo base=new BsBaseinfo();
		base.setPatnIptCnt(inp.getAdmissionTimes());//患者住院次数
		base.setIptNo(ipid);//住院号
		base.setMedcasno(inp.getAdminissionNo());	//病案号
		base.setPsnName(inp.getPatientName());//	人员姓名
		base.setGend(inp.getSexCode());	//性别
		base.setBrdy(Util.format(pat.getDataOfBirth(), "yyyy-MM-dd"));	//出生日期
		base.setNtly(DictMapping.nat_regn_code(pat.getCountryCode()));	//国籍
		base.setNtlyName(pat.getCountry());	//国籍名称

		base.setAdmCaty(DictMapping.caty(inp.getAdmissionDept(), hisDeptList));	//入院科别
		base.setAdmWard(inp.getAdmissionWard());//	入院病房
		base.setAdmDate(Util.format(inp.getAdmissionTime(), "yyyy-MM-dd HH:mm:ss"));//	入院日期
		base.setDscgDate(Util.format(inp.getDischargeTime(), "yyyy-MM-dd HH:mm:ss"));//	出院日期
		base.setDscgCaty(DictMapping.caty(inp.getDeptName(), hisDeptList));//	出院科别
		base.setDscgWard(inp.getWardName());//	出院病房
		String inHopitalDay = inp.getInHopitalDay();
		
		try {
			if(!Util.isEmpty(inHopitalDay))
				inHopitalDay = inHopitalDay.replace("天", "");
		}catch (Exception e) {
			
		} 
		base.setIptDays(inHopitalDay);//	住院天数
		base.setMrgStas(inp.getMarriageStatusCode());	//婚姻状态
		base.setAge(inp.getAge());	//年龄

		base.setMedfeeSumamt(Util.isEmpty(inp.getDqFyze())?inp.getDqFyze():inp.getDqYjjze());	//医疗费总额
		base.setValiFlag("1");	//有效标志
		base.setBrxh(ipid);
		base.setJgdm(pat.getOrgid());

		String COMA_BEFORE_DAY="";
		String COMA_BEFORE_HOUR="";
		String COMA_BEFORE_MINUTE="";
		String COMA_AFTER_DAY="";
		String COMA_AFTER_HOUR="";
		String COMA_AFTER_MINUTE="";
		String recordContentStuct = getParameter("recordContentStuct");
		XMLDocument xd = XMLDocument.parse(recordContentStuct);
		XMLNode[] xn = xd.selectNodes("structs");
		for (int i = 0; i < xn.length; i++) {
			XMLNode node = xn[i];
			XMLNode[] childNodes = node.getChildNodes();
			for (int j = 0; j < childNodes.length; j++) {
				XMLNode xmlnode = childNodes[j];
				String structID=xmlnode.getAttribute("id");
				String eleValue=xmlnode.getAttribute("value");
				if(!Util.isEmpty(eleValue)) {
					eleValue.trim();
				}
				if("CHILD_WEIGHT".equals(structID)) {
					try {
						Double.parseDouble(eleValue);
						base.setNwbBirWt(eleValue);	//新生儿出生体重
					}catch (Exception e) {
						
					} 
				}

				if("CHILD_ADMISSION_WEIGHT".equals(structID)) {
					try {
						Double.parseDouble(eleValue);
						base.setNwbAdmWt(eleValue);	//新生儿入院体重
					}catch (Exception e) {
					} 
				}

				if("BirthPlace".equals(structID)) {
					base.setBirplc(eleValue);//	出生地
				}
				if("NativePlace".equals(structID)) {
					base.setNapl(eleValue);//	籍贯
				}
				if("Nationality".equals(structID)) {	
					base.setNatyName(eleValue);	//民族名称
					base.setNaty(DictMapping.naty(eleValue));	//民族
				}
				if("CertNo".equals(structID)) {
					base.setCertno(eleValue);//证件号码
				}
				if("Occupation".equals(structID)) {
					base.setPrfs(DictMapping.prfs(eleValue));//职业
				}

				if("HomeAddress".equals(structID)) {
					base.setCurrAddr(eleValue);//	现住址
				}
				if("HomePostcode".equals(structID)) {
					base.setCurrAddrPoscode(eleValue);//	现住址-邮政编码
				}
				if("MobilePhone".equals(structID)) {
					base.setPsnTel(eleValue);	//个人联系电话
				}
				if("RegisteredEmail".equals(structID)) {
					base.setResdAddrPoscode(eleValue);//户口地址- 邮政编码
				}
				if("RegisteredAddress".equals(structID)) {
					base.setResdAddr(eleValue);//户口地址
				}
				if("BusinessPhone".equals(structID)) {
					base.setEmprTel(eleValue);//	工作单位联系电话
				}
				if("BusinessPostcode".equals(structID)) {
					base.setEmprPoscode(eleValue);//工作单位- 邮政编码
				}
				if("Company".equals(structID)) {
					base.setEmprAddr(eleValue);	//工作单位及地址
				}
				if("ContactPhone".equals(structID)) {
					base.setConerTel(eleValue);//	联系人电话
				}
				if("ContactAddress".equals(structID)) {
					base.setConerAddr(eleValue);//联系人地址
				}
				if("Relation".equals(structID)) {
					base.setConerRltsCode(DictMapping.patn_rlts(eleValue));//	与联系人关系代码
				}
				if("AdmissionPathWay".equals(structID)) {
					base.setAdmWayName(DictMapping.adm_way(eleValue));//入院途径名称
					base.setAdmWayCode(eleValue);//	入院途径代码
				}
				if("AdmissionPathWay".equals(structID)) {
					base.setAdmWayName(DictMapping.adm_way(eleValue));//入院途径名称
					base.setAdmWayCode(eleValue);//	入院途径代码
				}
				if("TrtTypeName".equals(structID)) {
					base.setTrtTypeName(DictMapping.trt_type(eleValue));//	治疗类别名称
					base.setTrtType(DictMapping.trt_type_code(eleValue));//	治疗类别
				}
				if("CHANGE_DEPT".equals(structID)) {
					base.setRefldeptcatyname("-".equals(eleValue)?"":eleValue);//	转科科别名称
					
				}
				if("ALLERGIC_FLAG".equals(structID)) {
					base.setDrugDicmFlag(eleValue);//	药物过敏标志
				}
				if("ALLERGIC_DRUG".equals(structID)) {
					base.setDicmDrugName(eleValue);//	药物过敏标志
				}
				if("deadAutopsy".equals(structID)) {
					base.setDieAutpFlag("-".equals(eleValue)?"":eleValue);
				}
				if("BloodType".equals(structID)) {
					base.setAboCode(eleValue);
					base.setAboName(DictMapping.blotype_abo(eleValue));
				}
				if("RhBloodType".equals(structID)) {
					base.setRhCode(eleValue);
					base.setRhName(DictMapping.blotype_rh(eleValue));
				}
				if("LEAVE_WAY".equals(structID)) {
					base.setDscgWayName(DictMapping.dscg_way(eleValue));	//离院方式名称
					base.setDscgWay(eleValue);//	离院方式
					if("5".equals(eleValue)) {
						base.setDieFlag("1");//	死亡标志
					}
				}
				if("KZR_DOCTOR_NAME".equals(structID)) {
					base.setDeptdrtCode(hd.getDoctorId(eleValue));
					base.setDeptdrtName(eleValue);//	科主任姓名
				}
				if("ZRFZR_DOCTOR_NAME".equals(structID)) {
					base.setChfdrName(eleValue);//主任( 副主任)医师姓名
				}
				if("ZZ_DOCTOR_NAME".equals(structID)) {
					base.setAtddrCode(hd.getDoctorId(eleValue));//主治医生代码
					base.setAtddrName(eleValue);//	主治医生姓名
				}
				if("ChfpdrName".equals(structID)) {
					base.setChfdrCode(hd.getDoctorId(eleValue)); //	主诊医师代码
					base.setChfpdrName(eleValue);//	主诊医师姓名
				}
				if("ZY_DOCTOR_NAME".equals(structID)) {
					base.setIptDrCode(hd.getDoctorId(eleValue));
					base.setIptDrName(eleValue);//	住院医师姓名
				}
				if("ZR_NURSE_NAME".equals(structID)) {
					base.setRespNursCode(hd.getDoctorId(eleValue));
					base.setRespNursName(eleValue);//	责任护士姓名
				}
				if("JX_DOCTOR_NAME".equals(structID)) {
					base.setTrainDrName(eleValue);//进修医师姓名
				}
				if("SX_DOCTOR_NAME".equals(structID)) {
					base.setIntnDrName(eleValue);//实习医师姓名
				}
				if("CodrName".equals(structID)) {
					base.setCodrName(eleValue);//	编码员姓名
				}
				if("ZK_DOCTOR_NAME".equals(structID)) {
					base.setQltctrlDrCode(hd.getDoctorId(eleValue));
					base.setQltctrlDrName(eleValue);	//质控医师姓名
				}
				if("ZK_NURSE_NAME".equals(structID)) {
					base.setQltctrlNursCode(hd.getDoctorId(eleValue));
					base.setQltctrlNursName(eleValue);//	质控护士姓名
				}
				if("MedcasQltName".equals(structID)) {
					base.setMedcasQltCode(eleValue);//	病案质量代码
					base.setMedcasQltName(DictMapping.medcas_qlt_name(eleValue));//	病案质量名称
				}
				if("QltctrlDate".equals(structID)) {
					base.setQltctrlDate(eleValue);//质控日期
				}
				if("TRANSFER_HOSPITAL".equals(structID)) {
					base.setAcpMedinsCode(eleValue);	//拟接收医疗机构代码
				}
				if("READMISSION_PLAN".equals(structID)) {
					base.setDscg31DaysRinpFlag(eleValue);//	出院 31天内再住院计划标志
				}
				if("READMISSION_REASON".equals(structID)) {
					base.setDscg31DaysRinpPup(eleValue);//出院31天内再住院目的
				}
				if("EXTERNAL_CAUESES".equals(structID)) {
					base.setDamgIntxExtRea(eleValue);//损伤、中毒的外部原因
				}	
				if("EXTERNALCODE".equals(structID)) {
					base.setDamgIntxExtReaDisecode(eleValue);//损伤、中毒的外部原因疾病编码
				}



				



				if("COMA_BEFORE_DAY".equals(structID)){
					COMA_BEFORE_DAY=eleValue;
				}
				if("COMA_BEFORE_HOUR".equals(structID)){
					COMA_BEFORE_HOUR=eleValue;
				}
				if("COMA_BEFORE_MINUTE".equals(structID)){
					COMA_BEFORE_MINUTE=eleValue;
				}
				if("COMA_AFTER_DAY".equals(structID)){
					COMA_AFTER_DAY=eleValue;
				}
				if("COMA_AFTER_HOUR".equals(structID)){
					COMA_AFTER_HOUR=eleValue;
				}
				if("COMA_AFTER_MINUTE".equals(structID)){
					COMA_AFTER_MINUTE=eleValue;
				}
				if("VentUsedDura".equals(structID)) {
					base.setVentUsedDura(eleValue);//	呼吸机使用时长
				}
				if("CnfmDate".equals(structID)) {
					base.setCnfmDate(eleValue);	//确诊日期
				}
				if("DIAG_MZ_CY".equals(structID)) {
					base.setIptPatnDiagInscp(DictMapping.ipt_dise_inscp(eleValue));	//住院患者诊断符合情况
					base.setIptPatnDiagInscpCode(DictMapping.ipt_dise_inscp_code(eleValue));	//住院患者诊断符合情况代码
					base.setPatnDiseDiagCrsp("门诊诊断与出院诊断");	//患者疾病诊断对照
					base.setPatnDiseDiagCrspCode("1");	//住院患者疾病诊断对照代码
				}

				if("CURE".equals(structID)&&eleValue!=null&&eleValue.indexOf("治愈")>-1) {
					base.setDscgTrtRslt("治愈");	//出院治疗结果
					base.setDscgTrtRsltCode("1");	//出院治疗结果代码
				}else if("IMPROVE".equals(structID)&&eleValue!=null&&eleValue.indexOf("好转")>-1) {
					base.setDscgTrtRslt("好转");	//出院治疗结果
					base.setDscgTrtRsltCode("2");	//出院治疗结果代码
				}else if("FAILURE".equals(structID)&&eleValue!=null&&eleValue.indexOf("未愈")>-1) {
					base.setDscgTrtRslt("未愈");	//出院治疗结果
					base.setDscgTrtRsltCode("3");	//出院治疗结果代码
				}else if("DEATH".equals(structID)&&eleValue!=null&&eleValue.indexOf("死亡")>-1) {
					base.setDscgTrtRslt("死亡");	//出院治疗结果
					base.setDscgTrtRsltCode("4");	//出院治疗结果代码
				}else if("OTHER".equals(structID)&&eleValue!=null&&eleValue.indexOf("其他")>-1) {
					base.setDscgTrtRslt("其他");	//出院治疗结果
					base.setDscgTrtRsltCode("5");	//出院治疗结果代码
				}


				base.setWmDiseCode(inp.getRegisterCode()!=null?inp.getRegisterCode():"无");//西医诊断代码
				base.setOtpWmDise(inp.getRegisterDiagnosis()!=null?inp.getRegisterDiagnosis():"无");//西医诊断 

				//				medinsorgcode	医疗机构组织机构代码
				//				aise	过敏源
				//				poteintndrname	研究生实习医师姓名
				//				hbsag	乙肝表面抗原（HBsAg）
				//				hcvab	丙型肝炎抗体
				//				（HCV-Ab）
				//				hivab	艾滋病毒抗体（hiv-ab）
				if("RESCUE_TIMES".equals(structID)) {
					base.setRescCnt("0".equals(eleValue)?"":eleValue);//抢救次数
				}
				if("RESCUE_SUCCESS_TIMES".equals(structID)) {
					base.setRescSuccCnt("0".equals(eleValue)?"":eleValue);//	抢救成功次数
				}


				//	hospdisefsttime	手术、治疗、检查、诊断为本院第一例
				//				hifpaywayname	医保基金付费方式名称
				//				hifpaywaycode	医保基金付费方式代码
				//				medfeepaymtdname	医疗费用支付方式名称
				//				medfeepaymtdcode	医疗费用支付方式代码
				//				selfpayamt	自付金额

				//				ordnmedservfee	一般医疗服务费
				//				ordntrtoprtfee	一般治疗操作费
				//				nursfee	护理费
				//				commedservothfee	综合医疗服务类其他费用
				//				palgdiagfee	病理诊断费
				//				labdiagfee	实验室诊断费
				//				rdhydiagfee	影像学诊断费
				//				clncdisefee	临床诊断项目费
				//				nsrgtrtitemfee	非手术治疗项目费
				//				clncphystrtfee	临床物理治疗费
				//				rgtrttrtfee	手术治疗费
				//				anstfee	麻醉费
				//				oprnfee	手术费
				//				rhabfee	康复费
				//				tcmtrtfee	中医治疗费
				//				wmfee	西药费
				//				abtlmednfee	抗菌药物费用
				//				tcmpatfee	中成药费
				//				tcmherbfee	中药饮片费
				//				blofee	血费
				//				albufee	白蛋白类制品费
				//				glonfee	球蛋白类制品费
				//				clotfacfee	凝血因子类制品费
				//				cykifee	细胞因子类制品费
				//				examdspomatlfee	检查用一次性医用材料费
				//				trtdspomatlfee	治疗用一次性医用材料费
				//				oprndspomatlfee	手术用一次性医用材料费
				//				othfee	其他费

				//				fixmedinscode	定点医药机构编号

			} 
		}

		if(("".equals(COMA_BEFORE_DAY)&&"".equals(COMA_BEFORE_HOUR)&&"".equals(COMA_BEFORE_MINUTE))) {

		}else if(("0".equals(COMA_BEFORE_DAY)&&"0".equals(COMA_BEFORE_HOUR)&&"0".equals(COMA_BEFORE_MINUTE))) {

		}else {
			base.setBrnDamgBfadmComaDura((COMA_BEFORE_DAY+"/"+COMA_BEFORE_HOUR+"/"+COMA_AFTER_MINUTE+""));//颅脑损伤患者入院前昏迷时长
		}
		if(("".equals(COMA_AFTER_DAY)&&"".equals(COMA_AFTER_HOUR)&&"".equals(COMA_AFTER_MINUTE))) {

		}else if(("0".equals(COMA_AFTER_DAY)&&"0".equals(COMA_AFTER_HOUR)&&"0".equals(COMA_AFTER_MINUTE))) {

		}else {
			base.setBrnDamgAfadmComaDura((COMA_AFTER_DAY+"/"+COMA_AFTER_HOUR+"/"+COMA_AFTER_MINUTE+""));	//颅脑损伤患者入院后昏迷时长
		}

		ret=hd.saveFrontSheet(fs,base,isAdd);
 		}catch(Exception e) {
			e.printStackTrace();
			ret = e.getMessage();
		}
		return ret;
	}

	public String getDiagXmlStr(String ipid,String pid,List<BsDiseinfo> list) throws Exception {
		String strXML = "";
		XMLDocument myXMLDoc = XMLDocument.newDocument();
		XMLNode rootElement = myXMLDoc.createElement("data");
		XMLNode cyzdElement = myXMLDoc.createElement("cyzd");
		rootElement.appendChild(cyzdElement);
		XMLNode cyzdRecordElement = myXMLDoc.createElement("record");
		cyzdElement.appendChild(cyzdRecordElement);

		//		List<BsDiseinfo> list=new HisDao().getBsDiseinfoByZylsh(ipid);
		List<InpDiag> westernDiag = new ArrayList<InpDiag>();
		for(int i=0;list!=null&&i<list.size();i++) {
			BsDiseinfo bd=list.get(i);
			InpDiag id=new InpDiag();
			id.setIpid(ipid);
			id.setPid(pid);
			id.setDiagName(bd.getDiagName());
			id.setDiagCode(bd.getDiagCode());
			id.setICDCode(bd.getDiagCode());
			id.setDiagClass("ICD10");
			id.setDiagClassCode("0001");
			id.setDiagTypeCode("cyzd");
			id.setSupDiagFlag("1");
			id.setDiagSupplementDesc(bd.getDiagName()+",null");
			id.setStateOfIllness(bd.getAdmDiseCondCode());
			id.setStateOfIllnessDesc(bd.getAdmDiseCondName());

			westernDiag.add(id);
		}
		if (westernDiag != null && westernDiag.size() > 0) {
			XMLNode westernElement = myXMLDoc.createElement("western");
			cyzdRecordElement.appendChild(westernElement);
			XMLNode westernRecordElement = myXMLDoc.createElement("record");
			westernElement.appendChild(westernRecordElement);
			List<InpDiag> westrnprimaryDiag = new ArrayList<InpDiag>();
			westrnprimaryDiag.add(westernDiag.get(0));
			westernRecordElement.appendChild(currencyDiagXMLEn(myXMLDoc, westrnprimaryDiag, "primary"));
			westernDiag.remove(0);
			List<InpDiag> other1Diag = new ArrayList<InpDiag>();
			List<InpDiag> other2Diag = new ArrayList<InpDiag>();
			for (int d = 0; westernDiag != null && d < westernDiag.size(); d++) {
				if (d < 10) {
					other1Diag.add(westernDiag.get(d));
				} else {
					other2Diag.add(westernDiag.get(d));
				} 
			} 
			if (other1Diag != null && other1Diag.size() > 0)
				westernRecordElement.appendChild(currencyDiagXMLEn(myXMLDoc,  other1Diag, "other1")); 
			if (other2Diag != null && other2Diag.size() > 0)
				westernRecordElement.appendChild(currencyDiagXMLEn(myXMLDoc,  other2Diag, "other2")); 
		} 
		XMLNode signerElement = myXMLDoc.createElement("signer");
		XMLNode signature_dateElement = myXMLDoc.createElement("signature_date");
		cyzdRecordElement.appendChild(signerElement);
		cyzdRecordElement.appendChild(signature_dateElement);
		signerElement.setTextContent("");
		signature_dateElement.setTextContent("");
		myXMLDoc.appendChild(rootElement);
		strXML = myXMLDoc.getOuterXML();
		System.out.println(""+ strXML);
		return strXML;
	}

	public XMLNode currencyDiagXMLEn(XMLDocument myXMLDoc, List<InpDiag> diagList, String primary) throws Exception {
		XMLNode RootsElement = myXMLDoc.createElement(primary);
		if (diagList != null && diagList.size() > 0)
			for (int i = 0; i < diagList.size(); i++) {
				XMLNode RootElement = myXMLDoc.createElement("record");
				RootsElement.appendChild(RootElement);
				InpDiag inpDiag = diagList.get(i);
				String diagnosis = inpDiag.getDiagName();
				String outCome = inpDiag.getOutcome();
				String diagCode = inpDiag.getDiagCode();
				String stateOfIllnessDesc = inpDiag.getStateOfIllnessDesc();
				if (inpDiag.getDiagSupplementDesc() != null && inpDiag.getDiagSupplementDesc().trim().length() > 0) {
					XMLNode diagnosisElement = myXMLDoc.createElement("diagnosis");
					RootElement.appendChild(diagnosisElement);
					XMLNode diagnosisRecordElement = myXMLDoc.createElement("record");
					diagnosisElement.appendChild(diagnosisRecordElement);
					XMLNode diagnosisContentElement = myXMLDoc.createElement("content");
					diagnosisRecordElement.appendChild(diagnosisContentElement);
					String[] diagSupplementDesc = Util.split(inpDiag.getDiagSupplementDesc(), ",");
					if (diagSupplementDesc.length >= 1)
						diagnosisContentElement.setTextContent(diagSupplementDesc[0]); 
				} 
				if (diagCode != null && diagCode.trim().length() > 0) {
					XMLNode codeElement = myXMLDoc.createElement("code");
					RootElement.appendChild(codeElement);
					XMLNode codeRecordElement = myXMLDoc.createElement("record");
					codeElement.appendChild(codeRecordElement);
					XMLNode codeContentElement = myXMLDoc.createElement("content");
					codeRecordElement.appendChild(codeContentElement);
					codeContentElement.setTextContent(diagCode);
				} 
				if (outCome != null && outCome.trim().length() > 0) {
					XMLNode outcomeElement = myXMLDoc.createElement("outcome");
					RootElement.appendChild(outcomeElement);
					XMLNode outcomeRecordElement = myXMLDoc.createElement("record");
					outcomeElement.appendChild(outcomeRecordElement);
					XMLNode outcomeContentElement = myXMLDoc.createElement("content");
					outcomeRecordElement.appendChild(outcomeContentElement);
					outcomeContentElement.setTextContent(outCome);
				} 
				if (stateOfIllnessDesc != null && stateOfIllnessDesc.trim().length() > 0) {
					XMLNode conditionElement = myXMLDoc.createElement("condition");
					RootElement.appendChild(conditionElement);
					XMLNode conditionRecordElement = myXMLDoc.createElement("record");
					conditionElement.appendChild(conditionRecordElement);
					XMLNode conditionRecordContentElement = myXMLDoc.createElement("content");
					conditionRecordElement.appendChild(conditionRecordContentElement);
					conditionRecordContentElement.setTextContent(stateOfIllnessDesc);
				} 
			}  
		return RootsElement;
	}
	
	public String getOperaAndMinorXmlStr(List<BsOprninfo> oprnList) throws Exception {

		StringBuffer sb = new StringBuffer();
		if (oprnList != null && oprnList.size() > 0) {
			sb.append("<recordset>");
			for (int i=0;oprnList!=null&&i<oprnList.size();i++) {
				BsOprninfo opera=oprnList.get(i);
				String operationname = opera.getOprnOprtName();
				sb.append("<record><field id='OPERATION_CODE' value='" + Util.escapeInnerText(opera.getOprnOprtCode()) + "'/> " + 
						"<field id='OPERATION_TIME' value='" + Util.escapeInnerText(opera.getOprnOprtDate()) + "'/> " + 
						"<field id='OPERATION_LEVEL' value='" + Util.escapeInnerText(opera.getOprnLvName()) + "'/> " + 
						"<field id='OPERATION_NAME' value='" + Util.escapeInnerText(operationname) + "'/> " + 
						"<field id='OPERATION_DOCTOR' value='" + Util.escapeInnerText(opera.getOperName()) + "'/> " + 
						"<field id='ASSISTANT_I' value='" + Util.escapeInnerText(opera.getAsit1Name()) + "'/> " + 
						"<field id='ASSISTANT_II' value='" + Util.escapeInnerText(opera.getAsit2Name()) + "'/> " + 
						"<field id='OPERATION_HEAL_LEVEL' value='" + Util.escapeInnerText(opera.getSincHealLv()) + "'/> " + 
						"<field id='ANESTHESIA' value='" + Util.escapeInnerText(opera.getAnstMtdName()) + "'/> " + 
						"<field id='ANESTHESIA_DOCTOR' value='" + Util.escapeInnerText(opera.getAnstDrName()) + "'/> " + 
						"</record>");
			} 
		}
		sb.append("</recordset>");
		return sb.toString();
	}
	
	public String toBase64(String str) {
		String ret = null;
		if (str != null)
			ret = Util.toBASE64(str.getBytes()); 
		return ret;
	}
}
