

function changediv1(){

    var home = document.getElementById('home');
    var insertdata = document.getElementById('insertData');
    var salesData = document.getElementById('SalesData');
	//var last = 0;  

    if(salesData.style.display=="block" || insertdata.style.display=="block"){
	salesData.style.display="none";
	insertdata.style.display="none";
	home.style.display="block";
}
}

function changediv2(){
     var home = document.getElementById('home');
    var insertdata = document.getElementById('insertData');
    var salesData = document.getElementById('SalesData');
  
    if(home.style.display=="block" || salesData.style.display=="block"){
	home.style.display="none";
	salesData.style.display="none";
	insertdata.style.display="block";

		
}
}

function changediv3(){
	 var home = document.getElementById('home');
    var insertdata = document.getElementById('insertData');
    var salesData = document.getElementById('SalesData');
     if(home.style.display=="block" || insertdata.style.display=="block"){
	home.style.display="none";
	insertdata.style.display="none";
	salesData.style.display="block";
}
}
// }

function logout(){
	window.location.href=("login.html");
}