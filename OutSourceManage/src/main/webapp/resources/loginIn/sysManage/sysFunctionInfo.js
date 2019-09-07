/**
 * author:杨洋
 * day:2016-11-19
 * @deprecated 组织架构
 */
$(document).ready(function() { 
	 
 	$('#sysfunctionInfoId').tree({
	    onClick: function(node){
	      
	        	  window.localStorage.setItem("parentFunctionId",node.id);
	        		layui.use(['paging', 'form','element'], function() {
	    				var $ = layui.jquery,
	    					element = layui.element(); //Tab的切换功能，切换事件监听等，需要依赖element模块
	    					paging = layui.paging(),
	    					layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
	    					layer = layui.layer, //获取当前窗口的layer对象
	    					form = layui.form();
	    					
	    					
	    				paging.init({
	    					url: base.serverContet+'/manager/loginIn/SysFunctionInfo/query.do?parentFunctionId='+ window.localStorage.getItem("parentFunctionId"), //地址
	    					elem: '#content', //内容容器
	    					params: { //发送到服务端的参数
	    					},
	    					type: 'POST',
	    					tempElem: '#tpl', //模块容器
	    					pageConfig: { //分页参数配置
	    						elem: '#paged', //分页容器
	    						pageSize: base.pageSize, //分页大小
	    						skin:"#1E9FFF"
	    						
	    					},
	    					success: function() { //渲染成功的回调
	    						//alert('渲染成功');
	    					},
	    					fail: function(msg) { //获取数据失败的回调
	    						//alert('获取数据失败')
	    					},
	    					complate: function() { //完成的回调
	    						
	    					},
	    				});
	    				 
	    			});
            		        	 
	        
	    }
	});	
}); 


		
	
 
