var required=function(className,msg,isRequired){
	if(isRequired){
		var result=true;
		$(className).each(function(i,tag){
			var val=$(tag).val();
			if(val==''||val==null){
				layer.alert(msg, function(index){
					  //do something
					layer.close(index);
				});
				result=false;
			}
		});
	return result;
	}
};

var check=function(reg,elem,msg){
	var result=true;
	if(!(reg.test($(elem).val()))){ 
		layer.alert(msg==null?'格式有误':msg, function(index){
			  //do something
			layer.close(index);
		});
		result=false;
	}
	return result;
};

var checkPhone=function(elem,msg){
	return check(/^1[3|4|5|8][0-9]\d{4,8}$/,elem,msg);
};
 
var checkPhones=function(className,msg,isRequired){
	if(isRequired){
		var result=true;
		$(className).each(function(i,tag){
			result=check(/^1[3|4|5|8][0-9]\d{4,8}$/,tag,msg);
		});
		return result;
	}
};

var checkQq=function(elem,msg){
	return check(/^\d{5,12}$/,elem,msg);
};

var checkQqs=function(className,msg,isRequired){
	if(isRequired){
		var result=true;
		$(className).each(function(i,tag){
			result=check(/^\d{5,12}$/,tag,msg);
		});
		return result;
	}
};

var checkEmail=function(elem,msg){
	return check(/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/,elem,msg);
};

var checkEmails=function(className,msg,isRequired){
	if(isRequired){
		var result=true;
		$(className).each(function(i,tag){
			result=check(/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/,tag,msg);
		});
		return result;
	}
};

var checkWeiXin=function(elem,msg){
	return check(/^[a-zA-Z\d_]{5,}$/,elem,msg);;
};

var checkWeiXins=function(className,msg,isRequired){
	if(isRequired){
		var result=true;
		$("."+className).each(function(i,tag){
			result=check(/^[a-zA-Z\d_]{5,}$/,tag,msg);
		});
		return result;
	}
};
