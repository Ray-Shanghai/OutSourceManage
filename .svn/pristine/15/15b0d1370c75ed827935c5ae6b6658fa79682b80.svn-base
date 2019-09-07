$(function(){
	var dbType="";
	var pkId=$("#systemInfoId").val();
	$.ajax({
		url:base.serverContet+'/manager/loginIn/SdSystemInfo/queryByPkId.do?pkId='+pkId,
		type:'get',
		async:false,
		success:function(msg){
			var item=msg.systemInfo;
			$("input[name='systemName']").val(item.systemName);
			$("input[name='systemWebcontext']").val(item.systemWebcontext);
			dbType=item.dbType;
			$("input[name='dbName']").val(item.dbName);
			$("input[name='dbUsername']").val(item.dbUsername);
			$("input[name='dbUserpwd']").val(item.dbUserpwd);
		}
	});
	//加载数据库类型
	$.ajax({
		url:base.serverContet+'/manager/loginIn/SysDictionaryInfo/queryDictionaryInfo.do?dictionaryTypeId=00003',
		type:'get',
		async:false,
		success:function(msg){
			for (var i = 0; i < msg.length; i++) {
				var item=msg[i];
				var isSelected=dbType==item.dictionaryId?'selected':'';
				$("#dbType").append("<option "+isSelected+" value='"+item.dictionaryId+"'>"+item.dictionaryName+"</option>");
			}
		}
	});
});