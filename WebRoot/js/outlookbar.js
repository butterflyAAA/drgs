function showitem(id, name) {
	return ("<div class='tree_itemline'><a href='javascript:void(0);' onclick=\""
			+ id + "\">" + name + "</a></div>")
}
function switchoutlookBar(number) {
	//已打开
	var i = outlookbar.opentitle;
	//即将打开
	outlookbar.opentitle = number;
	var id1, id2, id1b, id2b,fun1,fun2;
	if (number != i && outlooksmoothstat == 0) {
		if (number != -1) {
			if (i == -1) {
				id2 = "blankdiv";
				id2b = "blankdiv";
			} else {
				id2 = "outlookdiv" + i;
				id2b = "outlookdivin" + i;
				document.all("outlooktitle" + i).className = outlookbar.maincolor;
				document.all("outlooktitle" + i).style.textalign = "left";
			}
			fun1 = "fun"+number;
			fun2 = "fun"+i;
			document.getElementById(fun1).src='images/fun_open.png';
			document.getElementById(fun2).src='images/fun_close.png';
			id1 = "outlookdiv" + number;
			id1b = "outlookdivin" + number;
			document.all("outlooktitle" + number).className = outlookbar.maincolor;
			document.all("outlooktitle" + number).style.textalign = "left";
			smoothout(id1, id2, id1b, id2b, 0);
		} else {
			document.all("blankdiv").style.display = "";
			document.all("blankdiv").style.height = "100%";
			document.all("outlookdiv" + i).style.display = "none";
			document.all("outlookdiv" + i).style.height = "0%";
			document.all("outlooktitle" + i).style.className = outlookbar.maincolor;
			document.all("outlooktitle" + i).style.textalign = "left";
		}
	}
}
function smoothout(id1, id2, id1b, id2b, stat) {
	if (stat == 0) {
		tempinnertext1 = document.all(id1b).innerHTML;
		tempinnertext2 = document.all(id2b).innerHTML;
		document.all(id1b).innerHTML = "";
		document.all(id2b).innerHTML = "";
		outlooksmoothstat = 1;
		document.all(id1b).style.overflow = "hidden";
		document.all(id2b).style.overflow = "hidden";
		document.all(id1).style.height = "0%";
		document.all(id1).style.display = "";
		setTimeout("smoothout('" + id1 + "','" + id2 + "','" + id1b + "','"
						+ id2b + "'," + outlookbar.inc + ")",
				outlookbar.timedalay);
	} else {
		stat += outlookbar.inc;
		if (stat > 100)
			stat = 100;
		document.all(id1).style.height = stat + "%";
		document.all(id2).style.height = (100 - stat) + "%";
		if (stat < 100)
			setTimeout("smoothout('" + id1 + "','" + id2 + "','" + id1b + "','"
							+ id2b + "'," + stat + ")", outlookbar.timedalay);
		else {
			document.all(id1b).innerHTML = tempinnertext1;
			document.all(id2b).innerHTML = tempinnertext2;
			outlooksmoothstat = 0;
			document.all(id1b).style.overflow = "auto";
			document.all(id2).style.display = "none";
		}
	}
}
function getOutLine() {
	outline = "<table " + outlookbar.otherclass + ">";
	for (var i = 0; i < (outlookbar.titlelist.length); i++) {
		outline += "<tr><td name=outlooktitle" + i + " id=outlooktitle" + i
				+ " ";
		if (i != outlookbar.opentitle)
			outline += " nowrap align=left class='"
					+ outlookbar.maincolor
					+ "' style='cursor:hand;padding:5 5 2 5 ' ";
		else
			outline += " nowrap align=left class='"
					+ outlookbar.maincolor
					+ "' style='cursor:hand;padding:5 5 2 5 ' ";
		// outline+=outlookbar.titlelist[i].otherclass
		outline += " onClick='switchoutlookBar(" + i
				+ ")'><img src='images/alpha.gif' class='tree_title'>";
		outline += outlookbar.titlelist[i].title + "</td>";
		outline +="<td name=img" + i + " id=img" + i
				+ " ";
		if (i != outlookbar.opentitle)
			outline += " nowrap align=right class='"
					+ outlookbar.maincolor
					+ "' style='cursor:hand;padding:5 5 2 5 '";
		else
			outline += " nowrap align=right class='"
					+ outlookbar.maincolor
					+ "' style='cursor:hand;padding:5 5 2 5 ' ";
		outline += " onClick='switchoutlookBar(" + i+ ")'>";
		if (i != outlookbar.opentitle){
			outline += "<img name=fun" + i + " id=fun" + i +" src='images/fun_close.png'>";
		}else{
			outline += "<img name=fun" + i + " id=fun" + i +" src='images/fun_open.png' >";
		}
		outline += "</td></tr>";
		outline += "<tr><td name=outlookdiv"
				+ i
				+ " valign=top align=left id=outlookdiv"
				+ i
				+ " class='tree_itembg' colspan = '2' style='width:100% ";
		if (i != outlookbar.opentitle)
			outline += ";display:none;height:0%;";
		else
			outline += ";display:;height:100%;";
		outline += "'><div name=outlookdivin" + i + " id=outlookdivin" + i
				+ " style='overflow:auto;width:100%;height:100%;'>";
		for (var j = 0; j < outlookbar.itemlist[i].length; j++)
			outline += showitem(outlookbar.itemlist[i][j].key,
					outlookbar.itemlist[i][j].title);
		outline += "</div></td></tr>";
	}
	outline += "</table>";
	return outline;
}
function show() {
	var outline;
	outline = "<div id=outLookBarDiv name=outLookBarDiv style='width=100%;height:100%'>";
	outline += outlookbar.getOutLine();
	outline += "</div>";
	document.write(outline);
}
function theitem(intitle, instate, inkey) {
	this.state = instate;
	this.otherclass = " nowrap ";
	this.key = inkey;
	this.title = intitle;
}
function addtitle(intitle) {
	outlookbar.itemlist[outlookbar.titlelist.length] = new Array();
	outlookbar.titlelist[outlookbar.titlelist.length] = new theitem(intitle, 1,
			0);
	return (outlookbar.titlelist.length - 1);
}
function additem(intitle, parentid, inkey) {
	if (parentid >= 0 && parentid <= outlookbar.titlelist.length) {
		outlookbar.itemlist[parentid][outlookbar.itemlist[parentid].length] = new theitem(
				intitle, 2, inkey);
		outlookbar.itemlist[parentid][outlookbar.itemlist[parentid].length - 1].otherclass = " nowrap align=left style='height:5' ";
		return (outlookbar.itemlist[parentid].length - 1);
	} else
		additem = -1 ;
}
function outlook() {
	this.titlelist = new Array();
	this.itemlist = new Array();
	this.divstyle = "style='height:100%;width:100%;overflow:auto' align=left";
	this.otherclass = "border=0 cellspacing='0' cellpadding='0' style='height:100%;width:100%'valign=middle align=left ";
	this.addtitle = addtitle;
	this.additem = additem;
	this.starttitle = -1;
	this.show = show;
	this.getOutLine = getOutLine;
	this.opentitle = this.starttitle;
	this.reflesh = outreflesh;
	this.timedelay = 50;
	this.inc = 10;
	// this.maincolor = "#336699";
	this.maincolor = "tree_bg1";
}
function outreflesh() {
	document.all("outLookBarDiv").innerHTML = outlookbar.getOutLine();
}
function locatefold(foldname) {
	if (foldname == "" && outlookbar.titlelist.length>0)
		foldname = outlookbar.titlelist[0].title;
	for (var i = 0; i < outlookbar.titlelist.length; i++) {
		if (foldname == outlookbar.titlelist[i].title) {
			outlookbar.starttitle = i;
			outlookbar.opentitle = i;
		}
	}
}