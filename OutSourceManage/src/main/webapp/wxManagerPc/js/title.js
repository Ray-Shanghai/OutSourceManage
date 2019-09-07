/**
 * 
 */
$(function(){
	var position="";
	$.ajax({
		url:base.serverContent+"/personCenter/queryByPushSet.do",
		type:'POST',
		async:false,
		dataType:'json',
		success:function(data){
			var userhtml='<span class="userNameSpan">'+data.userName+'</span>&ensp;<span class="iconfont icon-icon-test"></span>';
			$(".name-word").html(userhtml);
			var html='<div class="person-class"><ul><li class="active" onclick="yearmonthactive(this)">月度</li><li onclick="yearmonthactive(this)">年度</li><li style="float:right;width:80px;"><a href="login.html"><span class="iconfont icon-tuichu'
					+'"></span> 注销</a></li></ul><div class="line-height-16"></div></div>'
					+'<div class="person-content"><div class="person-number">&emsp;成交量：<span >'+data.totalNum+'</span>件</div>'
					+'<div class="person-number">&emsp;销售额：<span class="totalPrice">'+data.totalPrice+'</span>元</div>'
					+'<div class="person-number">预计收益：<span class="yujiMoney">'+data.yujiMoney+'</span>元</div>'
					+'</div>'
					+'<div class="person-content" style="display: none;">'
					+'<div class="person-number">&emsp;成交量：<span class="totalCount2">'+data.totalCount2+'</span>件</div>'
					+'<div class="person-number">&emsp;销售额：<span class="totalPrice2">'+data.totalPrice2+'</span>元</div>'
					+'<div class="person-number">预计收益：<span class="yujiMoney2">'+data.yujiMoney2+'</span>元</div>'
					+'</div>'
					+'<div class="person-img"><img src="images/money.png" width="260"/></div>';
			
			$(".personal").html(html);
			position=data.position;
			
		},error:function(data){}
	});
	//判断当前登录人的职位，0.外协经理,1.核价经理2.采购经理3.检验经理4.采购员，5检验员
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
	$(".index-ct-1>li").each(function(index,element){
		//alert(index);
		$(functionIdArray).each(function(index2,element2){
			//alert(index2);
			if((index+1)==functionIdArray[index2]){
				$(element).find(".shade-icon").addClass("select-ct");
			}
		});
		if(!$(element).find(".shade-icon").hasClass("select-ct")){
			$(element).attr("onclick","");
		}
	})
	//列表页权限控制
	if(position!=""){
		if(position==1){
			$(".nav-main>li").each(function(index,element){
				if(index==2){
					$(this).css("display","none");
				}
			});
		}else if(position==4||position==5){
			$(".nav-main>li").each(function(index,element){
				if(index==1||index==2){
					$(this).css("display","none");
				}
			});
		}else if(position==0||position==2||position==3){
			$(".nav-main>li").each(function(index,element){
				if(index==1){
					$(this).css("display","none");
				}
			});
		}
	}
})

function yearmonthactive(t){
	var index = $(t).index();
	$('.person-class ul li').removeClass('active').eq(index).addClass('active');
	$('.person-content').hide().eq(index).show();
}
		

