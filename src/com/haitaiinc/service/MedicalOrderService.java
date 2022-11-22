package com.haitaiinc.service;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haitaiinc.Util;
import com.haitaiinc.common.DataUtil;
import com.haitaiinc.dao.EmrDao;
import com.haitaiinc.dao.HisDao;
import com.haitaiinc.hisdb.dictmanage.DictDepart;
import com.haitaiinc.htdb.adt.dto.Inpatient;
import com.haitaiinc.htdb.inpord.dto.DrugOrder;
import com.haitaiinc.htdb.inpord.dto.MedicalOrder;
import com.haitaiinc.system.ConfigManager;
import com.haitaiinc.xml.XMLDocument;
import com.haitaiinc.xml.XMLNode;

import dom.TemplateOperator;

public class MedicalOrderService {

	public static void main(String[] args) {
		String jsonStr="{\"ipid\": \"16661\",\"fixmedins_code\": \"1234\",\"mdtrt_sn\": \"111\",\"mdtrt_id\": \"2222\",\"psn_no\": \"33333\"}";
		String retStr=new MedicalOrderService().getMedicalOrderByIpid(jsonStr);
		System.out.println("==="+retStr);
		
//		List<MedicalOrder> moList= new EmrDao().getMedicalOrderByIpid("16661");
//		for(int i=0;moList!=null&&i<moList.size();i++){
//			MedicalOrder mo=moList.get(i);
//			JSONObject moJson=JSONArray.parseObject(JSONArray.toJSON(mo).toString());
//			System.out.println(moJson);
//		}
	}
	
	protected List<DictDepart> hisDeptList=null;
	
