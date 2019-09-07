$(function(){
		var tableId=window.location.search.split("=")[1];
		var tableType="";
		$("#functionDbTableId").val(tableId);
		$.ajax({
			url :  base.serverContet+'/manager/loginIn/SdFunctionDbTable/queryByPkId.do?pkId='+tableId,
			type : 'get',
			success : function(data) {
				var item = data.functionTable;
				$("#functionDbTableName").val(item.functionDbTableName);
				$("#functionDbTableDesc").val(item.functionDbTableDesc);
				tableType=item.functionDbTableTypeId;
				
				//加载表名类型
				$.ajax({
					url:base.serverContet+'/manager/loginIn/SysDictionaryInfo/queryDictionaryInfo.do?dictionaryTypeId=00004',
					type:'get',
					async:false,
					success:function(msg){
						for (var i = 0; i < msg.length; i++) {
							var item=msg[i];
							var isSelected=tableType==item.dictionaryId?'selected':'';
							$("#functionDbTableTypeName").append("<option "+isSelected+" value='"+item.dictionaryId+"'>"+item.dictionaryName+"</option>");
						}
					}
				});
			},
			error:function(){
				alert("失败！");
			}
		});
});