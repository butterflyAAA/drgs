function fPopUpCalendarDlg(ctrlobj) {
	showx = event.screenX - event.offsetX - 4 - 210; // + deltaX;
	showy = event.screenY - event.offsetY + 18; // + deltaY;
	newWINwidth = 210 + 4 + 18;
	var defvalue = ctrlobj.value;
	var arg=null;
	if(defvalue!=null){
		arg={defvalue:defvalue};
	}
	var retval = window.showModalDialog(
					"js/calendar.htm",arg,
					"dialogWidth=219px;dialogHeight=232px;status=no");
	if (retval != null && retval != "undefined") {
		ctrlobj.value = retval;
	} else {
		// alert("canceled");
	}
}
/**
 * 选择时间（精确到秒）
 * @param obj
 * @return
 */
function fPopUpTimeDlg(obj) {
	var lc = "js/select_time.htm";
	var valuex = window.showModalDialog(lc, "",
			"dialogWidth=236px;dialogHeight=70px;status=no");
	if(valuex!=null){
		obj.value = valuex;
	}
}
/**
 * 选择时间（精确到分）
 * @param obj
 * @return
 */
function fPopUpTimeMinDlg(obj) {
	var lc = "js/select_time_min.htm";
	var valuex = window.showModalDialog(lc, "",
			"dialogWidth=220px;dialogHeight=100px;status=no");
	if(valuex){
		obj.value = valuex;
	}
}

function fPopUpDateTimeDlg(ctrlobj2) {
	showx = event.screenX - event.offsetX - 4 - 210; // + deltaX;
	showy = event.screenY - event.offsetY + 18; // + deltaY;
	newWINwidth = 210 + 4 + 18;

	var defvalue = ctrlobj2.value;
	defvalue=defvalue.substring(0, 4)
	+defvalue.substring(5, 7)
	+defvalue.substring(8, 10)
	+defvalue.substring(11, 13)
	+defvalue.substring(14, 16)+"00";
	var arg=null;
	if(defvalue!=null){
		arg={defvalue:defvalue};
	}
	retval2 = window
			.showModalDialog(
					"js/selectDateTime.htm",
					arg,
					"dialogWidth=250px; dialogHeight=260px;status=no; directories=yes;scrollbars=no;Resizable=no");
	if (retval2 != null) {
		ctrlobj2.value = retval2;
	}
}
function fPopUpDateTimeDlgs(ctrlobj2) {
	showx = event.screenX - event.offsetX - 4 - 210; // + deltaX;
	showy = event.screenY - event.offsetY + 18; // + deltaY;
	newWINwidth = 210 + 4 + 18;

	retval2 = window
			.showModalDialog(
					"js/showDateDTime.html",
					"????????????",
					"dialogWidth=390px; dialogHeight=180px;status=no; directories=yes;scrollbars=no;Resizable=no");
	if (retval2 != null) {
		ctrlobj2.value = retval2;
	}
}

/**
 * 使用Ajax技术保存数据，显示数据处理过程进度框，调用保存方法
 * @param loadDo 保存数据的方法 此参数必有
 */
function showLoad(loadDo){
	if(loadDo==null||loadDo==undefined||loadDo==""){
		return;
	}
	window.showModalDialog("js/ShowModalDialog.htm","showLoadLayer","dialogWidth=300;dialogHeight=130");
	window.setTimeout(loadDo,1);
}

/**
 * 使用Ajax技术保存数据失败后调用的函数
 * @param error 出错信息，可选参数
 */
function errorInfo(error){
	var divobj = document.getElementById("dealWithdivobj");
	if(error==null){
		error="数据处理出错，请将输入信息另存后，重新执行操作，如果操作不能完成，请联系系统管理员!";
		error = divobj.text;
	}
	var str ="<table height='100%' width='98%'><tr><td align='left' height='100%'>"
		+error+"</td></tr><tr><td align='center' height='30'>"
		+"<input type='button' name='btnErrorSave' value='保 存' class='f' onclick='saveDatainfo();hideLoad();'> "
		+"<input type='button' name='btnErrorClose' value='关 闭' class='f' onclick='closeLayer(\"showLoadLayer\");'></td></tr></table>";
	showLayerForHtml("showLoadLayer",str,"信息框",300,130,true);
}

/**
 * 固定好格式的alert改写
 * 
 * @param reason
 *            原因
 * @param operdesc
 *            操作
 */
function fn_alert(reason, operdesc) {
	var str = "！";
	if (operdesc != null && operdesc != "") {
		str = operdesc + str
	}
	if (reason != null && reason != "") {
		if(str.length>1){
			str ="，"+str;
		}
		str = "因为" + reason + str
	}
	var width = str.length * 12 + 20;
	var color = document.body.style.backgroundColor;

	window
			.showModalDialog(
					"js/FnAlert.htm",
					str,
					"dialogWidth:"
							+ width
							+ "px;dialogHeight:100px;center:yes;status:no;resizable:no;scroll:no");
}
/**
 * 固定好格式的confirm改写
 * 
 * @param reason
 *            原因
 * @param operdesc
 *            操作
 * @param adv
 *            建议
 */