	public String getMedicalOrderByIpid(String jsonStr){
		try{
			JSONObject inputStr=JSONArray.parseObject(jsonStr);
			String ipid=inputStr.getString("ipid");
			JSONObject retjson=new JSONObject();
			Inpatient inp=new EmrDao().getInpateintByipid(ipid);
			if(inp!=null&&inp.getIpid()!=null){
				JSONObject inpJson=JSONArray.parseObject(JSONArray.toJSON(inp).toString());
				List<MedicalOrder> moList= new EmrDao().getMedicalOrderByIpid(ipid);
				Map<String,DrugOrder> orderMap=new EmrDao().getDrugOrderByIpid(ipid);
				
				this.hisDeptList= new HisDao().getDictDepart();
				URL url = ConfigManager.class.getResource("/4402.xml");
				XMLDocument xdDoc = XMLDocument.parse(new File(url.toURI()));
				
				/**
				 * �� 209 ���루�ڵ��ʶ��data��
				 */
				XMLNode[] dataEles = xdDoc.getDocumentElement().selectNodes("/Config/data");
				
				for(int i=0;i<dataEles.length;i++){
					JSONArray jsonArray=new JSONArray();
					if(moList!=null&&moList.size()>0){
						for (int a=0;a<moList.size();a++){
							JSONObject json=new JSONObject();
							MedicalOrder mo=moList.get(a);
							JSONObject moJson=JSONArray.parseObject(JSONArray.toJSON(mo).toString());
							DrugOrder dOrder=orderMap.get(mo.getOrderSN());
							JSONObject dOrderJson=null;
							if(dOrder!=null){
								dOrderJson=JSONArray.parseObject(JSONArray.toJSON(dOrder).toString());
							}
							XMLNode xn = dataEles[i];
							XMLNode[] childs =xn.getChildNodes();
							for(int j=0;j<childs.length;j++){
								XMLNode cxn =childs[j];
								//�ڵ�����
								String nodeName=cxn.getNodeName();
								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
									//�ڵ�ֵ
									String value=getValue(cxn,nodeName,"",inpJson,moJson,dOrderJson,inputStr);
									if(value!=null&&value.indexOf("err_msg")>-1){
										return value;
									}
					                if ("medcas_drord_detl_id".equals(nodeName))
					                    json.put(nodeName, Integer.valueOf(Integer.parseInt(value)));
					                  else {
					                    json.put(nodeName, value);
					                  }
								}
							}
							jsonArray.add(json);
						}
						
					}else{
						JSONObject json=new JSONObject();
						XMLNode xn = dataEles[i];
						XMLNode[] childs =xn.getChildNodes();
						for(int j=0;j<childs.length;j++){
							XMLNode cxn =childs[j];
							//�ڵ�����
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//�ڵ�ֵ
								String value=getValue(cxn,nodeName,"",inpJson,null,null,inputStr);
								if(value!=null&&value.indexOf("err_msg")>-1){
									return value;
								}
				                if ("medcas_drord_detl_id".equals(nodeName))
				                    json.put(nodeName, Integer.valueOf(Integer.parseInt(value)));
				                  else {
				                    json.put(nodeName, value);
				                  }
							}
						}
						jsonArray.add(json);
					}
					retjson.put("data", jsonArray);
				}
				return retjson.toJSONString();
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
	public String getValue(XMLNode cxn,String nodeName,String xmlCont,JSONObject inpJson,JSONObject moJson,JSONObject dOrderJson,JSONObject inputStr){
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
				else if("MEDICALORDER".equals(table)&&moJson!=null){
					value=moJson.get(textContent)+"";
				}
				else if("DRUGORDER".equals(table)&&dOrderJson!=null){
					value=dOrderJson.get(textContent)+"";
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
	public String getDictCodeByTypeAndName(String type,String name){
		String ret="";
		if(Util.isEmpty(name)){
			return ret;
		}
		
		if("drord_type".equals(type)){
			return drord_type(name);
		}
		else if("drord_item_type_code".equals(type)){
			return drord_item_type_code(name);
		}
		else if("drord_item_type".equals(type)){
			return drord_item_type(name);
		}
		else if("drug_medc_way_code".equals(type)){
			return drug_medc_way_code(name);
		}
		else if("drug_medc_way".equals(type)){
			return drug_medc_way(name);
		}
		return ret;
	}
	
	private String drug_medc_way(String name){
		if("�ڷ�".equals(name)){
			return "�ڷ�";
		}else if(name.indexOf("ֱ��")>-1){
			return "ֱ����ҩ";
		}else if(name.indexOf("����")>-1){
			return "���¸�ҩ";
		}else if(name.indexOf("Ƥ��")>-1){
			return "Ƥ��ע��";
		}else if(name.indexOf("Ƥ��")>-1){
			return "Ƥ��ע��";
		}
		else if(name.indexOf("����")>-1){
			return "����ע��";
		}
		else if(name.indexOf("����")>-1){
			return "����ע�������ע";
		}
		else if(name.indexOf("ע��")>-1){
			return "ע���ҩ";
		}
		else if(name.indexOf("����")>-1){
			return "�����ҩ";
		}
		else if(name.indexOf("�ֲ�")>-1){
			return "�ֲ���ҩ";
		}
		else if(name.indexOf("������")>-1){
			return "��������ҩ";
		}
		else if(name.indexOf("����")>-1){
			return "����";
		}
		else if(name.indexOf("�α�")>-1){
			return "�α�";
		}
		else if(name.indexOf("��")>-1){
			return "���� ";
		}
		else if(name.indexOf("����")>-1){
			return "��Ƥ�� ";
		}
		return "������ҩ;��";
	}
	
	private String drug_medc_way_code(String name){
		if("�ڷ�".equals(name)){
			return "1";
		}else if(name.indexOf("ֱ��")>-1){
			return "2";
		}else if(name.indexOf("����")>-1){
			return "3";
		}else if(name.indexOf("Ƥ��")>-1){
			return "401";
		}else if(name.indexOf("Ƥ��")>-1){
			return "402";
		}
		else if(name.indexOf("����")>-1){
			return "403";
		}
		else if(name.indexOf("����")>-1){
			return "404";
		}
		else if(name.indexOf("����")>-1){
			return "5";
		}
		else if(name.indexOf("�ֲ�")>-1){
			return "6";
		}
		else if(name.indexOf("������")>-1){
			return "606";
		}
		else if(name.indexOf("����")>-1){
			return "607";
		}
		else if(name.indexOf("�α�")>-1){
			return "608";
		}
		else if(name.indexOf("��")>-1){
			return "608";
		}
		else if(name.indexOf("����")>-1){
			return "612";
		}
		return "9";
	}
	
	private String drord_item_type(String name){
		if("XY".equals(name)){
			return "��ҩ";
		}else if("ZCY".equals(name)){
			return "�г�ҩ";
		}else if("CY".equals(name)){
			return "��ҩ��Ƭ";
		}else if("ZL".equals(name)){
			return "����";
		}else if("JY".equals(name)){
			return "����";
		}else if("JC".equals(name)){
			return "���";
		}else if("SS".equals(name)){
			return "����";
		}else if("HL".equals(name)){
			return "����";
		}else if("SW".equals(name)){
			return "��ʳ";
		}
		return "31";
	}
	private String drord_item_type_code(String name){
		if("XY".equals(name)){
			return "11";
		}else if("ZCY".equals(name)){
			return "12";
		}else if("CY".equals(name)){
			return "13";
		}else if("ZL".equals(name)){
			return "21";
		}else if("JY".equals(name)){
			return "22";
		}else if("JC".equals(name)){
			return "23";
		}else if("SS".equals(name)){
			return "24";
		}else if("HL".equals(name)){
			return "26";
		}else if("SW".equals(name)){
			return "27";
		}
		return "31";
	}
	
	private String drord_type(String name){
		if("Y".equals(name)){
			return "2";
		}else if("N".equals(name)){
			return "1";
		}
		return "3";
	}
	
	
}
