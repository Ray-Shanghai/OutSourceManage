var base ={};
base.serverContent = "/OutSourceManage";
base.serverContet = "/OutSourceManage";
base.pageSize =10;
/**
 * 错误信息验证提醒
 */
base.failAlert = function(data){
	if(data.code=="500"){
		//var channel=window.localStorage.getItem("channel");
		//window.localStorage.removeItem("channel");
		//if(channel=="qq"){
		//	window.location.href= wxBase.loginUrlNoWx;
		//}else{
		//	window.location.href= wxBase.loginUrl;
		//}
	}else{
		alert(data.msg);
	}
};

function isShow(functionId,columns,loadGrid){
	
	$.ajax({
		url:base.serverContent+'/manager/loginIn/functionModuleRule/queryModuleRuleList.do?functionId='+functionId,
		type:'get',
		async:true,
		success:function(data){
			$.each(data.searchList,function(index,tag){
				$("#"+this.moduleFromDataName).show();
			});
			
			$.each(data.colList,function(index,tag){
				$.each(columns,function(index,tag2){
					if(tag.moduleFromDataName==tag2.dataIndex){
						tag2.visible=true;
						if(tag.isOrder=="0"){
							tag2.sortable=true;
							tag2.handler=function(){
							};
						}
					}
				});
			});
			
			
			$("#search").show();
			loadGrid();
			$.each(data.buttonList,function(index,tag){
				$("#"+this.moduleFromDataName).show();
			});
		},error:function(data){
			
		}
	});
	return true;
}
//登录超时，打开登录页面
var loginOut = function(obj){
  window.location.href=base.serverContent+"/login.html";
};

  base.alertTip = function(data){
	 
	
	
	layui.config({base : base.serverContent+'/backstage/js/'});
	layui.use([ 'paging', 'form', 'element' ],function() {
	 var $ = layui.jquery;
	layer.alert(data.msg,{icon : 3,yes:function(){
		if(data.code=="111"){
			
			window.location.href=base.serverContent+'/login.html';
		}else if(data.code=="222"){
			window.location.href=base.serverContent+'/wxManagerPc/login.html';
		}else if(data.code=="333"){
			window.location.href=base.serverContent+'/wxManagerWx/login.html';
		}
		
	}});});
	
	
 
};

  






base.isNotBlank = function(data){
	if(data!=undefined && data!=null && data!=""&&data!="null"){
		return true;
	}
 return false;
};
	//layui渲染
function renderForm(tag){
	layui.use(['form'],function(){
		if(tag==null){layui.form().render();}else{layui.form().render(tag);}
	});
}

//两个数字求和
function numSub(num1, num2) { 
	var baseNum, baseNum1, baseNum2; 
	var precision;// 精度
	try { 
	baseNum1 = num1.toString().split(".")[1].length; 
	} catch (e) { 
	baseNum1 = 0; 
	} 
	try { 
	baseNum2 = num2.toString().split(".")[1].length; 
	} catch (e) { 
	baseNum2 = 0; 
	} 
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2)); 
	precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2; 
	return ((num1 * baseNum + num2 * baseNum) / baseNum).toFixed(precision); 
}; 
//俩个数之差 NUM1 较大  NUM2 较小
function numDif(num1, num2) { 
	var baseNum, baseNum1, baseNum2; 
	var precision;// 精度
	try { 
	baseNum1 = num1.toString().split(".")[1].length; 
	} catch (e) { 
	baseNum1 = 0; 
	} 
	try { 
	baseNum2 = num2.toString().split(".")[1].length; 
	} catch (e) { 
	baseNum2 = 0; 
	} 
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2)); 
	precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2; 
	return ((num1 * baseNum - num2 * baseNum) / baseNum).toFixed(precision); 
}; 
// 两个浮点数相减  
function accSub(num1,num2){  
   var r1,r2,m;  
   try{  
       r1 = num1.toString().split('.')[1].length;  
   }catch(e){  
       r1 = 0;  
   }  
   try{  
       r2=num2.toString().split(".")[1].length;  
   }catch(e){  
       r2=0;  
   }  
   m=Math.pow(10,Math.max(r1,r2));  
   n=(r1>=r2)?r1:r2;  
   return (Math.round(num1*m-num2*m)/m).toFixed(n);  
}  
/*成本核算之单位用量计算规则*/
function calculateByDanWei(chang,kuan,hou,num){
	if(chang=="0"||chang==null||chang==""){
		chang=0
	}else{
		chang=Number(chang);
	}
	if(kuan=="0"||kuan==null||kuan==""){
		kuan=0
	}else{
		kuan=Number(kuan);
	}
	if(hou=="0"||hou==null||hou==""){
		hou=0
	}else{
		hou=Number(hou);
	}
	if(num=="0"||num==null||num==""){
		num=0
	}else{
		num=Number(num);
	}
	return (chang*kuan*hou*num*0.000000001).toFixed(4);//精确到小数点后四位
}
/*俩个数相除，避免分母为0报错*/
function divisionMethod(childnum,mothernum){
	if(mothernum==""||mothernum==null||mothernum==undefined||mothernum==0||mothernum==0.0||mothernum==0.00){
		return 0;
	}else{
		return (childnum/mothernum).toFixed(2);
	}
}