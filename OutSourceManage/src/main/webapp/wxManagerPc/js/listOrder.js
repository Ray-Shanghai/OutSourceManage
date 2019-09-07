/**
 * 订单列表相关js
 */
$(function(){
	$.ajax({type : 'POST',
		url : base.serverContent+ '/BaseInfo/queryUser.do',
		async : false,
		success : function(data) {
				if (data.code == "000") {
					var optionHtml="";
					if(data.sysUserInfo.position==""){
						optionHtml='<option value="">全部</option>'
							+'<option value="2">订单确认</option>'
							+'<option value="4">待报价</option>'
							+'<option value="5">报价核定中</option>'
							+'<option value="7">配料</option>'
							+'<option value="8">裁切</option>'
							+'<option value="9">生产</option>'
							+'<option value="10">完成</option>'
							+'<option value="11">验收通过</option>'
							+'<option value="12">完结</option>'
							+'<option value="14">验收不通过</option>';
					}else{
						if(data.sysUserInfo.position==1){
							optionHtml='<option value="">请选择</option><option value="2">订单确认</option>'
								+'<option value="5">报价核定中</option>';
						}else if(data.sysUserInfo.position==0||data.sysUserInfo.position==2||data.sysUserInfo.position==3||data.sysUserInfo.position==4){
							optionHtml='<option value="">请选择</option><option value="7">配料</option>'
								+'<option value="8">裁切</option>'
								+'<option value="9">生产</option>'
								+'<option value="10">完成</option>'
								+'<option value="12">完结</option>';
						}else if(data.sysUserInfo.position==5){
							optionHtml='<option value="">请选择</option><option value="7">配料</option>'
								+'<option value="8">裁切</option>'
								+'<option value="9">生产</option>'
								+'<option value="10">完成</option>'
								+'<option value="11">验收通过</option>'
								+'<option value="12">完结</option>'
								+'<option value="14">验收不通过</option>';
						}
					}
					//添加下拉选项
					$("select[name='dataState']").append(optionHtml);
					renderForm();
				}
		},
		error:function(){
		}
	});
});
//订单确认
function confirmAssignInfo(orderId){
	//判断用户是否有确认权限
	$.ajax({type : 'POST',
		url : base.serverContent+ '/BaseInfo/queryUser.do',
		success : function(data) {
				if (data.code == "000") {
					if(data.sysUserInfo.position==1||data.sysUserInfo.position==""){//只有核价经理能确认订单
						layer.open({
							type: 2,
							title: '订单确认',
							shadeClose: true,
							shade: [0.6, '#393D49'],
							maxmin: true, //开启最大化最小化按钮
							area: ['1200px', '80%'],
							content: 'confirmAssignInfo.html?'+orderId,
							btn: ['确认','取消'],
							btnAlign: 'c',
							skin: 'layui-layer-red',
							yes : function( index,layero) {
								$.ajax({type : 'POST',
									url : base.serverContent+ '/manager/loginIn/SdOrderInfo/confirmOrder.do',
									data :{orderId:orderId,dataState:'3'},//修改订单状态
									async : false,
									success : function(data) {
											if (data.code == "000") {
												
												layer.alert('订单确认成功',{icon : 6},
														function(index2){
														layer.close(index2);
														layer.close(index);
														window.location.reload();}
																);
												 
											} else {
												layer.alert('确认失败',{icon : 2});
												 
											 }
										},
										error : function() {
										}
									});
							}
						});
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

function offerInfo(orderId) {
	//判断该用户是否有报价权限
	$.ajax({type : 'POST',
		url : base.serverContent+ '/BaseInfo/queryUser.do',
		success : function(data) {
				if (data.code == "000") {
					if(data.sysUserInfo.position==4||data.sysUserInfo.position==""){//只有采购员才能报价
						layer.open({
							type: 2,
							title: '报价',
							shadeClose: true,
							shade: [0.6, '#393D49'],
							maxmin: true, //开启最大化最小化按钮
							area: ['1200px', '80%'],
							content: 'listOrderOffer.html?'+orderId,
							/*btn: ['确定','取消'],
							btnAlign: 'c',*/
							skin: 'layui-layer-red'
						});
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

function offerAll(orderId) {
	//判断用户是否有筛选权限
	$.ajax({type : 'POST',
		url : base.serverContent+ '/BaseInfo/queryUser.do',
		success : function(data) {
				if (data.code == "000") {
					if(data.sysUserInfo.position==1||data.sysUserInfo.position==""){//只有核价经理才能核价
						layer.open({
							type: 2,
							title: '筛选报价',
							shadeClose: true,
							shade: [0.6, '#393D49'],
							maxmin: true, //开启最大化最小化按钮
							area: ['1200px', '80%'],
							content: 'listOrderOfferAll.html?'+orderId,
							/*btn: ['确定','取消'],
							btnAlign: 'c',*/
							skin: 'layui-layer-red'
						});
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


function changeStatus(orderId) {
	//判断用户是否有修改权限
	$.ajax({type : 'POST',
		url : base.serverContent+ '/BaseInfo/queryUser.do',
		success : function(data) {
				if (data.code == "000") {
					//只有采购员，采购经理，检验员，检验经理进行状态更改
					if(data.sysUserInfo.position==0||data.sysUserInfo.position==2||data.sysUserInfo.position==3||data.sysUserInfo.position==4||data.sysUserInfo.position==5||data.sysUserInfo.position==""){
						layer.open({
							type: 2,
							title: '修改状态',
							shadeClose: true,
							shade: [0.6, '#393D49'],
							maxmin: true, //开启最大化最小化按钮
							area: ['1200px', '80%'],
							content: 'listOrderEdit.html?'+orderId,
							/*btn: ['确定','取消'],
							btnAlign: 'c',*/
							skin: 'layui-layer-red'
						});
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