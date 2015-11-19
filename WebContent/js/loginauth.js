function auth(){
var uid=document.login.uid.value;
var pass=document.login.pass.value;
if(uid==""){
	alert("Please enter User ID");
	document.login.uid.focus();
	return false;
}
else if(pass==""){
	alert("Please enter Password");
	document.login.pass.focus();
	return false;
}
else{
	return true;
}

}