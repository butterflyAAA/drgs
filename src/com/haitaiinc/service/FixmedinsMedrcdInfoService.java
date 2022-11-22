package com.haitaiinc.service;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haitaiinc.Util;
import com.haitaiinc.common.DataUtil;
import com.haitaiinc.dao.EmrDao;
import com.haitaiinc.dao.HisDao;
import com.haitaiinc.hisdb.dictmanage.DictDepart;
import com.haitaiinc.htdb.adt.dto.Inpatient;
import com.haitaiinc.htdb.comm.dto.SystemDict;
import com.haitaiinc.htdb.inpcase.dto.DeathRec;
import com.haitaiinc.htdb.inpcase.dto.DischargeSummary;
import com.haitaiinc.htdb.inpcase.dto.FrontSheet;
import com.haitaiinc.htdb.inpcase.dto.HospitalRecord;
import com.haitaiinc.htdb.inpcase.dto.InpDiag;
import com.haitaiinc.htdb.inpcase.dto.OperationInfoRec;
import com.haitaiinc.htdb.inpcase.dto.ProgressNote;
import com.haitaiinc.htdb.inptemper.dto.Temperature;
import com.haitaiinc.htdb.inptemper.dto.TemperatureDetail;
import com.haitaiinc.htdb.mpi.dto.Patient;
import com.haitaiinc.htdb.usermgmt.dto.UserInfo;
import com.haitaiinc.system.ConfigManager;
import com.haitaiinc.xml.XMLDocument;
import com.haitaiinc.xml.XMLNode;

import dom.TemplateOperator;

public class FixmedinsMedrcdInfoService {

	public static void main(String[] args) {
//		HospitalRecord hr=new EmrDao().getHospitalRecordByIpid("150705");
//		String xmlCont=hr.getXmlCont();
//		TemplateOperator to=new TemplateOperator();
//		to.loadXml(xmlCont);
//		String ELAPSEMHIS=to.getTextValueOrPanelTextById("75FBA87AABFD48B68EAB430E73A6295C");
//		System.out.println("------"+ELAPSEMHIS);
//		JSONObject hrJson=JSONArray.parseObject(JSONArray.toJSON(hr).toString());
//		System.out.println(hrJson);
		String jsonStr="{\"ipid\": \"151083\",\"fixmedins_code\": \"1234\",\"mdtrt_sn\": \"111\",\"mdtrt_id\": \"2222\",\"psn_no\": \"33333\"}";
		String retStr=new FixmedinsMedrcdInfoService().getFixmedinsMedrcdInfoServiceByIpid(jsonStr);
		System.out.println("==="+retStr);
	}
	
