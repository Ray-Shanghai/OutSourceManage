/**
 * 检验客户订单号是否存在
 */
layui.use(['layer'], function() {
			var	layer = layui.layer;
		});
var customerFlag=false;
$("input[name='customerNo']").bind("blur",function(){
	$.ajax({
		url:base.serverContent+"/manager/loginIn/SdOrderInfo/queryByCustomerNo.do",
		type:"post",
		data:{"customerNo":$("input[name='customerNo']").val()},
		success:function(data){
			if(data.cusNoYN=="N"){
				layer.alert("此客户订单号已经存在,请重新输入",{icon:3});
			}else{
				customerFlag=true;
			}
		},error:function(data){}
	})
})