package com.haitaiinc.custume.frontsheet;

import java.util.List;

import com.haitaiinc.Util;
import com.haitaiinc.hisdb.dictmanage.DictDepart;
import com.haitaiinc.htdb.comm.dto.SystemDict;

public class DictMapping {

	/**
	 * 民族
	 * @param name
	 * @return
	 */
	public static String naty(String name) {
		if(Util.isEmpty(name)) {
			return "99";
		}else {
			if(name.indexOf("汉族")>-1) {
				return "01";
			}else if(name.indexOf("柯尔克孜")>-1) {
				return "29";
			}else if(name.indexOf("蒙古")>-1) {
				return "02";
			}else if(name.indexOf("土")>-1) {
				return "30";
			}else if(name.indexOf("回")>-1) {
				return "03";
			}else if(name.indexOf("达斡尔")>-1) {
				return "31";
			}else if(name.indexOf("藏")>-1) {
				return "04";
			}else if(name.indexOf("仫佬")>-1) {
				return "32";
			}else if(name.indexOf("维吾尔")>-1) {
				return "05";
			}else if(name.indexOf("羌")>-1) {
				return "33";
			}else if(name.indexOf("苗")>-1) {
				return "06";
			}else if(name.indexOf("布朗")>-1) {
				return "34";
			}else if(name.indexOf("彝")>-1) {
				return "07";
			}else if(name.indexOf("撒拉")>-1) {
				return "35";
			}else if(name.indexOf("壮")>-1) {
				return "08";
			}else if(name.indexOf("毛南")>-1) {
				return "36";
			}else if(name.indexOf("布依")>-1) {
				return "09";
			}else if(name.indexOf("仡佬")>-1) {
				return "37";
			}else if(name.indexOf("朝鲜")>-1) {
				return "10";
			}else if(name.indexOf("锡伯")>-1) {
				return "38";
			}else if(name.indexOf("满")>-1) {
				return "11";
			}else if(name.indexOf("阿昌")>-1) {
				return "39";
			}else if(name.indexOf("侗")>-1) {
				return "12";
			}else if(name.indexOf("普米")>-1) {
				return "40";
			}else if(name.indexOf("瑶")>-1) {
				return "13";
			}else if(name.indexOf("塔吉克")>-1) {
				return "41";
			}else if(name.indexOf("白")>-1) {
				return "14";
			}else if(name.indexOf("怒")>-1) {
				return "42";
			}else if(name.indexOf("土家")>-1) {
				return "15";
			}else if(name.indexOf("乌孜别克")>-1) {
				return "43";
			}else if(name.indexOf("哈尼")>-1) {
				return "16";
			}else if(name.indexOf("俄罗斯")>-1) {
				return "44";
			}else if(name.indexOf("哈萨克")>-1) {
				return "17";
			}else if(name.indexOf("鄂温克")>-1) {
				return "45";
			}else if(name.indexOf("傣")>-1) {
				return "18";
			}else if(name.indexOf("德昂")>-1) {
				return "46";
			}else if(name.indexOf("黎")>-1) {
				return "19";
			}else if(name.indexOf("保安")>-1) {
				return "47";
			}else if(name.indexOf("傈僳")>-1) {
				return "20";
			}else if(name.indexOf("裕固")>-1) {
				return "48";
			}else if(name.indexOf("佤")>-1) {
				return "21";
			}else if(name.indexOf("京")>-1) {
				return "49";
			}else if(name.indexOf("畲")>-1) {
				return "22";
			}else if(name.indexOf("塔塔尔")>-1) {
				return "50";
			}else if(name.indexOf("高山")>-1) {
				return "23";
			}else if(name.indexOf("独龙")>-1) {
				return "51";
			}else if(name.indexOf("拉祜")>-1) {
				return "24";
			}else if(name.indexOf("鄂伦春")>-1) {
				return "52";
			}else if(name.indexOf("水")>-1) {
				return "25";
			}else if(name.indexOf("赫哲")>-1) {
				return "53";
			}else if(name.indexOf("东乡")>-1) {
				return "26";
			}else if(name.indexOf("门巴")>-1) {
				return "54";
			}else if(name.indexOf("纳西")>-1) {
				return "27";
			}else if(name.indexOf("珞巴")>-1) {
				return "55";
			}else if(name.indexOf("景颇")>-1) {
				return "28";
			}else if(name.indexOf("基诺")>-1) {
				return "56";
			}else {
				return "99";
			}
		}
	}
	
