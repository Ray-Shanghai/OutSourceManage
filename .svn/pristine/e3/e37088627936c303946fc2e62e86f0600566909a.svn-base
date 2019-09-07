$(document).ready(function() { 
	$.ajax({
		url : base.serverContet+'/manager/loginIn/SysUserInfo/getCurrentUserMenu.do',
		type : 'post',
		async: false,//使用同步的方式,true为异步方式
		data : "",//这里使用json对象
		success : function(data){
			window.meuns=data.functionMap;
			window.userName=data.userName;
		},
		fail:function(data){
			alert(res);
		}
		});
	
	
	
	BUI.use('common/main',function(){
		$("#userName").text(window.userName);
	      var config = [{
	          id:'menu', 
	          homePage : 'code',
	          menu:window.meuns["2"]
	          },{
	            id:'sysManager',
	            menu:window.meuns["1"]
	            	
	          },{
	              id:'search',
	              menu:[{
	                  text:'请假单审核',
	                  items:[
	                    {id:'code',text:'请假单待审核列表',href:'search/code.html'},
	                    {id:'example',text:'请假单已审核列表',href:'search/example.html'}
	                  ]
	                },{
	                  text : '合同审核',
	                  items : [
	                    {id : 'tab',text : '使用tab过滤',href : 'search/tab.html'}
	                  ]
	                }]
	            },{
	            id : 'chart',
	            menu : [{
	              text : '报表、图表',
	              items:[
	                  {id:'code',text:'引入代码',href:'chart/code.html'},
	                  {id:'line',text:'折线图',href:'chart/line.html'},
	                  {id:'area',text:'区域图',href:'chart/area.html'},
	                  {id:'column',text:'柱状图',href:'chart/column.html'},
	                  {id:'pie',text:'饼图',href:'chart/pie.html'}, 
	                  {id:'radar',text:'雷达图',href:'chart/radar.html'}
	              ]
	            }]
	          }];
	      new PageUtil.MainPage({
	        modulesConfig : config
	      });
	    });
	
	 
	
	
}); 


		
	
 
