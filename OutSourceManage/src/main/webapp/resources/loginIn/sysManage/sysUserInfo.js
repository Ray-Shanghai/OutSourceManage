/**
 * author:杨洋
 * day:2016-11-19
 * @deprecated 组织架构
 */


$(document).ready(function() { 
	var roleId=new Array();
	function query(){
		$.ajax({
		url:"../../../manager/loginIn/SysUserRole/query.do",
		type:"post",
		data:{userId:$("#userId").val()},
		async:false,
		success:function(msg){
			roleId=eval(msg);
		}
	});
	}
	if($("#userId").val()!=null&&$("#userId").val()!=""){
		query();
	}
	function isHas(row){
		if(roleId.length>0){
    		 for (var i = 0; i < roleId.length; i++) {
				if(row.departId==roleId[i]){
					return "✔是";
				}else if((roleId.length-1)==i){
					return "✘否";
				}
			}
    	}else{
    		return "✘否";	  
    	}
	}
	
	//部门添加
 	$('#sysRoleInfoId').tree({
	    onClick: function(node){
	        if(node.isVirtual=="0"&&node.nodeType=="5"){
	        	 var pnode = $('#sysRoleInfoId').tree('getParent', node.target);
	        	
	        	 	//alert(pnode.text);
	        		var s;
	        		var url="";
	        	 
	        		if(node.id.length==6){
	        			url="../../SysRoleInfo/addSysRole.do";
	        			 
	        			url+="?parentDepartId="+node.id+"&departName="+pnode.text;
	        			 s= [
	        			     {field:'departId1',title:'是否拥有',width:80,align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		 return isHas(row);
	    	                  }},
	       	                  {field:'departId',title:'角色编号',width:100,align:'center'},
	    	                  {field:'departName',title:'角色名称',width:100,align:'center'},
	    	                  {field:'departDesc',title:'角色名称',width:100,	align:'center',hidden:true},             
	    	                  {field:'createTime',title:'创建时间',width:150,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
	    	              ];
	        			
	        		}else if(node.id.length==12){
	        			url="../SysRoleInfo/addUnitRoleInfo.do";
 	        		 url+="?parentDepartId="+node.id+"&unitName="+pnode.text+"&unitId="+pnode.id;

	        		  s= [
	        		      {field:'departId1',title:'是否拥有',width:80,align:'center',
    	                	  formatter:function(value,row,index){
    	                		  return isHas(row);
    	                  }},
       	                  {field:'departId',title:'部门编号',width:180,align:'center'},
    	                  {field:'unitName',title:'单位名称',width:100,align:'center'},
    	                  {field:'departName',title:'角色名称',width:100,align:'center'},
    	                  {field:'departDesc',title:'角色名称',width:100,	align:'center',hidden:true},         
    	                  {field:'createTime',title:'创建时间',width:150,align:'center'},
    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
    	              ];
	        		}else if(node.id.length==18){
	        			url="../SysRoleInfo/addDepartRoleInfo.do";
	        			 var ppnode = $('#sysRoleInfoId').tree('getParent', pnode.target);
	    	        	 ppnode = $('#sysRoleInfoId').tree('getParent', ppnode.target);
 	        			url+="?parentDepartId="+node.id+"&departName="+pnode.text+"&unitName="+ppnode.text+"&unitId="+ppnode.id;

	        			 s= [
	        			     {field:'departId1',title:'是否拥有',width:80,align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		  return isHas(row);
	    	                  }},
	       	                  {field:'departId',title:'角色编号',width:200,align:'center'},
	    	                  {field:'unitName',title:'单位名称',width:80,align:'center'},
	    	                  {field:'departName1',title:'部门名称',width:80,align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		  return pnode.text;
	    	                  }},
	    	                 
	    	                  {field:'departName',title:'角色名称',width:100,align:'center'},
	    	                  {field:'departDesc',title:'角色名称',width:100,align:'center',hidden:true},             
	    	                  {field:'createTime',title:'创建时间',width:150,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
	    	              ];
	        			
	        		} else if(node.id.length==24){
	        			url="../SysRoleInfo/addTeamRoleInfo.do";
	        			 var ppnode = $('#sysRoleInfoId').tree('getParent', pnode.target);
	    	        	 ppnode = $('#sysRoleInfoId').tree('getParent', ppnode.target);
	    	        	 
	    	        	 var dw=$('#sysRoleInfoId').tree('getParent', ppnode.target);
	    	        	 dw= $('#sysRoleInfoId').tree('getParent', dw.target);
	    	        	 
	        			url+="?parentDepartId="+node.id+"&teamName="+pnode.text+"&departName="+ppnode.text+"&unitName="+dw.text+"&unitId="+ppnode.id;

	        			 s= [
	        			     {field:'departId1',title:'是否拥有',width:80,align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		  return isHas(row);
	    	                  }},
	       	                  {field:'departId',title:'角色编号',width:200,align:'center'},
	    	                  {field:'unitName',title:'单位名称',width:100,align:'center'},
	    	                  {field:'departName1',title:'部门名称',width:100,align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		  return ppnode.text;
	    	                                }
	    	                  },
	    	                  {field:'departName2',title:'班组名称',width:100,	align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		  return pnode.text;
	    	                                }},
	    	                  {field:'departName',title:'角色名称',width:100,	align:'center'},
	    	                  {field:'departDesc',title:'角色名称',width:100,	align:'center',hidden:true},
	    	                  {field:'createTime',title:'创建时间',width:150,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
	    	              ];
	        			
	        		}else{
	        			return;
	        		}
	        		var reqUrl ='../../../manager/loginIn/SysRoleInfo/getDepartInfoByParentId.do?parentDepartId='+node.id;
 		        	$(function(){
		        			 $('#listId').datagrid({ 
		        				 //title:'问题列表', 
		        			        iconCls:'icon-edit',//图标 
		        			        width: 800, 
		        			        height: '200', 
		        			        nowrap: false, 
		        			        striped: true, 
		        			        border: true, 
		        			        collapsible:false,//是否可折叠的 
		        			        fit: true,//自动大小 
		        			        url:reqUrl, 
		        			        //sortName: 'code', 
		        			        //sortOrder: 'desc', 
		        			        remoteSort:false,  
		        			        pageSize: 15,//每页显示的记录条数，默认为10 
		        			        pageList: [15,30,45],//可以设置每页记录条数的列表
		        			        idField:'departId', 
		        			        singleSelect:true,//是否单选 
		        			        pagination:true,//分页控件 
		        			        rownumbers:true,//行号 
		        					 columns:[s],
		        	        onClickRow: function(index, data) {
		        	        } ,
		        	        toolbar: [{ 
		        	            text: '添加', 
		        	            iconCls: 'icon-add', 
		        	            handler: function() {
		        	            	var userId = $("#userId").val();
		        	            	var row = $('#listId').datagrid('getSelected');
		        	            	if(row==null){
		        	            		return;
		        	            	}
		        	            	var isHas = true;
	        	            		for (var i = 0; i < roleId.length; i++) {
										if(row.departId==roleId[i]){
											isHas = false;
											break;
										}
									}
	        	            		if(isHas){
			        	            	var data = {userId:userId,roleId:row.departId};
			        	            	$.ajax({ url: "../../../manager/loginIn/SysUserRole/addUserRoleInfo.do",method:"POST", data: data, success: function(){
			        	                    alert("设置成功");
			        	                    query();
			        	                    $('#listId').datagrid('reload');
			        	                   }});
			        	            	
	        	            			}else{
	        	            				alert("已设置，请选择其他角色进行设置。");
	        	            			} 
		        	            	}
		        	         
		        	        },{
		        	        	text: '删除', 
		        	            iconCls: 'icon-remove', 
		        	            handler: function() {
		        	            	var userId = $("#userId").val();
		        	            	var row = $('#listId').datagrid('getSelected');
		        	            	if(row!=null){
		        	            		var isHas = false;
		        	            		 for (var i = 0; i < roleId.length; i++) {
												if(row.departId==roleId[i]){
													isHas = true;
													break;
												}
											}
		        	            		if(isHas){
				        	            	var data = {userId:userId,roleId:row.departId}
				        	            	$.ajax({ url: "../../../manager/loginIn/SysUserRole/delete.do",method:"POST", data: data, success: function(){
				        	                    alert("已删除成功。");
				        	                    query();
				        	                    $('#listId').datagrid('reload');
				        	                   }});
		        	            	
		        	            		}else{
		        	            			alert("请选择已拥有的角色信息。");
		        	            		}
		        	            	}else{
		        	            		alert("请选择已拥有的角色信息。");
		        	            	}
		        	            	
		        	            } 
		        	         
		        	        }]
		        	    });	
		        				//设置分页控件 
		        			    var p = $('#listId').datagrid('getPager'); 
		        			    $(p).pagination({ 
		        			        method : 'POST',
		        			        loading:true,
		        			        beforePageText: '第',//页数文本框前显示的汉字 
		        			        afterPageText: '页    共 {pages} 页', 
		        			        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		        			        onBeforeRefresh:function(){
		        			            $(this).pagination('loading');
		        			            alert('before refresh');
		        			            $(this).pagination('loaded');
		        			        },
		        			        onRefresh:function(){
		        			        	   $(this).pagination('loading');
		        				            alert('before onRefresh');
		        				            $(this).pagination('loaded');
		        			        	
		        			        }
		        			    });  
		        			    $(p).pagination('loading');
		        	});
	        }else{
	        }
	    }
	});	
 	$('#sysdepartInfoId').tree({
	    onClick: function(node){
	    	var text=node.text;
	    	var id =node.id;
	    	if(id.length==9){
	    		 
	    		$("#unitId").val(id);
	    		$("#unitName").val(text);
	    		
	    		$("#departId").val("");
	    		$("#departName").val("");
	    		
		 		$("#teamId").val("");
		 		$("#teamName").val("");
	    		$("#depart").text(text);
	    		
	    	}else if(id.length==15){
	    		//部门
	    		 var pnode = $('#sysdepartInfoId').tree('getParent', node.target);
	    		 var ppnode = $('#sysdepartInfoId').tree('getParent', pnode.target);
	    		
	    		$("#unitId").val(ppnode.id);
	    		$("#unitName").val(ppnode.text);
	    		
	    		$("#departId").val(id);
	    		$("#departName").val(text);
	    		
		 		$("#teamId").val("");
		 		$("#teamName").val("");
	    		$("#depart").text(ppnode.text+"-"+text);
	    		
	    	}else if(id.length==21){
		   		 var pnode = $('#sysdepartInfoId').tree('getParent', node.target);
		   		 var ppnode = $('#sysdepartInfoId').tree('getParent', pnode.target);
		   		 
		 		$("#departId").val(ppnode.id);
		 		$("#departName").val(ppnode.text);
		 		
		 		  pnode = $('#sysdepartInfoId').tree('getParent', ppnode.target);
		   		   ppnode = $('#sysdepartInfoId').tree('getParent', pnode.target);
		 		
		 		$("#unitId").val(ppnode.id);
				$("#unitName").val(ppnode.text);
		 		
		 		$("#teamId").val(id);
		 		$("#teamName").val(text);
		 		$("#depart").text(ppnode.text+"-"+$("#departName").val()+"-"+text);
	 		
	 	}
	    }
	});	
});
