
function prenext(i,j,k){
	a=i+j;
	b=i-k;
	
	if(i==0){
		if(a>formx.elements.length-1){a=i;}
		if(event.keyCode==39){formx.elements[a].focus();}
		if(event.keyCode==37){formx.elements[i].focus();}
	}
	else if(i==formx.elements.length-1){
		if(b<0){b=i;}
		if(event.keyCode==39){formx.elements[i].focus();}
		if(event.keyCode==37){formx.elements[b].focus();}
	}
	else{
		if(a>formx.elements.length-1){a=i;}
		if(b<0){b=i;}
		if(event.keyCode==39){formx.elements[a].focus();}
		if(event.keyCode==37){formx.elements[b].focus();}
	}

}
function dlick(obj){
        
        
	for(i=0;i<formx.elements.length;i++){
		
		if(formx.elements[i].name==obj.name)
		{return i;}
			
		}
	
	
} 
function getcurrdate(){
  today=new Date();
  lo=today.toGMTString();
  year=today.getFullYear();
  month=today.getMonth()+1;
  date=today.getDate();
  if(month<10){month="0"+month;}
  if(date<10){date="0"+date;}
  str=year+"-"+month+"-"+date;
  return str;
}
//时间比较
function comdate(time1,time2){
	if(time1>time2) return -1;
	if(time1==time2) return 0;
	if(time1<time2) return 1;
}
function StrLen(str)
        {
                var strlength=0;
                for (var i=0;i<str.length;i++)
                {
                        if(str.charCodeAt(i)>=1000)
                                strlength += 2;
                        else
                                strlength += 1;
                }
                return (strlength );
        } 
function checkChar(s,str)
{
  var n=0;
  var count=s.length;
  if(s.charAt(0)==str) return 2;
  if(s.charAt(count-1)==str) return 2;
  for(i=0;i<count;i++)
  {
    if(s.charAt(i)==str)
      n++;
  }
  return n;
}
function checkData(str,regexp)
{
  if(regexp.test(str.replace(/ /g,""))==false)
  return false;
  return true;
}
function compared(str,num,name)
{
  var strlength=StrLen(str);

  if(strlength>num)
  {
    alert("对不起，您所输入的"+name+"字数超过了系统规定的英文"+num+"个字符，中文"+num/2+"个字符的限制，请重输！");
	return false;
  }
  return true;
}
function isNumberStr (InString,RefString)          //用RefString校验InString;
	{
		if(InString.length==0)
	      return false;
		for (Count=0; Count < InString.length; Count++) 
		 {
			TempChar= InString.substring (Count, Count+1);
		   if (RefString.indexOf (TempChar, 0)==-1)  
			return (false);
          }
        return true;
        }
