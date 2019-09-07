//para后台接收的集合实体类参数名
//row行的class
//name实体类属性名
function indexSort(para, row, name) {
	if (para != null && para != '') {
		if (row != null && row != '') {
			if (name != null && name != '') {
				var n = name.split(';');
				for (var i = 0; i < $('.' + row).length; i++) {
					for (var j = 0; j < n.length; j++) {
					var $tagObject = $('.' + row).eq(i).find("." + n[j]);
						$tagObject.attr("name",
								para + "[" + i + "]." + n[j]);
					}
				}
			}
		}
	}
}
var indexSortSelected = function(para, row, className) {
	if (para != null && para != '') {
		if (row != null && row != '') {
			if (className != null && className != '') {
				var n = className.split(';');
				var k=0;
				for (var i = 0; i < $('.' + row).length; i++) {
					for (var j = 0; j < n.length; j++) {
						
					var isSelected=$('.' + row)[i].className.indexOf("bg-blue-selected");
						if(isSelected>-1){
							var $tagObject = $('.' + row).eq(i).find("." + n[j]);
							
							$tagObject.attr("name",
									para + "[" + k + "]." + n[j]);
							k++;
						}
				 
						
					}
				}
			}
		}
	}
}
