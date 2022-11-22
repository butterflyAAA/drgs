package com.haitaiinc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haitaiinc.Util;
import com.haitaiinc.common.HISDataAccessObject;
import com.haitaiinc.custume.frontsheet.DictMapping;
import com.haitaiinc.data.DBOperator;
import com.haitaiinc.db.OperOrderConfig;
import com.haitaiinc.hisdb.dictmanage.DictDepart;
import com.haitaiinc.hisdb.dictmanage.DictICD;
import com.haitaiinc.hisdb.dictmanage.TplTemplate;
import com.haitaiinc.hisdb.dictmanage.tableadapters.DictDepartTableAdapter;
import com.haitaiinc.hisdb.dictmanage.tableadapters.DictICDTableAdapter;
import com.haitaiinc.hisdb.dictmanage.tableadapters.TplTemplateTableAdapter;
import com.haitaiinc.hisdb.drgs.BsBaseinfo;
import com.haitaiinc.hisdb.drgs.BsDiseinfo;
import com.haitaiinc.hisdb.drgs.BsOprninfo;
import com.haitaiinc.hisdb.drgs.FrontSheet;
import com.haitaiinc.hisdb.drgs.tableadapters.BsBaseinfoTableAdapter;
import com.haitaiinc.hisdb.drgs.tableadapters.BsDiseinfoTableAdapter;
import com.haitaiinc.hisdb.drgs.tableadapters.BsOprninfoTableAdapter;
import com.haitaiinc.hisdb.drgs.tableadapters.FrontSheetTableAdapter;
import com.haitaiinc.hisdb.his.PatInpatDiagnosis;
import com.haitaiinc.hisdb.his.VInpatientinfo;
import com.haitaiinc.hisdb.his.VPatientinfo;
import com.haitaiinc.hisdb.his.tableadapters.PatInpatDiagnosisTableAdapter;
import com.haitaiinc.hisdb.his.tableadapters.VInpatientinfoTableAdapter;
import com.haitaiinc.hisdb.his.tableadapters.VPatientinfoTableAdapter;
import com.haitaiinc.htdb.adt.dto.Inpatient;
import com.haitaiinc.htdb.inpcase.dto.InpDiag;
import com.haitaiinc.htdb.inpcase.dto.OperationInfoRec;

import util.Log;

public class HisDao extends HISDataAccessObject{