	protected List<DictDepart> hisDeptList=null;
	protected Map<String,List<SystemDict>> map=null;
	protected TemperatureDetail td=null;
	protected Temperature temper=null;
	public String getFixmedinsMedrcdInfoServiceByIpid(String jsonStr){
		try{
			JSONObject inputStr=JSONArray.parseObject(jsonStr);
			String ipid=inputStr.getString("ipid");
			JSONObject retjson=new JSONObject();
			Inpatient inp=new EmrDao().getInpateintByipid(ipid);
			td=new EmrDao().getTemperatureDetail(ipid);
			temper=new EmrDao().getTemperature(ipid);
			if(Util.isEmpty(inp.getNurseID())){
				inp.setNurseID(td!=null?td.getCreator():"");
				UserInfo ui=new EmrDao().getUserInfoByipid(td.getCreator());
				inp.setNurse(ui!=null?ui.getUserName():"");
			}
			if(inp!=null&&inp.getIpid()!=null){
				JSONObject inpJson=JSONArray.parseObject(JSONArray.toJSON(inp).toString());
				Patient pat=new EmrDao().getPatientByPid(inp.getPid());
				JSONObject patJson=JSONArray.parseObject(JSONArray.toJSON(pat).toString());
				
				this.hisDeptList= new HisDao().getDictDepart();
				this.map= new EmrDao().getSystemDictListByItemType();
				URL url = ConfigManager.class.getResource("/4701.xml");
				XMLDocument xdDoc = XMLDocument.parse(new File(url.toURI()));
				
				/**
				 * 表 223 输入-入院信息（节点标识：adminfo）
				 */
				HospitalRecord hr=new EmrDao().getHospitalRecordByIpid(ipid);
				HospitalRecord hr1=new EmrDao().getAdmissionDischarge24hRecByIpid(ipid);
				if(hr!=null&&hr1!=null){
					hr.setXmlCont(hr1.getXmlCont());
				}
				XMLNode[] dataEles = xdDoc.getDocumentElement().selectNodes("/Config/adminfo");
				for(int i=0;i<dataEles.length;i++){
					JSONObject json=new JSONObject();
					if(hr!=null&&hr.getIpid()!=null){
						JSONObject hrJson=JSONArray.parseObject(JSONArray.toJSON(hr).toString());
						XMLNode xn = dataEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//节点名称
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//节点值
								String value=getValue(cxn,nodeName,hr.getXmlCont(),inpJson,patJson,hrJson,inputStr,ipid+"  adminfo");
								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}
								
								json.put(nodeName, value);

							}
						}

					}else{
						XMLNode xn = dataEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//节点名称
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//节点值
								String value=getValue(cxn,nodeName,"",inpJson,patJson,null,inputStr,ipid);
								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}
								json.put(nodeName, value);

							}
						}
					}
					retjson.put("adminfo", json);
				}


				/**
				 * 表 224 输入-诊断信息（节点标识：diseinfo）
				 */
				String westIcd="";//西医主诊断
				String westDiagName="";//西医主诊断
				String chineseIcd="";//中医主诊断
				String chineseDiagName="";//中医主诊断
				//入院主诊断
				XMLNode[] inpDiagEles = xdDoc.getDocumentElement().selectNodes("/Config/diseinfo");
				List<InpDiag> inpDiagList=new EmrDao().getInpDiagListByIpid(ipid);
				Map<String,List<InpDiag>> mapInpDiagMap=featchInpDiagListToMap(inpDiagList);
				/**
				 * 中医inpDiagList根据sup_diag_sn转成map。用来疾病症候转成一条数据
				 */
				Map<String,String> isInMainFlagMap =new HashMap<String,String>();
				Map<String,String> isOutMainFlagMap =new HashMap<String,String>();
				for(int i=0;i<inpDiagEles.length;i++){
					JSONArray jsonArray=new JSONArray();
					if(inpDiagList!=null&&inpDiagList.size()>0){
						String isOutMainFlag="";//出院主诊断标志
						String isInMainFlag="";//入院主诊断标志
						for (int a=0;a<inpDiagList.size();a++){
							JSONObject json=new JSONObject();
							InpDiag inpDiag=inpDiagList.get(a);
							if(!"0001".equals(inpDiag.getDiagClassCode())){
								continue;
							}
							JSONObject diagJson=JSONArray.parseObject(JSONArray.toJSON(inpDiag).toString());
							XMLNode xn = inpDiagEles[i];
							XMLNode[] childs =xn.getChildNodes();
							for(int j=0;j<childs.length;j++){
								XMLNode cxn =childs[j];
								//节点名称
								String nodeName=cxn.getNodeName();
								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
									//节点值
									String value="";
									//									
									if("maindiag_flag".equals(nodeName)){
										if("cbzd".equals(inpDiag.getDiagTypeCode())||"ryzd".equals(inpDiag.getDiagTypeCode())){
											if("".equals(isInMainFlag)){
												isInMainFlag="1";
											}else{
												isInMainFlag="0";
											}
											isInMainFlagMap.put(inpDiag.getDiagSN(), isInMainFlag);
											value=isInMainFlag;
										}
										else if("swzd".equals(inpDiag.getDiagTypeCode())||"cyzd".equals(inpDiag.getDiagTypeCode())){
											if("".equals(isOutMainFlag)){
												isOutMainFlag="1";
											}else{
												isOutMainFlag="0";
											}
											isOutMainFlagMap.put(inpDiag.getDiagSN(), isOutMainFlag);
											value=isOutMainFlag;
										}else{
											value="0";
										}
									}
									else if("diag_seq".equals(nodeName)){
//										value=inpDiag.getOrdinal();
										value=a+"";
									}
									else if("wm_diag_code".equals(nodeName)){//西医诊断编码
										if("0001".equals(inpDiag.getDiagClassCode())){
											value=inpDiag.getICDCode();
											if("1".equals(isInMainFlag)){
												westIcd=inpDiag.getICDCode();//西医主诊断
												westDiagName=inpDiag.getDiagName();//西医主诊断
											}
										}
									}else if("wm_diag_name".equals(nodeName)){//西医诊断名称
										if("0001".equals(inpDiag.getDiagClassCode())){
											value=inpDiag.getDiagName();
										}
									}else{
										value=getValue(cxn,nodeName,hr!=null?hr.getXmlCont():"",inpJson,patJson,diagJson,inputStr,ipid+"  diseinfo");
										if(value!=null&&value.indexOf("err_msg")>-1){
											return value;
										}
									}
									if("0001".equals(inpDiag.getDiagClassCode())){
										json.put(nodeName, value);
									}
									
									
								}
							}
							if("0001".equals(inpDiag.getDiagClassCode())){
								jsonArray.add(json);
							}else if("0002".equals(inpDiag.getDiagClassCode())){//mapInpDiagMap里包含了0002和0003为了 防止重复。只取0002
								List<InpDiag> tempList=mapInpDiagMap.get(inpDiag.getSupDiagSN());
								for(int b=0;tempList!=null&&b<tempList.size();b++){
									InpDiag tempInpDiag=tempList.get(b);
									String icdCode=tempInpDiag.getICDCode();
									String icdName=tempInpDiag.getDiagName();
									
									if("cbzd".equals(tempInpDiag.getDiagTypeCode())||"ryzd".equals(tempInpDiag.getDiagTypeCode())){
										json.put("inout_diag_type", "1");
									}else if("swzd".equals(tempInpDiag.getDiagTypeCode())||"cyzd".equals(tempInpDiag.getDiagTypeCode())){
										json.put("inout_diag_type", "2");
									}else{
										json.put("inout_diag_type", "1");
									}
									
									String tempinMain=isInMainFlagMap.get(tempInpDiag.getDiagSN());
									String tempOutMain=isOutMainFlagMap.get(tempInpDiag.getDiagSN());
									if(tempinMain!=null&&tempinMain.length()>0){
										json.put("maindiag_flag", tempinMain);
									}else if(tempOutMain!=null&&tempOutMain.length()>0){
										json.put("maindiag_flag", tempOutMain);
									}else{
										json.put("maindiag_flag", "0");
									}
									json.put("diag_seq", (a+1)+"");
									json.put("diag_time", Util.format(tempInpDiag.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
									json.put("wm_diag_code","");
									json.put("wm_diag_name","");
									json.put("vali_flag","1");
									if("0002".equals(tempInpDiag.getDiagClassCode())){
										if("1".equals(isInMainFlag)){
											chineseIcd=inpDiag.getICDCode();//中医主诊断
											chineseDiagName=inpDiag.getDiagName();//中医主诊断
										}
										json.put("tcm_dise_code", icdCode);
										json.put("tcm_dise_name", icdName);
									}else if("0003".equals(tempInpDiag.getDiagClassCode())){
										json.put("tcmsymp_code", icdCode);
										json.put("tcmsymp", icdName);
									}
								}
								jsonArray.add(json);
							}
							
						}

					}else{
						JSONObject json=new JSONObject();
						XMLNode xn = inpDiagEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//节点名称
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//节点值
								String value=getValue(cxn,nodeName,"",inpJson,patJson,null,inputStr,ipid);
								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}


								json.put(nodeName, value);

							}
						}
						jsonArray.add(json);
					}
					retjson.put("diseinfo", jsonArray);
				}
				
				//病程记录---抢救记录
				List<ProgressNote> qjjlList=new ArrayList<ProgressNote>();
				/**
				 * 表 225 输入-病程记录（节点标识：coursrinfo）
				 */
				XMLNode[] coursrinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/coursrinfo");
				List<ProgressNote> progressNoteList=new EmrDao().getProgressNoteByIpid(ipid);
				for(int i=0;i<coursrinfoEles.length;i++){
					JSONArray jsonArray=new JSONArray();
					//主诉，为了普通病程记录使用
					String chfcomp="";
					if(progressNoteList!=null&&progressNoteList.size()>0){
						for (int a=0;a<progressNoteList.size();a++){
							JSONObject json=new JSONObject();
							ProgressNote progressNote=progressNoteList.get(a);
							if(progressNote.getPnTypeDesc().indexOf("抢救记录")>-1){
								qjjlList.add(progressNote);
							}
							if("0008".equals(progressNote.getPnTypeCode())){

								JSONObject progressNoteJson=JSONArray.parseObject(JSONArray.toJSON(progressNote).toString());
								XMLNode xn = coursrinfoEles[i];
								XMLNode[] childs =xn.getChildNodes();
								for(int j=0;j<childs.length;j++){
									XMLNode cxn =childs[j];
									//节点名称
									String nodeName=cxn.getNodeName();
									if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
										//节点值
										String value="";
										value=getValue(cxn,nodeName,progressNote.getXmlCont(),inpJson,patJson,progressNoteJson,inputStr,ipid+"  coursrinfo");
										if("chfcomp".equals(nodeName)){

											if(Util.isEmpty(value)){
												if(!"".equals(chfcomp)){
													value=chfcomp.substring(0,33);
												}else{
													if(hr!=null){
														if(hr.getChiefComplaint()!=null &&hr.getChiefComplaint().length()>33){
															value= hr.getChiefComplaint().substring(0,33);
														}else{
															value= hr.getChiefComplaint();
														}
														
														if(Util.isEmpty(value)){
															value="无";
														}
													}else{
														value="无";
													}
												}
											}else{
												chfcomp=value.substring(0,33);
											}

										}
										else if("prnt_doc_name".equals(nodeName)){
											if(Util.isEmpty(value)){
												cxn.setTextContent("creatorName");
												value=getValue(cxn,nodeName,progressNote.getXmlCont(),inpJson,patJson,progressNoteJson,inputStr,ipid);
											}
										}
										else if("prel_wm_diag_code".equals(nodeName)){
											value=westIcd;//西医主诊断
										}
										else if("prel_wm_dise_name".equals(nodeName)){
											value=westDiagName;//西医主诊断
										}
										else if("prel_tcm_diag_code".equals(nodeName)){
											value=chineseIcd;//中医主诊断
										}
										else if("prel_tcm_dise_name".equals(nodeName)){
											value=chineseDiagName;//中医主诊断
										}
										else if("codse_rcd_id".equals(nodeName)){
											value=(a+1)+"";
										}
										
										if("cas_ftur".equals(nodeName)&&value!=null&&value.length()>333){
											value=value.substring(0, 333);
										}
										
										if(value!=null&&value.indexOf("err_msg")>-1){
											return value;
										}
										json.put(nodeName, value);
									}
								}
								jsonArray.add(json);
							}
						}
					}else{
						JSONObject json=new JSONObject();
						XMLNode xn = coursrinfoEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//节点名称
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//节点值
								String value=getValue(cxn,nodeName,"",inpJson,patJson,null,inputStr,ipid);

								if("chfcomp".equals(nodeName)){
									value="无";
								}else if("ipdr_code".equals(nodeName)){
									value=inpJson.getString("doctor");
								}else if("ipdr_name".equals(nodeName)){
									value=inpJson.getString("doctorID");
								}else if("prnt_doc_name".equals(nodeName)){
									value=inpJson.getString("doctor");
								}else if("codse_rcd_id".equals(nodeName)){
									value="1";
								}else if("prel_wm_diag_code".equals(nodeName)){
									value=westIcd;//西医主诊断
								//	value =  inp.getPrincipalDiagnosisCode();
								}
								else if("prel_wm_dise_name".equals(nodeName)){
									value=westDiagName;//西医主诊断
									//value = inp.getPrincipalDiagnosis();
								}
								else if("prel_tcm_diag_code".equals(nodeName)){
									value=chineseIcd;//中医主诊断
								}
								else if("prel_tcm_dise_name".equals(nodeName)){
									value=chineseDiagName;//中医主诊断
								}else if("rcd_time".equals(nodeName)){
									value=Util.format(inpJson.getString("admissionTime"), "yyyy-MM-dd HH:mm:ss");
								}

								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}
								json.put(nodeName, value);

							}
						}
						jsonArray.add(json);
					}

					retjson.put("coursrinfo", jsonArray);
				}
				
				/**
				 * 手术记录（节点标识：oprninfo）
				 */
				XMLNode[] oprninfoEles = xdDoc.getDocumentElement().selectNodes("/Config/oprninfo");
				List<OperationInfoRec> operationInfoRecList=new EmrDao().getOperationInfoRecListByIpid(ipid);
				for(int i=0;i<oprninfoEles.length;i++){
					JSONArray jsonArray=new JSONArray();
					if(operationInfoRecList!=null&&operationInfoRecList.size()>0){
						for (int a=0;a<operationInfoRecList.size();a++){
							JSONObject json=new JSONObject();
							OperationInfoRec oir=operationInfoRecList.get(a);
							if("".equals(oir.getOperationStartTime())| oir.getOperationStartTime()==null){
								oir.setOperationStartTime(oir.getOperationTime());

							}

							if("".equals(oir.getOperationEndTime())|
									oir.getOperationEndTime()==null){
								SimpleDateFormat df = new SimpleDateFormat
										("yyyyMMddHHmmss");
								Calendar calendar = Calendar.getInstance();
								calendar.setTime(df.parse
										(oir.getOperationStartTime()));
								calendar.add(Calendar.HOUR_OF_DAY,3);
								Date time = calendar.getTime();
								oir.setOperationEndTime(df.format(time));
							}

							if(compareDate(oir.getOperationStartTime
									(),oir.getOperationEndTime())){
								SimpleDateFormat df = new SimpleDateFormat
										("yyyyMMddHHmmss");
								Calendar calendar = Calendar.getInstance();
								calendar.setTime(df.parse
										(oir.getOperationStartTime()));
								calendar.add(Calendar.HOUR_OF_DAY,3);
								Date time = calendar.getTime();
								oir.setOperationEndTime(df.format(time));

							}
							JSONObject oirJson=JSONArray.parseObject(JSONArray.toJSON(oir).toString());
							XMLNode xn = oprninfoEles[i];
							XMLNode[] childs =xn.getChildNodes();
							for(int j=0;j<childs.length;j++){
								XMLNode cxn =childs[j];
								//节点名称
								String nodeName=cxn.getNodeName();
								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
									//节点值
									String value="";
									if("oprn_seq".equals(nodeName)){
										value=(a+1)+"";
									}else{
										value=getValue(cxn,nodeName,null,inpJson,patJson,oirJson,inputStr,ipid+"  oprninfo");
										
									}
									if(value!=null&&value.indexOf("err_msg")>-1){
										return value;
									}
									json.put(nodeName, value);
									
								}
								
							}
							jsonArray.add(json);
						}
					}
