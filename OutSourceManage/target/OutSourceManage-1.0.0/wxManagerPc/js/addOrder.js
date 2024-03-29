/**
 * 订单添加页js
 * 
 */
//客户输入框的值改变执行函数
var  $autocomplete2=$('<div class="autocomplete"></div>').hide();
var customerChange=function(){
	
	$('input[name="customerName"]').bind('input propertychange', function() { 
		//alert($(this).val());
		 var $customerInput=$(this);
		//创建自动完成的下拉列表，用于显示服务器返回的数据,插入在搜索按钮的后面，等显示的时候再调整位置 
		 $autocomplete2.insertAfter(this);
		 //清空下拉列表的内容并且隐藏下拉列表区 
		 var clear = function() {
		     $autocomplete2.empty().hide();
		     $autocomplete2.height("auto");
		 };
		 clear();
		 //注册事件，当输入框失去焦点的时候清空下拉列表并隐藏 
		 $(this).blur(function() {
		     setTimeout(clear, 500);
		 });
	    $.ajax( {
            url :base.serverContent+'/SdCustomerInfo/queryList.do', //服务器的地址 
            data : {
                'customerName' : $(this).val()
            }, //参数 
            dataType : 'json', //返回数据类型 
            type : 'POST', //请求类型 
            success : function(data) {
                if (data.code=="000") {
                	
                    //遍历data，添加到自动完成区 
                 $.each(data.customerList, function(index, item) {
                     //创建li标签,添加到下拉列表中 
                    $('<li></li>').text(item.customerName).appendTo($autocomplete2).hover(function() {
                        //下拉列表每一项的事件，鼠标移进去的操作 
                            $(this).siblings().removeClass('highlight');
                            $(this).addClass('highlight');
                        }, function() {
                            //下拉列表每一项的事件，鼠标离开的操作 
                            $(this).removeClass('highlight');
                        }).click(function() {
                        //鼠标单击下拉列表的这一项的话，就将这一项的值添加到输入框中 
                        	$customerInput.val(item.customerName);
                        	var $tbody=$customerInput.parent().parent().parent().parent();
                        	$tbody.find("input[name='customerAddress']").val(item.customerAddress);
                        	
                            //清空并隐藏下拉列表 
                        	clear();
                        });
                });
            //设置下拉列表的位置，然后显示下拉列表 
           
            var $parentDiv= $autocomplete2.parent();
            $parentDiv.css({
            	'position':'relative'
            })
            $autocomplete2.css( {
                'position' : 'absolute',
                'top':'34px',
                'left':'0',
                'zindex':'100',
                'width':'446px'
               
            });
            var height=$autocomplete2.height();
            if(height>120){
            	$autocomplete2.css({
            		 'height':'120px',
                     'overflow-x':'hidden',
                     'overflow-y':'scroll'
            	});
            }
           // setSelectedItem(0);
            //显示下拉列表 
           $autocomplete2.show();
        }
    }
        });
	});
}