function fn_confirm(reason, operdesc, adv) {
	var str = "！";
	if (adv != null && adv != "") {
		str = adv + str
	}
	if (operdesc != null && operdesc != "") {
		if(str.length>1){
			str = "，"+str;
		}
		str = operdesc + str
	}
	if (reason != null && reason != "") {
		if(str.length>1){
			str = "，"+str;
		}
		str = "请确认需要" + reason + str
	}
	var width = str.length * 12 + 20;
	return window
			.showModalDialog(
					"js/FnConfirm.htm",
					str,
					"dialogWidth:"
							+ width
							+ "px;dialogHeight:100px;center:yes;status:no;resizable:no;scroll:no");
}
/**
 * 固定好格式的保存信息改写
 * 
 * @param info
 *            保存信息
 */
function fn_saveInfo(info) {
	var width = info.length * 14 + 20;
	window
			.showModalDialog(
					"js/SaveInfo.htm",
					info,
					"dialogWidth:"
							+ width
							+ "px;dialogHeight:100px;center:yes;status:no;resizable:no;scroll:no");
}
/**
 * 控件专用选择日期时间的方法
 * @param tableName 控件对应表
 * @param fieldName 控件对应字段
 * @return
 */
function selectDateTime(tableName,fieldName,type,ctlName){
		if(type==null||type==""){
		   var defvalue = document.all.emreditor.GetValue("db",tableName,fieldName);
		}else{
		   var defvalue = document.all.emreditor.GetValue("ctl",ctlName,'');
		}
		var arg=null;
		if(defvalue!=null){
			arg={defvalue:defvalue};
		}
		var retval = window.showModalDialog(
				"js/selectDateTime.htm",arg,
				"dialogWidth=250px; dialogHeight=260px;status=no; directories=yes;scrollbars=no;Resizable=no");
		if (retval && retval != "undefined") {
			var s=retval.match(/[^-\s\:]/g);
			var str = s.join("");
			for(var i=str.length;i<14;i++){
				str+="0";
			}
			if(type==null||type==""){
				document.all.emreditor.SetValue("db",tableName,fieldName,str,retval);
			}else{
				document.all.emreditor.SetValue("ctl",ctlName,fieldName,str,retval);
			}
		} else {
		}
}
/**
 * 控件专用选择日期方法
 * @param tableName 控件对应表
 * @param fieldName 控件对应字段
 * @return
 */
function selectDate(tableName,fieldName,type,ctlName){
	if(type==null||type==""){
	   var defvalue = document.all.emreditor.GetValue("db",tableName,fieldName);
	}else{
	   var defvalue = document.all.emreditor.GetValue("ctl",ctlName,'');
	}
	var arg=null;
	if(defvalue!=null){
		arg.defvalue=defvalue;
	}
	var retval = window.showModalDialog(
		"js/calendar.htm",arg,
		"dialogWidth=217px;dialogHeight=220px");
	if (retval && retval != "undefined") {
		var s=retval.match(/[^-\s\:]/g);
		var str = s.join("");
		for(var i=str.length;i<8;i++){
			str+="0";
		}
		document.all.emreditor.SetValue("db",tableName,fieldName,retval);
	} 
}

/**
 * 日期年月的相加/相减
 * @param fmt
 * @return
 */
Date.prototype.Format = function(fmt){
    var o = { 
        "M+" : this.getMonth() + 1, //月份 
        "d+" : this.getDate(), 		//日 
        "h+" : this.getHours(), 	//小时 
        "m+" : this.getMinutes(), 	//分 
        "s+" : this.getSeconds(), 	//秒 
        "q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
        "S" : this.getMilliseconds()//毫秒 
    }; 
    if (/(y+)/.test(fmt)) 
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length)); 
    for (var k in o) 
        if (new RegExp("(" + k + ")").test(fmt)) 
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length))); 
    return fmt; 
}


Date.prototype.addDays = function(d){
    this.setDate(this.getDate() + d);
};

Date.prototype.addWeeks = function(w){
    this.addDays(w * 7);
};

Date.prototype.addMonths= function(m){
    var d = this.getDate();
    this.setMonth(this.getMonth() + m);
    if (this.getDate() < d)
        this.setDate(0);
};

Date.prototype.addYears = function(y){
    var m = this.getMonth();
    this.setFullYear(this.getFullYear() + y);
    if (m < this.getMonth()){
        this.setDate(0);
    }
};

function writeFile(filestr,filename){
	var fso = new ActiveXObject("Scripting.FileSystemObject"); 
	var file=fso.CreateTextFile(filename, true); 
	file.WriteLine(filestr);
	file.Close();
}
//******************************************************

