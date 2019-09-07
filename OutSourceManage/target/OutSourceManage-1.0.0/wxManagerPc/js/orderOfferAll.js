/**
 * 筛选报价相关js
 */
$.ajax({
		type : 'POST',
		url : base.serverContent+ '/SdOrderQuote/queryList.do',
		data:{'orderId':orderId},
		async : false,
		success : function(data) {
			
			layui.use(['form','laytpl'], function(){
				var laytpl = layui.laytpl;
				
				laytpl(filtrateTpl.innerHTML).render(data, function(html){
					$("#filtrateContent").html(html);
				});
			});
		},error:function(){}
});

/*提交数据*/
$("#supply-btn").click(function(){
	var index=$('input:radio[name="orderQuoteId"]:checked').val();
	var orderId=$('input:radio[name="orderQuoteId"]:checked').next().val();
	//alert(orderId);
	if(index==''||index==null){
		layer.alert('请选择一个供应商', {icon: 2});
	}else{
		$.ajax({
			url:base.serverContent+"/SdOrderQuote/update.do",
			type:"post",
			data:{orderQuoteId:index,orderId:orderId},
			dataType:"json",
			success:function(data){
				if(data.code="000"){
					/*layer.alert('核价成功', {icon: 1});*/
					parent.location.reload();
				}
			},error:function(data){}
			
		});
	}
})