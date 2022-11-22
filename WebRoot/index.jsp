<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.haitaiinc.servlet.JSP"%>
<%@page import="com.haitaiinc.Util"%>
<%@page import="com.haitaiinc.xml.XMLDocument"%>
<%@page import="com.haitaiinc.xml.XMLNode"%>
<%@page import="com.haitaiinc.util.Dict" %>
<%@page import="java.util.*" %>

<jsp:useBean id="tt" class="com.haitaiinc.hisdb.dictmanage.TplTemplate" scope="request"></jsp:useBean>
<jsp:useBean id="inp" class="com.haitaiinc.hisdb.his.VInpatientinfo" scope="request"></jsp:useBean>
<jsp:useBean id="pat" class="com.haitaiinc.hisdb.his.VPatientinfo" scope="request"></jsp:useBean>
<jsp:useBean id="inpAllInfo" class="java.lang.String" scope="request"></jsp:useBean>
<%!
public String toBase64(String str){
	String ret=null;
	if(str!=null){
		ret = Util.toBASE64(str.getBytes());
	}
	return ret;
}
%>
<%
XMLDocument xd = XMLDocument.parse("<external/>");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病案首页</title>
<%-- <%=JSP.getHtCSSDef(request)%>
<%=JSP.getPageCSSDef(request)%>
<%=JSP.getHtJSDef(request)%>
<%=JSP.getPageJSDef(request)%> --%>
</head>
<body class="main_bg_ntool_gray">
<form name="editForm">
<table height="80%" border="0" cellpadding="0" cellspacing="0"  width="100%">
		<tr>
			<td id="invalidinfoTd" style="padding-right: 5px;color: red;"></td>
		</tr>
  <tr>
    <td  height="100%"> 
    <object id="emreditor" classid="clsid:2202DAD5-034E-4490-976F-590A978E4D92" width="100%" height="100%">
		</object>
		<textarea style="visibility: hidden;" name="allInfo"><%=toBase64(inpAllInfo) %></textarea>
		<textarea style="visibility: hidden;" name="recordContent"><%=toBase64(tt.getTplData()) %></textarea>
		<textarea style="visibility: hidden;" name="moduleCont"><%=toBase64(xd.getDocumentElement().getOuterXML()) %></textarea>
		<textarea style="visibility: hidden;" name="allInfoXml"><%=inpAllInfo %></textarea>
		<%-- <textarea style="visibility: hidden;" name="diagsXmlstr"><%=diagsXmlstr %></textarea>
		<textarea style="visibility: hidden;" name="oprationInfoStr"><%=oprationInfoStr %></textarea>
		<textarea style="visibility: hidden;" name="recordContentStuct"></textarea> --%>
  </td>
  </tr>
  <tr>
		<td class="td_button_f">
		   <!--  <input type="button" value="病历资料" onclick="searchRoom('MedicalRecordF');" name="btnsr" class="f">
			<input type="checkbox" id="revision" style="width:auto;" onclick="revisionMode();">留痕查看 -->
			<input type="hidden" name="tplId" value="<%=tt.getTplID()%> ">
			<input type="hidden" name="tplVersion" value="<%=tt.getTplVersion() %> ">
		</td>
	</tr>
</table>    
</form>
</body>
<script type="text/javascript" defer="defer">