	/**
	 * 职业
	 * @param name
	 * @return
	 */
	public static String prfs(String name){
		if(name.indexOf("公务员")>-1){
			return "11";
		}else if(name.indexOf("技术")>-1){
			return "13";
		}else if(name.indexOf("职员")>-1){
			return "17";
		}else if(name.indexOf("管理")>-1){
			return "21";
		}else if(name.indexOf("工人")>-1){
			return "24";
		}else if(name.indexOf("农民")>-1){
			return "27";
		}else if(name.indexOf("学生")>-1){
			return "31";
		}else if(name.indexOf("现役军人")>-1){
			return "37";
		}else if(name.indexOf("自由")>-1){
			return "51";
		}else if(name.indexOf("个体")>-1||name.indexOf("经营")>-1){
			return "54";
		}else if(name.indexOf("无业")>-1){
			return "70";
		}else if(name.indexOf("退")>-1||name.indexOf("离")>-1){
			return "80";
		}
		return "90";
	}
	/**
	 * 婚姻状态
	 * @param name
	 * @return
	 */
	public static String mrg_stas(String name){
		if("1".equals(name)){
			return "10";
		}else if("2".equals(name)){
			return "20";
		}else if("3".equals(name)){
			return "30";
		}else if("4".equals(name)){
			return "40";
		}
		return "90";
	}
	
