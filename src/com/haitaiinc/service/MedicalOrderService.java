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
				 * 表 209 输入（节点标识：data）
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
								//节点名称
								String nodeName=cxn.getNodeName();
								if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
									//节点值
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
							//节点名称
							String nodeName=cxn.getNodeName();
							if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
								//节点值
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



			//节点值
			String textContent=cxn.getTextContent();
			//节点属性值
			String structId=cxn.getAttribute("struct_id");
			String table=cxn.getAttribute("table");

			/**
			 * 如果节点属性structId不为空。则按照structId值取模板数据。
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
			 * 如果节点属性table不为空。则按照table判断哪个表，然后用节点值取对应json的值
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
			 * 如果都没有，则判断节点值是否为空,不为空的话，则直接默认值
			 */
			else if(!Util.isEmpty(DataUtil.toString(textContent))){
				value=textContent;
			}
			/**
			 * 处理空和"-"
			 */
			value=DataUtil.toString(value);

			/**
			 * 判断dict是否为空，不为空，则用dict去进行转换
			 */
			String dict=cxn.getAttribute("dict");
			if(!Util.isEmpty(dict)){
				value=getDictCodeByTypeAndName(dict,value);
			}
			/**
			 * 判断数据类型
			 */
			String type=cxn.getAttribute("type");
			if("date".equals(type)){
				String format=cxn.getAttribute("format");
				try{
					if(value!=null&&value.indexOf("月")>-1){
						value=value.replace("月", "-");
					}
					if(value!=null&&value.indexOf("日")>-1||value!=null&&value.indexOf("号")>-1){
						value=value.replace("日", "-");
						value=value.replace("号", "-");
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
		 * 判断是否必填。isnull=N为必填
		 */
		String isnull=cxn.getAttribute("isnull");
		if("N".equals(isnull)&&(Util.isEmpty(value))){
			JSONObject errJson=new JSONObject();
			errJson.put("infcode", "-1");//交易状态码
			errJson.put("err_msg", nodeName+"不能为空！！");
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
		if("口服".equals(name)){
			return "口服";
		}else if(name.indexOf("直肠")>-1){
			return "直肠给药";
		}else if(name.indexOf("舌下")>-1){
			return "舌下给药";
		}else if(name.indexOf("皮下")>-1){
			return "皮下注射";
		}else if(name.indexOf("皮内")>-1){
			return "皮内注射";
		}
		else if(name.indexOf("肌肉")>-1){
			return "肌肉注射";
		}
		else if(name.indexOf("静脉")>-1){
			return "静脉注射或静脉滴注";
		}
		else if(name.indexOf("注射")>-1){
			return "注射给药";
		}
		else if(name.indexOf("吸入")>-1){
			return "吸入给药";
		}
		else if(name.indexOf("局部")>-1){
			return "局部用药";
		}
		else if(name.indexOf("气管内")>-1){
			return "气管内用药";
		}
		else if(name.indexOf("滴眼")>-1){
			return "滴眼";
		}
		else if(name.indexOf("滴鼻")>-1){
			return "滴鼻";
		}
		else if(name.indexOf("含")>-1){
			return "含化 ";
		}
		else if(name.indexOf("外用")>-1){
			return "擦皮肤 ";
		}
		return "其他给药途径";
	}
	
	private String drug_medc_way_code(String name){
		if("口服".equals(name)){
			return "1";
		}else if(name.indexOf("直肠")>-1){
			return "2";
		}else if(name.indexOf("舌下")>-1){
			return "3";
		}else if(name.indexOf("皮下")>-1){
			return "401";
		}else if(name.indexOf("皮内")>-1){
			return "402";
		}
		else if(name.indexOf("肌肉")>-1){
			return "403";
		}
		else if(name.indexOf("静脉")>-1){
			return "404";
		}
		else if(name.indexOf("吸入")>-1){
			return "5";
		}
		else if(name.indexOf("局部")>-1){
			return "6";
		}
		else if(name.indexOf("气管内")>-1){
			return "606";
		}
		else if(name.indexOf("滴眼")>-1){
			return "607";
		}
		else if(name.indexOf("滴鼻")>-1){
			return "608";
		}
		else if(name.indexOf("含")>-1){
			return "608";
		}
		else if(name.indexOf("外用")>-1){
			return "612";
		}
		return "9";
	}
	
	private String drord_item_type(String name){
		if("XY".equals(name)){
			return "西药";
		}else if("ZCY".equals(name)){
			return "中成药";
		}else if("CY".equals(name)){
			return "中药饮片";
		}else if("ZL".equals(name)){
			return "治疗";
		}else if("JY".equals(name)){
			return "检验";
		}else if("JC".equals(name)){
			return "检查";
		}else if("SS".equals(name)){
			return "手术";
		}else if("HL".equals(name)){
			return "护理";
		}else if("SW".equals(name)){
			return "膳食";
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