function initload(){

	 if(document.all.recordContent.value!=null&&document.all.recordContent.value.length>0){
		var str = '<document>\n';
		str += '<pagesetting height="1169" width="827" leftmargin="120" topmargin="80" rightmargin="120" bottommargin="80" landscape="0"/>\n';
		str += '<viewmode val="page"/>\n';
		str += '<font name="宋体" size="12" color="black" regular="true" bold="false" italic="false" underline="false" strikeout="false"/>\n';
		str += '<user id ="admin" name="管理员" department="测试科室" dutyID=""/>\n';
		str += '</document>';
		document.all.emreditor.InitForIE(str,window);
	 	document.all.emreditor.LoadAllXml(document.all.recordContent.value,document.all.allInfo.value,document.all.moduleCont.value,"base64","false"); 
	 	//医疗付费方式
	 	document.all.emreditor.SetValue("db","Inpatient","FeeTypeCode","<%=inp.getFeeTypeCode()%>","<%=inp.getFeeTypeCode()%>"); 
	 	//健康卡号
	 	document.all.emreditor.SetValue("db","Patient","InsuranceNo","<%=pat.getInsuranceNo()%>","<%=pat.getInsuranceNo()%>"); 
	 	//住院次数
	 	document.all.emreditor.SetValue("db","Inpatient","AdmissionTimes","<%=inp.getAdmissionTimes()%>","<%=inp.getAdmissionTimes()%>"); 
	 	//住院号
	 	document.all.emreditor.SetValue("db","Inpatient","AdminissionNo","<%=inp.getAdminissionNo()%>","<%=inp.getAdminissionNo()%>"); 
	 	//姓名
	 	document.all.emreditor.SetValue("db","Inpatient","PatientName","<%=inp.getPatientName()%>","<%=inp.getPatientName()%>"); 
		//性别代码	 	
	 	document.all.emreditor.SetValue("db","Inpatient","SexCode","<%=inp.getSexCode()%>","<%=inp.getSexCode()%>"); 
	 	//出生日期
	 	document.all.emreditor.SetValue("db","Patient","DataOfBirth","<%=pat.getDataOfBirth()%>","<%=pat.getDataOfBirth()%>"); 
		//年龄
	 	document.all.emreditor.SetValue("db","Inpatient","AgeDesc","<%=inp.getAgeDesc()%>","<%=inp.getAgeDesc()%>"); 
		//国籍
	 	document.all.emreditor.SetValue("db","Patient","Country","<%=pat.getCountry()%>","<%=pat.getCountry()%>"); 
		//出生地
	 	document.all.emreditor.SetValue("db","Patient","Birthplace","<%=pat.getBirthplace()%>","<%=pat.getBirthplace()%>"); 
	 	//籍贯
	 	document.all.emreditor.SetValue("db","Patient","NativePlace","<%=pat.getNativePlace()%>","<%=pat.getNativePlace()%>"); 
	 	//民族
	 	document.all.emreditor.SetValue("db","Patient","Nationality","<%=pat.getNationality()%>","<%=pat.getNationality()%>"); 
	 	//身份证号
	 	document.all.emreditor.SetValue("db","Patient","CertNo","<%=pat.getCertNo()%>","<%=pat.getCertNo()%>"); 
	 	//职业
	 	document.all.emreditor.SetValue("db","Patient","Occupation","<%=pat.getOccupation()%>","<%=pat.getOccupation()%>"); 
	 	//婚姻代码
	 	document.all.emreditor.SetValue("db","Patient","MarriageStatusCode","<%=pat.getMarriageStatusCode()%>","<%=pat.getMarriageStatusCode()%>"); 
	 	//现住址
	 	document.all.emreditor.SetValue("db","Patient","HomeAddress","<%=pat.getHomeAddress()%>","<%=pat.getHomeAddress()%>"); 
	 	//电话
	 	document.all.emreditor.SetValue("db","Patient","MobilePhone","<%=pat.getMobilePhone()%>","<%=pat.getMobilePhone()%>"); 
		//现住址邮编	 	
	 	document.all.emreditor.SetValue("db","Patient","HomePostcode","<%=pat.getHomePostcode()%>","<%=pat.getHomePostcode()%>"); 
	 	//户口地址
	 	document.all.emreditor.SetValue("db","Patient","RegisteredAddress","<%=pat.getRegisteredAddress()%>","<%=pat.getRegisteredAddress()%>"); 
		//户口邮编
	 	document.all.emreditor.SetValue("db","Patient","RegisteredEmail","<%=pat.getRegisteredEmail()%>","<%=pat.getRegisteredEmail()%>"); 
		//工作单位
	 	document.all.emreditor.SetValue("db","Patient","Company","<%=pat.getCompany()%>","<%=pat.getCompany()%>"); 
		//工作单位电话
	 	document.all.emreditor.SetValue("db","Patient","BusinessPhone","<%=pat.getBusinessPhone()%>","<%=pat.getBusinessPhone()%>"); 
	 	//工作单位邮编
	 	document.all.emreditor.SetValue("db","Patient","BusinessPostcode","<%=pat.getBusinessPostcode()%>","<%=pat.getBusinessPostcode()%>"); 
		
		
		
		
		document.all.emreditor.SetValue("db","DischargeSummary","WardName","<%=inp.getWardName()%>","<%=inp.getWardName()%>"); 
		
<%-- 		document.all.emreditor.RefreshControlsDataSource(document.all.allInfo.value,"base64");
		document.all.emreditor.SetScript("ctl","REGISTER_CHINESE_DIAGNOSIS","","javascript","showReasonList('门（急）诊诊断（中医诊断）')","onclick");
		document.all.emreditor.SetScript("ctl","REGISTER_DIAGNOSIS","","javascript","showReasonList('门（急）诊诊断（西医诊断）')","onclick");
		document.all.emreditor.SetScript("ctl","EXTERNAL_CAUESES","","javascript","showReasonList('损伤中毒原因')","onclick");
		document.all.emreditor.SetScript("ctl","PATHOLOGY_DIAGNOSIS","","javascript","showReasonList('病理诊断')","onclick");
		document.all.emreditor.SetScript("ctl","ALLERGIC_DRUG","","javascript","showDrugList('过敏药物')","onclick");
			//setFee();
		document.all.emreditor.SetScript("db","Inpatient","HospitalDischargeTime","javascript","selectDateTime('Inpatient','HospitalDischargeTime'),getInHospitalDay()","onclick");
		document.all.emreditor.SetValue3("ctl","InHopitalDay","","<%=Util.escapeInnerText(inHopitalDay)%>","<%=Util.escapeInnerText(inHopitalDay)%>",false);
		document.all.emreditor.SetValue3("ctl","CURE","","<%=Util.escapeInnerText(inpdiag.getOutcome())%>","<%=Util.escapeInnerText(inpdiag.getOutcome())%>",false);
		document.all.emreditor.SetValue3("ctl","IMPROVE","","<%=Util.escapeInnerText(inpdiag.getOutcome())%>","<%=Util.escapeInnerText(inpdiag.getOutcome())%>",false);
		document.all.emreditor.SetValue3("ctl","FAILURE","","<%=Util.escapeInnerText(inpdiag.getOutcome())%>","<%=Util.escapeInnerText(inpdiag.getOutcome())%>",false);
		document.all.emreditor.SetValue3("db","DischargeSummary","WardName","<%=Util.escapeInnerText(outWardName)%>","<%=Util.escapeInnerText(outWardName)%>",false);
		document.all.emreditor.SetValue3("ctl","COMPLETE","","<%=Util.escapeInnerText(clinicPathInfo)%>","<%=Util.escapeInnerText(clinicPathInfo)%>",false);
		document.all.emreditor.SetValue3("ctl","VARIANCE","","<%=Util.escapeInnerText(clinicPathInfo)%>","<%=Util.escapeInnerText(clinicPathInfo)%>",false);
		document.all.emreditor.SetValue3("ctl","EXIT","","<%=Util.escapeInnerText(clinicPathInfo)%>","<%=Util.escapeInnerText(clinicPathInfo)%>",false);
		document.all.emreditor.SetValue3("ctl","UNENTER","","<%=Util.escapeInnerText(clinicPathInfo)%>","<%=Util.escapeInnerText(clinicPathInfo)%>",false);
		document.all.emreditor.HandleCommand("fill_table_data","OPERATION_TABLE",document.all.oprationInfoStr.value,"1");
		document.all.emreditor.HandleCommand("refresh_data_source","doc","",document.all.diagsXmlstr.value); --%>
	 } 
}