function checkFloat(num,mn,mx)
{
  if(!isNumberStr(num,"1234567890.")) return false;
  if(checkChar(num,".")>1) return false;
  regexp=/^0[0-9]+/;
  if(checkData(num,regexp)) return false;
  regexp=/[\.][0-9]{2,}$/;
  if(checkData(num,regexp)) return false;
  if(parseFloat(num)<mn||parseFloat(num)>mx) return false;
  return true;
}
function checkFloat(num,mn,mx)
{
  if(!isNumberStr(num,"1234567890.")) return false;
  if(checkChar(num,".")>1) return false;
  regexp=/^0[0-9]+/;
  if(checkData(num,regexp)) return false;
  regexp=/[\.][0-9]{2,}$/;
  if(checkData(num,regexp)) return false;
  if(parseFloat(num)<mn||parseFloat(num)>mx) return false;
  return true;
}
function checkFloatxxx(num,mn,mx)
{
  if(!isNumberStr(num,"1234567890.")) return false;
  if(checkChar(num,".")>1) return false;
  regexp=/^0[0-9]+/;
  if(checkData(num,regexp)) return false;
  regexp=/[\.][0-9]{3,}$/;
  if(checkData(num,regexp)) return false;
  if(parseFloat(num)<mn||parseFloat(num)>mx) return false;
  return true;
}
function checkFloatxx(num,mn,mx)
{
  if(!isNumberStr(num,"1234567890.")) return false;
  if(checkChar(num,".")>1) return false;
  regexp=/^0[0-9]+/;
  if(checkData(num,regexp)) return false;
  regexp=/[\.][0-9]{5,}$/;
  if(checkData(num,regexp)) return false;
  if(parseFloat(num)<mn||parseFloat(num)>mx) return false;
  return true;
}
function checkFloat1(num)
{
  if(!isNumberStr(num,"1234567890.")) return false;
  if(checkChar(num,".")>1) return false;
  regexp=/^0[0-9]+/;
  if(checkData(num,regexp)) return false;
  return true;
}
function checkMoney(money)
{
  if(!isNumberStr(money,"1234567890.")) return false;
  if(checkChar(money,".")>1) return false;
  regexp=/^0[0-9]+/;
  if(checkData(money,regexp)) return false;
  regexp=/[\.][0-9]{3,}$/;
  if(checkData(money,regexp)) return false;
  return true;
}
function checkInteger(num,mn,mx)
{
  if(!isNumberStr(num,"1234567890")) return false;
  regexp=/^0[0-9]+/;
  if(checkData(num,regexp)) return false;
  if(parseInt(num)<mn||parseInt(num)>mx) return false;
  return true;
}
function checkIntegerall(num)
{
  if(!isNumberStr(num,"1234567890")) return false;
  regexp=/^0[0-9]+/;
  if(checkData(num,regexp)) return false;
  return true;
}
function checknumxx(num,mn,mx)
{
  if(!isNumberStr(num,"1234567890")) return false;
  regexp=/^[0-9]{1,2}$/;
  if(!checkData(num,regexp)) return false;
  if(parseInt(num)<mn||parseInt(num)>mx) return false;
  return true;
}
function checknumx(num,mn,mx)
{
  if(!isNumberStr(num,"1234567890")) return false;
  regexp=/^[0-9]{2}$/;
  if(!checkData(num,regexp)) return false;
  if(parseInt(num)<mn||parseInt(num)>mx) return false;
  return true;
}
function isNumstring(text)
{
  count=text.length;
  judge=false;
  for(i=0;i<count;i++)
  {
    if((text.charAt(i)<"0")||(text.charAt(i)>"9"))
    {
      judge=true;
       break;
    }
  }
  if(judge)
    return false;

    return true;
}
function isnull(c)
{
	if (c=="")
		return true;
	else
		return false;
}
function isletter(c)
{
	count=c.length;
	for(i=0;i<count;i++)
	{
	  if ((c.charAt(i)<"a") || (c.charAt(i)>"z"))
	  return false;
	}
	return true;  
}
function checkchar(s)
{         
	 invalidchar=new Array("\'","\"","\t","&","<",">","+","(",")","\\","%","\255","@","#","^","|","{","}","[","]","“","”","‘","’","；","：",":",";","，","。","?","？","/","、","—","=","——","）","（","…","￥","·","！","~","`","*","-","《","》","〈","〉","1","2","3","4","5","6","7","8","9","0",".");
	 t="";
	for (i=0; i<s.length; i++)
	{
		n = s.substring(i, i+1);
		for(j=0;j<invalidchar.length;j++)
		{
			if (n==invalidchar[j])
			{
			 t+=n;
			}
		}
				
	}
	if(t!="") {alert(t+"是非法字符！");	return false;}
	 
	return true;
}
/*病人ID的校验*/
function checkSickID(sickID)
{
  if(sickID.value=="")
  {
    alert("请输入病人ID号！");
	sickID.select();
    sickID.focus();
    return false;
  }
  if(!isNumberStr(sickID.value,"1234567890-"))
  {
   alert("病人ID号"+sickID.value+"不正确，请重新输入！");
   sickID.select();
   sickID.focus();
   return false;
  }
  if(sickID.value.indexOf(" ")!=-1){
  	alert("病人ID号"+sickID.value+"有空格，请重新输入！");
  	sickID.select();
  	sickID.focus();
   	return false;
  }
  if(sickID.value.length>20)
  {
    alert("输入的病人ID号超过系统规定的20位，请重输！");
	sickID.select();
	sickID.focus();
   return false;
  }
 return true;
}
/*姓名的校验*/
function checkName(name)
{
  
  if(name.value=="")
  {
    alert("请输入病人的姓名！");
    name.select();
	name.focus();
    return false;
  }
    if(!checkchar(name.value)) 
    {
      alert("请重新输入病人的姓名！");
      name.select();
	  name.focus();
      return false;}
    if(!compared(name.value,30,"病人姓名"))
	{
	  name.select();
	  name.focus();
	  return false;
	}  
 return true;
 }

 
/*拼音码的校验*/
function checkNameSpell(nameSpell)
{
  if(!isletter(nameSpell.value))  
  {
   alert("请输入正确的拼音码!");
   nameSpell.select();
   nameSpell.focus();
   return false;	
  }
  if(!compared(nameSpell.value,8,"拼音码"))
  {
    nameSpell.select();
	nameSpell.focus();
	return false;
  }
  return true;               
}
/*性别的校验*/
function checkSex(sex)
{
  if(sex.value=="")            
  {
   alert("请选择病人的性别！");
   sex.focus();
   return false;	
  }
  return true;
}
function checkBirthday(birthday)
{
  if(birthday.value=="")
  { 
   alert("请选择病人的出生日期！");
   return false;
  }
  
  return true;
}
/*身高的校验*/
function checkHeight(height)
{
  if(isnull(height.value))
   return true;
  if(!checkInteger(height.value,1,300))
       {
        alert("身高"+height.value+"不正确，请重输(请输入1-300之间的整数)！");
        height.select();
		height.focus();
        return false;
       }
  return true;
}

