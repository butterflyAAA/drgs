package com.haitaiinc.business;

import com.haitaiinc.service.FixmedinsMedrcdInfoService;
import com.haitaiinc.service.FrontSheetService;
import com.haitaiinc.service.MedicalOrderService;


public class Manage{
	public String manageType(String type, String jsonStr) throws Exception{
		String returnValue = "";
		System.out.println("传入的Type====" + type);
		if("getFrontSheet".equals(type)){
			System.out.println("传入的jsonStr====" + jsonStr);
			returnValue =new FrontSheetService().getFrontSheetByIpid(jsonStr);
		}else if("getMedicalOrder".equals(type)){
			System.out.println("传入的jsonStr====" + jsonStr);
			returnValue =new MedicalOrderService().getMedicalOrderByIpid(jsonStr);
		}else if("getFixmedinsMedrcdInfo".equals(type)){
			System.out.println("传入的jsonStr====" + jsonStr);
			returnValue =new FixmedinsMedrcdInfoService().getFixmedinsMedrcdInfoServiceByIpid(jsonStr);
		}
		System.out.println("返回值："+returnValue);
		return returnValue;
	}
}