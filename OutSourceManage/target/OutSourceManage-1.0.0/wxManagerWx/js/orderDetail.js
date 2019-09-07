/**
 *获取订单详情
 */

 var orderId=window.location.search.split("?")[1];
 if(orderId.indexOf("&")>0){
	 orderId=window.location.search.split("?")[1].split("&")[0];
 }
 var $stateSelect=$("#state");
layui.use(['form', 'layedit', 'laydate','laytpl'], function(){
				var form = layui.form()
				  ,layer = layui.layer
				  ,layedit = layui.layedit
				  ,laydate = layui.laydate;		  
				});
				$.ajax({
					type : 'POST',
					url : base.serverContent+ '/manager/loginIn/SdOrderInfo/queryByPkId.do',
					data : {orderId:orderId},
					async : false,
					success : function(data) {
						for ( var key in data.sdorderinfo) {
							var value=data.sdorderinfo[key];
							//订单表数据
							$("#"+key).html(value);
							
						}
						
						if($stateSelect!=null){
							$stateSelect.val(data.sdorderinfo.dataState);
							if("14"==data.sdorderinfo.dataState){
								$("#dataState option[value='"+data.sdorderinfo.dataState+"']").attr("name","nice");
								$("option[name='nice']").prevAll().each(function(index){//删除当前状态前面所有节点
									if(index>=3){
										$(this).remove();
									}
								});
							}else{
								$("#state option[value='"+data.sdorderinfo.dataState+"']").attr("name", 'nice');
								$("option[name='nice']").prevAll().each(function(){//删除当前状态前面所有节点
								    $(this).remove();
								  });
							}
						}
						
						layui.use(['form','laytpl'], function(){
							var laytpl = layui.laytpl;
							
							laytpl(indexTpl.innerHTML).render(data, function(html){
								$(".check-material").html(html);
							});
							laytpl(detailTpl.innerHTML).render(data, function(html){
								$(".swiper-wrapper").html(html);
							});
							
							for(var j=0;j<data.sdorderinfo.detailList.length;j++){
								//获取类别数据
								 $.ajax( {
							        url :base.serverContent+'/SdProductType/queryList.do', //服务器的地址 
							        dataType : 'json', //返回数据类型 
							        type : 'GET', //请求类型 
							        async: false,
							        success : function(result) {
							            if (result.code==0) {
							           	 for(var i=0;i<result.rows.length;i++){
							           		 
							           		 if(data.sdorderinfo.detailList[j].productTypeId==result.rows[i].productTypeId){
							           			$("select[name='productTypeId"+j+"']").append(new Option(result.rows[i].productTypeName,result.rows[i].productTypeId,true,true));
							           		 }else{
							           			$("select[name='productTypeId"+j+"']").append(new Option(result.rows[i].productTypeName,result.rows[i].productTypeId));
							           		 }
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
								        success : function(result2) {
								            if (result2.code==0) {
								           	 for(var i=0;i<result2.rows.length;i++){
								           		 if(data.sdorderinfo.detailList[j].productGradeId==result2.rows[i].productGradeId){
								           			$("select[name='productGradeId"+j+"']").append(new Option(result2.rows[i].productGradeName,result2.rows[i].productGradeId,true,true));
								           		 }else{
								           			$("select[name='productGradeId"+j+"']").append(new Option(result2.rows[i].productGradeName,result2.rows[i].productGradeId));
								           		 }
								           	}
								           }
								       },error:function(){}
								 });
							}
							//外协经理、核价经理、管理员可见成本价格，商务报价
							if(data.position!=""&&(data.position==0||data.position==2||data.position==3||data.position==4||data.position==5)){
								$("body div[name='costPrice']").each(function(index){
									$(this).html("******");
								})
								$("#commercialPrice").html("******");
								$("#customerNo").html("******");
							}
							
							layui.form().render();
						});
						
						
					},error : function() {
					}
				});
				
				$('.icon-icon-test').click(function(){
					$(this).parent().parent().children('.list-content ul').hide();
				})
				
				
			$(".icon-icon-test").click(function(){
				if($(this).hasClass('rotate')){
					$(this).parent().parent().children('.list-content ul').hide();
					$(this).removeClass('rotate').addClass('rotate1');
				}else{
					$(this).parent().parent().children('.list-content ul').show();
					$(this).removeClass('rotate1').addClass('rotate');
				}
				
			})
			
			function detailOrder(){
					$('.bg-tc').show();
					   
					   var swiper = new Swiper('.swiper-container', {
					        pagination: '.swiper-pagination',
					        paginationClickable: true,
					        observer: true,//修改swiper自己或子元素时，自动初始化swiper
				            observeParents: true//修改swiper的父元素时，自动初始化swiper
					   });	
				}
			$('.close-btn .icon-chahao').click(function(){
				$('.bg-tc').hide();
			})	