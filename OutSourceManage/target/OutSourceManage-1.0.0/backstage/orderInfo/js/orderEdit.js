/**
 * 状态修改相关js
 */
/*提交 数据*/
$("#supply-btn").click(function(){
	$.ajax({
		url:base.serverContent+"/manager/loginIn/SdOrderInfo/updateOrder.do",
		type:"post",
		data:$("#form1").serialize(),
		dataType:"json",
		success:function(data){
			if(data.code="000"){
				parent.location.reload();
			}
		},error:function(data){}
		
	});
});