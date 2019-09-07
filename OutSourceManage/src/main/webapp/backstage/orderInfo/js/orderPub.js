/**
 * 订单详情公共js
 */
 var orderId=window.location.search.split("?")[1];
 $("input[name='orderId']").val(orderId);
 var $stateSelect=$("#dataState");
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
							$("input[name="+key+"]").val(value);
							
						}
						//外协经理、核价经理、管理员可见成本价格，商务报价
						/*if(data.position==2||data.position==3||data.position==4||data.position==5){
							$("input[name='costPrice']").val("******");
							$("input[name='commercialPrice']").val("******");
							$("input[name='customerNo']").val("******");
						}*/
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
								$("#dataState option[value='"+data.sdorderinfo.dataState+"']").attr("name","nice");
								$("option[name='nice']").prevAll().each(function(){//删除当前状态前面所有节点
									$(this).remove();
								});
							}
						}
						layui.use(['form','laytpl'], function(){
							var laytpl = layui.laytpl;
							
							laytpl(partTpl.innerHTML).render(data, function(html){
								$("#content").html(html);
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
							           			$("#productTypeId"+j).append(new Option(result.rows[i].productTypeName,result.rows[i].productTypeId,true,true));
							           		 }else{
							           			$("#productTypeId"+j).append(new Option(result.rows[i].productTypeName,result.rows[i].productTypeId));
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
								           			$("#productGradeId"+j).append(new Option(result2.rows[i].productGradeName,result2.rows[i].productGradeId,true,true));
								           		 }else{
								           			$("#productGradeId"+j).append(new Option(result2.rows[i].productGradeName,result2.rows[i].productGradeId));
								           		 }
								           	}
								           }
								       },error:function(){}
								 });
							}
							
							
							layui.form().render();
						});
						
						
					},error : function() {
					}
				});
			
			/*查看pdf文档*/
			function showPdf(url,isShow){
				if(base.isNotBlank(url)){
					var arr=url.split('.');
				    var type=arr[arr.length-1];
				}
				if(type=='jpg'||type=='png'||type=='gif'){
					$("#imgpic").attr("src",url);
					$("#imgDiv").css("display","block");
				}else{
					//encodeURIComponent对url进行编码
					$("#pdfContainer").attr("src","/OutSourceManage/wxManagerPc/pdf/web/viewer.html?file="+encodeURIComponent(url));
					var state = "";
					if(isShow){
						state = "block";
					}else{
						state = "none";
					}
					var pop = document.getElementById("pop");
					pop.style.display = state;
					var lightbox = document.getElementById("lightbox");
					lightbox.style.display = state;
				}
			}
			
			$("#closeImg").click(function(){
				$("#imgDiv").css("display","none");
			});
				
			//关闭
			function close(){
				showPdf(false);
			}