//					else{
//						JSONObject json=new JSONObject();
//						XMLNode xn = oprninfoEles[i];
//						XMLNode[] childs =xn.getChildNodes();
//						for(int j=0;j<childs.length;j++){
//							XMLNode cxn =childs[j];
//							//节点名称
//							String nodeName=cxn.getNodeName();
//							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//								//节点值
//								String value=getValue(cxn,nodeName,null,inpJson,patJson,null,inputStr,ipid);
//								if(value!=null&&value.indexOf("err_msg")>-1){
//									return value;
//								}
//								json.put(nodeName, value);
//							}
//						}
//						jsonArray.add(json);
//					}
					retjson.put("oprninfo", jsonArray);
				}
				/**
				 * 输入-病情抢救记录
				 */
				if(qjjlList!=null&&qjjlList.size()>0){
					XMLNode[] rescinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/rescinfo");
					JSONArray jsonArray=new JSONArray();
					for(int i=0;i<rescinfoEles.length;i++){
						for (int a=0;a<operationInfoRecList.size();a++){
							JSONObject json=new JSONObject();
							ProgressNote pn=qjjlList.get(a);
							JSONObject pnJson=JSONArray.parseObject(JSONArray.toJSON(pn).toString());
							XMLNode xn = rescinfoEles[i];
							XMLNode[] childs =xn.getChildNodes();
							for(int j=0;j<childs.length;j++){
								XMLNode cxn =childs[j];
								//节点名称
								String nodeName=cxn.getNodeName();
								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
									//节点值
									String value="";
									if("resc_id".equals(nodeName)){
										value=(a+1)+"";
									}else{
										value=getValue(cxn,nodeName,null,inpJson,patJson,pnJson,inputStr,ipid+"  rescinfo");
										if(value!=null&&value.indexOf("err_msg")>-1){
											return value;
										}
									}
									
									json.put(nodeName, value);
								}
							}
							jsonArray.add(json);
						}
					}
					retjson.put("rescinfo", jsonArray);
				}
				
				/**
				 * 生成 dieinfo
				 */
				XMLNode[] dieinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/dieinfo");
				DeathRec dr=new EmrDao().getDeadRecByIpid(ipid);
				if(dr!=null){
					JSONObject drJson=JSONArray.parseObject(JSONArray.toJSON(dr).toString());
					for(int i=0;i<dieinfoEles.length;i++){
						JSONObject json=new JSONObject();
						XMLNode xn = dieinfoEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//节点名称
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//节点值
								String xmlCont=dr!=null?dr.getXmlCont():"";
								if("die_time".equals(nodeName)){
									System.out.println("die_time");
								}
								String value=getValue(cxn,nodeName,xmlCont,inpJson,patJson,drJson,inputStr,ipid+"  dieinfo");
								if("die_drt_rea".equals(nodeName)){
									value=westDiagName;
								}else if("die_drt_rea_code".equals(nodeName)){
									if(westIcd.length()>10){
										value=westIcd.replace("x", "");
									}else{
										value=westIcd;
									}
								}else if("die_dise_name".equals(nodeName)){
									value=westDiagName;
								}else if("die_diag_code".equals(nodeName)){
									value=westIcd;
								}
								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}
								json.put(nodeName, value);
							}
						}
						retjson.put("dieinfo", json);
					}
				}
				
				/**
				 * 生成 dscginfo
				 */
				XMLNode[] dscginfoEles = xdDoc.getDocumentElement().selectNodes("/Config/dscginfo");
				DischargeSummary ds=new EmrDao().getDischargeSummaryByIpid(ipid);
				if(ds!=null&&ds.getIpid()!=null){
					JSONObject dsJson=JSONArray.parseObject(JSONArray.toJSON(ds).toString());
					JSONObject json=new JSONObject();
					for(int i=0;i<dscginfoEles.length;i++){
						XMLNode xn = dscginfoEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//节点名称
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//节点值
								String xmlCont=ds!=null?ds.getXmlCont():"";
								String value=getValue(cxn,nodeName,xmlCont,inpJson,patJson,dsJson,inputStr,ipid+"  dscginfo");
								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}
								json.put(nodeName, value);
							}
						}
					}
					retjson.put("dscginfo", json);
				}
				
				return retjson.toJSONString();
			}else{
				JSONObject errJson=new JSONObject();
				errJson.put("infcode", "-1");//交易状态码
				errJson.put("err_msg", ipid+"该病人不存在！！");
				return errJson.toJSONString();
			}
		}catch(Exception e){
			e.printStackTrace();
			JSONObject errJson=new JSONObject();
			errJson.put("infcode", "-1");//交易状态码
			errJson.put("err_msg", e.getMessage());
			return errJson.toJSONString();
		}finally{
			
		}
	}
	
	public String getValue(XMLNode cxn,String nodeName,String xmlCont,JSONObject inpJson,JSONObject patJson,JSONObject json,JSONObject inputStr,String ipid){
		String value="";
		if("fixmedins_code".equals(nodeName)){
			value= inputStr.getString("fixmedins_code");
		}else if("mdtrt_sn".equals(nodeName)){
			value= inputStr.getString("mdtrt_sn");
		}else if("mdtrt_id".equals(nodeName)){
			value= inputStr.getString("mdtrt_id");
		}else if("psn_no".equals(nodeName)){
			value= inputStr.getString("psn_no");
		}else{
			if("physexm_systolic_pre".equals(nodeName)){
				System.out.println();
			}
			/**
			 * 判断数据类型
			 */
			String type=cxn.getAttribute("type");
			
			//节点值
			String textContent=cxn.getTextContent();
			//节点属性值
			String structId=cxn.getAttribute("struct_id");
			String table=cxn.getAttribute("table");

			/**
			 * 如果节点属性structId不为空。则按照structId值取模板数据。
			 */
			if(structId!=null&&structId.length()>0){
				if(xmlCont!=null&&xmlCont.length()>0){
					TemplateOperator to=new TemplateOperator();
					to.loadXml(xmlCont);
					if(structId.indexOf("/")>-1){
						String ss="";
						String[] struct_ids=structId.split("/");
						for(int a=0;a<struct_ids.length;a++){
							if("".equals(ss)){
								ss=DataUtil.toString(to.getTextValueOrPanelTextById(struct_ids[a]));
							}else{
								ss=ss+"/"+DataUtil.toString(to.getTextValueOrPanelTextById(struct_ids[a]));
							}
							
							
						}
						value=ss;
					}else if(structId.indexOf(";")>-1){
						String ss="";
						String[] struct_ids=structId.split(";");
						if(structId.indexOf("isnotnull")>0){
							return "0.0";
						}
						for(int a=0;a<struct_ids.length;a++){
							if("".equals(ss)){
								ss=DataUtil.toString(to.getTextValueOrPanelTextById(struct_ids[a]));
							}else{
								ss=ss+""+DataUtil.toString(to.getTextValueOrPanelTextById(struct_ids[a]));
							}
							String sss="";
							if(!Util.isEmpty(ss)){
								if("number".equals(type)){
									try{
										double d=Double.parseDouble(ss);
										sss="isnumber";
									}catch(Exception e){
										e.printStackTrace();
									}
								 }
							}
							if("isnumber".equals(sss)){
								break;
							}
						}
						value=ss;
					}else{
						value=to.getTextValueOrPanelTextById(structId);
					}
					
					if("mena_his".equals(nodeName)){
						String temp=to.getTextValueOrPanelTextById("5B74F0DBAD6A4D6582F91368F6C61662");
						String[] str=value.split("。");
						if(str!=null&&str.length>1){
							value=temp+str[1];
						}else{
							value=temp;
						}
					}
				}else{
					value="无";
				}
			}
			/**
			 * 如果节点属性table不为空。则按照table判断哪个表，然后用节点值取对应json的值
			 */
			else if(table!=null&&table.length()>0){
				if("INPATIENT".equals(table)){

					value=inpJson.get(textContent)+"";
				}
				else if("PATIENT".equals(table)){
					value=patJson.get(textContent)+"";
				}
				else if("HOSPITALRECORD".equals(table)&&json!=null){
					value=json.get(textContent)+"";
				}
				else if("INPDIAG".equals(table)&&json!=null){
					value=json.get(textContent)+"";
				}
				else if("PROGRESSNOTE".equals(table)&&json!=null){
					value=json.get(textContent)+"";
				}
				else if("OPERATIONINFOREC".equals(table)&&json!=null){
					value=json.get(textContent)+"";
				}
				else if("DISCHARGESUMMARY".equals(table)&&json!=null){
					value=json.get(textContent)+"";
				}
				else if("DEATHREC".equals(table)&&json!=null){
					value=json.get(textContent)+"";
				}
			}
			/**
			 * 如果都没有，则判断节点值是否为空,不为空的话，则直接默认值
			 */
			else if(!Util.isEmpty(DataUtil.toString(textContent))){
				value=textContent;
			}
			if(Util.isEmpty(value)){
				/**
				 * 生命体征没有取体温单信息
				 */
				if("physexm_tprt".equals(nodeName)){//体温
					value=td.getTemper();
					if(Util.isEmpty(value)){
						value="0";
					}
				}
				else if("physexm_pule".equals(nodeName)){//脉搏
					value=td.getPulse();
					if(Util.isEmpty(value)){
						value="0";
					}
				}
				else if("physexm_vent_frqu".equals(nodeName)){//呼吸
					value=td.getBreath();
					if(Util.isEmpty(value)){
						value="0";
					}
				}
				else if("physexm_systolic_pre".equals(nodeName)){//收缩压
					value=temper.getSystolicPressure();
					if(Util.isEmpty(value)){
						value="0";
					}
				}
				else if("physexm_dstl_pre".equals(nodeName)){//舒张压
					value=temper.getDiastolicPressure();
					if(Util.isEmpty(value)){
						value="0";
					}
				}
				else if("physexm_height".equals(nodeName)){//身高
					value=temper.getHeight();
					if(Util.isEmpty(value)){
						value="0";
					}
				}
				else if("physexm_wt".equals(nodeName)){//体重
					value=temper.getWeight();
					if(Util.isEmpty(value)){
						value="0";
					}
				}
				
				
			}
			/**
			 * 处理空和"无"
			 */
			value=DataUtil.toString(value);

			/**
			 * 判断dict是否为空，不为空，则用dict去进行转换
			 */
			String dict=cxn.getAttribute("dict");
			if(!Util.isEmpty(dict)){
				value=getDictCodeByTypeAndName(dict,value);
			}
			
			if("date".equals(type)){
				String format=cxn.getAttribute("format");
				try{
					if(value!=null&&value.indexOf("月")>-1){
						value=value.replace("月", "无");
					}
					if(value!=null&&value.indexOf("日")>-1||value!=null&&value.indexOf("号")>-1){
						value=value.replace("日", "无");
						value=value.replace("号", "无");
					}
					value=Util.format(value, format);
				}catch(Exception e){
					value="";
				}
			}
			else if("number".equals(type)){
				try{
					Double.parseDouble(value);
					//					Integer.parseInt(value);
				}catch(Exception e){
					value="0";
				}
			}
		}
		if("illhis_stte_name".equals(nodeName)&&Util.isEmpty(value)){
			value=inpJson.getString("patientName");
		}else if("illhis_stte_rltl".equals(nodeName)&&Util.isEmpty(value)){
			value="01";
		}else if("stte_rele".equals(nodeName)&&Util.isEmpty(value)){
			value="1";
		}
//		else if("oprn_time".equals(nodeName)&&Util.isEmpty(value)){
//		value=inpJson.get("admissionTime")+"";
//	}
		else if("oprn_begntime".equals(nodeName)&&Util.isEmpty(value)){
			value=Util.format(json.get("operationTime")+"", "yyyy-MM-dd HH:mm:ss");
		}
		else if("oprn_endtime".equals(nodeName)&&Util.isEmpty(value)){
			value=Util.format(json.get("operationTime")+"", "yyyy-MM-dd HH:mm:ss");
		}
		else if("resc_begntime".equals(nodeName)&&Util.isEmpty(value)){
			value=Util.format(json.get("pnDateTime")+"", "yyyy-MM-dd HH:mm:ss");
		}
		else if("resc_endtime".equals(nodeName)&&Util.isEmpty(value)){
			value=Util.format(json.get("pnDateTime")+"", "yyyy-MM-dd HH:mm:ss");
		}
		
		/**
		 * 判断长度
		 */
		String length=cxn.getAttribute("length");
	
		if(length!=null&&length.length()>0){
			if((!Util.isEmpty(value))&&value.length()>Integer.parseInt(length)){
				value=value.substring(0, Integer.parseInt(length));
			}
		}
		
		if("chfcomp".equals(nodeName)){
			Log.info("--------"+value);
		}
		
		/**
		 * 判断是否必填。isnull=N为必填
		 */
		String isnull=cxn.getAttribute("isnull");
		if("N".equals(isnull)&&(Util.isEmpty(value))){
			JSONObject errJson=new JSONObject();
			errJson.put("infcode", "-1");//交易状态码
			errJson.put("err_msg", ipid+":"+nodeName+"不能为空！！");
			return errJson.toJSONString();
		}
		if(!Util.isEmpty(value)){
			value=value.replaceAll("\"", "");
		}
		return value;
	}
	
	
	public String getDictCodeByTypeAndName(String type,String name){
		String ret="";
		if("hlcon".equals(type)){
			return hlcon(name);
		}else if("dise_his".equals(type)){
			return dise_his(name);
		}else if("infect".equals(type)){
			return infect(name);
		}else if("oprn_his".equals(type)){
			return oprn_his(name);
		}else if("bld_his".equals(type)){
			return bld_his(name);
		}
		else if("algs_his".equals(type)){
			return algs_his(name);
		}
		else if("prev_vcnt".equals(type)){
			return prev_vcnt(name);
		}
		else if("mena_his".equals(type)){
			return mena_his(name);
		}
		else if("physexm_height".equals(type)){
			return physexm_height(name);
		}
		else if("physexm_wt".equals(type)){
			return physexm_wt(name);
		}
		else if("adm_way".equals(type)){
			return adm_way(name);
		}else if("anst_mtd_code".equals(type)){
			return anst_mtd_code(name);
		}
		else if("mtl_stas_norm".equals(type)){
			return mtl_stas_norm(name);
		}
		else if("slep_info".equals(type)){
			return slep_info(name);
		}
		else if("smok".equals(type)){
			return smok(name);
		}
		else if("patn_rlts".equals(type)){
			return patn_rlts(name);
		}
		else if("caty".equals(type)){
			return caty(name);
		}
		else if("isnotnull".equals(type)){
			return isnotnull(name);
		}
		else if("inout_diag_type".equals(type)){
			return inout_diag_type(name);
		}
		else if("blotype_abo_code".equals(type)){
			return blotype_abo_code(name);
		}
		else if("blotype_abo".equals(type)){
			return blotype_abo(name);
		}
		
		return ret;
	}
	
	
	private String blotype_abo_code(String name){
		String value="";
		List<SystemDict> sdList=this.map.get("BloodType");
		for(int i=0;sdList!=null&&i<sdList.size();i++){
			SystemDict sd= sdList.get(i);
			if(sd.getItemCode().equals(name)){
				value=sd.getItemName();
			}
		}
		if(value.indexOf("AB")>-1){
			return "4";
		}else if(value.indexOf("A")>-1){
			return "1";
		}else if(value.indexOf("B")>-1){
			return "2";
		}else if(value.indexOf("O")>-1){
			return "3";
		}else if(value.indexOf("不详")>-1){
			return "5";
		}else{
			return "9";
		}
	}

	private String blotype_abo(String name){
		List<SystemDict> sdList=this.map.get("BloodType");
		String value="";
		for(int i=0;sdList!=null&&i<sdList.size();i++){
			SystemDict sd= sdList.get(i);
			if(sd.getItemCode().equals(name)){
				value=sd.getItemName();
			}
		}
		if("".equals(value)){
			return "未查";
		}
		
		if(value.indexOf("AB")>-1){
			return "AB型";
		}else if(value.indexOf("A")>-1){
			return "A型";
		}else if(value.indexOf("B")>-1){
			return "B型";
		}else if(value.indexOf("O")>-1){
			return "O型";
		}else if(value.indexOf("不详")>-1){
			return "不详";
		}else{
			return "未查";
		}
	}
	
	private String inout_diag_type(String name){
		if("swzd".equals(name)||"cyzd".equals(name)){
			return "2";
		}
		return "1";
	}
	private String isnotnull(String name){
		if(Util.isEmpty(name)){
			return "无";
		}
		return name;
	}
	private String caty(String name){
		for(int i=0;this.hisDeptList!=null&&i<this.hisDeptList.size();i++){
			DictDepart dd=this.hisDeptList.get(i);
			if(dd.getBmID().equals(name)){
				return dd.getMicode()!=null?dd.getMicode():"D99";
			}
		}
		return "D99";
	}
	private String patn_rlts(String name){
		if(name.indexOf("本人")>-1){
			return "01";
		}
		else if(name.indexOf("户主")>-1){
			return "02";
		}
		else if(name.indexOf("配偶")>-1){
			return "10";
		}
		else if(name.indexOf("夫")>-1){
			return "11";
		}
		else if(name.indexOf("妻")>-1){
			return "12";
		}
		else if(name.indexOf("子")>-1||name.indexOf("儿")>-1){
			return "20";
		}
		else if(name.indexOf("女")>-1){
			return "30";
		}
		else if(name.indexOf("孙")>-1){
			return "40";
		}
		else if(name.indexOf("父")>-1){
			return "51";
		}
		else if(name.indexOf("母")>-1){
			return "52";
		}
		else if(name.indexOf("兄")>-1||name.indexOf("弟")>-1||name.indexOf("姐")>-1||name.indexOf("妹")>-1){
			return "70";
		}
		return "80";
	}
	
	private String smok(String name){
		if(name.indexOf("有吸烟")>-1){
			return "1";
		}
		return "0";
	}
	private String adm_way(String name){
		if(name.indexOf("急诊")>-1){
			return "1";
		}else if(name.indexOf("门诊")>-1){
			return "2";
		}else if(name.indexOf("转入")>-1){
			return "3";
		}else if(name.indexOf("003")>-1){
			return "3";
		}else if("1".equals(name)){
			return "1";
		}else if("2".equals(name)){
			return "2";
		}else if("3".equals(name)){
			return "3";
		}
		return "9";
		
	}
	private String physexm_wt(String name){
		if(Util.isEmpty(name)){
			return "0";
		}else{
			return name;
		}
	}
	private String physexm_height(String name){
		if(Util.isEmpty(name)){
			return "0";
		}else{
			return name;
		}
	}
	private String mena_his(String name){
		if(Util.isEmpty(name)){
			return "无";
		}else{
			return name;
		}
	}

	private String anst_mtd_code(String name) {
		if("全身麻醉".equals(name)) {
			return "1";
		}else  if("静脉麻醉".equals(name)) {
			return "12";
		}else  if("吸入麻醉".equals(name)) {
			return "11";
		}else  if("基础麻醉".equals(name)) {
			return "13";
		}else  if("椎管内麻醉".equals(name)) {
			return "2";
		}else  if("蛛网膜下腔阻滞麻醉".equals(name)) {
			return "21";
		}else  if("硬脊膜外腔阻滞麻醉".equals(name)) {
			return "22";
		}else  if("局部麻醉".equals(name)) {
			return "3";
		}else  if("神经丛阻滞麻醉".equals(name)) {
			return "31";
		}else  if("神经阻滞麻醉".equals(name)) {
			return "33";
		}else  if("区域阻滞麻醉".equals(name)) {
			return "34";
		}else  if("局部浸润麻醉".equals(name)) {
			return "35";
		}else  if("表面麻醉".equals(name)) {
			return "36";
		}else  if("复合麻醉".equals(name)) {
			return "4";
		}else  if("静吸复合全麻".equals(name)) {
			return "41";
		}else  if("针药复合麻醉".equals(name)) {
			return "42";
		}else  if("神经丛与硬膜外阻滞复合麻醉".equals(name)) {
			return "43";
		}else  if("全麻复合全身降温".equals(name)) {
			return "44";
		}else  if("全麻复合控制性降压".equals(name)) {
			return "45";
		}else  if("其他麻醉方法".equals(name)) {
			return "9";
		}
		return "9";
		}
	private String mtl_stas_norm(String name){
		if(name.indexOf("精神可")>-1||name.indexOf("精神好")>-1||name.indexOf("精神尚可")>-1||name.indexOf("精神佳")>-1){
			return "1";
		}
		if(name.indexOf("精神欠佳")>-1){
			return "0";
		}
		return "0";
	}
	private String prev_vcnt(String name){
		String[] names=name.split("；");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("接种")>-1){
				return names[i];
			}
		}
		names=name.split("。");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("接种")>-1){
				return names[i];
			}
		}
		names=name.split("，");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("接种")>-1){
				return names[i];
			}
		}
		return "无";
	}
	private String slep_info(String name){
		String value="";
		String[] names=name.split("；");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
				value= names[i];
				break;
			}
		}
		names=value.split("，");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
				value= names[i];
				break;
			}
		}
		
		names=value.split("。");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
				value= names[i];
				break;
			}
		}
		
		names=value.split(",");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
				value= names[i];
				break;
			}
		}
		names=value.split("、");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
				value= names[i];
				break;
			}
		}
		if(Util.isEmpty(value)){
			return "无";
		}
		return value;
	}
	
	private String algs_his(String name){
		String value="";
		String[] names=name.split("；");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
				value= names[i];
				break;
			}
		}
		names=value.split("，");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
				value= names[i];
				break;
			}
		}
		
		names=value.split("。");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
				value= names[i];
				break;
			}
		}
		
		names=value.split(",");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
				value= names[i];
				break;
			}
		}
		names=value.split("、");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
				value= names[i];
				break;
			}
		}
		if(Util.isEmpty(value)){
			return "无";
		}
		return value;

	}
	
	
	private String infect(String name){
		return "0";
	}
	
	private String bld_his(String name){

		String value="";
		String[] names=name.split("；");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("输血")>-1){
				value= names[i];
				break;
			}
		}
		names=value.split("，");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("输血")>-1){
				value= names[i];
				break;
			}
		}
		
		names=value.split("。");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("输血")>-1){
				value= names[i];
				break;
			}
		}
		
		names=value.split(",");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("输血")>-1){
				value= names[i];
				break;
			}
		}
		names=value.split("、");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("输血")>-1){
				value= names[i];
				break;
			}
		}
		if(Util.isEmpty(value)){
			return "无";
		}
		return value;

	}
	
	
	private String oprn_his(String name){


		String value="";
		String[] names=name.split("；");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("手术")>-1){
				value= names[i];
				break;
			}
		}
		names=value.split("，");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("手术")>-1){
				value= names[i];
				break;
			}
		}
		
		names=value.split("。");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("手术")>-1){
				value= names[i];
				break;
			}
		}
		
		names=value.split(",");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("手术")>-1){
				value= names[i];
				break;
			}
		}
		names=value.split("、");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("手术")>-1){
				value= names[i];
				break;
			}
		}
		if(Util.isEmpty(value)){
			return "无";
		}
		return value;
	
	}
	
	private String dise_his(String name){
		String ret="";
		String[] names=name.split("；");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("疾病")>-1){
				ret+=names[i];
			}
		}
		if(ret!=null&&ret.length()>0){
			return ret;
		}
		names=name.split("，");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("疾病")>-1){
				ret+=names[i];
			}
		}
		
		if(ret!=null&&ret.length()>0){
			return ret;
		}
		names=name.split("。");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("疾病")>-1){
				ret+=names[i];
			}
		}
		names=name.split("、");
		for(int i=0;i<names.length;i++){
			if(names[i]!=null&&names[i].indexOf("疾病")>-1){
				ret+=names[i];
			}
		}
		if(ret!=null&&ret.length()>0){
			return ret;
		}
		if(ret!=null&&ret.length()>0){
			return ret;
		}else{
			return "无";
		}
	}
	private String hlcon(String name){
		if(name.indexOf("有高血压")>-1||name.indexOf("有糖尿病")>-1){
			return "3";
		}
		if(name.indexOf("体健")>-1){
			return "1";
		}
		return "2";
	}
	
	public Map<String,List<InpDiag>> featchInpDiagListToMap(List<InpDiag> inpDiagList){
		Map<String,List<InpDiag>> map=new HashMap<String,List<InpDiag>>();
		for(int i=0;inpDiagList!=null&&i<inpDiagList.size();i++){
			InpDiag inpDiag=inpDiagList.get(i);
			if("0002".equals(inpDiag.getDiagClassCode())||"0003".equals(inpDiag.getDiagClassCode())){
				String supDiagSN=inpDiag.getSupDiagSN();
				if(map.containsKey(supDiagSN)){
					List<InpDiag> list=map.get(supDiagSN);
					list.add(inpDiag);
					map.put(supDiagSN, list);
				}else{
					List<InpDiag> list=new ArrayList<InpDiag>();
					list.add(inpDiag);
					map.put(supDiagSN, list);
				}
			}
		}
		
		return map;
	}
	public boolean compareDate(String date1,String date2){
		DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date d1 = dateFormat.parse(date1);
			Date d2 = dateFormat.parse(date2);
			if(d1.equals(d2)){
				return true;
			}else if(d1.after(d2)){
				return true;
			}else if((d2.getDay()-d1.getDay())>1){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("方法——compareDate（{}，{}）异常"+date1+","+date2);
		}
		return false;
	}
	
}

