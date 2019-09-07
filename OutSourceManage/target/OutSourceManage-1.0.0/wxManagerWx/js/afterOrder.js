/**
 * 订单跟踪列表
 */
function queryDataList(isPaging,dataState){
    		var orderNuber=$("input[name='orderNuber']").val();
    		var pageIndex = $("#pageIndex").val();	//页码
    		if(base.isNotBlank(pageIndex)==false || isPaging==0){
    			pageIndex = 1;
    			$("#pageIndex").val("1");
    		}
    		var dataVal = {
    				pageSize:6,
    				pageIndex:pageIndex,
    				orderNuber:orderNuber,
    				dataState:dataState
    		};
    		
    		$.ajax({
				url:base.serverContent+'/manager/loginIn/SdOrderInfo/queryListByTrack.do',
				type:'post',
				data:dataVal,
				dataType:'json',
				success:function(data){
					if(data.code==0){
						if(isPaging==0){	//说明是第一次加载
							$("#content").html("");
							$("#noDataSource").css("display","none");
							$("#moreButton").css("display","none");
							$("#noMoreButton").css("display","none");
						}
						$("#pageIndex").val((parseInt(pageIndex)+1));
						layui.use(['form','laytpl'], function(){
							var laytpl = layui.laytpl;
							
							laytpl(partTpl.innerHTML).render(data, function(html){
								$("#content").append(html);
							});
						});
						if(data.rows.length==0){
							$("#noDataSource").css("display","block");
							$("#moreButton").css("display","none");
							$("#noMoreButton").css("display","none");
						}else  if(pageIndex<Math.ceil(data.count/6)){
							$("#moreButton").css("display","block");
							$("#noMoreButton").css("display","none");
						}else if(pageIndex>1){
							$("#moreButton").css("display","none");
							$("#noMoreButton").css("display","block");
						}else{
							$("#noDataSource").css("display","none");
							$("#moreButton").css("display","none");
							$("#noMoreButton").css("display","none");
						} 
					}else{
						alert("服务错误");
					}
					
				},
				error:function(){}
			})
    		
    	}
	/*点击更多时*/
	$("#moreBtn").click(function(){
		queryDataList(1,$("input[name='dataState']").val());
	});
	/*点击查询时*/
	$(".search-btn").click(function(){
		queryDataList(0,$("input[name='dataState']").val());
	});