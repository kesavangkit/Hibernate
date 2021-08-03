/**
 * 
 */
function register(){
	document.getElementById("errorDiv").style.display = "none";
	document.getElementById("resultDiv").style.display = "none";
	document.getElementById("registerDiv").style.display = "block";
	document.getElementById("errorDiv").style.display = "none";
	document.getElementById("searchDiv").style.display = "none";
	document.getElementById("action").value="register";
}

function search(){
	document.getElementById("searchDiv").style.display = "block";
	document.getElementById("resultDiv").style.display = "none";
	document.getElementById("errorDiv").style.display = "none";
	document.getElementById("registerDiv").style.display = "none";
	document.getElementById("action").value="search";
}

function result(){
	document.getElementById("searchDiv").style.display = "none";
	document.getElementById("registerDiv").style.display = "none";
	if(document.getElementById("errorMsg").value == 'enable'){
		document.getElementById("errorDiv").style.display = "block";
	}else{
		document.getElementById("errorDiv").style.display = "none";
	}
	if(document.getElementById("resultDiv").value == 'enable'){
		document.getElementById("resultDiv").style.display = "block";
	}else{
		document.getElementById("resultDiv").style.display = "none";
	}
}

function reset(){
	document.getElementById("searchDiv").style.display = "none";
	document.getElementById("registerDiv").style.display = "none";
	if(document.getElementById("errorMsg") != null){
		if(document.getElementById("errorMsg").value == 'enable'){
			document.getElementById("errorDiv").style.display = "block";
		}else{
			document.getElementById("errorDiv").style.display = "none";
		}
	}else{
		document.getElementById("errorDiv").style.display = "none";
	}
	if(document.getElementById("resultMsg") != null){
		if(document.getElementById("resultMsg").value == 'enable'){
			document.getElementById("resultDiv").style.display = "block";
		}else{
			document.getElementById("resultDiv").style.display = "none";
		}
	}else{
		document.getElementById("resultDiv").style.display = "none";
	}
}