//				/**
//				 * 表 223 输入-入院信息（节点标识：adminfo）
//				 */
//				HospitalRecord hr=new EmrDao().getHospitalRecordByIpid(ipid);
//				XMLNode[] dataEles = xdDoc.getDocumentElement().selectNodes("/Config/adminfo");
//				for(int i=0;i<dataEles.length;i++){
//					JSONObject json=new JSONObject();
//					if(hr!=null&&hr.getIpid()!=null){
//						JSONObject hrJson=JSONArray.parseObject(JSONArray.toJSON(hr).toString());
//						XMLNode xn = dataEles[i];
//						XMLNode[] childs =xn.getChildNodes();
//						for(int j=0;j<childs.length;j++){
//							XMLNode cxn =childs[j];
//							//节点名称
//							String nodeName=cxn.getNodeName();
//							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//								//节点值
//								String value=getValue(cxn,nodeName,hr.getXmlCont(),inpJson,patJson,hrJson,inputStr);
//								if(value!=null&&value.indexOf("err_msg")>-1){
//									return value;
//								}
//								json.put(nodeName, value);
//
//							}
//						}
//
//					}else{
//						XMLNode xn = dataEles[i];
//						XMLNode[] childs =xn.getChildNodes();
//						for(int j=0;j<childs.length;j++){
//							XMLNode cxn =childs[j];
//							//节点名称
//							String nodeName=cxn.getNodeName();
//							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//								//节点值
//								String value=getValue(cxn,nodeName,"",inpJson,patJson,null,inputStr);
//								if(value!=null&&value.indexOf("err_msg")>-1){
//									return value;
//								}
//								json.put(nodeName, value);
//
//							}
//						}
//					}
//					retjson.put("adminfo", json);
//				}
//
//
//				/**
//				 * 表 224 输入-诊断信息（节点标识：diseinfo）
//				 */
//				String westIcd="";//西医主诊断
//				String westDiagName="";//西医主诊断
//				String chineseIcd="";//中医主诊断
//				String chineseDiagName="";//中医主诊断
//				//入院主诊断
//				XMLNode[] inpDiagEles = xdDoc.getDocumentElement().selectNodes("/Config/diseinfo");
//				List<InpDiag> inpDiagList=new EmrDao().getInpDiagListByIpid(ipid);
//				for(int i=0;i<inpDiagEles.length;i++){
//					JSONArray jsonArray=new JSONArray();
//					if(inpDiagList!=null&&inpDiagList.size()>0){
//						String isOutMainFlag="";//出院主诊断标志
//						String isInMainFlag="";//入院主诊断标志
//						for (int a=0;a<inpDiagList.size();a++){
//							JSONObject json=new JSONObject();
//							InpDiag inpDiag=inpDiagList.get(a);
//							JSONObject diagJson=JSONArray.parseObject(JSONArray.toJSON(inpDiag).toString());
//							XMLNode xn = inpDiagEles[i];
//							XMLNode[] childs =xn.getChildNodes();
//							for(int j=0;j<childs.length;j++){
//								XMLNode cxn =childs[j];
//								//节点名称
//								String nodeName=cxn.getNodeName();
//								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//									//节点值
//									String value="";
//									//									
//									if("maindiag_flag".equals(nodeName)){
//										if("cbzd".equals(inpDiag.getDiagTypeCode())||"ryzd".equals(inpDiag.getDiagTypeCode())){
//											if("".equals(isInMainFlag)){
//												isInMainFlag="1";
//											}else{
//												isInMainFlag="0";
//											}
//											value=isInMainFlag;
//										}
//										else if("swzd".equals(inpDiag.getDiagTypeCode())||"cyzd".equals(inpDiag.getDiagTypeCode())){
//											if("".equals(isOutMainFlag)){
//												isOutMainFlag="1";
//											}else{
//												isOutMainFlag="0";
//											}
//											value=isOutMainFlag;
//										}
//									}
//									else if("diag_seq".equals(nodeName)){
////										value=inpDiag.getOrdinal();
//										value=a+"";
//									}
//									else if("wm_diag_code".equals(nodeName)){//西医诊断编码
//										if("0001".equals(inpDiag.getDiagClassCode())){
//											value=inpDiag.getICDCode();
//											if("1".equals(isInMainFlag)){
//												westIcd=inpDiag.getICDCode();//西医主诊断
//												westDiagName=inpDiag.getDiagName();//西医主诊断
//											}
//										}
//									}else if("wm_diag_name".equals(nodeName)){//西医诊断名称
//										if("0001".equals(inpDiag.getDiagClassCode())){
//											value=inpDiag.getDiagName();
//										}
//									}else if("tcm_dise_code".equals(nodeName)){//中医病名代码
//										if("0002".equals(inpDiag.getDiagClassCode())){
//											value=inpDiag.getICDCode();
//											if("1".equals(isInMainFlag)){
//												chineseIcd=inpDiag.getICDCode();//中医主诊断
//												chineseDiagName=inpDiag.getDiagName();//中医主诊断
//											}
//										}
//									}else if("tcm_dise_name".equals(nodeName)){//中医病名
//										if("0002".equals(inpDiag.getDiagClassCode())){
//											value=inpDiag.getDiagName();
//										}
//									}else if("tcmsymp_code".equals(nodeName)){//中医证候代码
//										if("0003".equals(inpDiag.getDiagClassCode())){
//											value=inpDiag.getICDCode();
//										}
//									}else if("tcmsymp".equals(nodeName)){//中医证候	字符型
//										if("0003".equals(inpDiag.getDiagClassCode())){
//											value=inpDiag.getDiagName();
//										}
//									}else{
//										value=getValue(cxn,nodeName,hr.getXmlCont(),inpJson,patJson,diagJson,inputStr);
//										if(value!=null&&value.indexOf("err_msg")>-1){
//											return value;
//										}
//									}
//									json.put(nodeName, value);
//								}
//
//							}
//							jsonArray.add(json);
//						}
//
//					}else{
//						JSONObject json=new JSONObject();
//						XMLNode xn = inpDiagEles[i];
//						XMLNode[] childs =xn.getChildNodes();
//						for(int j=0;j<childs.length;j++){
//							XMLNode cxn =childs[j];
//							//节点名称
//							String nodeName=cxn.getNodeName();
//							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//								//节点值
//								String value=getValue(cxn,nodeName,"",inpJson,patJson,null,inputStr);
//								if(value!=null&&value.indexOf("err_msg")>-1){
//									return value;
//								}
//
//
//								json.put(nodeName, value);
//
//							}
//						}
//						jsonArray.add(json);
//					}
//					retjson.put("diseinfo", jsonArray);
//				}
//				
//				//病程记录---抢救记录
//				List<ProgressNote> qjjlList=new ArrayList<ProgressNote>();
//				/**
//				 * 表 225 输入-病程记录（节点标识：coursrinfo）
//				 */
//				XMLNode[] coursrinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/coursrinfo");
//				List<ProgressNote> progressNoteList=new EmrDao().getProgressNoteByIpid(ipid);
//				for(int i=0;i<coursrinfoEles.length;i++){
//					JSONArray jsonArray=new JSONArray();
//					//主诉，为了普通病程记录使用
//					String chfcomp="";
//					if(progressNoteList!=null&&progressNoteList.size()>0){
//						for (int a=0;a<progressNoteList.size();a++){
//							JSONObject json=new JSONObject();
//							ProgressNote progressNote=progressNoteList.get(a);
//							if(progressNote.getPnTypeDesc().indexOf("抢救记录")>-1){
//								qjjlList.add(progressNote);
//							}
//							if("0008".equals(progressNote.getPnTypeCode())){
//
//								JSONObject progressNoteJson=JSONArray.parseObject(JSONArray.toJSON(progressNote).toString());
//								XMLNode xn = coursrinfoEles[i];
//								XMLNode[] childs =xn.getChildNodes();
//								for(int j=0;j<childs.length;j++){
//									XMLNode cxn =childs[j];
//									//节点名称
//									String nodeName=cxn.getNodeName();
//									if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//										//节点值
//										String value="";
//										value=getValue(cxn,nodeName,progressNote.getXmlCont(),inpJson,patJson,progressNoteJson,inputStr);
//										if("chfcomp".equals(nodeName)){
//
//											if(Util.isEmpty(value)){
//												if(!"".equals(chfcomp)){
//													value=chfcomp;
//												}else{
//													if(hr!=null){
//														value=hr.getChiefComplaint(); 
//														if(Util.isEmpty(value)){
//															value="无";
//														}
//													}else{
//														value="无";
//													}
//												}
//											}else{
//												chfcomp=value;
//											}
//
//										}
//										else if("prnt_doc_name".equals(nodeName)){
//											if(Util.isEmpty(value)){
//												cxn.setTextContent("creatorName");
//												value=getValue(cxn,nodeName,progressNote.getXmlCont(),inpJson,patJson,progressNoteJson,inputStr);
//											}
//										}
//										else if("prel_wm_diag_code".equals(nodeName)){
//											value=westIcd;//西医主诊断
//
//
//										}
//										else if("prel_wm_dise_name".equals(nodeName)){
//											value=westDiagName;//西医主诊断
//										}
//										else if("prel_tcm_diag_code".equals(nodeName)){
//											value=chineseIcd;//中医主诊断
//										}
//										else if("prel_tcm_dise_name".equals(nodeName)){
//											value=chineseDiagName;//中医主诊断
//										}
//										//									<prel_tcmsymp_code   ></prel_tcmsymp_code><!--初步诊断-中医证候代码 9  -->
//										//								    <prel_tcmsymp   ></prel_tcmsymp><!--初步诊断-中医证候 200  -->
//
//										if(value!=null&&value.indexOf("err_msg")>-1){
//											return value;
//										}
//										json.put(nodeName, value);
//									}
//								}
//								jsonArray.add(json);
//							}
//						}
//					}else{
//						JSONObject json=new JSONObject();
//						XMLNode xn = coursrinfoEles[i];
//						XMLNode[] childs =xn.getChildNodes();
//						for(int j=0;j<childs.length;j++){
//							XMLNode cxn =childs[j];
//							//节点名称
//							String nodeName=cxn.getNodeName();
//							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//								//节点值
//								String value=getValue(cxn,nodeName,"",inpJson,patJson,null,inputStr);
//
//								if("chfcomp".equals(nodeName)){
//									value="无";
//								}else if("ipdr_code".equals(nodeName)){
//									value=inpJson.getString("doctor");
//								}else if("ipdr_name".equals(nodeName)){
//									value=inpJson.getString("doctorID");
//								}else if("prnt_doc_name".equals(nodeName)){
//									value=inpJson.getString("doctor");
//								}
//
//								if(value!=null&&value.indexOf("err_msg")>-1){
//									return value;
//								}
//								json.put(nodeName, value);
//
//							}
//						}
//						jsonArray.add(json);
//					}
//
//					retjson.put("coursrinfo", jsonArray);
//				}
//				
//				/**
//				 * 手术记录（节点标识：oprninfo）
//				 */
//				XMLNode[] oprninfoEles = xdDoc.getDocumentElement().selectNodes("/Config/oprninfo");
//				List<OperationInfoRec> operationInfoRecList=new EmrDao().getOperationInfoRecListByIpid(ipid);
//				for(int i=0;i<oprninfoEles.length;i++){
//					JSONArray jsonArray=new JSONArray();
//					if(operationInfoRecList!=null&&operationInfoRecList.size()>0){
//						for (int a=0;a<operationInfoRecList.size();a++){
//							JSONObject json=new JSONObject();
//							OperationInfoRec oir=operationInfoRecList.get(a);
//							JSONObject oirJson=JSONArray.parseObject(JSONArray.toJSON(oir).toString());
//							XMLNode xn = oprninfoEles[i];
//							XMLNode[] childs =xn.getChildNodes();
//							for(int j=0;j<childs.length;j++){
//								XMLNode cxn =childs[j];
//								//节点名称
//								String nodeName=cxn.getNodeName();
//								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//									//节点值
//									String value="";
//									value=getValue(cxn,nodeName,null,inpJson,patJson,oirJson,inputStr);
//									if(value!=null&&value.indexOf("err_msg")>-1){
//										return value;
//									}
//									json.put(nodeName, value);
//									
//								}
//							}
//							jsonArray.add(json);
//						}
//					}
////					else{
////						JSONObject json=new JSONObject();
////						XMLNode xn = oprninfoEles[i];
////						XMLNode[] childs =xn.getChildNodes();
////						for(int j=0;j<childs.length;j++){
////							XMLNode cxn =childs[j];
////							//节点名称
////							String nodeName=cxn.getNodeName();
////							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
////								//节点值
////								String value=getValue(cxn,nodeName,null,inpJson,patJson,null,inputStr);
////								if(value!=null&&value.indexOf("err_msg")>-1){
////									return value;
////								}
////								json.put(nodeName, value);
////							}
////						}
////						jsonArray.add(json);
////					}
//					retjson.put("oprninfo", jsonArray);
//				}
//				/**
//				 * 输入-病情抢救记录
//				 */
//				if(qjjlList!=null&&qjjlList.size()>0){
//					XMLNode[] rescinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/rescinfo");
//					JSONArray jsonArray=new JSONArray();
//					for(int i=0;i<rescinfoEles.length;i++){
//						for (int a=0;a<operationInfoRecList.size();a++){
//							JSONObject json=new JSONObject();
//							ProgressNote pn=qjjlList.get(a);
//							JSONObject pnJson=JSONArray.parseObject(JSONArray.toJSON(pn).toString());
//							XMLNode xn = rescinfoEles[i];
//							XMLNode[] childs =xn.getChildNodes();
//							for(int j=0;j<childs.length;j++){
//								XMLNode cxn =childs[j];
//								//节点名称
//								String nodeName=cxn.getNodeName();
//								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//									//节点值
//									String value="";
//									value=getValue(cxn,nodeName,null,inpJson,patJson,pnJson,inputStr);
//									if(value!=null&&value.indexOf("err_msg")>-1){
//										return value;
//									}
//									json.put(nodeName, value);
//								}
//							}
//							jsonArray.add(json);
//						}
//					}
//					retjson.put("rescinfo", jsonArray);
//				}
//				
//				/**
//				 * 生成 dieinfo
//				 */
//				XMLNode[] dieinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/dieinfo");
//				DeathRec dr=new EmrDao().getDeadRecByIpid(ipid);
//				if(dr!=null){
//					JSONObject drJson=JSONArray.parseObject(JSONArray.toJSON(dr).toString());
//					for(int i=0;i<dieinfoEles.length;i++){
//						JSONObject json=new JSONObject();
//						XMLNode xn = dieinfoEles[i];
//						XMLNode[] childs =xn.getChildNodes();
//						for(int j=0;j<childs.length;j++){
//							XMLNode cxn =childs[j];
//							//节点名称
//							String nodeName=cxn.getNodeName();
//							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//								//节点值
//								String xmlCont=dr!=null?dr.getXmlCont():"";
//								String value=getValue(cxn,nodeName,xmlCont,inpJson,patJson,drJson,inputStr);
//								if(value!=null&&value.indexOf("err_msg")>-1){
//									return value;
//								}
//								json.put(nodeName, value);
//							}
//						}
//						retjson.put("dieinfo", json);
//					}
//				}
//				
//				/**
//				 * 生成 dscginfo
//				 */
//				XMLNode[] dscginfoEles = xdDoc.getDocumentElement().selectNodes("/Config/dscginfo");
//				DischargeSummary ds=new EmrDao().getDischargeSummaryByIpid(ipid);
//				if(ds!=null&&ds.getIpid()!=null){
//					JSONObject dsJson=JSONArray.parseObject(JSONArray.toJSON(ds).toString());
//					JSONObject json=new JSONObject();
//					for(int i=0;i<dscginfoEles.length;i++){
//						XMLNode xn = dscginfoEles[i];
//						XMLNode[] childs =xn.getChildNodes();
//						for(int j=0;j<childs.length;j++){
//							XMLNode cxn =childs[j];
//							//节点名称
//							String nodeName=cxn.getNodeName();
//							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//								//节点值
//								String xmlCont=ds!=null?ds.getXmlCont():"";
//								String value=getValue(cxn,nodeName,xmlCont,inpJson,patJson,dsJson,inputStr);
//								if(value!=null&&value.indexOf("err_msg")>-1){
//									return value;
//								}
//								json.put(nodeName, value);
//							}
//						}
//					}
//					retjson.put("dscginfo", json);
//				}
//				
//				return retjson.toJSONString();
//			}else{
//				JSONObject errJson=new JSONObject();
//				errJson.put("infcode", "-1");//交易状态码
//				errJson.put("err_msg", ipid+"该病人不存在！！");
//				return errJson.toJSONString();
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			JSONObject errJson=new JSONObject();
//			errJson.put("infcode", "-1");//交易状态码
//			errJson.put("err_msg", e.getMessage());
//			return errJson.toJSONString();
//		}finally{
//			
//		}
//	}
//	
//	public String getValue(XMLNode cxn,String nodeName,String xmlCont,JSONObject inpJson,JSONObject patJson,JSONObject json,JSONObject inputStr){
//		String value="";
//		if("fixmedins_code".equals(nodeName)){
//			value= inputStr.getString("fixmedins_code");
//		}else if("mdtrt_sn".equals(nodeName)){
//			value= inputStr.getString("mdtrt_sn");
//		}else if("mdtrt_id".equals(nodeName)){
//			value= inputStr.getString("mdtrt_id");
//		}else if("psn_no".equals(nodeName)){
//			value= inputStr.getString("psn_no");
//		}else{
//
//
//			//节点值
//			String textContent=cxn.getTextContent();
//			//节点属性值
//			String structId=cxn.getAttribute("struct_id");
//			String table=cxn.getAttribute("table");
//
//			/**
//			 * 如果节点属性structId不为空。则按照structId值取模板数据。
//			 */
//			if(structId!=null&&structId.length()>0){
//				if(xmlCont!=null&&xmlCont.length()>0){
//					TemplateOperator to=new TemplateOperator();
//					to.loadXml(xmlCont);
//					if(structId.indexOf("/")>-1){
//						String ss="";
//						String[] struct_ids=structId.split("/");
//						for(int a=0;a<struct_ids.length;a++){
//							if("".equals(ss)){
//								ss=DataUtil.toString(to.getTextValueOrPanelTextById(struct_ids[a]));
//							}else{
//								ss=ss+"/"+DataUtil.toString(to.getTextValueOrPanelTextById(struct_ids[a]));
//							}
//						}
//					}else if(structId.indexOf(";")>-1){
//						String ss="";
//						String[] struct_ids=structId.split(";");
//						for(int a=0;a<struct_ids.length;a++){
//							if("".equals(ss)){
//								ss=DataUtil.toString(to.getTextValueOrPanelTextById(struct_ids[a]));
//							}else{
//								ss=ss+""+DataUtil.toString(to.getTextValueOrPanelTextById(struct_ids[a]));
//							}
//						}
//						value=ss;
//					}else{
//						value=to.getTextValueOrPanelTextById(structId);
//					}
//					if("mena_his".equals(nodeName)){
//						String temp=to.getTextValueOrPanelTextById("5B74F0DBAD6A4D6582F91368F6C61662");
//						String[] str=value.split("。");
//						if(str!=null&&str.length>1){
//							value=temp+str[1];
//						}else{
//							value=temp;
//						}
//					}
//				}else{
//					value="无";
//				}
//			}
//			/**
//			 * 如果节点属性table不为空。则按照table判断哪个表，然后用节点值取对应json的值
//			 */
//			else if(table!=null&&table.length()>0){
//				if("INPATIENT".equals(table)){
//					value=inpJson.get(textContent)+"";
//				}
//				else if("PATIENT".equals(table)){
//					value=patJson.get(textContent)+"";
//				}
//				else if("HOSPITALRECORD".equals(table)&&json!=null){
//					value=json.get(textContent)+"";
//				}
//				else if("INPDIAG".equals(table)&&json!=null){
//					value=json.get(textContent)+"";
//				}
//				else if("PROGRESSNOTE".equals(table)&&json!=null){
//					value=json.get(textContent)+"";
//				}
//				else if("OPERATIONINFOREC".equals(table)&&json!=null){
//					value=json.get(textContent)+"";
//				}
//				else if("DISCHARGESUMMARY".equals(table)&&json!=null){
//					value=json.get(textContent)+"";
//				}
//			}
//			/**
//			 * 如果都没有，则判断节点值是否为空,不为空的话，则直接默认值
//			 */
//			else if(!Util.isEmpty(DataUtil.toString(textContent))){
//				value=textContent;
//			}
//			
//			
//			
//			/**
//			 * 处理空和"-"
//			 */
//			value=DataUtil.toString(value);
//
//			/**
//			 * 判断dict是否为空，不为空，则用dict去进行转换
//			 */
//			String dict=cxn.getAttribute("dict");
//			if(!Util.isEmpty(dict)){
//				value=getDictCodeByTypeAndName(dict,value);
//			}
//			/**
//			 * 判断数据类型
//			 */
//			String type=cxn.getAttribute("type");
//			if("date".equals(type)){
//				String format=cxn.getAttribute("format");
//				try{
//					if(value!=null&&value.indexOf("月")>-1){
//						value=value.replace("月", "-");
//					}
//					if(value!=null&&value.indexOf("日")>-1||value!=null&&value.indexOf("号")>-1){
//						value=value.replace("日", "-");
//						value=value.replace("号", "-");
//					}
//					value=Util.format(value, format);
//				}catch(Exception e){
//					value="";
//				}
//			}
//			else if("number".equals(type)){
//				try{
//					Double.parseDouble(value);
//					//					Integer.parseInt(value);
//				}catch(Exception e){
//					value="0";
//				}
//			}
//		}
//		if("illhis_stte_name".equals(nodeName)&&Util.isEmpty(value)){
//			value=inpJson.getString("patientName");
//		}else if("illhis_stte_rltl".equals(nodeName)&&Util.isEmpty(value)){
//			value="01";
//		}else if("stte_rele".equals(nodeName)&&Util.isEmpty(value)){
//			value="1";
//		}
////		else if("oprn_time".equals(nodeName)&&Util.isEmpty(value)){
////		value=inpJson.get("admissionTime")+"";
////	}
//		else if("oprn_begntime".equals(nodeName)&&Util.isEmpty(value)){
//			value=Util.format(json.get("operationTime")+"", "yyyy-MM-dd HH:mm:ss");
//		}
//		else if("oprn_endtime".equals(nodeName)&&Util.isEmpty(value)){
//			value=Util.format(json.get("operationTime")+"", "yyyy-MM-dd HH:mm:ss");
//		}
//		else if("resc_begntime".equals(nodeName)&&Util.isEmpty(value)){
//			value=Util.format(json.get("pnDateTime")+"", "yyyy-MM-dd HH:mm:ss");
//		}
//		else if("resc_endtime".equals(nodeName)&&Util.isEmpty(value)){
//			value=Util.format(json.get("pnDateTime")+"", "yyyy-MM-dd HH:mm:ss");
//		}
//		
//		/**
//		 * 判断长度
//		 */
//		String length=cxn.getAttribute("length");
//		if(length!=null&&length.length()>0){
//			if((!Util.isEmpty(value))&&value.length()>Integer.parseInt(length)){
//				value=value.substring(0, Integer.parseInt(length));
//			}
//		}
//		
//		/**
//		 * 判断是否必填。isnull=N为必填
//		 */
//		String isnull=cxn.getAttribute("isnull");
//		if("N".equals(isnull)&&(Util.isEmpty(value))){
//			JSONObject errJson=new JSONObject();
//			errJson.put("infcode", "-1");//交易状态码
//			errJson.put("err_msg", nodeName+"不能为空！！");
//			return errJson.toJSONString();
//		}
//		return value;
//	}
//	
//	
//	public String getDictCodeByTypeAndName(String type,String name){
//		String ret="";
//		if("hlcon".equals(type)){
//			return hlcon(name);
//		}else if("dise_his".equals(type)){
//			return dise_his(name);
//		}else if("infect".equals(type)){
//			return infect(name);
//		}else if("oprn_his".equals(type)){
//			return oprn_his(name);
//		}else if("bld_his".equals(type)){
//			return bld_his(name);
//		}
//		else if("algs_his".equals(type)){
//			return algs_his(name);
//		}
//		else if("prev_vcnt".equals(type)){
//			return prev_vcnt(name);
//		}
//		else if("mena_his".equals(type)){
//			return mena_his(name);
//		}
//		else if("physexm_height".equals(type)){
//			return physexm_height(name);
//		}
//		else if("physexm_wt".equals(type)){
//			return physexm_wt(name);
//		}
//		else if("adm_way".equals(type)){
//			return adm_way(name);
//		}
//		else if("mtl_stas_norm".equals(type)){
//			return mtl_stas_norm(name);
//		}
//		else if("slep_info".equals(type)){
//			return slep_info(name);
//		}
//		else if("smok".equals(type)){
//			return smok(name);
//		}
//		else if("patn_rlts".equals(type)){
//			return patn_rlts(name);
//		}
//		else if("caty".equals(type)){
//			return caty(name);
//		}
//		else if("isnotnull".equals(type)){
//			return isnotnull(name);
//		}
//		else if("inout_diag_type".equals(type)){
//			return inout_diag_type(name);
//		}
//		else if("blotype_abo_code".equals(type)){
//			return blotype_abo_code(name);
//		}
//		else if("blotype_abo".equals(type)){
//			return blotype_abo(name);
//		}
//		return ret;
//	}
//	
//	
//	private String blotype_abo_code(String name){
//		String value="";
//		List<SystemDict> sdList=this.map.get("BloodType");
//		for(int i=0;sdList!=null&&i<sdList.size();i++){
//			SystemDict sd= sdList.get(i);
//			if(sd.getItemCode().equals(name)){
//				value=sd.getItemName();
//			}
//		}
//		if(value.indexOf("AB")>-1){
//			return "4";
//		}else if(value.indexOf("A")>-1){
//			return "1";
//		}else if(value.indexOf("B")>-1){
//			return "2";
//		}else if(value.indexOf("O")>-1){
//			return "3";
//		}else if(value.indexOf("不详")>-1){
//			return "5";
//		}else{
//			return "9";
//		}
//	}
//
//	private String blotype_abo(String name){
//		List<SystemDict> sdList=this.map.get("BloodType");
//		String value="";
//		for(int i=0;sdList!=null&&i<sdList.size();i++){
//			SystemDict sd= sdList.get(i);
//			if(sd.getItemCode().equals(name)){
//				value=sd.getItemName();
//			}
//		}
//		if("".equals(value)){
//			return "未查";
//		}
//		
//		if(value.indexOf("AB")>-1){
//			return "AB型";
//		}else if(value.indexOf("A")>-1){
//			return "A型";
//		}else if(value.indexOf("B")>-1){
//			return "B型";
//		}else if(value.indexOf("O")>-1){
//			return "O型";
//		}else if(value.indexOf("不详")>-1){
//			return "不详";
//		}else{
//			return "未查";
//		}
//	}
//	
//	private String inout_diag_type(String name){
//		if("swzd".equals(name)||"cyzd".equals(name)){
//			return "2";
//		}
//		return "1";
//	}
//	private String isnotnull(String name){
//		if(Util.isEmpty(name)){
//			return "无";
//		}
//		return name;
//	}
//	private String caty(String name){
//		for(int i=0;this.hisDeptList!=null&&i<this.hisDeptList.size();i++){
//			DictDepart dd=this.hisDeptList.get(i);
//			if(dd.getBmID().equals(name)){
//				return dd.getMicode()!=null?dd.getMicode():"D99";
//			}
//		}
//		return "D99";
//	}
//	private String patn_rlts(String name){
//		if(name.indexOf("本人")>-1){
//			return "01";
//		}
//		else if(name.indexOf("户主")>-1){
//			return "02";
//		}
//		else if(name.indexOf("配偶")>-1){
//			return "10";
//		}
//		else if(name.indexOf("夫")>-1){
//			return "11";
//		}
//		else if(name.indexOf("妻")>-1){
//			return "12";
//		}
//		else if(name.indexOf("子")>-1||name.indexOf("儿")>-1){
//			return "20";
//		}
//		else if(name.indexOf("女")>-1){
//			return "30";
//		}
//		else if(name.indexOf("孙")>-1){
//			return "40";
//		}
//		else if(name.indexOf("父")>-1){
//			return "51";
//		}
//		else if(name.indexOf("母")>-1){
//			return "52";
//		}
//		else if(name.indexOf("兄")>-1||name.indexOf("弟")>-1||name.indexOf("姐")>-1||name.indexOf("妹")>-1){
//			return "70";
//		}
//		return "80";
//	}
//	
//	private String smok(String name){
//		if(name.indexOf("有吸烟")>-1){
//			return "1";
//		}
//		return "0";
//	}
//	private String adm_way(String name){
//		if(name.indexOf("急诊")>-1){
//			return "1";
//		}else if(name.indexOf("门诊")>-1){
//			return "2";
//		}else if(name.indexOf("转入")>-1){
//			return "3";
//		}
//		return "4";
//		
//	}
//	private String physexm_wt(String name){
//		if(Util.isEmpty(name)){
//			return "0";
//		}else{
//			return name;
//		}
//	}
//	private String physexm_height(String name){
//		if(Util.isEmpty(name)){
//			return "0";
//		}else{
//			return name;
//		}
//	}
//	private String mena_his(String name){
//		if(Util.isEmpty(name)){
//			return "无";
//		}else{
//			return name;
//		}
//	}
//	private String mtl_stas_norm(String name){
//		if(name.indexOf("精神可")>-1||name.indexOf("精神好")>-1||name.indexOf("精神尚可")>-1||name.indexOf("精神佳")>-1){
//			return "1";
//		}
//		if(name.indexOf("精神欠佳")>-1){
//			return "0";
//		}
//		return "0";
//	}
//	private String prev_vcnt(String name){
//		String[] names=name.split("；");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("接种")>-1){
//				return names[i];
//			}
//		}
//		names=name.split("。");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("接种")>-1){
//				return names[i];
//			}
//		}
//		names=name.split("，");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("接种")>-1){
//				return names[i];
//			}
//		}
//		return "无";
//	}
//	private String slep_info(String name){
//		String value="";
//		String[] names=name.split("；");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		names=value.split("，");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		
//		names=value.split("。");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		
//		names=value.split(",");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		names=value.split("、");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("睡眠")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		if(Util.isEmpty(value)){
//			return "无";
//		}
//		return value;
//	}
//	
//	private String algs_his(String name){
//		String value="";
//		String[] names=name.split("；");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		names=value.split("，");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		
//		names=value.split("。");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		
//		names=value.split(",");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		names=value.split("、");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("过敏")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		if(Util.isEmpty(value)){
//			return "无";
//		}
//		return value;
//
//	}
//	
//	
//	private String infect(String name){
//		return "0";
//	}
//	
//	private String bld_his(String name){
//
//		String value="";
//		String[] names=name.split("；");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("输血")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		names=value.split("，");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("输血")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		
//		names=value.split("。");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("输血")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		
//		names=value.split(",");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("输血")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		names=value.split("、");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("输血")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		if(Util.isEmpty(value)){
//			return "无";
//		}
//		return value;
//
//	}
//	
//	
//	private String oprn_his(String name){
//
//
//		String value="";
//		String[] names=name.split("；");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("手术")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		names=value.split("，");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("手术")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		
//		names=value.split("。");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("手术")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		
//		names=value.split(",");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("手术")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		names=value.split("、");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("手术")>-1){
//				value= names[i];
//				break;
//			}
//		}
//		if(Util.isEmpty(value)){
//			return "无";
//		}
//		return value;
//	
//	}
//	
//	
//	private String dise_his(String name){
//		String ret="";
//		String[] names=name.split("；");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("疾病")>-1){
//				ret+=names[i];
//			}
//		}
//		if(ret!=null&&ret.length()>0){
//			return ret;
//		}
//		names=name.split("，");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("疾病")>-1){
//				ret+=names[i];
//			}
//		}
//		
//		if(ret!=null&&ret.length()>0){
//			return ret;
//		}
//		names=name.split("。");
//		for(int i=0;i<names.length;i++){
//			if(names[i]!=null&&names[i].indexOf("疾病")>-1){
//				ret+=names[i];
//			}
//		}
//		if(ret!=null&&ret.length()>0){
//			return ret;
//		}
//		if(ret!=null&&ret.length()>0){
//			return ret;
//		}else{
//			return "无";
//		}
//	}
//	private String hlcon(String name){
//		if(name.indexOf("有高血压")>-1||name.indexOf("有糖尿病")>-1){
//			return "3";
//		}
//		if(name.indexOf("体健")>-1){
//			return "1";
//		}
//		return "2";
//	}
//}
