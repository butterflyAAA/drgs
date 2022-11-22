package com.haitaiinc.test;

import java.io.File;
import java.net.URL;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haitaiinc.Util;
import com.haitaiinc.common.EMRDataAccessObject;
import com.haitaiinc.dao.EmrDao;
import com.haitaiinc.data.DBOperator;
import com.haitaiinc.htdb.adt.dto.Inpatient;
import com.haitaiinc.htdb.adt.tableadapters.InpatientTableAdapter;
import com.haitaiinc.htdb.inpcase.dto.FrontSheet;
import com.haitaiinc.htdb.inpcase.dto.FrontSheetFee;
import com.haitaiinc.system.ConfigManager;
import com.haitaiinc.xml.XMLDocument;
import com.haitaiinc.xml.XMLNode;

import dom.TemplateOperator;

public class Test{
	public static void main(String[] arg0) throws Exception{
		
		FrontSheetFee fee=new EmrDao().getFrontSheetFeeByIpid("16658");
		JSONObject feeJson=JSONArray.parseObject(JSONArray.toJSON(fee).toString());
		System.out.println(feeJson.toJSONString());
		
		
//		String struct_id="955DB6B625524069B8F249748BDF25D8/FD8432F6F9134110B35CE7D41D98BA17/4492E791AEBA4B7495C6C72775A4C129";
//		if(struct_id.indexOf("/")>-1){
//			String[] struct_ids=struct_id.split("/");
//			for(int j=0;j<struct_ids.length;j++){
//				System.out.println(struct_ids[j]);
//			}
//		}
//		
		
//		FrontSheet fs=new FrontSheetDao().getFrontSheetByIpid("16658");
//		
//		String xmlCont=fs.getXmlCont();
//		TemplateOperator to=new TemplateOperator();
//		to.loadXml(xmlCont);
//		System.out.println(to.getTextValueOrPanelTextById("A91D38BC077E4B47A06E04BF29CDC54E"));
		
//		URL url = ConfigManager.class.getResource("/Config.xml");
//		XMLDocument xdDoc = XMLDocument.parse(new File(url.toURI()));
//		XMLNode[] baseinfoEles = xdDoc.getDocumentElement().selectNodes("/Config/baseinfo");
//		for(int i=0;i<baseinfoEles.length;i++){
//			XMLNode xn = baseinfoEles[i];
//			XMLNode[] childs =xn.getChildNodes();
//			for(int j=0;j<childs.length;j++){
//				XMLNode cxn =childs[j];
//				//节点名称
//				String nodeName=cxn.getNodeName();
//				if((!"#text".equals(nodeName))&&(!"#comment".equals(nodeName))){
//					//节点值
//					String textContent=cxn.getTextContent();
//					//节点属性值
//					String structId=cxn.getAttribute("struct_id");
//					String table=cxn.getAttribute("table");
//					System.out.println("节点名称==="+nodeName+"   节点值="+textContent+"   struct_id="+structId+"   table=="+table);
//					/**
//					 * 如果节点属性不为空。则按照节点值取模板数据。
//					 */
//					if(structId!=null&&structId.length()>0){
//						
//					}
//				}
//			}
//		}
//		String ss=Util.toPascalName("ADMINISSION_NO");
//		System.out.println(ss);
		
//		List<HospitalRecord> list = new HospitalRecordTableAdapter(dbo).select("ipid='16672'");
//		if(list!=null&&list.size()>0){
//			HospitalRecord hr=list.get(0);
//			TemplateOperator ope = new TemplateOperator();
//			ope.loadXml(hr.getXmlCont());
//			System.out.println(ope.getSummary());
//		}
	}
}