var img_plus = new Image();
var img_minus = new Image();
img_plus.src = "images/nolines_plus.gif";
img_minus.src = "images/nolines_minus.gif";
function openPlus(objBody, objImg) {
	if (objBody.style.display == "block") {
		objBody.style.display = "none";
		objImg.src = img_plus.src;
	} else {
		objBody.style.display = "block";
		objImg.src = img_minus.src;
	}
}
//******************************************************
var $focusobj = null
function fcObj() {
	if ($focusobj != null && $focusobj != undefined) {
		// alert($focusobj.name);
		$focusobj.focus();
		$focusobj.focus();
	}
}
function focusObj(obj) {
	try {
		$focusobj = obj;
		// alert(obj.name);
		window.setTimeout("fcObj()", 500);
		// obj.focus();
	} catch (e) {
	}
}
//********************************************************
/**
 * 使用Ajax技术保存数据，显示数据处理过程进度框，调用保存方法
 * @param loadDo 保存数据的方法 此参数必有
 */
function showLoad(loadDo){
	if(loadDo==null||loadDo==undefined||loadDo==""){
		return;
	}
	var objS = document.getElementsByTagName("input");
	for(var i=0;objS != null && i<objS.length;i++){
		if(objS[i].type == "button"){
			objS[i].disabled = true;
		}
	}
	window.setTimeout(loadDo,1);
}
/**
 * 使用Ajax技术保存数据失败后调用的函数
 * @param error 出错信息，可选参数
 */
function errorInfo(error,flag){
	if(error==null){
		error="数据处理出错，请将输入信息另存后，重新执行操作，如果操作不能完成，请联系系统管理员!";
	}
	var arg = new Object();
	arg.error = error;
	var retval = window.showModalDialog(
			"js/doSaveInfo.htm",arg,
			"dialogWidth=300px; dialogHeight=150px;status=no; directories=yes;scrollbars=no;Resizable=no");
	var objS = document.getElementsByTagName("input");
	for(var i=0;objS != null && i<objS.length;i++){
		if(objS[i].type == "button"){
			objS[i].disabled = false;
		}
	}
}
function inpErrorInfo(error,flag){
	if(error==null){
		error="数据处理出错，请将输入信息另存后，重新执行操作，如果操作不能完成，请联系系统管理员!";
	}
	var arg = new Object();
	arg.error = error;
	var retval = window.showModalDialog(
			"js/doSaveInfo.htm",arg,
			"dialogWidth=400px; dialogHeight=200px;status=no; directories=yes;scrollbars=no;Resizable=no");
	var objS = document.getElementsByTagName("input");
	for(var i=0;objS != null && i<objS.length;i++){
		if(objS[i].type == "button"){
			objS[i].disabled = false;
		}
	}
}
function errorInfo1(error,flag){
	if(error==null){
		error="数据处理出错，请将输入信息另存后，重新执行操作，如果操作不能完成，请联系系统管理员!";
	}
	alert(error);
	var objS = document.getElementsByTagName("input");
	for(var i=0;objS != null && i<objS.length;i++){
		if(objS[i].type == "button"){
			objS[i].disabled = false;
		}
	}
}
/**
 * 使用Ajax技术保存数据成功后调用的函数
 * @param str 成功信息
 * @param fndo 保存成功后应该调用的功能
 */
function doSuccess(str,fndo){
	if(str==null){
		str="操作成功!";
	}
	var arg = new Object();
	arg.success = str;
	var retval = window.showModalDialog(
			"js/doSaveInfo.htm",arg,
			"dialogWidth=300px; dialogHeight=130px;status=no; directories=yes;scrollbars=no;Resizable=no");
	var objS = document.getElementsByTagName("input");
	for(var i=0;objS != null && i<objS.length;i++){
		if(objS[i].type == "button"){
			objS[i].disabled = false;
		}
	}
}
//移动改变上下窗体的大小；
function move(top,obj) {
	var oBox = $("box"), oBottom = $("bottom"), oLine = $("line");
	 oLine.onmousedown = function(e) {
	  var disY = (e || event).clientY;
	  oLine.top = oLine.offsetTop;
	  document.onmousemove = function(e) {
	   var iT = oLine.top + ((e || event).clientY - disY);
	   var maxT = oBox.clientHeight - oLine.offsetHeight;
	   oLine.style.margin = 0;
	   iT < 100 && (iT = 100);
	   iT > maxT && (iT = maxT);
	   oLine.style.top = oBottom.style.top = iT + "px";
	   top.style.height= iT+"px";
	   if(iT<126){
			return false;
	   }
	   var x = iT-126;
	   if(obj!=null&&iT>126){
			   obj.style.height = x+"px";
	   }
	  return false;
	  };  
	  document.onmouseup = function() {
	   document.onmousemove = null;
	   document.onmouseup = null; 
	   oLine.releaseCapture && oLine.releaseCapture();
	  };
	  oLine.setCapture && oLine.setCapture();
	  return false;
	 };
}
//显示下方
function showBottom(){
	if(document.all.bottom.style.display=="none"){
		document.all.bottom.style.display = "";
		document.all.line.style.display = "";
		document.all.top.style.height = "50%";
		document.all.bottom.style.top = "50%";
	}
}
//隐藏下方内容
function hiddenBottom(){
	document.all.bottom.style.display = "none";
	document.all.line.style.display = "none";
	document.all.top.style.height = "98%";
	document.all.bottom.style.top = "50%";
	document.all.line.style.top = "50%";
}
function $(id) {
	 return document.getElementById(id);
}
