package com.haitaiinc.service;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXB;

import util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haitaiinc.Util;
import com.haitaiinc.common.DataUtil;
import com.haitaiinc.dao.EmrDao;
import com.haitaiinc.dao.HisDao;
import com.haitaiinc.hisdb.dictmanage.DictDepart;
import com.haitaiinc.htdb.adt.dto.Inpatient;
import com.haitaiinc.htdb.adt.tableadapters.InpatientTableAdapter;
import com.haitaiinc.htdb.comm.dto.SystemDict;
import com.haitaiinc.htdb.inpcase.dto.BivariateStructsSheet;
import com.haitaiinc.htdb.inpcase.dto.FrontSheet;
import com.haitaiinc.htdb.inpcase.dto.FrontSheetFee;
import com.haitaiinc.htdb.inpcase.dto.InpDiag;
import com.haitaiinc.htdb.inpcase.dto.OperationInfoRec;
import com.haitaiinc.htdb.mpi.dto.Patient;
import com.haitaiinc.system.ConfigManager;
import com.haitaiinc.xml.XMLDocument;
import com.haitaiinc.xml.XMLNode;
import com.haitaiinc.xml.jaxb.JAXBUtil;

import dom.TemplateOperator;

public class FrontSheetService {

	public static void main(String[] args) {
		String jsonStr="{\"ipid\": \"68558\",\"fixmedins_code\": \"1234\",\"mdtrt_sn\": \"111\",\"mdtrt_id\": \"2222\",\"psn_no\": \"33333\"}";
		String retStr=new FrontSheetService().getFrontSheetByIpid(jsonStr);
		System.out.println("==="+retStr);
	}
	