/*体重的校验*/
function checkWeight(weight)
{
  if(isnull(weight.value))
   return true;
  if(!checkFloatxxx(weight.value,1,400))
       {alert("体重"+weight.value+"不正确，请重输(请输入1-400之间的数,精确到小数点后两位)！");
        weight.select();
		weight.focus();
        return false;
       }
 return true;
}
/*国籍的校验*/
function checkCountry(country)
{
   if(country.value=="")            
  {
   alert("请选择病人的国籍！");
   country.focus();
   return false;	
  }
  return true;
}
/*籍贯的校验*/
function checkNativePlace(nativePlace)
{
  if(nativePlace.value=="")            
  {
   alert("请输入病人的籍贯！");
   nativePlace.select();
   nativePlace.focus();
   return false;	
  }
  if(!compared(nativePlace.value,40,"籍贯"))
  {
    nativePlace.select();
	nativePlace.focus();
	return false;
  }
 return true;
}
/*民族的校验*/
function checkNation(nation)
{
  if(nation.value=="")          
  {
   alert("请选择病人的民族！");
   nation.focus();
   return false;	
  }
  
   return true;
}
/*职业的校验*/
function checkJob(job)
{
  if(job.value=="")            
  {
   alert("请选择病人的职业！");
   job.focus();
   return false;	
  }
  return true;
}
/*证件类型的校验*/
function checkPaperType(paperType)
{
  if(paperType.value=="")            
  {
   alert("请选择病人的证件类型！");
   paperType.focus();
   return false;	
  }
  return true;
}
/*证件号的校验*/
function checkPaperNum(paperNum)
{
  if(!isnull(paperNum.value)){
  
    regexp=/^[0-9,x]{1,20}$/i;
    if(!checkData(paperNum.value,regexp))
    {
      alert("输入的证件号"+paperNum.value+"不正确，请重输(不超过20位的数字)！");
	paperNum.select();
	paperNum.focus();
	return false;
    }
  }
  return true;
}

/*计费类型的校验*/
function checkFeeType(feeType)
{
  if(feeType.value=="")            
  {
   alert("请选择计费类型！");
   feeType.focus();
   return false;	
  }
  return true;
}
/*邮编的校验*/
function checkPostZip(postZip,num)
{
  regexp=/^[0-9]{6}$/;
  if(postZip.value=="")
    return true;
   if(!checkData(postZip.value,regexp))
      {alert("邮编"+postZip.value+"不正确，请重新输入！");
       postZip.select();
	   postZip.focus();
       return false;
      }
   
  return true;  
}
function checkPhone(phone)
{
  
  if(phone.value=="")
  return true;
  if( phone.value.length<7 || isNumberStr(phone.value,"1234567890-()（）")!=1) 
    {
 	  alert("电话号码"+phone.value+"不正确，请重输(区号和分机号用\"-\"或\"( )\"隔开)!");
	  phone.select();
	  phone.focus();
	  return false;
	}
  if(!compared(phone.value,25,"电话号码"))
  {
    phone.select();
	phone.focus();
	return false;
  }	
  return true;	
  }
function checkSickID1(sickID)
{
  if(isnull(sickID.value)) return true;
  if(!isNumberStr(sickID.value,"1234567890-"))
  {
   alert("病人ID号"+sickID.value+"不正确，请重新输入！")
   sickID.select();
   sickID.focus();
   return false;
  }
  if(!compared(sickID.value,20,"病人ID号"))
  {
   sickID.select();
   sickID.focus();
   return false;
  }
 return true;
}
/*姓名的校验*/
function checkName1(name)
{
    if(!checkchar(name.value)) 
    {
      alert("请重输病人姓名！");
      name.select();
	  name.focus();
      return false;}
	if(!compared(name.value,30,"病人姓名"))
    {  
	  name.select();    
	  name.focus();
      return false;
    }
  return true;
}
/*医保号的校验*/
function checkMcNum(mcNum)
{
  
  if(!isNumstring(mcNum.value))
  {
    alert("医保号输入不正确，请重新输入！");
    mcNum.select();
	mcNum.focus();
    return false;
  }
  if(!compared(mcNum.value,32,"医保号"))
  {
    mcNum.select();
	mcNum.focus();
	return false;
  }
  return true;
}