//产品输入框值改变执行函数
var  $autocomplete=$('<div class="autocomplete"></div>').hide();
var productChange=function(){
	
	$('input[name="productName"]').bind('input propertychange', function() { 
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
            url :base.serverContent+'/manager/loginIn/SdProductInfo/search.do', //服务器的地址 
            data : {
                'productName' : $(this).val()
            }, //参数 
            dataType : 'json', //返回数据类型 
            type : 'POST', //请求类型 
            success : function(data) {
                if (data.code=="000") {
                	
                    //遍历data，添加到自动完成区 
                 $.each(data.proList, function(index, item) {
                     //创建li标签,添加到下拉列表中 
                    $('<li></li>').text(item.productName).appendTo($autocomplete).addClass(
                            'clickable').hover(function() {
                        //下拉列表每一项的事件，鼠标移进去的操作 
                            $(this).siblings().removeClass('highlight');
                            $(this).addClass('highlight');
                        }, function() {
                            //下拉列表每一项的事件，鼠标离开的操作 
                            $(this).removeClass('highlight');
                        }).click(function() {
                        //鼠标单击下拉列表的这一项的话，就将这一项的值添加到输入框中 
                        	$searchInput.val(item.productName)
                        	var $tbody=$searchInput.parent().parent().parent().parent();
                        	$tbody.find("input[name='customerSupplies']").val(item.customerSupplies);
                        	$tbody.find("input[name='productCode']").val(item.productCode);
                        	$tbody.find("input[name='productName']").val(item.productName);
                        	$tbody.find("input[name='productStandard']").val(item.productStandard);
                        	$tbody.find("input[name='productLength']").val(item.productLength);
                        	$tbody.find("input[name='productWidth']").val(item.productWidth);
                        	$tbody.find("input[name='productHeight']").val(item.productHeight);
                        	$tbody.find("select[name='isLid']").val(item.isLid);
                        	$tbody.find("input[name='costPrice']").val(item.costPrice); //成本核算
                        	$tbody.find("input[name='productOther']").val(item.productOther);
                        	$tbody.find("select[name='productTypeId']").val(item.productTypeId);
                        	$tbody.find("select[name='productGradeId']").val(item.productGradeId);
                        	$tbody.find("input[name='productInnerLength']").val(item.productInnerLength);
                        	$tbody.find("input[name='productInnerWidth']").val(item.productInnerWidth);
                        	$tbody.find("input[name='productInnerHeight']").val(item.productInnerHeight);
                        	$tbody.find("input[name='productOther']").val(item.productOther);
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
                'top':'34px',
                'left':'0',
                'zindex':'100',
                'width':'160px'
               
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


function onloadTypeAndGrade(index){
	//alert(index);
	//获取类别数据
	 $.ajax( {
        url :base.serverContent+'/SdProductType/queryList.do', //服务器的地址 
        dataType : 'json', //返回数据类型 
        type : 'GET', //请求类型 
        async: false,
        success : function(result) {
        	$(".table-content").eq(index).find("select[name='productTypeId']").html("");
            if (result.code==0) {
            	$(".table-content").eq(index).find("select[name='productTypeId']").append("<option value=''>请选择</option>")
           	 for(var i=0;i<result.rows.length;i++){
           		$(".table-content").eq(index).find("select[name='productTypeId']").append(new Option(result.rows[i].productTypeName,result.rows[i].productTypeId));
           	}
           }
       },error:function(){}
	 });
	 
	 //获取材质数据
	 $.ajax( {
	        url :base.serverContent+'/SdProductGrade/queryList.do', //服务器的地址 
	        dataType : 'json', //返回数据类型 
	        type : 'GET', //请求类型 
	        async: false,
	        success : function(result) {
	        	$(".table-content").eq(index).find("select[name='productGradeId']").html("");
	            if (result.code==0) {
	            	$(".table-content").eq(index).find("select[name='productGradeId']").append("<option value=''>请选择</option>")
	           	 for(var i=0;i<result.rows.length;i++){
	           		$(".table-content").eq(index).find("select[name='productGradeId']").append(new Option(result.rows[i].productGradeName,result.rows[i].productGradeId));
	           	}
	           }
	       },error:function(){}
	 });
}
//获取采购经理检验经理
function takeBuyerAndChecker(){
	 $.ajax( {
	        url :base.serverContent+'/manager/loginIn/SysUserInfo/getBuyerAndChecker.do', //服务器的地址 
	        dataType : 'json', //返回数据类型 
	        type : 'POST', //请求类型 
	        async: false,
	        success : function(result) {
	        	$("select[name='procurementUserId']").html("");
	        	$("select[name='checkoutUserId']").html("");
	            if (result.code=="000") {
	           	 for(var i=0;i<result.buyerUsers.length;i++){
	           		$("select[name='procurementUserId']").append(new Option(result.buyerUsers[i].userName,result.buyerUsers[i].userId));
	           	 }
	           	 for(var i=0;i<result.checkerUsers.length;i++){
		           	$("select[name='checkoutUserId']").append(new Option(result.checkerUsers[i].userName,result.checkerUsers[i].userId));
		         }
	           }
	       },error:function(){}
	 });
}

$(function() {
	fileNameShow("i"); //初始化数据
	productChange();
	customerChange();
	onloadTypeAndGrade(0);
	takeBuyerAndChecker();
});