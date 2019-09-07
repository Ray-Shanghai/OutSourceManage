// 加载资源类型下拉框数据
function loadResouceType(id){
	$.ajax({
		url:base.serverContet+"/manager/loginIn/IqResourceType/queryList.do",
		data:{'status':'Y'},
		type:"get",
		success:function(data){
			if(data.code=="000"){
				$.each(data.rows,function(index1,tag1){
					var $select=$(id+" .resourcesTypeId");
					$select.each(function(index2,tag2){
						$(tag2).append(new Option(tag1.resourceName,tag1.resourceTypeId));
					});
				});
				layui.form("select").render();
			}else{
				layer.open({title: '提示',content: data.msg});
			}
		},error:function(data){
			layer.open({title: '提示',content: data.msg}); 
		}
	});
} 
layui.use(['form'],function(){
	form = layui.form();
	
	// 加载品种下拉框数据
	form.on('select(supplierResourcesTypeId)',function(selectData){
		loadVariety(selectData);
	}); 
	
	// 加载品名下拉框数据
	form.on('select(varietyId)',function(selectData){
		loadCommodity(selectData);
	}); 
	
	// 加载牌号下拉框数据
	form.on('select(commodityId)',function(selectData){
		loadGrade(selectData);
	}); 
});
function loadVariety(selectData){
	$.ajax({
		url:base.serverContet+"/manager/loginIn/IqVarietyInfo/queryList.do",
		data:{'status':'Y','resourceTypeId':selectData.value},
		type:"get",
		async:false,
		success:function(data){
			if(data.code=="000"){
				var $select=$(selectData.elem.parentElement.parentElement.parentElement.parentElement).find(".varietyId");
				$select.each(function(){
					$(this).html('');
					$(this).append(new Option('选择或搜索',''));
				});
				var $select2=$(selectData.elem.parentElement.parentElement.parentElement.parentElement).find(".commodityId");
				$select2.each(function(){
					$(this).html('');
					$(this).append(new Option('选择或搜索',''));
				});
				$.each(data.rows,function(index1,tag1){
					$select.each(function(index2,tag2){
						$(tag2).append(new Option(tag1.varietyName,tag1.varietyId));
					});
				});
				form.render();
			}else{
				layer.open({title: '提示',content: data.msg});
			}
		},error:function(data){
			layer.open({title: '提示',content: data.msg}); 
		}
	});
}
function loadCommodity(selectData){
	$.ajax({
		url:base.serverContet+"/manager/loginIn/IqCommodityInfo/queryList.do",
		data:{'status':'Y','varietyId':selectData.value},
		type:"get",
		async:false,
		success:function(data){
			if(data.code=="000"){
				var $select=$(selectData.elem.parentElement.parentElement.parentElement.parentElement).find(".commodityId");
				$select.each(function(){
					$(this).html('');
					$(this).append(new Option('选择或搜索',''));
				});
				$.each(data.rows,function(index1,tag1){
					$select.each(function(index2,tag2){
						$(tag2).append(new Option(tag1.commodityName,tag1.commodityId));
					});
				});
				form.render();
			}else{
				layer.open({title: '提示',content: data.msg});
			}
		},error:function(data){
			layer.open({title: '提示',content: data.msg}); 
		}
	});
}
function loadGrade(selectData){
	$.ajax({
		url:base.serverContet+"/manager/loginIn/IqGradeInfo/queryList.do",
		data:{'status':'Y','commodityId':selectData.value},
		type:"get",
		async:false,
		success:function(data){
			if(data.code=="000"){
				var $select=$(selectData.elem.parentElement.parentElement.parentElement.parentElement).find(".gradeId");
				$select.each(function(){
					$(this).html('');
					$(this).append(new Option('选择或搜索',''));
				});
				$.each(data.rows,function(index1,tag1){
					$select.each(function(index2,tag2){
						$(tag2).append(new Option(tag1.gradeName,tag1.gradeId));
					});
				});
				form.render();
			}else{
				layer.open({title: '提示',content: data.msg});
			}
		},error:function(data){
			layer.open({title: '提示',content: data.msg}); 
		}
	});
}
// 加载钢厂下拉框数据
function loadSteelPlant(id){
	$.ajax({
		url:base.serverContet+"/manager/loginIn/IqSteelPlantInfo/queryList.do",
		data:{'status':'Y'},
		type:"get",
		async:false,
		success:function(data){
			if(data.code=="000"){
				$.each(data.rows,function(index1,tag1){
					var $select=$(id+" .steelPlantId");
					$select.each(function(index2,tag2){
						$(tag2).append(new Option(tag1.steelPlantName,tag1.steelPlantId));
					});
				});
				layui.form("select").render();
			}else{
				layer.open({title: '提示',content: data.msg});
			}
		},error:function(data){
			layer.open({title: '提示',content: data.msg}); 
		}
	});
}
// 加载仓库下拉框数据
function loadWarehouse(id){
	$.ajax({
		url:base.serverContet+"/manager/loginIn/IqWarehouseInfo/queryList.do",
		data:{'status':'Y'},
		type:"GET",
		async:false,
		success:function(data){
			if(data.code=="000"){
				$.each(data.rows,function(index1,tag1){
					var $select=$(id+" .warehouseId");
					$select.each(function(index2,tag2){
						$(tag2).append(new Option(tag1.warehouseName,tag1.warehouseId));
					});
				});
				layui.form("select").render();
			}else{
				layer.open({title: '提示',content: data.msg});
			}
		},error:function(data){
			layer.open({title: '提示',content: data.msg}); 
		}
	});
}