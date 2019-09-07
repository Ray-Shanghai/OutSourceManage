/**
 * 首页相关数据
 */
var position="";
$(function(){
	$.ajax({
		url:base.serverContent+"/personCenter/queryloginUser.do",
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.code="000"){
				position=data.sysUserInfo.position;
				$(".queRenNum").each(function(index){
					$(this).html(data.queRenNum);
				});
				$(".caigouNum").each(function(index){
					$(this).html(data.caigouNum);
				});
				$(".baojiaNum").each(function(index){
					$(this).html(data.baojiaNum);
				});
				$(".hedingNum").each(function(index){
					$(this).html(data.hedingNum);
				});
				$(".jianyanNum").each(function(index){
					$(this).html(data.jianyanNum);
				});
				$(".peiliaoNum").each(function(index){
					$(this).html(data.peiliaoNum);
				});
				$(".caiqieNum").each(function(index){
					$(this).html(data.caiqieNum);
				});
				$(".shengchanNum").each(function(index){
					$(this).html(data.shengchanNum);
				});
				$(".wanchenNum").each(function(index){
					$(this).html(data.wanchenNum);
				});
				$(".yanshouNum").each(function(index){
					$(this).html(data.yanshouNum);
				});
				$(".wanjieNum").each(function(index){
					$(this).html(data.wanjieNum);
				});
				$(".totalCount").html(data.totalCount);
				$(".zhipaiCount").html(data.zhipaiCount);
				$(".baojiaCount").html(data.baojiaCount);
				$(".shengcanCount").html(data.shengcanCount);
			}	
		},error:function(data){}
		
	});
	
});

function toListOrder(){
	window.location.href='listOrder.html';
	/*if(position==null||position==""){//系统管理员
		window.location.href='listOrder.html';
	}else if(position=="0"){//外协经理
		window.location.href='listOrder.html?2';
	}else if(position=="1"){//核价经理
		window.location.href='listOrder.html?5';
	}else if(position=="2"){//采购经理
		window.location.href='listOrder.html?allLink';
	}else if(position=="3"){//检验经理
		window.location.href='listOrder.html?allLink';
	}else if(position=="4"){//采购员
		window.location.href='listOrder.html?allLink';
	}else if(position=="5"){//检验员
		window.location.href='listOrder.html?allLink';
	}else{
		window.location.href='listOrder.html';
	}*/
}