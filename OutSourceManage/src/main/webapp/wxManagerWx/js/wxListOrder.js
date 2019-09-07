/**
 * 订单列表相关js
 */
	//去往订单确认页
    function confirmOrder(orderId){
    	//判断用户是否有确认权限
    	$.ajax({type : 'POST',
    		url : base.serverContent+ '/BaseInfo/queryUser.do',
    		success : function(data) {
    				if (data.code == "000") {
    					if(data.sysUserInfo.position==1||data.sysUserInfo.position==""){//只有核价经理能确认订单
    						window.location.href='confirmOrderDetail.html?'+orderId;
    					}else{
    						layer.alert('您无权限操作此订单,请联系外协经理',{icon : 3});
    					}
    				}else{
    					layer.alert('登陆超时',{icon:2});
    				} 
    			},
    			error : function() {
    			}
    		});
    }
    //去往报价页面
    function baojiaOrder(orderId){
    	//判断用户是否有报价权限
    	$.ajax({type : 'POST',
    		url : base.serverContent+ '/BaseInfo/queryUser.do',
    		success : function(data) {
    				if (data.code == "000") {
    					if(data.sysUserInfo.position==4||data.sysUserInfo.position==""){//只有指定采购员才能报价
    						window.location.href='OrderDatail2.html?'+orderId;
    					}else{
    						layer.alert('抱歉！只有该订单指定采购员才能参与报价',{icon : 3});
    					}
    				}else{
    					layer.alert('登陆超时',{icon:2});
    				} 
    			},
    			error : function() {
    			}
    		});
    }
    //去往核价页面
    function hejiaOrder(orderId){
    	//判断用户是否有核价权限
    	$.ajax({type : 'POST',
    		url : base.serverContent+ '/BaseInfo/queryUser.do',
    		success : function(data) {
    				if (data.code == "000") {
    					if(data.sysUserInfo.position==1||data.sysUserInfo.position==""){//只有核价经理才能赛选报价
    						window.location.href='OrderDatail3.html?'+orderId;
    					}else{
    						layer.alert('您无权限操作此订单,请联系核价经理',{icon : 3});
    					}
    				}else{
    					layer.alert('登陆超时',{icon:2});
    				} 
    			},
    			error : function() {
    			}
    		});
    }
  //去往状态修改页面
    function updateOrderState(orderId){
    	//判断用户是否有修改权限
    	$.ajax({type : 'POST',
    		url : base.serverContent+ '/BaseInfo/queryUser.do',
    		success : function(data) {
    				if (data.code == "000") {
    					//只有采购员，采购经理，检验员，检验经理进行状态更改
    					if(data.sysUserInfo.position==0||data.sysUserInfo.position==""||data.sysUserInfo.position==2||data.sysUserInfo.position==3||data.sysUserInfo.position==4||data.sysUserInfo.position==5){
    						window.location.href='OrderDatail5.html?'+orderId;
    					}else{
    						layer.alert('您无权限操作此订单,请联系相关人员',{icon : 3});
    					}
    				}else{
    					layer.alert('登陆超时',{icon:2});
    				} 
    			},
    			error : function() {
    			}
    		});
    }
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
    				dataState:dataState,
    				mark:"listOrder"
    		};
    		
    		$.ajax({
				url:base.serverContent+'/manager/loginIn/SdOrderInfo/queryListByWxPage.do',
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