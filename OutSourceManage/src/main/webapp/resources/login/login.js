$(document).ready(function() { 
	
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

        var errorCount = 0;

        form.on('submit(login)', function (data) {
			 
        	$.post('manager/loginIn/SysUserInfo/query.do',$('#loginFrm').serialize(),function(res){
        		 if(res.code=="LOGIN_0000"){
 	       			window.location.href = "page/index.html";
 	       			return;
 	       		}else{
	 	       		layer.alert(res.msg, {
	 	       	    skin: 'layui-layer-lan'
	 	       	    ,closeBtn: 0
	 	       	    ,anim: 4 //动画类型
	 	       		});
 	       			return;
 	       		}
        		});
        	
        	return false;
        });

    });
	
	
}); 


		
	
 
