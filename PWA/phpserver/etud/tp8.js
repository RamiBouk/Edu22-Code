let b=document.getElementById("mybut")
function search(){
	var input= parseInt(document.getElementById('searchTxt').value)
	var xhr=new XMLHttpRequest()
	let url ="tp8serverGet.php?KeyId="+input
	xhr.onreadystatechange=function(){
		console.log("status: "+this.readyState)
		if(this.readyState==4)
			if(this.status==200)
				console.log("response "+this.responseText)
	}
	xhr.open('GET',url ,true)
	xhr.send();

}
b.addEventListener('click',search )


