var sdfarme={};  //fdsafds  
sdfarme.initTableEvent=function(){
 
	
	
	$('#content.selecteds tr').click(function() {
		if($(this).hasClass('bg-blue-selected')) {
			$(this).removeClass('bg-blue-selected');
			$(this).children().children('.layui-form-checkbox').removeClass('layui-form-checked');
		} else {
			$(this).addClass('bg-blue-selected');
			$(this).children().children('.layui-form-checkbox').addClass('layui-form-checked');
		}
	});
	



     //user click single 
	$('#content.selected tr').click(function() {
		var index = $(this).index();
        $('#content tr').removeClass('bg-blue-selected').eq(index).addClass('bg-blue-selected');
		$('#content tr').children().children('.layui-form-checkbox').removeClass('layui-form-checked').eq(index).addClass('layui-form-checked');
		 

	});
	

	form.render('checkbox');
	form.on('checkbox(allselector)', function(data) {
		var elem = data.elem;

		$('#content').children('tr').each(function() {
			var $that = $(this);
			//全选或反选
			$that.children('td').eq(0).children('input[type=checkbox]')[0].checked = elem.checked;
			if($that.children('td').eq(0).children('input[type=checkbox]')[0].checked) {
				$that.addClass('bg-blue-selected');
			} else {
				$that.removeClass('bg-blue-selected');
			}

			form.render('checkbox');
		});
		
	 
	});

	 
}
  //Get the contents selected by the table
sdfarme.getSelected=function(){
	var jsonArrays =[];
	 
     $('.bg-blue-selected').each(function(i,obj){
		   var jsonObj = [];
		 $(obj).find("td").each(function(i1,obj1){
		 	jsonObj[i1] = $(obj1).text();
		 });
		 jsonArrays[i]=jsonObj;
		 
	});
	 
	
	return jsonArrays;
}
$.fn.serializeObject = function() {
    var json = {};
    var arrObj = this.serializeArray();
    $.each(arrObj, function() {
      if (json[this.name]) {
           if (!json[this.name].push) {
            json[this.name] = [ json[this.name] ];
           }
           json[this.name].push(this.value || '');
      } else {
           json[this.name] = this.value || '';
      }
    });
    return json;
};

$.fn.serializeJson=function(){  
    var serializeObj={};  
    var array=this.serializeArray();  
    var str=this.serialize();  
    $(array).each(function(){  
        if(serializeObj[this.name]){  
            if($.isArray(serializeObj[this.name])){  
                serializeObj[this.name].push(this.value);  
            }else{  
                serializeObj[this.name]=[serializeObj[this.name],this.value];  
            }  
        }else{  
            serializeObj[this.name]=this.value;   
        }  
    });  
    return serializeObj;  
};  
