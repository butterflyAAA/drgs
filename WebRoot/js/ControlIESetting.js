var $pasteObj = null;
var $ctrlcflag=false;
$isCircumgyrate = false;
$isUpDown = false;
$enterKey = true;
// 屏蔽Ctrl+N,屏蔽系统中使用Ctrl+C和Ctrl+V拷贝他人系统内容
window.ClearKey = function() {
	try {
		event.cancelBubble = false;
		var iKeyCode = event.keyCode;
		if (iKeyCode == 8) {
			if (window.event.srcElement != null
					&& (window.event.srcElement.tagName.toLowerCase() == "textarea" 
						|| (window.event.srcElement.tagName.toLowerCase() == "input" 
							&& (window.event.srcElement.type == "text" 
								|| window.event.srcElement.type == "file")))) {

			} else {
				event.keyCode = 0;
				return;
			}
		}
		if (iKeyCode == 13 && $enterKey) {
			if (window.event.srcElement.type.toLowerCase() != "button"
					&& window.event.srcElement.type.toLowerCase() != "image"
					&& window.event.srcElement.tagName.toLowerCase() != "button"
					&& window.event.srcElement.tagName.toLowerCase() != "textarea"
					&& window.event.srcElement.tagName.toLowerCase() != "img") {
				window.event.keyCode = 9;
			}
		}
		if(event.ctrlKey && iKeyCode == 67){
			$ctrlcflag=true;
		}
		if (iKeyCode == 86 && event.ctrlKey) {
			fn_ctrlV();
		}
		if (iKeyCode == 45 && event.shiftKey){
			fn_ctrlV();
		}
		if ($isUpDown&&iKeyCode == 40){
			event.keyCode = 9;
			return;
		}
		if ($isUpDown&&iKeyCode == 38){
			SendKeyBoards("+{TAB}");
		}
	} catch (e) {
		event.keyCode = 0;
	}

	if (iKeyCode==78 && event.ctrlKey){ //Ctrl+N
		return false;
	}
	if(!$enterKey){
		return false;
	}
	return true;
}
with (window.document) {
	onkeydown = window.ClearKey;
	onkeyup = function() {
		if ($ctrlcflag) { // Ctrl+C
			try {
				fn_ctrlC();
				$ctrlcflag=false;
				window.clipboardData.clearData("text");
				return false;
			} catch (e) {
			}
			window.clipboardData.clearData("text");
		}
		window.clipboardData.clearData("text");
		$enterKey = true;
	}
	onbeforedeactivate = function() {
		try {
			window.clipboardData.clearData("text");
			if (activeElement != null
					&& activeElement != undefined
					&& activeElement.tagName != null
					&& (activeElement.tagName.toLowerCase() == "textarea" || (activeElement.tagName
							.toLowerCase() == "input" && activeElement.type == "text"))) {
				$pasteObj = activeElement;
			}
		} catch (e) {
			event.keyCode = 0;
		}
	}
}
function fn_ctrlV() { // Ctrl+V
	if ($pasteObj != null) {
		if (document.activeElement.tagName.toLowerCase() == "textarea"
				|| (document.activeElement.tagName.toLowerCase() == "input" && document.activeElement.type
						.toLowerCase() == "text")) {
		} else {
			$pasteObj.focus();
		}
	}
	var oBao = new ActiveXObject("Microsoft.XMLHTTP");
	// var KeyMrid = document.all.copyContentKeyMrid;
	oBao.open("POST", "CtrlVProcess.jsp", false);
	oBao.setrequestheader("content-type", "application/x-www-form-urlencoded");
	oBao.send();
	var tt = unescape(oBao.responseText);
	if (tt == "CTRL+V") {
		alert("系统中不允许从其他病人或从外部拷贝资料进入系统！ 请确认！");
	} else {
		window.clipboardData.setData("text", tt);
		try {
			if (document.all.emreditor) {
				document.all.emreditor.HandlePaste();
			}
		} catch (e) {
		}
	}
}
function fn_ctrlC() {
	var oBao = new ActiveXObject("Microsoft.XMLHTTP");
	oBao.open("POST", "CtrlCProcess.jsp", false);
	oBao.setrequestheader("content-type", "application/x-www-form-urlencoded");
	var tSelectText = "";
	try {
		tSelectText = window.clipboardData.getData("text");
		window.clipboardData.clearData("text");
		try {
			if (document.all.emreditor) {
				document.all.emreditor.HandleCopy();
			}
		} catch (e) {
		}
		if (tSelectText == null) {
			tSelectText = window.clipboardData.getData("text");
		} else {
			if (window.clipboardData.getData("text") != null) {
				tSelectText = window.clipboardData.getData("text");
			}
		}
		// alert(tSelectText);
		// t = document.selection.createRange();// 获取选择区域对象
		// tSelectText = t.text;// 获取当前文本
		if (tSelectText == null) {
			tSelectText = "";
		}
	} catch (e) {
		tSelectText = "";
	}
	// 发送数据到后台
	oBao.send(escape(tSelectText));
	window.clipboardData.clearData("text");
}
/*
 * 模拟发出键盘事件 调用此函数可以发出任意键盘按键的组合，函数参数是需要发出的键盘值，包括： a－z，A－Z，0－9，{F1}-{F12},
 * {BACKSPACE},{CAPSLOCK},{DELETE},{END},{ENTER},{ESC},
 * {HELP},{HOME},{INSERT},{LEFT},{NUMLOCK},{PGDN},{PGUP},{PRTSC},{RIGHT}
 * {SCROLLLOCK},{TAB},{UP} 如果想发出多个键盘消息就用（），例如想发出“admin”就是（admin）。
 * 如果想加上Ctrl、Shift、Alt，就在键盘值前分别加^、+、%，
 * 例如Alt＋S就是%(S),Shift+Tab就是＋{TAB},Ctrl+V是^(V)
 */
function SendKeyBoards(keystr) {
	var WshShell = new ActiveXObject("WScript.Shell");
	WshShell.SendKeys(keystr);
	WshShell = null;
}

function OnKeyDownEnter(){
	if(event.keyCode == 13){
		$enterKey = false;
		return false;
	}
}