	/**
	 * 与联系人关系代码
	 * @param name
	 * @return
	 */
	public static String patn_rlts(String name){
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
	
	/**
	 * 入院途径
	 * @param name
	 * @return
	 */
	public static String adm_way(String name){
		if("1".equals(name)){
			return "急诊";
		}
		else if("2".equals(name)){
			return "门诊";
		}
		else if("3".equals(name)){
			return "其他医疗机构转入";
		}
		else if("9".equals(name)){
			return "其他";
		}else if("003".equals(name)){
			return "3";
		}
		return "门诊";
	}
	
	/**
	 * 模板里 :1.西医 2.中医 3民族医 4.中西医
	 * 治疗类别 
	 * @param name
	 * @return
	 */
	public static String trt_type(String name){
		if("1".equals(name)) {
			return "西医";
		}else if("2".equals(name)){
			return "中医";
		}else if("3".equals(name)){
			return "民族医";
		}else if("4".equals(name)){
			return "中西医";
		}
		return "西医";
	}
	/**
	 * 模板里 :1.西医 2.中医 3民族医 4.中西医
	 * 对应医保文档
	 * 10	西医	22	民族医
	 * 21	中医	30	中西医
	 * 治疗类别 
	 * @param name
	 * @return
	 */
	public static String trt_type_code(String name){
		if("1".equals(name)) {
			return "10";
		}else if("2".equals(name)){
			return "21";
		}else if("3".equals(name)){
			return "22";
		}else if("4".equals(name)){
			return "30";
		}
		return "10";
	}
	/**
	 * 科室转换
	 * @param name
	 * @param hisDeptList
	 * @return
	 */
	public static String caty(String name,List<DictDepart> hisDeptList){
		for(int i=0;hisDeptList!=null&&i<hisDeptList.size();i++){
			DictDepart dd=hisDeptList.get(i);
			if(dd.getBmID().equals(name)){
				return dd.getMicode();
			}
		}
		return "D99";
	}
	
	
	
	/**
	 * abo血型名称
	 * @param name
	 * @param sdList
	 * @return
	 */
	public static String blotype_abo(String value){
		if("1".equals(value)) {
			return "A型";
		}else if("2".equals(value)) {
			return "B型";
		}else if("3".equals(value)) {
			return "O型";
		}else if("4".equals(value)) {
			return "AB型";
		}else if("5".equals(value)) {
			return "不详";
		}else {
			return "未查";
		}
	}

	/**
	 * RH血型名称
	 * @param name
	 * @param sdList
	 * @return
	 */
	public static String blotype_rh(String value){
		if("1".equals(value)) {
			return "Rh阴型";
		}else if("2".equals(value)) {
			return "Rh阳型";
		}else if("3".equals(value)) {
			return "不详";
		}else {
			return "未查";
		}
	}
	
	/**
	 * 入院病情名称
	 * @param name
	 * @return
	 */
	public static String adm_cond_type(String name){
		if("1".equals(name)){
			return "有";
		}
		else if("2".equals(name)){
			return "临床未确定";
		}
		else if("3".equals(name)){
			return "情况不明";
		}
		else if("4".equals(name)){
			return "无";
		}
		return "有";
	}
	
	private String adm_cond_type_code(String name){
		if(name.indexOf("有")>-1){
			return "1";
		}
		else if(name.indexOf("未确定")>-1){
			return "2";
		}
		else if(name.indexOf("不明")>-1){
			return "3";
		}
		else if(name.indexOf("无")>-1){
			return "4";
		}
		return "1";
	}
	
	/**
	 * 诊断符合情况代码
	 * @param name
	 * @return
	 */
	public static String ipt_dise_inscp_code(String name) {
		if(Util.isEmpty(name)) {
			return "9";
		}else {
			name=name.trim();
		}
		return name;
	}
	
	/**
	 * 诊断符合情况名称
	 * @param name
	 * @return
	 */
	public static String ipt_dise_inscp(String name) {
		if("1".equals(name)) {
			return "符合";
		}else if("2".equals(name)) {
			return "不符合";
		}else if("3".equals(name)) {
			return "诊断符合情况扩充内容";
		}else{
			return "无对照";
		}
	}
	
	/**
	 * 离院方式名称
	 * @param name
	 * @return
	 */
	public static String dscg_way(String name){
		if("1".equals(name)){
			return "医嘱离院";
		}
		else if("2".equals(name)){
			return "医嘱转院";
		}
		else if("3".equals(name)){
			return "医嘱转社区卫生服务机构/乡镇卫生院";
		}
		else if("4".equals(name)){
			return "非医嘱离院";
		}
		else if("5".equals(name)){
			return "死亡";
		}
		else if("9".equals(name)){
			return "其他";
		}
		return "医嘱离院";
	}
	
	/**
	 * 病案质量
	 * @param name
	 * @return
	 */
	public static String medcas_qlt_name(String name){
		if("1".equals(name)||"甲".equals(name)){
			return "甲";
		}else if("2".equals(name)||"乙".equals(name)){
			return "乙";
		}else if("2".equals(name)||"丙".equals(name)){
			return "丙";
		}else{
			return "";
		}
	}
	
	public static String oprn_oprt_lv_code(String name){
		if("1".equals(name)){
			return "一级";
		}
		else if("2".equals(name)){
			return "二级";
		}
		else if("3".equals(name)){
			return "三级";
		}
		else if("4".equals(name)){
			return "四级";
		}
		return "其他等级";
	}
	
	
	/**
	 * 国籍字典转换
	 * @param name
	 * @return
	 */
	public static String nat_regn_code(String name ) {
		if("中国".equals(name)) {
			return "CHN";
		}else if("香港".equals(name)) {
			return "HKG";
		}else if("澳门".equals(name)) {
			return "MAC";
		}else if("台湾".equals(name)) {
			return "TWN";
		}else if("法国".equals(name)) {
			return "FRA";
		}else if("德国".equals(name)) {
			return "DEU";
		}else if("日本".equals(name)) {
			return "JPN";
		}else if("韩国".equals(name)) {
			return "KOR";
		}else if("朝鲜".equals(name)) {
			return "PRK";
		}
		return "CHN";
	}
	
}