	protected Map<String,List<SystemDict>> map=null;
	protected List<DictDepart> hisDeptList=null;
	public String getFrontSheetByIpid(String jsonStr){
		try{
			JSONObject inputStr=JSONArray.parseObject(jsonStr);
			String ipid=inputStr.getString("ipid");
			JSONObject retjson=new JSONObject();
			Inpatient inp=new EmrDao().getInpateintByipid(ipid);
			if(inp!=null&&inp.getIpid()!=null){
				
				this.map= new EmrDao().getSystemDictListByItemType();
				this.hisDeptList= new HisDao().getDictDepart();
				
				JSONObject inpJson=JSONArray.parseObject(JSONArray.toJSON(inp).toString());
				Patient pat=new EmrDao().getPatientByPid(inp.getPid());
				JSONObject patJson=JSONArray.parseObject(JSONArray.toJSON(pat).toString());
				URL url = ConfigManager.class.getResource("/4401.xml");
				XMLDocument xdDoc = XMLDocument.parse(new File(url.toURI()));
				
				FrontSheetFee fee=new EmrDao().getFrontSheetFeeByIpid(inp.getIpid());
				JSONObject feeJson=null;
				if(fee!=null){
					feeJson=JSONArray.parseObject(JSONArray.toJSON(fee).toString());
				}
				
				/**
				 * ���� baseinfo
				 */
				XMLNode[] baseinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/baseinfo");
				FrontSheet fs=new EmrDao().getFrontSheetByIpid(ipid);
				for(int i=0;i<baseinfoEles.length;i++){
					JSONObject json=new JSONObject();
					XMLNode xn = baseinfoEles[i];
					XMLNode[] childs =xn.getChildNodes();
					for(int j=0;j<childs.length;j++){
						XMLNode cxn =childs[j];
						//�ڵ�����
						String nodeName=cxn.getNodeName();
						if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
							//�ڵ�ֵ
							String xmlCont=fs!=null?fs.getXmlCont():"";
							String value=getValue(cxn,nodeName,xmlCont,inpJson,patJson,feeJson,null,null,inputStr);
							if(value!=null&&value.indexOf("err_msg")>-1){
								return value;
							}
							json.put(nodeName, value);
						}
					}
					retjson.put("baseinfo", json);
				}
				
				/**
				 * �����Ϣ���ڵ��ʶ��diseinfo��
				 */
				XMLNode[] diseinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/diseinfo");
				List<InpDiag> inpDiagList=new EmrDao().getInpDiagListByIpid(ipid);
				for(int i=0;i<diseinfoEles.length;i++){
					String isOutMainFlag="";//��Ժ����ϱ�־
					String isInMainFlag="";//��Ժ����ϱ�־
					JSONArray jsonArray=new JSONArray();
					for (int a=0;inpDiagList!=null&&a<inpDiagList.size();a++){
						JSONObject json=new JSONObject();
						InpDiag inpDiag=inpDiagList.get(a);
						JSONObject inpDiagJson=JSONArray.parseObject(JSONArray.toJSON(inpDiag).toString());
						XMLNode xn = diseinfoEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//�ڵ�����
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//�ڵ�ֵ
								String value=getValue(cxn,nodeName,"",inpJson,patJson,null,inpDiagJson,null,inputStr);
								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}
								if("maindiag_flag".equals(nodeName)){
									if("cbzd".equals(inpDiag.getDiagTypeCode())||"ryzd".equals(inpDiag.getDiagTypeCode())){
										if("".equals(isInMainFlag)){
											isInMainFlag="1";
										}else{
											isInMainFlag="0";
										}
										value=isInMainFlag;
									}
									else if("swzd".equals(inpDiag.getDiagTypeCode())||"cyzd".equals(inpDiag.getDiagTypeCode())){
										if("".equals(isOutMainFlag)){
											isOutMainFlag="1";
										}else{
											isOutMainFlag="0";
										}
										value=isOutMainFlag;
									}
								}
								
								json.put(nodeName, value);

							}
						}
						jsonArray.add(json);
					}
					retjson.put("diseinfo", jsonArray);
				}
				
				/**
				 * ������¼���ڵ��ʶ��oprninfo��
				 */
				XMLNode[] oprninfoEles = xdDoc.getDocumentElement().selectNodes("/Config/oprninfo");
				List<OperationInfoRec> operationInfoRecList=new EmrDao().getOperationInfoRecListByIpid(ipid);
				for(int i=0;i<oprninfoEles.length;i++){
					JSONArray jsonArray=new JSONArray();
					if(operationInfoRecList!=null&&operationInfoRecList.size()>0){
						for (int a=0;a<operationInfoRecList.size();a++){
							JSONObject json=new JSONObject();
							OperationInfoRec oir=operationInfoRecList.get(a);
							JSONObject oirJson=JSONArray.parseObject(JSONArray.toJSON(oir).toString());
							XMLNode xn = oprninfoEles[i];
							XMLNode[] childs =xn.getChildNodes();
							for(int j=0;j<childs.length;j++){
								XMLNode cxn =childs[j];
								//�ڵ�����
								String nodeName=cxn.getNodeName();
								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
									//�ڵ�ֵ
									String value=getValue(cxn,nodeName,"",inpJson,patJson,null,null,oirJson,inputStr);
									if(value!=null&&value.indexOf("err_msg")>-1){
										return value;
									}
									
									
									json.put(nodeName, value);
									
								}
							}
							jsonArray.add(json);
						}
						
					}else{
						JSONObject json=new JSONObject();
						XMLNode xn = oprninfoEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//�ڵ�����
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//�ڵ�ֵ
								String value=getValue(cxn,nodeName,"",inpJson,patJson,null,null,null,inputStr);
								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}
								
								
								json.put(nodeName, value);
								
							}
						}
						jsonArray.add(json);
					}
					retjson.put("oprninfo", jsonArray);
				}
				/**
				 * ���� icuinfo
				 */
				XMLNode[] icuinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/icuinfo");
				for(int i=0;i<icuinfoEles.length;i++){
					JSONArray jsonArray=new JSONArray();
					XMLNode xn = icuinfoEles[i];
					XMLNode[] childs =xn.getChildNodes();
					JSONObject json=new JSONObject();
					for(int j=0;j<childs.length;j++){
						XMLNode cxn =childs[j];
						//�ڵ�����
						String nodeName=cxn.getNodeName();
						if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
							//�ڵ�ֵ
							String xmlCont=fs!=null?fs.getXmlCont():"";
							String value=getValue(cxn,nodeName,xmlCont,inpJson,patJson,feeJson,null,null,inputStr);
							if(value!=null&&value.indexOf("err_msg")>-1){
								return value;
							}
							json.put(nodeName, value);
						}
					}
					jsonArray.add(json);
					retjson.put("icuinfo", jsonArray);
				}
				String ret=new HisDao().saveBaseInfo( ipid ,retjson,inp);
				if(ret.indexOf("�ɹ�")>-1){
					return retjson.toJSONString();
				}else{
					JSONObject errJson=new JSONObject();
					errJson.put("infcode", "-1");//����״̬��
					errJson.put("err_msg", ipid+" "+ret);
					return errJson.toJSONString();
				}
				
			}else{
				JSONObject errJson=new JSONObject();
				errJson.put("infcode", "-1");//����״̬��
				errJson.put("err_msg", ipid+"�ò��˲����ڣ���");
				return errJson.toJSONString();
			}
		}catch(Exception e){
			e.printStackTrace();
			JSONObject errJson=new JSONObject();
			errJson.put("infcode", "-1");//����״̬��
			errJson.put("err_msg", e.getMessage());
			return errJson.toJSONString();
		}finally{
			
		}
	}
	
	
	public String getDictCodeByTypeAndName(String type,String name){
		String ret="";
		
		if(Util.isEmpty(name)){
			return ret;
		}
		
		if("caty".equals(type)){
			return caty(name);
		}
		
		else if("mrg_stas".equals(type)){
			return mrg_stas(name);
		}
		else if("nat_regn_code".equals(type)){
			
			return nat_regn_code(name,this.map.get("nat_regn_code"));
		}else if("naty".equals(type)){
			return naty(name,this.map.get("naty"));
		}
		else if("blotype_abo_code".equals(type)){
			return blotype_abo_code(name,this.map.get("BloodType"));
		}
		else if("blotype_abo".equals(type)){
			return blotype_abo(name,this.map.get("BloodType"));
		}
		else if("blotype_rh".equals(type)){
			return blotype_rh(name,this.map.get("RhBloodType"));
		}
		else if("blotype_rh_code".equals(type)){
			return blotype_rh_code(name,this.map.get("RhBloodType"));
		}
		
		else if("prfs".equals(type)){
			return prfs(name);
		}
		else if("patn_rlts".equals(type)){
			return patn_rlts(name);
		}else if("adm_way".equals(type)){
			return adm_way(name);
		}else if("adm_way_code".equals(type)){
			return adm_way_code(name);
		}
		else if("medcas_qlt_code".equals(type)){
			return medcas_qlt_code(name);
		}
		else if("medcas_qlt_name".equals(type)){
			return medcas_qlt_name(name);
		}
		else if("dscg_way".equals(type)){
			return dscg_way(name);	
		}
		else if("dscg_rea".equals(type)){
			return dscg_rea(name);	
		}
		else if("medfee_paymtd_code".equals(type)){
			return medfee_paymtd_code(name);
		}
		else if("medfee_paymtd_name".equals(type)){
			return medfee_paymtd_name(name);
		}
		else if("ipt_dise_type".equals(type)){
			return ipt_dise_type(name);
		}
		else if("ipt_dise_type_code".equals(type)){
			return ipt_dise_type_code(name);
		}
		else if("adm_cond_type".equals(type)){
			return adm_cond_type(name);
		}
		else if("adm_cond_type_code".equals(type)){
			return adm_cond_type_code(name);
		}
		else if("oprn_oprt_lv_code".equals(type)){
			return oprn_oprt_lv_code(name);
		}
		else if("oprn_oprt_lv".equals(type)){
			return oprn_oprt_lv(name);
		}
		else if("sinc_heal_lv_code".equals(type)){
			return sinc_heal_lv_code(name);
		}
		else if("sinc_heal_lv".equals(type)){
			return sinc_heal_lv(name);
		}
		else if("anst_mtd_code".equals(type)){
			return anst_mtd_code(name);
		}
		else if("anst_mtd".equals(type)){
			return anst_mtd(name);
		}
		else if("anst_lv_code".equals(type)){
			return anst_lv_code(name);
		}
		else if("anst_lv".equals(type)){
			return anst_lv(name);
		}
		else if("trt_type".equals(type)){
			return trt_type(name);
		}
		else if("trt_type_code".equals(type)){
			return trt_type_code(name);
		}
		else if("surv_stas".equals(type)){
			return surv_stas(name);
		}
		return ret;
	}
	
	
	
	
	private String naty(String name,List<SystemDict> sdList){
		String value="";
		for(int i=0;sdList!=null&&i<sdList.size();i++){
			SystemDict sd= sdList.get(i);
			if(sd.getItemName().equals(name)){
				value=sd.getItemCode();
				break;
			}
		}
		return value;
	}
	
	private String nat_regn_code(String name,List<SystemDict> sdList){
		String value="";
		for(int i=0;sdList!=null&&i<sdList.size();i++){
			SystemDict sd= sdList.get(i);
			if(sd.getItemName().equals(name)){
				value=sd.getItemCode();
				break;
			}
		}
		return value;
	}
	
	private String blotype_abo_code(String name,List<SystemDict> sdList){
		String value="";
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
		}else if(value.indexOf("����")>-1){
			return "5";
		}else{
			return "9";
		}
	}
	
	private String blotype_abo(String name,List<SystemDict> sdList){
		String value="";
		for(int i=0;sdList!=null&&i<sdList.size();i++){
			SystemDict sd= sdList.get(i);
			if(sd.getItemCode().equals(name)){
				value=sd.getItemName();
			}
		}
		if("".equals(value)){
			return "δ��";
		}
		
		if(value.indexOf("AB")>-1){
			return "AB��";
		}else if(value.indexOf("A")>-1){
			return "A��";
		}else if(value.indexOf("B")>-1){
			return "B��";
		}else if(value.indexOf("O")>-1){
			return "O��";
		}else if(value.indexOf("����")>-1){
			return "����";
		}else{
			return "δ��";
		}
	}
	private String blotype_rh_code(String name,List<SystemDict> sdList){
		String value="";
		for(int i=0;sdList!=null&&i<sdList.size();i++){
			SystemDict sd= sdList.get(i);
			if(sd.getItemCode().equals(name)){
				value=sd.getItemName();
			}
		}
		if("".equals(value)){
			return "δ��";
		}
		if(value.indexOf("��")>-1){
			return "1";
		}else if(value.indexOf("��")>-1){
			return "2";
		}else if(value.indexOf("����")>-1){
			return "3";
		}
		return "4";
	}
	
	private String blotype_rh(String name,List<SystemDict> sdList){
		String value="";
		for(int i=0;sdList!=null&&i<sdList.size();i++){
			SystemDict sd= sdList.get(i);
			if(sd.getItemCode().equals(name)){
				value=sd.getItemName();
			}
		}
		if(value.indexOf("��")>-1){
			return "Rh����";
		}else if(value.indexOf("��")>-1){
			return "Rh����";
		}else if(value.indexOf("����")>-1){
			return "����";
		}
		return "δ��";
	}
	
	
	private String caty(String name){
		for(int i=0;this.hisDeptList!=null&&i<this.hisDeptList.size();i++){
			DictDepart dd=this.hisDeptList.get(i);
			if(dd.getBmID().equals(name)){
				return dd.getMicode();
			}
		}
		return "D99";
	}
	
	
	private String surv_stas(String name){
		if("5".equals(name)){
			return "2";
		}else{
			return "1";
		}
	}
	private String trt_type_code(String name){
		if("1".equals(name)||"1.1".equals(name)){
			return "21";
		}else if("1.2".equals(name)){
			return "22";
		}else if("2".equals(name)){
			return "30";
		}
		return "10";
	}
	
	private String trt_type(String name){
		if("1".equals(name)||"1.1".equals(name)){
			return "��ҽ";
		}else if("1.2".equals(name)){
			return "����ҽ";
		}else if("2".equals(name)){
			return "����ҽ";
		}
		return "��ҽ";
	}
	
	private String anst_lv_code(String name){
		if(name.indexOf("����")>-1){
			return "1";
		}else if(name.indexOf("��΢���ٴ�֢״")>-1){
			return "2";
		}else if(name.indexOf("Σ������")>-1){
			return "4";
		}else if(name.indexOf("����")>-1){
			return "3";
		}else if(name.indexOf("������")>-1){
			return "6";
		}else if(name.indexOf("���ܴ��")>-1){
			return "5";
		}
		return "";
	}
	private String anst_lv(String name){
		if(name.indexOf("����")>-1){
			return "�����Ļ���";
		}else if(name.indexOf("��΢���ٴ�֢״")>-1){
			return "��������΢���ٴ�֢״";
		}else if(name.indexOf("Σ������")>-1){
			return "���������Ե�ϵͳ�ٴ�֢״����Σ������";
		}else if(name.indexOf("����")>-1){
			return "���������Ե�ϵͳ�ٴ�֢״";
		}else if(name.indexOf("������")>-1){
			return "�������Ļ���";
		}else if(name.indexOf("���ܴ��")>-1){
			return "������������߽����ܴ��";
		}
		return "";
	}
	private String anst_mtd_code(String name){
		name=name.replaceAll("����", "");
		if(name.indexOf("ȫ��")>-1){
			return "1";
		}
		else if(name.indexOf("����")>-1){
			return "11";
		}
		else if(name.indexOf("����")>-1){
			return "12";
		}
		else if(name.indexOf("����")>-1){
			return "13";
		}
		else if(name.indexOf("׵��")>-1){
			return "2";
		}
		else if(name.indexOf("����Ĥ��ǻ����")>-1){
			return "21";
		}
		else if(name.indexOf("Ӳ��Ĥ��ǻ����")>-1){
			return "22";
		}
		else if(name.indexOf("�ֲ�")>-1||name.indexOf("����")>-1){
			return "3";
		}
		else if(name.indexOf("�񾭴�����")>-1){
			return "31";
		}
		else if(name.indexOf("�񾭽�����")>-1){
			return "32";
		}
		else if(name.indexOf("������")>-1){
			return "33";
		}
		else if(name.indexOf("��������")>-1){
			return "34";
		}
		else if(name.indexOf("�ֲ�����")>-1){
			return "35";
		}
		else if(name.indexOf("����")>-1){
			return "36";
		}
		else if(name.indexOf("����")>-1){
			return "4";
		}
		else if(name.indexOf("����")>-1){
			return "34";
		}
		return "9";
	}
	private String anst_mtd(String name){
		name=name.replaceAll("����", "");
		if(name.indexOf("ȫ��")>-1){
			return "ȫ������";
		}
		else if(name.indexOf("����")>-1){
			return "��������";
		}
		else if(name.indexOf("����")>-1){
			return "��������";
		}
		else if(name.indexOf("����")>-1){
			return "��������";
		}
		else if(name.indexOf("׵��")>-1){
			return "׵��������";
		}
		else if(name.indexOf("����Ĥ��ǻ����")>-1){
			return "����Ĥ��ǻ��������";
		}
		else if(name.indexOf("Ӳ��Ĥ��ǻ����")>-1){
			return "Ӳ��Ĥ��ǻ��������";
		}
		else if(name.indexOf("�ֲ�")>-1||name.indexOf("����")>-1){
			return "�ֲ�����";
		}
		else if(name.indexOf("�񾭴�����")>-1){
			return "�񾭴���������";
		}
		else if(name.indexOf("�񾭽�����")>-1){
			return "�񾭽���������";
		}
		else if(name.indexOf("������")>-1){
			return "������";
		}
		else if(name.indexOf("��������")>-1){
			return "������������";
		}
		else if(name.indexOf("�ֲ�����")>-1){
			return "�ֲ���������";
		}
		else if(name.indexOf("����")>-1){
			return "��������";
		}
		else if(name.indexOf("����")>-1){
			return "��������";
		}
		else if(name.indexOf("����")>-1){
			return "������������";
		}
		return "����������";
	}
	
	private String sinc_heal_lv(String name){
		if(name.indexOf("0��")>-1){
			return "0���п�";
		}
		else if(name.indexOf("��")>-1){
			if(name.indexOf("��")>-1){
				return "�пڵȼ���/�������ͼ�";
			}
			else if(name.indexOf("��")>-1){
				return "�пڵȼ���/����������";
			}
			else if(name.indexOf("��")>-1){
				return "�пڵȼ���/�������ͱ�";
			}
			return "�пڵȼ���/����";
		}
		else if(name.indexOf("��")>-1){
			if(name.indexOf("��")>-1){
				return "�пڵȼ���/�������ͼ�";
			}
			else if(name.indexOf("��")>-1){
				return "�пڵȼ���/����������";
			}
			else if(name.indexOf("��")>-1){
				return "�пڵȼ���/�������ͱ�";
			}
			return "�пڵȼ���/����";
		}
		else if(name.indexOf("��")>-1){
			if(name.indexOf("��")>-1){
				return "�пڵȼ���/�������ͼ�";
			}
			else if(name.indexOf("��")>-1){
				return "�пڵȼ���/����������";
			}
			else if(name.indexOf("��")>-1){
				return "�пڵȼ���/�������ͱ�";
			}
			return "�пڵȼ���/����";
		}
		return "�����п�����";
	}
	
	private String sinc_heal_lv_code(String name){
		if(name.indexOf("0��")>-1){
			return "0";
		}
		else if(name.indexOf("��")>-1){
			if(name.indexOf("��")>-1){
				return "1";
			}
			else if(name.indexOf("��")>-1){
				return "2";
			}
			else if(name.indexOf("��")>-1){
				return "3";
			}
			return "10";
		}
		else if(name.indexOf("��")>-1){
			if(name.indexOf("��")>-1){
				return "4";
			}
			else if(name.indexOf("��")>-1){
				return "5";
			}
			else if(name.indexOf("��")>-1){
				return "6";
			}
			return "11";
		}
		else if(name.indexOf("��")>-1){
			if(name.indexOf("��")>-1){
				return "7";
			}
			else if(name.indexOf("��")>-1){
				return "8";
			}
			else if(name.indexOf("��")>-1){
				return "9";
			}
			return "12";
		}
		return "99";
	}
	
	private String oprn_oprt_lv_code(String name){
		if("һ��".equals(name)){
			return "1";
		}
		else if("����".equals(name)){
			return "2";
		}
		else if("����".equals(name)){
			return "3";
		}
		else if("�ļ�".equals(name)){
			return "4";
		}
		return "5";
	}
	
	private String oprn_oprt_lv(String name){
		if("һ��".equals(name)){
			return "һ��";
		}
		else if("����".equals(name)){
			return "����";
		}
		else if("����".equals(name)){
			return "����";
		}
		else if("�ļ�".equals(name)){
			return "�ļ�";
		}
		return "����";
	}
	private String adm_cond_type(String name){
		if(name.indexOf("��")>-1){
			return "��";
		}
		else if(name.indexOf("δȷ��")>-1){
			return "�ٴ�δȷ��";
		}
		else if(name.indexOf("����")>-1){
			return "�������";
		}
		else if(name.indexOf("��")>-1){
			return "��";
		}
		return "��";
	}
	
	private String adm_cond_type_code(String name){
		if(name.indexOf("��")>-1){
			return "1";
		}
		else if(name.indexOf("δȷ��")>-1){
			return "2";
		}
		else if(name.indexOf("����")>-1){
			return "3";
		}
		else if(name.indexOf("��")>-1){
			return "4";
		}
		return "1";
	}
	
	private String ipt_dise_type_code(String name){
		if("cbzd".equals(name)||"ryzd".equals(name)||"xzzd".equals(name)||"bczd".equals(name)){
			return "31";
		}
		else if("swzd".equals(name)||"cyzd".equals(name)){
			return "1";
		}
		return "99";
	}
	private String ipt_dise_type(String name){
		if("cbzd".equals(name)||"ryzd".equals(name)||"xzzd".equals(name)||"bczd".equals(name)){
			return "��Ժ���";
		}
		else if("swzd".equals(name)||"cyzd".equals(name)){
			return "��Ժ���";
		}
		return "����";
	}
	
	private String medfee_paymtd_name(String name){
		if("01".equals(name)||"1".equals(name)){
			return "ְ������ҽ�Ʊ���";
		}else if("02".equals(name)||"2".equals(name)){
			return "�������ҽ�Ʊ���";
		}else if("03".equals(name)||"3".equals(name)){
			return "����ũ�����ҽ��";
		}else if("04".equals(name)||"4".equals(name)){
			return "ƶ������";
		}else if("05".equals(name)||"5".equals(name)){
			return "��ҵҽ�Ʊ���";
		}else if("06".equals(name)||"6".equals(name)){
			return "ȫ����";
		}else if("07".equals(name)||"7".equals(name)){
			return "ȫ�Է�";
		}else if("8".equals(name)||"90".equals(name)){
			return "�������ҽ�Ʊ���";
		}else if("9".equals(name)){
			return "����";
		}
		return "����";
	}
	private String medfee_paymtd_code(String name){
		if("01".equals(name)||"1".equals(name)){
			return "01";
		}else if("02".equals(name)||"2".equals(name)){
			return "02";
		}else if("03".equals(name)||"3".equals(name)){
			return "03";
		}else if("04".equals(name)||"4".equals(name)){
			return "04";
		}else if("05".equals(name)||"5".equals(name)){
			return "05";
		}else if("06".equals(name)||"6".equals(name)){
			return "06";
		}else if("07".equals(name)||"7".equals(name)){
			return "07";
		}else if("8".equals(name)||"90".equals(name)){
			return "90";
		}else if("9".equals(name)){
			return "99";
		}
		return "99";
	}
	
	private String dscg_rea(String name){
		if("1".equals(name)){
			return "����";
		}else if("2".equals(name)){
			return "��ת";
		}else if("3".equals(name)){
			return "δ��";
		}else if("4".equals(name)){
			return "����";
		}else{
			return "����";
		}
	}
	
	private String prfs(String name){
		if(name.indexOf("����Ա")>-1){
			return "11";
		}else if(name.indexOf("����")>-1){
			return "13";
		}else if(name.indexOf("ְԱ")>-1){
			return "17";
		}else if(name.indexOf("����")>-1){
			return "21";
		}else if(name.indexOf("����")>-1){
			return "24";
		}else if(name.indexOf("ũ��")>-1){
			return "27";
		}else if(name.indexOf("ѧ��")>-1){
			return "31";
		}else if(name.indexOf("���۾���")>-1){
			return "37";
		}else if(name.indexOf("����")>-1){
			return "51";
		}else if(name.indexOf("����")>-1||name.indexOf("��Ӫ")>-1){
			return "54";
		}else if(name.indexOf("��ҵ")>-1){
			return "70";
		}else if(name.indexOf("��")>-1||name.indexOf("��")>-1){
			return "80";
		}
		return "90";
	}
	
	private String dscg_way(String name){
		if("1".equals(name)){
			return "ҽ����Ժ";
		}
		else if("2".equals(name)){
			return "ҽ��תԺ";
		}
		else if("3".equals(name)){
			return "ҽ��ת���������������/��������Ժ";
		}
		else if("4".equals(name)){
			return "��ҽ����Ժ";
		}
		else if("5".equals(name)){
			return "����";
		}
		else if("9".equals(name)){
			return "����";
		}
		return "ҽ����Ժ";
	}
	
	private String patn_rlts(String name){
		if(name.indexOf("����")>-1){
			return "01";
		}
		else if(name.indexOf("����")>-1){
			return "02";
		}
		else if(name.indexOf("��ż")>-1){
			return "10";
		}
		else if(name.indexOf("��")>-1){
			return "11";
		}
		else if(name.indexOf("��")>-1){
			return "12";
		}
		else if(name.indexOf("��")>-1||name.indexOf("��")>-1){
			return "20";
		}
		else if(name.indexOf("Ů")>-1){
			return "30";
		}
		else if(name.indexOf("��")>-1){
			return "40";
		}
		else if(name.indexOf("��")>-1){
			return "51";
		}
		else if(name.indexOf("ĸ")>-1){
			return "52";
		}
		else if(name.indexOf("��")>-1||name.indexOf("��")>-1||name.indexOf("��")>-1||name.indexOf("��")>-1){
			return "70";
		}
		return "80";
	}
	
	private String adm_way(String name){
		if("1".equals(name)){
			return "����";
		}
		else if("2".equals(name)){
			return "����";
		}
		else if("3".equals(name)){
			return "����ҽ�ƻ���ת��";
		}
		else if("9".equals(name)){
			return "����";
		}else if("003".equals(name)){
			return "3";
		}
		return "����";
	}
	private String adm_way_code(String name){
		if("003".equals(name)){
			return "3";
		}
		else if("001".equals(name)){
			return "1";
		}
		else{
			return "9";
		}
	}
	
	
	
	
	private String mrg_stas(String name){
		if("δ��".equals(name)){
			return "10";
		}else if("�ѻ�".equals(name)){
			return "20";
		}else if("����".equals(name)){
			return "21";
		}else if("�ٻ�".equals(name)){
			return "22";
		}else if("����".equals(name)){
			return "23";
		}else if("ɥż".equals(name)){
			return "30";
		}else if("���".equals(name)){
			return "40";
		}
		return "90";
	}
	

	
	private String medcas_qlt_code(String name){
		if("1".equals(name)||"��".equals(name)){
			return "1";
		}else if("2".equals(name)||"��".equals(name)){
			return "2";
		}else if("2".equals(name)||"��".equals(name)){
			return "3";
		}else{
			return "";
		}
	}
	private String medcas_qlt_name(String name){
		if("1".equals(name)||"��".equals(name)){
			return "��";
		}else if("2".equals(name)||"��".equals(name)){
			return "��";
		}else if("2".equals(name)||"��".equals(name)){
			return "��";
		}else{
			return "";
		}
	}
	
	
	

	
	
	public String getValue(XMLNode cxn,String nodeName,String xmlCont,JSONObject inpJson,JSONObject patJson,JSONObject feeJson,JSONObject inpDiagJson,JSONObject oirJson,JSONObject inputStr){
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



			//�ڵ�ֵ
			String textContent=cxn.getTextContent();
			//�ڵ�����ֵ
			String structId=cxn.getAttribute("struct_id");
			String table=cxn.getAttribute("table");

			/**
			 * ����ڵ�����structId��Ϊ�ա�����structIdֵȡģ�����ݡ�
			 */
			if(structId!=null&&structId.length()>0&&xmlCont!=null&&xmlCont.length()>0){
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
				}else{
					value=to.getTextValueOrPanelTextById(structId);
				}



			}
			/**
			 * ����ڵ�����table��Ϊ�ա�����table�ж��ĸ���Ȼ���ýڵ�ֵȡ��Ӧjson��ֵ
			 */
			else if(table!=null&&table.length()>0){
				if("INPATIENT".equals(table)){
					value=inpJson.get(textContent)+"";
				}
				else if("PATIENT".equals(table)){
					value=patJson.get(textContent)+"";
				}
				else if("FRONTSHEETFEE".equals(table)){
					value=feeJson.get(textContent)+"";
				}
				else if("INPDIAG".equals(table)&&inpDiagJson!=null){
					value=inpDiagJson.get(textContent)+"";
					//				System.out.println("�ڵ����ƣ�"+nodeName+" textContent��"+textContent+"  value��"+value);
				}
				else if("OPERATIONINFOREC".equals(table)&&oirJson!=null){
					value=oirJson.get(textContent)+"";
				}

			}
			/**
			 * �����û�У����жϽڵ�ֵ�Ƿ�Ϊ��,��Ϊ�յĻ�����ֱ��Ĭ��ֵ
			 */
			else if(!Util.isEmpty(DataUtil.toString(textContent))){
				value=textContent;
			}
			/**
			 * ����պ�"-"
			 */
			value=DataUtil.toString(value);

			/**
			 * �ж�dict�Ƿ�Ϊ�գ���Ϊ�գ�����dictȥ����ת��
			 */
			String dict=cxn.getAttribute("dict");
			if(!Util.isEmpty(dict)){
				value=getDictCodeByTypeAndName(dict,value);
			}
			/**
			 * �ж���������
			 */
			String type=cxn.getAttribute("type");
			if("date".equals(type)){
				String format=cxn.getAttribute("format");
				try{
					if(value!=null&&value.indexOf("��")>-1){
						value=value.replace("��", "-");
					}
					if(value!=null&&value.indexOf("��")>-1||value!=null&&value.indexOf("��")>-1){
						value=value.replace("��", "-");
						value=value.replace("��", "-");
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
					value="";
				}
			}
		}
		/**
		 * �ж��Ƿ���isnull=NΪ����
		 */
		String isnull=cxn.getAttribute("isnull");
		if("N".equals(isnull)&&(Util.isEmpty(value))){
			JSONObject errJson=new JSONObject();
			errJson.put("infcode", "-1");//����״̬��
			errJson.put("err_msg", nodeName+"����Ϊ�գ���");
			return errJson.toJSONString();
		}
		return value;
	}
	
}