function setFee(){
	<%-- document.all.emreditor.SetValue3("ctl","TOTAL_FEE","","<%=Util.escapeInnerText(frontSheetFee.getTotalCharge()) %>","<%=Util.escapeInnerText(frontSheetFee.getTotalCharge()) %>",false);            //总费用
	document.all.emreditor.SetValue3("ctl","SELF_SUPPORT_MONEY","","<%=Util.escapeInnerText(frontSheetFee.getSelfSupportMoney()) %>","<%=Util.escapeInnerText(frontSheetFee.getSelfSupportMoney()) %>",false);            //自付金额
	document.all.emreditor.SetValue3("ctl","MEDICAL_SERVICE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getMedicalServiceFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getMedicalServiceFee()) %>",false);            //一般医疗服务费
	document.all.emreditor.SetValue3("ctl","CHINESE_DIALECTIC_FEE","","<%=Util.escapeInnerText(frontSheetFee.getChineseDialecticFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseDialecticFee()) %>",false);            //中医辨证论治费
	document.all.emreditor.SetValue3("ctl","CDC_FEE","","<%=Util.escapeInnerText(frontSheetFee.getCdcFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getCdcFee()) %>",false);            //中医辨证论治会诊费

	document.all.emreditor.SetValue3("ctl","CURE_OPERATION_FEE","","<%=Util.escapeInnerText(frontSheetFee.getCureOperationFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getCureOperationFee()) %>",false);            //一般治疗操作费
	document.all.emreditor.SetValue3("ctl","NURSE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getNurseFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getNurseFee()) %>",false);            //护理费
	document.all.emreditor.SetValue3("ctl","ELSE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getElseFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getElseFee()) %>",false);            //其他费用
	document.all.emreditor.SetValue3("ctl","PATHOLOGY_DIAG_FEE","","<%=Util.escapeInnerText(frontSheetFee.getPathologyDiagFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getPathologyDiagFee()) %>",false);            //病理诊断费
	document.all.emreditor.SetValue3("ctl","LABORATORY_DIAG_FEE","","<%=Util.escapeInnerText(frontSheetFee.getLaboratoryDiagFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getLaboratoryDiagFee()) %>",false);            //实验室诊断费

	document.all.emreditor.SetValue3("ctl","VIDEO_DIAG_FEE","","<%=Util.escapeInnerText(frontSheetFee.getVideoDiagFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getVideoDiagFee()) %>",false);            //影像学诊断费
	document.all.emreditor.SetValue3("ctl","CLINIC_DIAG_FEE","","<%=Util.escapeInnerText(frontSheetFee.getClinicDiagFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getClinicDiagFee()) %>",false);            //临床诊断项目费
	document.all.emreditor.SetValue3("ctl","NOT_OPERATION_CURE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getNotOperationCureFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getNotOperationCureFee()) %>",false);            //非手术治疗项目费
	document.all.emreditor.SetValue3("ctl","CLINIC_PHYSICS_CURE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getClinicPhysicsCureFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getClinicPhysicsCureFee()) %>",false);            //临床物理治疗费
	document.all.emreditor.SetValue3("ctl","OPERATION_CURE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getOperationCureFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getOperationCureFee()) %>",false);            //手术治疗费

	document.all.emreditor.SetValue3("ctl","ANAESTHESIA_FEE","","<%=Util.escapeInnerText(frontSheetFee.getAnaesthesiaFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getAnaesthesiaFee()) %>",false);            //麻醉费
	document.all.emreditor.SetValue3("ctl","OPERATION_FEE","","<%=Util.escapeInnerText(frontSheetFee.getOperationFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getOperationFee()) %>",false);			  //手术费
	document.all.emreditor.SetValue3("ctl","HEALING_FEE","","<%=Util.escapeInnerText(frontSheetFee.getHealingFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getHealingFee()) %>",false);            //康复费
	document.all.emreditor.SetValue3("ctl","CHINESE_DIAG","","<%=Util.escapeInnerText(frontSheetFee.getChineseDiag()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseDiag()) %>",false);            //中医诊断
	document.all.emreditor.SetValue3("ctl","CHINESE_CURE","","<%=Util.escapeInnerText(frontSheetFee.getChineseCure()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseCure()) %>",false);            //中医治疗

	document.all.emreditor.SetValue3("ctl","CHINESE_EXT_TREATMENT","","<%=Util.escapeInnerText(frontSheetFee.getChineseExtTreatment()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseExtTreatment()) %>",false);            //中医外治
	document.all.emreditor.SetValue3("ctl","CHINESE_BONE_FRACTURE","","<%=Util.escapeInnerText(frontSheetFee.getChineseBoneFracture()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseBoneFracture()) %>",false);            //中医骨伤
	document.all.emreditor.SetValue3("ctl","PRICK_MOXIBUSTION","","<%=Util.escapeInnerText(frontSheetFee.getPrickMoxibustion()) %>","<%=Util.escapeInnerText(frontSheetFee.getPrickMoxibustion()) %>",false);            //针刺与灸法
	document.all.emreditor.SetValue3("ctl","CHINESE_MASSAGE_CURE","","<%=Util.escapeInnerText(frontSheetFee.getChineseMassageCure()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseMassageCure()) %>",false);            //中医推拿治疗
	document.all.emreditor.SetValue3("ctl","CHINESE_ANUS_CURE","","<%=Util.escapeInnerText(frontSheetFee.getChineseAnusCure()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseAnusCure()) %>",false);            //中医肛肠治疗

	document.all.emreditor.SetValue3("ctl","CHINESE_ESPECIAL_CURE","","<%=Util.escapeInnerText(frontSheetFee.getChineseEspecialCure()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseEspecialCure()) %>",false);            //中医特殊治疗
	document.all.emreditor.SetValue3("ctl","CHINESE_ELSE","","<%=Util.escapeInnerText(frontSheetFee.getChineseElse()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseElse()) %>",false);            //中医其他
	document.all.emreditor.SetValue3("ctl","CHINESE_ESPECIAL_PREPARE","","<%=Util.escapeInnerText(frontSheetFee.getChineseEspecialPrepare()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseEspecialPrepare()) %>",false);            //中药特殊调配加工
	document.all.emreditor.SetValue3("ctl","MIALECTIC_MEAL","","<%=Util.escapeInnerText(frontSheetFee.getMialecticMeal()) %>","<%=Util.escapeInnerText(frontSheetFee.getMialecticMeal()) %>",false);            //辨证施膳
	document.all.emreditor.SetValue3("ctl","WESTERN_MEDICINE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getWesternMedicineFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getWesternMedicineFee()) %>",false);            //西药费

	document.all.emreditor.SetValue3("ctl","ANTIBACTERIAL_FEE","","<%=Util.escapeInnerText(frontSheetFee.getAntibacterialFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getAntibacterialFee()) %>",false);            //抗菌药物费用
	document.all.emreditor.SetValue3("ctl","CHINESE_DRUG_FEE","","<%=Util.escapeInnerText(frontSheetFee.getChineseDrugFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getChineseDrugFee()) %>",false);            //中成药费
	document.all.emreditor.SetValue3("ctl","CMMP_FEE","","<%=Util.escapeInnerText(frontSheetFee.getCmmpFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getCmmpFee()) %>",false);            //医疗机构中药制剂费
	document.all.emreditor.SetValue3("ctl","HERBAL_MEDICINE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getHerbalMedicineFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getHerbalMedicineFee()) %>",false);            //中草药费
	document.all.emreditor.SetValue3("ctl","BLOOD_FEE","","<%=Util.escapeInnerText(frontSheetFee.getBloodFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getBloodFee()) %>",false);            //血费

	document.all.emreditor.SetValue3("ctl","ALBUMIN_PRODUCE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getAlbuminProduceFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getAlbuminProduceFee()) %>",false);            //白蛋白类制品费
	document.all.emreditor.SetValue3("ctl","GLOBIN_PRODUCE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getGlobinProduceFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getGlobinProduceFee()) %>",false);            //球蛋白类制品费
	document.all.emreditor.SetValue3("ctl","CRUOR_PRODUCE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getCruorProduceFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getCruorProduceFee()) %>",false);            //凝血因子类制品费
	document.all.emreditor.SetValue3("ctl","CELL_PRODUCE_FEE","","<%=Util.escapeInnerText(frontSheetFee.getCellProduceFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getCellProduceFee()) %>",false);            //细胞因子类制品费
	document.all.emreditor.SetValue3("ctl","EOM_FEE","","<%=Util.escapeInnerText(frontSheetFee.getEomFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getEomFee()) %>",false);            //检查用一次性医用材料费

	document.all.emreditor.SetValue3("ctl","COM_FEE","","<%=Util.escapeInnerText(frontSheetFee.getComFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getComFee()) %>",false);            //治疗用一次性医用材料费
	document.all.emreditor.SetValue3("ctl","OOM_FEE","","<%=Util.escapeInnerText(frontSheetFee.getOomFee()) %>","<%=Util.escapeInnerText(frontSheetFee.getOomFee()) %>",false);            //手术用一次性医用材料费
	document.all.emreditor.SetValue3("ctl","ELSE_CHARGE","","<%=Util.escapeInnerText(frontSheetFee.getElseCharge()) %>","<%=Util.escapeInnerText(frontSheetFee.getElseCharge()) %>",false);            //其他费
	--%>
}


window.setTimeout("initload()",1);

function loadXml(text){
	var xmldoc = new ActiveXObject("Microsoft.XMLDOM");  
	xmldoc.async = "false";  
	xmldoc.loadXML(text); 
	return xmldoc;
}



</script>
</html>