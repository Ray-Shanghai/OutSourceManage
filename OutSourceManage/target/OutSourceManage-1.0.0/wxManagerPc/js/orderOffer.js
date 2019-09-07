/**
 *订单报价相关js
 */

$(function(){
	fileNameShow("i"); //初始化数据
	providerChange();
	var orderId2=window.location.search.split("?")[1];
	$.ajax({
		url:base.serverContent+"/SdOrderQuote/query.do",
		type:"post",
		data:{orderId:orderId2},
		success:function(data){
			if(data.code=="000"){
				$("#filtrateContent").css("display","block");
				//显示以往报价
				layui.use(['form','laytpl'], function(){
					var laytpl = layui.laytpl;
					
					laytpl(filtrateTpl.innerHTML).render(data, function(html){
						$("#filtrateContent").html(html);
					});
				});
			}
		},error:function(data){}
	});
});


//产品输入框值改变执行函数
var providerChange=function(){
	var  $autocomplete=$('<div class="autocomplete"></div>').hide();
	
	$('input[name="providerName"]').bind('input propertychange', function() { 
		//alert($(this).val());
		 var $searchInput=$(this);
		//创建自动完成的下拉列表，用于显示服务器返回的数据,插入在搜索按钮的后面，等显示的时候再调整位置 
		 $autocomplete.insertAfter(this);
		 //清空下拉列表的内容并且隐藏下拉列表区 
		 var clear = function() {
		     $autocomplete.empty().hide();
		     $autocomplete.height("auto");
		 };
		 clear();
		 //注册事件，当输入框失去焦点的时候清空下拉列表并隐藏 
		 $(this).blur(function() {
		     setTimeout(clear, 500);
		 });
	    $.ajax( {
            url :base.serverContent+'/SdSupplierInfo/queryList.do', //服务器的地址 
            data : {
                'supplierName' : $(this).val()
            }, //参数 
            dataType : 'json', //返回数据类型 
            type : 'POST', //请求类型 
            async:false,
            success : function(data) {
                if (data.code==0) {
                	
                    //遍历data，添加到自动完成区 
                 $.each(data.rows, function(index, item) {
                     //创建li标签,添加到下拉列表中 
                    $('<li></li>').text(item.supplierName).appendTo($autocomplete).addClass(
                            'clickable').hover(function() {
                        //下拉列表每一项的事件，鼠标移进去的操作 
                            $(this).siblings().removeClass('highlight');
                            $(this).addClass('highlight');
                        }, function() {
                            //下拉列表每一项的事件，鼠标离开的操作 
                            $(this).removeClass('highlight');
                        }).click(function() {
                        //鼠标单击下拉列表的这一项的话，就将这一项的值添加到输入框中 
                        	$searchInput.val(item.supplierName);
                        	var $partd=$searchInput.parent();
                        	$partd.find("input[name='providerId']").val(item.supplierId);
                        	
                            //清空并隐藏下拉列表 
                        	clear();
                        });
                });
            //设置下拉列表的位置，然后显示下拉列表 
           
            var $parentDiv= $autocomplete.parent();
            $parentDiv.css({
            	'position':'relative'
            })
            $autocomplete.css( {
                'position' : 'absolute',
                'top':'42px',
                'left':'0',
                'zindex':'99999999',
                'width':'180px'
               
            });
            var height=$autocomplete.height();
            if(height>150){
            	$autocomplete.css({
            		 'height':'150px',
                     'overflow-x':'hidden',
                     'overflow-y':'scroll'
            	});
            }
           // setSelectedItem(0);
            //显示下拉列表 
           $autocomplete.show();
        }
    }
        });
	});
}


/*提交数据*/
$("#supply-btn").click(function(){
	var providerName=$("input[name='providerName']").val();
	var doQuote=$("input[name='doQuote']").val();
	//alert(doQuote);
	if(base.isNotBlank(providerName) && base.isNotBlank(doQuote)){
		$.ajax({
			type:"post",
			url : base.serverContet+'/upload.do', 
			data:new FormData($("#form1")[0]),
			processData : false,
			contentType : false,
			datetype : "json",
			async:false,
			success:function(data){
			},error:function(){}
		});
		$.ajax({
			url:base.serverContent+"/SdOrderQuote/add.do",
			type:"post",
			data:$("#form1").serialize(),
			dataType:"json",
			success:function(data){
				if(data.code="000"){
					//layer.alert('添加成功', {icon: 1});
					/*layer.alert('报价成功',{icon : 1},
							function(index2){
							layer.close(index2);
							parent.layer.close(index);
							parent.parent.location.reload();
							}
					);*/
					parent.location.reload();
				}
			},error:function(data){}
			
		});
	}else{
		layer.alert('请填写完整报价信息', {icon: 2});
	}
	
})