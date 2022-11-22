function getTreeViewRoots() {
	var roots = new Array();
	var elements = document.getElementsByTagName("DIV");
	for (var i = 0;i < elements.length; i++) {
		var element = elements[i];
		if (element.className == "treeview") {
			roots.push(element);
		}
	}
	return roots;
}
function initializeTreeView() {
	// alert("1");
	var roots = getTreeViewRoots();
	for (var i = 0;i < roots.length; i++) {
		var root = roots[i];
		initializeTreeNodes(root);
	}
}
function initializeTreeNodes(parentNode, level) {
	for (var i = 0;i < parentNode.children.length; i++) {
		var node = parentNode.children[i];
		if (node.tagName == "P") {
			var content = node.nextSibling;
			if (node.className == "node-collapse") {
				content.style.display = "none";
			}
			node.onclick = function() {
				if(window.event.srcElement&&window.event.srcElement.className=='newimg'){
					alert();
				  return false;
				}
				else {
	  				if (this.className == "node-expand") {
	  					this.nextSibling.style.display = "none";
	  					this.className = "node-collapse";
	  				} else {
	  					this.nextSibling.style.display = "";
	  					this.className = "node-expand";
	  				}
				}
			}
			initializeTreeNodes(content);
		}
		else if (node.tagName == "A" && node.onclick == null) {
			node.href = "javascript:void(0);";
			node.onclick = function() {
				fn(this.id, this.innerHTML);
			}
		}
	}
}