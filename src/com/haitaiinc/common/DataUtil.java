package com.haitaiinc.common;

import com.haitaiinc.Util;


public class DataUtil {

	public static String toString(String str){
		if(!Util.isEmpty(str)){
			str=str.trim();
			if("-".equals(str)){
				return "";
			}
			if("—".equals(str)){
				return "";
			}
			if("null".equals(str)||"NULL".equals(str)){
				return "";
			}
		}else{
			return "";
		}
		return str;
	}
	

	
	
	
}
