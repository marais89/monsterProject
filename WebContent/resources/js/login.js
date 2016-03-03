function changeLogin() {
 
  var formSignIn; 
  var formSignUp;
  
  formSignIn = document.getElementById('formSignIn');
  formSignUp = document.getElementById('formSignUp');
 
  if(formSignIn.style.visibily =='hidden') {
 
	  formSignIn.className += "hidden";
	  formSignUp.style.visibility = 'hidden';
 
  } else {
 
	  formSignIn.style.visibility = 'hidden';
	  formSignUp.style.visibility = 'visible';
  }
 
}