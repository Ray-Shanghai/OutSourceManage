$(function(){
	//加载数据库类型
	$.ajax({
		url:base.serverContet+'/manager/loginIn/SysDictionaryInfo/queryDictionaryInfo.do?dictionaryTypeId=00003',
		type:'get',
		async:false,
		success:function(msg){
			for (var i = 0; i < msg.length; i++) {
				var item=msg[i];
				$("#dbType").append("<option value='"+item.dictionaryId+"'>"+item.dictionaryName+"</option>");
			}
		}
	});
});	


