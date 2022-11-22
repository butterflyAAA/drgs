Haitai = {
	openFitScreen : function(url, name) {
		var width = screen.availWidth - 10;
		var height = screen.availHeight - 33;
		var params = "left=0,top=0,width=" + width + ",height=" + height
				+ ",status=no,toolbar=no,menubar=no,location=no";
		var w = window.open(url, name, params);
		if (w) {
			w.focus();
		}
	},
	isSuccessful : function(p) {
		if (!p || p.indexOf("Exception: ") == -1) {
			return true;
		}
	},
	renderTree : function(obj) {
		obj.className = "ht-tree";
		var elements = obj.getElementsByTagName("DIV");
		for (var i = 0; i < elements.length; i++) {
			var element = elements[i];
			if (element.className != "ht-tree-node-collapse") {
				element.className = "ht-tree-node-expand";
			}
		}
		elements = obj.getElementsByTagName("P");
		for (var i = 0; i < elements.length; i++) {
			var element = elements[i];
			element.onclick = function() {
				var node = this.parentNode;
				if (node.className == "ht-tree-node-expand") {
					node.className = "ht-tree-node-collapse";
				} else {
					node.className = "ht-tree-node-expand";
				}
			};
		}
		var elements = obj.getElementsByTagName("LI");
		for (var i = 0; i < elements.length; i++) {
			var element = elements[i];
			element.onmouseover = function() {
				this.className = "ht-tree-node-hover";
			};
			element.onmouseout = function() {
				this.className = "ht-tree-node-normal";
			};
		}
	}
};

Haitai.Ajax = {
	loadingIndicator : "<div class='ht-ajax-loading'>加载中...</div>",
	request : function(o) {
		var xh;
		var activeXs = ["MSXML2.XMLHttp.5.0", "MSXML2.XMLHttp.4.0",
				"MSXML2.XMLHttp.3.0", "MSXML2.XMLHttp", "Microsoft.XMLHttp"];
		for (var i = 0; i < activeXs.length; i++) {
			try {
				var activeX = activeXs[i];
				xh = new ActiveXObject(activeX);
				break;
			} catch (e) {
			}
		}
		if (!xh) {
			xh = new XMLHttpRequest();
		}
		var url = o.url ? o.url : o.form.action;
		var params = new Array();
		if (o.params) {
			for (var key in o.params) {
				params.push(encodeURIComponent(key) + "="
						+ encodeURIComponent(o.params[key]));
			}
		}
		if (o.form) {
			for (var i = 0; i < o.form.length; i++) {
				var el = o.form[i];
				if (el.disabled || !el.name) {
					continue;
				}
				if ((el.type == "button")
						|| ((el.type == "checkbox" || el.type == "radio") && !el.checked)
						|| (el.type == "select-one" && el.length == 0)) {
					continue;
				}
				if (el.type == "select-multiple") {
					for (var j = 0; j < el.length; j++) {
						if (!el[j].selected) {
							continue;
						}
						params.push(encodeURIComponent(el.name) + "="
								+ encodeURIComponent(el[j].value));
					}
					continue;
				}
				params.push(encodeURIComponent(el.name) + "="
						+ encodeURIComponent(el.value));
			}
		}
		var parameterStr = params.join("&");
		if (o.callback) {
			xh.open("POST", url, true);
			xh.onreadystatechange = function() {
				if (xh.readyState == 4) {
					if (o.isXML) {
						o.callback(xh.responseXML);
					} else {
						o.callback(xh.responseText);
					}
				}
			};
			xh.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;");
			xh.send(parameterStr);
			return Haitai.Ajax.loadingIndicator;
		} else {
			xh.open("POST", url, false);
			xh.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;");
			xh.send(parameterStr);
			if (o.isXML) {
				return xh.responseXML;
			} else {
				return xh.responseText;
			}
		}
	}
};
/*jjliu grid*/
function autoResize(){
	var tables = document.getElementsByTagName("table");
	for(var i=0;tables&&i<tables.length;i++){
		if(tables[i].className=="main_talbe"){
			var eastlistdiv = null;
			var tbodytable=null;
			var thtable=null;
			var eastdiv=null;
			var tbodydiv=null;
			var arr = tables[i].getElementsByTagName("table");
			for(var j=0;arr&&j<arr.length;j++){
				if(arr[j].className=="tbody_table"){
					tbodytable=arr[j];
				}
				else if(arr[j].className=="th_table"){
					thtable=arr[j];
				}
				if(tbodytable&&tbodytable){
					break;
				}
			}
			arr = tables[i].getElementsByTagName("div");
			for(var j=0;arr&&j<arr.length;j++){
				if(arr[j].className=="east_list_div"){
					eastlistdiv=arr[j];
				}
				else if(arr[j].className=="east_div"){
					eastdiv=arr[j];
				}
				else if(arr[j].className=="tbody_div"){
					tbodydiv=arr[j];
				}
				if(eastdiv&&tbodydiv&&eastlistdiv){
					break;
				}
			}
			if(eastlistdiv&&tbodydiv&&eastdiv&&tbodytable&&thtable){
				eastlistdiv.style.height = tbodytable.offsetHeight+thtable.offsetHeight;
				eastdiv.onscroll=function(){
				  tbodydiv.scrollTop = eastdiv.scrollTop;
				};
			}
		}
	}
}
if (document.all && window.print) {
	document.oncontextmenu = function stop(){

		return false;

		};
}