$(document).ready(function() { 
	var media=window.location.search.indexOf("media=client");
	if(media>0){
		window.localStorage.setItem("media","client");
	}
	layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
			$ = layui.jquery,
			form = layui.form();

        form.verify({
            userName: function (value) {
                if (value === '')
                    return '请输入用户名';
            },
            password: function (value) {
                if (value === '')
                    return '请输入密码';
            }
        });

        var isopen =true;
        form.on('submit(login)', function (data) {
        	$.post(base.serverContent+'/manager/loginIn/SysUserInfo/login.do',$('#loginFrm').serialize(),function(res){
        		 if(res.code=="LOGIN_0000"){
 	       			window.location.href = "backstage/index.html";
 	       			return;
 	       		 }else{
	 	       		booo =true;
	 	       		layer.open({
	 	       		  content: '用户名密码错误'
	 	       		  ,btn: ['确定']
	 	       		  ,yes: function(index, layero){
	 	       		    //按钮【按钮一】的回调
	 	       			isopen =false;
	 	       			layer.close(index);
	 	       		  }
	 	       		  ,cancel: function(){ 
	 	       			
	 	       			isopen =false;
	 	       		    //return false 开启该代码可禁止点击该按钮关闭
	 	       		  }
	 	       		});
	 	         return;
 	       		}
        		});
        	
        	return false;
        });
        
        $(document).on("keydown",function(e){
        	 
        	if(e.keyCode==13&&isopen){
        		
        		$.post(base.serverContent+'/manager/loginIn/SysUserInfo/login.do',$('#loginFrm').serialize(),function(res){
           		 if(res.code=="LOGIN_0000"){
    	       			window.location.href = "backstage/index.html";
    	       			return;
    	       		 }else{
   	 	       		booo =true;
   	 	       		layer.open({
   	 	       		  content: '用户名密码错误'
   	 	       		  ,btn: ['确定']
   	 	       		  ,yes: function(index, layero){
   	 	       		    //按钮【按钮一】的回调
   	 	       			isopen =false;
   	 	       			layer.close(index);
   	 	       		  }
   	 	       		  ,cancel: function(){ 
   	 	       			
   	 	       			isopen =false;
   	 	       		    //return false 开启该代码可禁止点击该按钮关闭
   	 	       		  }
   	 	       		});
   	 	         return;
    	       		}
           		});
        		
        		
        		return false;
        	}
        });

    });
	
	
}); 


		
	
 