	public String saveBaseInfo(String zylsh ,JSONObject retjson,Inpatient inp){
		String ret="保存成功";
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			
			/**
			 * 先判断有没有上传。
			 */
			String D4101="";
			String orgid="";
			String sql="select t.D4101,t1.orgid from pat_inpat_info t ,dict_hospinfo t1 where zylsh=?";
			PreparedStatement ps=dbo.prepareStatement(sql);
			ps.setString(1, zylsh);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				D4101=rs.getString("D4101");
				orgid=rs.getString("orgid");
			}
			rs.close();
			ps.close();
			Inpatient inpatient=new EmrDao().getInpateintByipid(zylsh);
			if(Util.isEmpty(D4101)||"-1".equals(D4101)){
				JSONObject baseinfojson=(JSONObject) retjson.get("baseinfo");
				System.out.println(baseinfojson);  
				BsBaseinfo bbi=JSON.toJavaObject(baseinfojson, BsBaseinfo.class);
				bbi.setNtly(new DictMapping().nat_regn_code(baseinfojson.get("ntly_name").toString()));//国籍代码
				bbi.setNtlyName(baseinfojson.get("ntly_name").toString());//国籍名称
				bbi.setDscgCaty(baseinfojson.get("dscg_caty").toString());//出院科别
				bbi.setCurrAddr(baseinfojson.get("curr_addr").toString());//现住址
				bbi.setEmprAddr(baseinfojson.get("empr_addr").toString());//单位地址
				bbi.setEmprTel(baseinfojson.get("empr_tel").toString());//单位电话
				bbi.setCurrAddrPoscode(baseinfojson.get("curr_addr_poscode").toString());//邮编
				bbi.setConerName(baseinfojson.get("coner_name").toString());//联系人姓名
				String conrlt=baseinfojson.get("coner_rlts_code").toString();
				String conadd=baseinfojson.get("coner_addr").toString();
				String contel=baseinfojson.get("coner_tel").toString();
				if(baseinfojson.get("coner_name").toString()!=""){
					if("".equals(conrlt.trim()))conrlt="80";
					if("".equals(conadd.trim()))conadd="无";
					if("".equals(contel.trim()))contel="无";
				}
				bbi.setConerRltsCode(conrlt);//与患者关系
				bbi.setConerAddr(conadd);//联系人地址
				bbi.setConerTel(contel);//联系人电话
				String adm_way_name=baseinfojson.get("adm_way_name").toString();
				String adm_name_code="";
				if ("急诊".equals(adm_way_name))adm_name_code="1";
				else if ("门诊".equals(adm_way_name))adm_name_code="2";
				else if ("其他医疗机构转入".equals(adm_way_name))adm_name_code="3";
				else adm_name_code="9";
				
				bbi.setAdmWayName(adm_way_name!=null?adm_way_name:"其他");//入院途径名称
				bbi.setAdmWayCode(adm_name_code!=null?adm_name_code:"9");//入院途径代码
				String zllb="10";
				if(baseinfojson.get("trt_type").toString()!="")zllb=baseinfojson.get("trt_type").toString();
				bbi.setTrtType(zllb);//治疗类别
				bbi.setAdmDate(baseinfojson.get("adm_date").toString());//入院时间
				String zkkb=baseinfojson.get("refldeptCatyName").toString().trim();
				if("无".equals(zkkb)||"无".equals(zkkb))zkkb="";
				bbi.setRefldeptDept(zkkb);//转科科别
				bbi.setDscgDate(baseinfojson.get("dscg_date").toString());//出院时间
				bbi.setDscgCaty(baseinfojson.get("dscg_caty").toString());//出院科别
				bbi.setWmDiseCode(baseinfojson.get("wm_dise_code").toString());//西医疾病代码
				bbi.setOtpWmDise(baseinfojson.get("otp_wm_dise").toString());//门急诊西医诊断
				String lyfs="1";
				String lyfsmc="医嘱离院";
				if(baseinfojson.get("dscg_way").toString()!=""){
					lyfs=baseinfojson.get("dscg_way").toString();
					lyfsmc=baseinfojson.get("dscg_way_name").toString();
				}
				bbi.setDscgWay(lyfs);//离院方式代码
				bbi.setDscgWayName(lyfsmc);//离院方式
//				bbi.setChfpdrName(baseinfojson.get("atddr_name").toString()!=null?baseinfojson.get("atddr_name").toString():baseinfojson.get("deptdrt_name").toString());//主诊医师姓名

//				bbi.setChfdrName(!Util.isEmpty(baseinfojson.get("atddr_name").toString())?baseinfojson.get("atddr_name").toString():baseinfojson.get("deptdrt_name").toString());//主诊医师
//				bbi.setAtddrCode(!Util.isEmpty(getDoctorId(baseinfojson.get("atddr_name").toString()))?getDoctorId(baseinfojson.get("atddr_name").toString()):getDoctorId(inp.getDoctor()));//主治医生代码
//				bbi.setAtddrName(!Util.isEmpty(baseinfojson.get("atddr_name").toString())?baseinfojson.get("atddr_name").toString():inp.getDoctor());//主治医生
				
				bbi.setChfpdrName(baseinfojson.get("ipt_dr_name").toString());//主诊医师姓名
				if("".equals(bbi.getChfpdrName())){
					bbi.setChfpdrName(inpatient.getZzDoctorName());
				}
			
				bbi.setChfdrCode(getDoctorId2(baseinfojson.get("chfdr_name").toString()));//主诊医师工号
				Log.info("----"+inpatient.getZzDoctorCode());
				if(bbi.getChfdrCode() == null ||"".equals(bbi.getChfdrCode().trim())){
					bbi.setChfdrCode(getGjbmByKeyno(inpatient.getZzDoctorCode()));
				}
				bbi.setAtddrCode(getDoctorId(baseinfojson.get("ipt_dr_name").toString()));//主治医生代码
				String atddrCode = "";
				if(bbi.getAtddrCode() ==null ||"".equals(bbi.getAtddrCode().trim())){
					atddrCode = getGjbmByKeyno(inpatient.getZzDoctorCode());
					bbi.setAtddrCode(atddrCode);
				}
				System.out.println("---"+bbi.getAtddrCode());
				bbi.setAtddrName(baseinfojson.get("ipt_dr_name").toString());//主治医生
				if("".equals(bbi.getAtddrName())){
					bbi.setAtddrName(inpatient.getZzDoctorName());
				}
				bbi.setBrxh(zylsh);
				bbi.setJgdm(orgid);
				bbi.setIptNo(zylsh);
				List<BsDiseinfo> bdiList=new ArrayList<BsDiseinfo>();//诊断
				List<BsOprninfo> boiList=new ArrayList<BsOprninfo>();//手术
				
				List<InpDiag> inpdiagList=new EmrDao().getInpDiagListByIpid2(zylsh);
				List<OperationInfoRec> operationList=new EmrDao().getOperationInfoRecListByIpid(zylsh);
				List<OperOrderConfig> ocolist=new EmrDao().getOperOrderConfigListByIpid(zylsh);
				int jj=0;
				for(int i=0;inpdiagList!=null&&i<inpdiagList.size();i++){
					if("swzd".equals(inpdiagList.get(i))){
						jj=1;
					}
					System.out.println(inpdiagList.size());
				}
				for(int i=0;inpdiagList!=null&&i<inpdiagList.size();i++){
					InpDiag inpDiag=inpdiagList.get(i);
					if(jj==1&&"cyzd".equals(inpDiag.getDiagTypeCode())){
						continue;
					}
					BsDiseinfo bdi=new BsDiseinfo();
					bdi.setBrxh(zylsh);
					bdi.setJgdm(orgid);
					bdi.setSxh(inpDiag.getOrdinal());
					bdi.setPalgNo("");//病理号
					String zdlxdm=inpDiag.getDiagTypeCode();
					String zdlx="其他";
					String jbzddm="99";
					String zzd="0";	
					if("0001".equals(inpDiag.getDiagClassCode())){					
						if(i==0){
							zdlx="主要诊断";
							jbzddm="12";
							zzd="1";
							jj=0;
						}else{
							zdlx="次要诊断";
							jbzddm="13";
						}												
					}else if("0002".equals(inpDiag.getDiagClassCode())){//中医主病
						zdlx="中医出院主病";jbzddm="141";
					}else if("0003".equals(inpDiag.getDiagClassCode())){//中医主证
						zdlx="中医出院主证";jbzddm="142";
					}
					bdi.setIptPatnDisediagTypeCode(jbzddm);//住院患者疾病诊断类型代码
					bdi.setDisediagType(zdlx);//疾病诊断类型
					bdi.setDiagType("1");
				
					bdi.setMaindiagFlag(zzd);//主诊断标志
					bdi.setDiagCode(inpDiag.getDiagCode());//诊断代码
					bdi.setDiagName(inpDiag.getDiagName());//诊断名称
					bdi.setInhospDiagCode(inpDiag.getDiagCode());//院内诊断代码
					bdi.setInhospDiagName(inpDiag.getDiagName());//院内诊断名称
					String ryjbbqdm="3";
					String ryjbbqmc="情况不明";
					if(inpDiag.getStateOfIllness() !=null && inpDiag.getStateOfIllness()!="")ryjbbqdm=inpDiag.getStateOfIllness();
					if(inpDiag.getStateOfIllnessDesc() !=null && inpDiag.getStateOfIllnessDesc()!="")ryjbbqmc=inpDiag.getStateOfIllnessDesc();
					bdi.setAdmDiseCondCode(ryjbbqdm);//入院疾病病情代码
					bdi.setAdmDiseCondName(ryjbbqmc);//入院疾病病情名称
					bdi.setAdmCond("一般");//入院病情
					bdi.setAdmCondCode("3");//入院病情代码
					bdi.setHighDiagEvid("");//最高诊断依据
					bdi.setBkupDeg("");//分化程度
					bdi.setBkupDegCode("");//分化程度代码
					bdi.setValiFlag("1");//有效标志
					bdi.setIptMedcasHmpgSN("");//住院病案首页流水号
					bdi.setMdtrtSN("");//就医流水号
					//bdi.setFixmedinsCode(orgid);//定点医药机构编码
					bdiList.add(bdi);
					System.out.println("====="+bdi.toString());
				}
				
				JSONArray arrjson =(JSONArray) retjson.get("oprninfo");
				
				for(int i=0;ocolist!=null&&ocolist.size()>i;i++){
					System.out.println("ocoSize=="+ocolist.size());
					JSONObject oprnjson = new JSONObject();
					OperationInfoRec op = new OperationInfoRec();
					if(null!=operationList && operationList.size()>0){
						if(i>=operationList.size()){
							oprnjson=(JSONObject) arrjson.get(arrjson.size()-1);
							op=operationList.get(operationList.size()-1);
						}else{
							op=operationList.get(i);
							oprnjson=(JSONObject) arrjson.get(i);
						}
						
					}
					
					OperOrderConfig oco = ocolist.get(i);
					BsOprninfo boi=new BsOprninfo();
					boi.setBrxh(zylsh);
					//boi.setJgdm(orgid);
					boi.setSxh(String.valueOf(i));
					boi.setOprnOprtDate(oco.getOperationTime());//手术操作日期
					boi.setOprnOprtName(oco.getOperationName());//手术操作名称
					boi.setOprnOprtCode(oco.getOperationCode());//手术操作代码
					if(i==0){
						boi.setOprnOprtSN("1");//手术操作序列号
						boi.setOprnOprtType("1");
					}else{
						boi.setOprnOprtSN("0");//手术操作序列号
						boi.setOprnOprtType("2");
					}
					
					boi.setOprnLvCode(oco.getOperationLevelCode());//手术级别代码
					boi.setOprnLvName(oco.getOperationLevel());//手术级别名称
				//	boi.setOperName(oco.getOperationDoctor());//手术者姓名
					boi.setOperName(op.getOperationDoctor());//手术者姓名
					boi.setAsit1Name(oco.getAssistantI());//助手1姓名
					boi.setAsit2Name(oco.getAssistantIi());//助手2姓名
					boi.setSincHealLv(oco.getHealGrade());//手术切口愈合等级
					boi.setSincHealLvCode(oco.getHealGradeCode());//手术切口愈合等级代码
					boi.setAnstMtdName(oprnjson.getString("anst_mtd_name"));//麻醉方法
					boi.setAnstMtdCode(oprnjson.getString("anst_mtd_code"));//麻醉方法代码
					boi.setAnstDrName(oco.getAnesthesiaDoctor());//麻醉医师姓名
					boi.setOprnOperPart("");//手术操作部位
					boi.setOprnOperPartCode("");//手术操作部位代码
					//boi.setOprnConTime(op.getOperationWholeTime());//手术持续时间
					boi.setAnstLvName("");//麻醉分级名称
					boi.setAnstLvCode("");//麻醉分级代码
					boi.setOprnPatnType("");//手术患者类型
					boi.setOprnPatnTypeCode("");//手术患者类型代码
					boi.setMainOprnFlag("");//主要手术标志
					boi.setAnstAsaLvCode(oco.getAsaLevelCode());//麻醉ASA分级代码
					boi.setAnstAsaLvName(oco.getAsaLevelName());//麻醉aSA分级名称
					boi.setAnstMednCode("");//麻醉药物代码
					boi.setAnstMednName("");//麻醉药物名称
					boi.setAnstMednDos("");//麻醉药物计量
					boi.setUnt("");//计量单位
					boi.setAnstBegntime("");//麻醉开始时间
					boi.setAnstEndtime("");//麻醉结束时间
					boi.setAnstCopnCode("");//麻醉合并症ID
					boi.setAnstCopnName("");//麻醉合并症名称
					boi.setAnstCopnDscr("");//麻醉合并症描述
					boi.setPacuBegntime("");//复苏室开始时间
					boi.setPacuEndtime("");//复苏室结束时间
					boi.setCancOprnFlag(op.getRecStatus());//取消手术标志
					boi.setValiFlag("1");//有效标志
					boi.setIptMedcasHmpgSN("");//住院病案首页流水号
					boi.setMdtrtSN("");//就医流水号
					boi.setJgdm("1003");//院区代码
					/*if("".equals(oco.getOperationDoctorID())){
						boi.setOperCode(getDoctorId2(op.getOperationDoctorID()));//手术医师id
					}else{
						boi.setOperCode(getDoctorId2(oco.getOperationDoctorID()));//手术医师id
					}*/
					if(oco.getOperationDoctorID()!=null && !"".equals(oco.getOperationDoctorID())){
						boi.setOperCode(getDoctorId2(oco.getOperationDoctorID()));//手术医师id
					}else{
						boi.setOperCode(getDoctorId2(op.getOperationDoctorID()));//手术医师id
					}
					System.out.println("op.getOperCode()=="+boi.getOperCode());
					System.out.println("op.getAnesthesiaDoctorCode()=="+oco.getAnesthesiaDoctorCode());
					boi.setAnstDrCode(getDoctorId2(oco.getAnesthesiaDoctorCode()));//麻醉医师 id
					boi.setAsit1Code(getDoctorId2(oco.getAssistantICode()));//助手1 id
					boi.setAsit2Code(getDoctorId2(oco.getAssistantIiCode()));//助手2 id
					boiList.add(boi);
					System.out.println("boi=="+boi.toString());
				}
				
				
				
				
				
				new BsBaseinfoTableAdapter(dbo).delete("Brxh=?",new int[1],new String[]{zylsh} );
				new BsDiseinfoTableAdapter(dbo).delete("Brxh=?",new int[1],new String[]{zylsh});
				new BsOprninfoTableAdapter(dbo).delete("Brxh=?",new int[1],new String[]{zylsh});
				new BsBaseinfoTableAdapter(dbo).insert(bbi);
				new BsDiseinfoTableAdapter(dbo).insert(bdiList);
				new BsOprninfoTableAdapter(dbo).insert(boiList);
				dbo.commit();
			}
			
			
			
			

			
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
			ret="保存失败！"+e.getMessage();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return ret;
	}
	
	public List<DictDepart> getDictDepart(){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<DictDepart> list=new DictDepartTableAdapter(dbo).select("DEL_FLAG='0'");
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public TplTemplate getTplTemplate(){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<TplTemplate> list=new TplTemplateTableAdapter(dbo).select();
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public VInpatientinfo getVInpatientinfoByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<VInpatientinfo> list=new VInpatientinfoTableAdapter(dbo).select("ipid=?",new int[1],new String[] {ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public VPatientinfo getVPatientinfoByPid(String pid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<VPatientinfo> list=new VPatientinfoTableAdapter(dbo).select("pid=?",new int[1],new String[] {pid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public FrontSheet getFrontSheetByIpid(String ipid) {
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<FrontSheet> list=new FrontSheetTableAdapter(dbo).select("ipid=?",new int[1],new String[] {ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	/**
	 * 根据ICD码获得名称
	 * @param icd
	 * @return
	 */
	public  String getDictIcdByIcd(String icd,DBOperator dbo) {
		try{
			if(icd!=null) {
				icd=icd.replace("YB", "");
			}
			List<DictICD> list=new DictICDTableAdapter(dbo).select(" jbdm=? and del_flag='0'",new int[1],new String[] {icd});
			if(list!=null) {
				DictICD di=list.get(0);
				return di.getJbMc();
			}
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
		}
		return "";
	}

	public static void main(String[] args) {
		new HisDao().featchBsOprninfo("67163","123456");
//		new HisDao().featchPatInpDiagnosis("2017065536","123456");
	}
	
	
	public List<BsOprninfo> featchBsOprninfo(String zylsh,String orgid){
		List<BsOprninfo> oprnlist =new ArrayList<BsOprninfo>();
		String sql="select a.ssrq,b.sfssdm,b.sfssmc,b.xh,nvl(b.sfssdj,a.ssdj) as ssdj,c.xm,a.zsys,a.qkdj,d.mzff1,d.mzys1,a.sssj_score "
				+ "from his.inpat_oper_info a,his.inpat_oper_tz_sfxm b,dictmanage.dict_empe c,his.inpat_mz_info d "
				+ "where a.jl_id=b.jl_id and a.jl_id=d.jl_id(+) and b.sfssdm is not null and a.zdys_id=c.keyno(+)"
				+ "and a.zylsh=?";
		DBOperator dbo = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			dbo=getDBOperator();
			ps= dbo.prepareStatement(sql);
			ps.setString(1, zylsh);
			rs=ps.executeQuery();
			int i=1;
			while(rs.next()){
				BsOprninfo bo=new BsOprninfo();
				bo.setOprnOprtDate(Util.format(rs.getString("ssrq"), "yyyy-MM-dd"));
				bo.setOprnOprtName(rs.getString("sfssmc"));
				bo.setOprnOprtCode(rs.getString("sfssdm"));
				String xh=rs.getString("xh");
				bo.setOprnOprtSN(Util.isEmpty(xh)?((i)+""):xh);
				bo.setSxh(bo.getOprnOprtSN());
				String ssdj=rs.getString("ssdj");
				if(Util.isEmpty(ssdj)) {
					ssdj="5";
				}
				bo.setOprnLvCode(ssdj);
				bo.setOprnLvName(DictMapping.oprn_oprt_lv_code(ssdj));
				bo.setOperName(rs.getString("xm"));
				bo.setAsit1Code(rs.getString("zsys"));
				bo.setAnstMtdCode(rs.getString("mzff1"));
				//bo.setOprnConTime(rs.getString("sssj_score"));
			
				bo.setIptMedcasHmpgSN(zylsh);
				bo.setBrxh(zylsh);
				bo.setValiFlag("1");
				bo.setJgdm(orgid);
				oprnlist.add(bo);
			}
			
			new BsOprninfoTableAdapter(dbo).delete("ipt_medcas_hmpg_sn=?",new int[1],new String[] {zylsh});
			new BsOprninfoTableAdapter(dbo).insert(oprnlist);
			dbo.commit();
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(dbo!=null){
				dbo.close();
			}
		}
		return oprnlist;
	}
	
	/**
	 * 查询住院主诊断
	 * @param zylsh
	 * @return
	 */
	public PatInpatDiagnosis featchPatInpDiagnosisByZyslh(String zylsh) {
		PatInpatDiagnosis pid =new PatInpatDiagnosis();
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<PatInpatDiagnosis> list=new PatInpatDiagnosisTableAdapter(dbo).select("zylsh=? and zdlx_id='1'",new int[1],new String[] {zylsh},"zdlx_id");
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return pid;
	}
	
	
	public List<BsDiseinfo> getBsDiseinfoByZylsh(String zylsh){
		List<BsDiseinfo> diselist =new ArrayList<BsDiseinfo>();
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<BsDiseinfo> list=new BsDiseinfoTableAdapter(dbo).select("brxh=?",new int[1],new String[] {zylsh});
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return diselist;
	}
	
//	public List<InpDiag> getInpDiagByZylsh(String zylsh){
//		List<InpDiag> westernDiag = new ArrayList<InpDiag>();
//		DBOperator dbo = null;
//		try{
//			dbo=getDBOperator();
//			List<PatInpatDiagnosis> list=new PatInpatDiagnosisTableAdapter(dbo).select("zylsh=?",new int[1],new String[] {zylsh});
//			
//			for(int i=0;list!=null&&i<list.size();i++) {
//				PatInpatDiagnosis pd=list.get(i);
//				InpDiag id=new InpDiag();
//				id.setIpid(zylsh);
//				id.setPid(pd.getPatID());
//				id.setDiagName(bd.getDiagName());
//				id.setDiagCode(bd.getDiagCode());
//				id.setICDCode(bd.getDiagCode());
//				id.setDiagClass("ICD10");
//				id.setDiagClassCode("0001");
//				id.setDiagTypeCode("cyzd");
//				id.setSupDiagFlag("1");
//				id.setOrdinal(bd.getSxh());
//				id.setOutcome(strXML);
//				id.setOutcomeCode(strXML);
//				westernDiag.add(id);
//			}
//			return westernDiag;
//		}catch(Exception e){
//			if(dbo!=null){
//				dbo.rollback();
//			}
//			e.printStackTrace();
//		}finally{
//			if(dbo!=null){
//				dbo.close();
//			}
//		}
//		return westernDiag;
//	}
	
	/**
	 * 诊断插入DRGS表
	 * @param zylsh
	 * @param orgid
	 * @return
	 */
	public List<BsDiseinfo> featchPatInpDiagnosis(String zylsh,String orgid) {
		List<BsDiseinfo> diselist =new ArrayList<BsDiseinfo>();
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<PatInpatDiagnosis> list=new PatInpatDiagnosisTableAdapter(dbo).select("zylsh=?",new int[1],new String[] {zylsh},"zdlx_id");
			
			for(int i=0;list!=null&&i<list.size();i++) {
				PatInpatDiagnosis pd=list.get(i);
				BsDiseinfo bd =new BsDiseinfo();
				bd.setIptPatnDisediagTypeCode("1".equals(pd.getZdlxID())?"12":"13");//住院患者疾病诊断类型代码
				bd.setDisediagType("1".equals(pd.getZdlxID())?"主要诊断":"次要诊断");//�疾病诊断类型
				bd.setMaindiagFlag("1".equals(pd.getZdlxID())?"1":"0");// maindiag_flag
				bd.setDiagCode(pd.getZdICD().replace("YB", ""));//诊断代码
				bd.setDiagName(getDictIcdByIcd(pd.getZdICD(),dbo));//诊断名称
				bd.setInhospDiagCode(pd.getZdICD());//院内诊断代码
				bd.setInhospDiagName(bd.getDiagName());//院内诊断名称
				bd.setAdmDiseCondName(DictMapping.adm_cond_type(pd.getRybqID()));//入院疾病病情名称
				bd.setAdmDiseCondCode(Util.isEmpty(pd.getRybqID())?"1":pd.getRybqID());	//入院疾病病情代码
				bd.setAdmCond("一般");	//入院病情
				bd.setAdmCondCode("3");	//入院时病情代码
				bd.setHighDiagEvid("1");	//最高诊断依据 
				bd.setBkupDeg("");	//分化程度
				bd.setBkupDegCode("");	//分化程度代码
				bd.setValiFlag("1");	//有效标志־
				bd.setIptMedcasHmpgSN(zylsh);	//住院病案首页流水号
				bd.setBrxh(zylsh);
				bd.setSxh((i+1)+"");
				bd.setJgdm(orgid);
				bd.setDiagType("1"); //1	西医诊断 2	中医主病诊断 3	中医主证诊断
				

				diselist.add(bd);
			}
			new BsDiseinfoTableAdapter(dbo).delete("ipt_medcas_hmpg_sn=?",new int[1],new String[] {zylsh});
			new BsDiseinfoTableAdapter(dbo).insert(diselist);
			dbo.commit();
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return diselist;
	}
	
	/**
	 * 获取医生国家编码
	 * @param name
	 * @return
	 */
	public String getDoctorId(String name) {
		DBOperator dbo =null;
		String ret = "";
		try {
			dbo =getDBOperator();
			String sql = "select gjbm from dictmanage.dict_empe where xm ='"+name+"'";
			PreparedStatement pstm = dbo.createPreparedStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				ret = rs.getString("gjbm");
			}
			rs.close();
			pstm.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			dbo.rollback();
			return "0";
		}finally {
			if(dbo!=null)
				dbo.close();
		}
		return ret;
	}
	
	public String saveFrontSheet(FrontSheet fs,BsBaseinfo base,String isAdd) {
		String ret="保存成功";
		System.out.println(base);
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			if("true".equals(isAdd)) {//新增
				new FrontSheetTableAdapter(dbo).insert(fs);
			}else {//修改
				new FrontSheetTableAdapter(dbo).update("ipid=?",new int[1],new String[] {fs.getIpid()},fs);
				new BsBaseinfoTableAdapter(dbo).delete("IPT_NO=?",new int[1],new String[] {fs.getIpid()});
			}
			if(base!=null&&base.getIptNo()!=null) {
				new BsBaseinfoTableAdapter(dbo).insert(base);
			}else {
				return "基本信息为空，不能保存";
			}
			
			dbo.commit();
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
			
			ret="保存失败："+e.getMessage();
			//return "信息处理失败："+e.getMessage();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return ret;
	}
	public String getDoctorId2(String id) {
		DBOperator dbo =null;
		String ret = "";
		try {
			dbo =getDBOperator();
			String sql = "select gjbm from dictmanage.dict_empe where zgh ='"+id+"'";
			PreparedStatement pstm = dbo.createPreparedStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				ret = rs.getString("gjbm");
			}
			rs.close();
			pstm.close();

		}catch(Exception e) {
			e.printStackTrace();
			dbo.rollback();
			return "0";
		}finally {
			if(dbo!=null)
				dbo.close();
		}
		return ret;
	}
	public String getGjbmByKeyno(String id) {
		DBOperator dbo =null;
		String ret = "";
		try {
			dbo =getDBOperator();
			String sql = "select gjbm from dictmanage.dict_empe where keyno ='"+id+"'";
			PreparedStatement pstm = dbo.createPreparedStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				ret = rs.getString("gjbm");
			}
			rs.close();
			pstm.close();

		}catch(Exception e) {
			e.printStackTrace();
			dbo.rollback();
			return "0";
		}finally {
			if(dbo!=null)
				dbo.close();
		}
		return ret;
	}


}

