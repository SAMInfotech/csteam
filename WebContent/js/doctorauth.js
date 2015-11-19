function auth(){
	var uid=document.patient.uid.value;
	var pass=document.patient.pass.value;
	var name=document.patient.name.value;
	var address=document.patient.address.value;
	var dob=document.patient.dob.value;
	var gender=document.patient.gender.value;
		
	var errorMessage="";
	if(uid==""){
		errorMessage +="please enter username \n";
	}
	 if(pass==""){
		errorMessage +="please enter password \n";
	}
	 if(name==""){
			errorMessage +="please enter name \n";
		}
	 if(address==""){
			errorMessage +="please enter address \n";
		}
	 if(dob==""){
			errorMessage +="please enter dob \n";
		}
	 if(gender==false){
			errorMessage +="please select gender \n";
		}
	 
if(errorMessage!="")
	{
		alert(errorMessage);
		return false;
	}
}
