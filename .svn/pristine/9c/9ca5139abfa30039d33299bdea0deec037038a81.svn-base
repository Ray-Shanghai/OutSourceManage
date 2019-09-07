/**
 * 微信端权限控制
 */
$(function(){
	var functionIdArray=new Array();
	$.ajax({
		url:base.serverContent+"/manager/loginIn/PowerPositionInfo/queryByPositionId.do",
		type:"post",
		async:false,
		success:function(data){
			if(data.code="000"){
				functionIdArray=data.functionIds.split(",");
				
			}
		},
		error:function(){}
	})
	//首页权限控制
	$(".flow-index .swiper-slide").each(function(index,element){
		//alert(index);
		$(functionIdArray).each(function(index2,element2){
			//alert(index2);
			if((index+1)==functionIdArray[index2]){
				$(element).find("span").addClass("active");
			}
		});
		if(!$(element).find("span").hasClass("active")){
			$(element).find("p").css("color","#cccccc");
			$(element).find("a").attr("href","");
		}
	})
	
	/*var position="";
	$.ajax({
		url:base.serverContent+"/BaseInfo/queryUser.do",
		type:'POST',
		async:false,
		dataType:'json',
		success:function(data){
			if(data.code=="000"){
				position=data.sysUserInfo.position;
				//判断当前登录人的职位，0.外协经理,1.核价经理2.采购经理3.检验经理4.采购员，5检验员
				if(position==0){
					$(".flow-index .swiper-slide").each(function(index){
						if(index==0||index==1||index==2){
							$(this).find("span").addClass("active");
						}else{
							$(this).find("p").css("color","#cccccc");
							$(this).find("a").attr("href","#");
						}
					});
					
				}else if(position==1){
					$(".flow-index .swiper-slide").each(function(index){
						if(index==2){
							$(this).find("span").addClass("active");
						}else{
							$(this).find("p").css("color","#cccccc");
							$(this).find("a").attr("href","#");
						}
					});
					
				}else if(position==2||position==3){
					$(".flow-index .swiper-slide").each(function(index){
						if(index==2||index==3){
							$(this).find("span").addClass("active");
						}else{
							$(this).find("p").css("color","#cccccc");
							$(this).find("a").attr("href","#");
						}
					});
					
				}else if(position==4){
					$(".flow-index .swiper-slide").each(function(index){
						if(index==4||index==5||index==7){
							$(this).find("span").addClass("active");
						}else{
							$(this).find("p").css("color","#cccccc");
							$(this).find("a").attr("href","#");
						}
					});
					
				}else if(position==5){
					$(".flow-index .swiper-slide").each(function(index){
						if(index==5||index==6){
							$(this).find("span").addClass("active");
						}else{
							$(this).find("p").css("color","#cccccc");
							$(this).find("a").attr("href","#");
						}
					});
					
				}
			}
		},
		error:function(data){}
	});*/
});