
 function login(){

 	var usname = document.getElementById("username");
 	var uspwd = document.getElementById("password");

 	if(usname.value == ""){   //验证用户名是否为空
 		window.alert("用户名不能为空！");
 		window.location.reload();
 		
 	}else if( usname.value.length!=5){  //限制用户名长度
 		window.alert("用户名格式错误！");
 		location.reload();

 	}else if(uspwd.value ==""){
 		window.alert("密码不能为空！");
 		location.reload();
 	}
 	else if(uspwd.value.length  != 5){
 		window.alert("请输入5位密码");
 		location.reload();
 	}
 	else
 		window.alert("登录成功！");
 	}
