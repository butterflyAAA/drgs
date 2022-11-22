//角度变弧度函数
var pi = Math.PI;
function degToRad(x) {
	return ( x/(360/(2*pi)) ); 
}
function radToDeg(x) {
	return ( x*(360/(2*pi)) ); 
}

var Class = {
  create: function() {
    return function() {
      this.initialize.apply(this, arguments);
    };
  }
};
function $(objId){
	if(typeof(objId)== "string"){
		return document.getElementById(objId);
	}
	else{
		return objId;
	}
}
var DashBoard = Class.create();
DashBoard.prototype={
	text:"",
	accuracy:3,
	scaleMin:0,
	interval:1,
	bgRed:9,
	initialize:function(initObj){
		this.id=initObj.id;
		this.text=initObj.text;
		this.container=$(initObj.container);
		this.scaleMin=initObj.scaleMin;
		this.interval = initObj.interval;
		this.bgRed = initObj.bgRed;
		this.accuracy=initObj.accuracy?initObj.accuracy:this.accuracy;
		this.buildDashBoard();
	},
	buildDashBoard:function(){
		this.bgDiv = document.createElement("div");
		this.bgDiv.className="point_bg";
		this.pointDiv=document.createElement("div");
		this.pointDiv.className="point";
		this.bgDiv.appendChild(this.pointDiv);
		for(var i=0;i<9;i++){
			var div2 = document.createElement("div");
			div2.className="point_scale"+(i*30);
			this.scaleMax=this.scaleMin+i*this.interval;
			div2.innerText=this.scaleMax;
			this.bgDiv.appendChild(div2);
		}
		var div3 = document.createElement("div");
		div3.className="point_title";
		div3.innerText=this.text;
		this.bgDiv.appendChild(div3);
		this.container.appendChild(this.bgDiv);
		var img = document.createElement("img");
		img.src="images/point/pointer_0.png";
		this.pointDiv.appendChild(img);
		this.pointImg = img;
	},
	setPoint:function(pt){
		if(this.bgRed&&pt>=this.bgRed){
			this.bgDiv.className="point_bgred";
		}
		else{
			this.bgDiv.className="point_bg";
		}
		if(pt>this.scaleMax){
			pt=this.scaleMax;
		}
		if(pt<this.scaleMin){
			pt=this.scaleMin;
		}
		var num = (pt-this.scaleMin)/((this.scaleMax-this.scaleMin)/240);
		num=num/this.accuracy;
		num = Math.round(num);
		
		num=num*this.accuracy;
		this.pointImg.src='images/point/pointer_'+num+'.png';
		
		/*
		//将角度转变成弧度
		var rad = degToRad(num);
		//计算弧度的cos和sin值
		costheta = Math.cos(rad);
		sintheta = Math.sin(rad);
		var el = this.pointDiv;
		if(el) {
		  //应用滤镜
		  el.style.filter = "progid:DXImageTransform.Microsoft.Matrix()";
		  
		  //设置滤镜的属性值
		  el.filters.item("DXImageTransform.Microsoft.Matrix").SizingMethod = "clip to original";
		  //el.filters.item("DXImageTransform.Microsoft.Matrix").FilterType = "nearest neighbor";

		  //运用旋转滤镜
		  el.filters.item("DXImageTransform.Microsoft.Matrix").M11 = costheta;
		  el.filters.item("DXImageTransform.Microsoft.Matrix").M12 = -sintheta;
		  el.filters.item("DXImageTransform.Microsoft.Matrix").M21 = sintheta;
		  el.filters.item("DXImageTransform.Microsoft.Matrix").M22 = costheta;
		  el.filters.item("DXImageTransform.Microsoft.Matrix").Dx=95-(95*costheta-95*sintheta);
		  el.filters.item("DXImageTransform.Microsoft.Matrix").Dy=-(95*sintheta+95*costheta-95);
		}
		*/
	}
}