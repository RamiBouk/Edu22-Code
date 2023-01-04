console.log("hello")
let body=document.getElementsByTagName("body")[0]
let xhr =new XMLHttpRequest();
console.log(`init`);
xhr.addEventListener("readystatechange", function(){
	console.log(`state: ${this.readyState} ${this.status}`);
	if(this.readyState==4){
		console.log(`response: ${this.responseText}`);
	}
})
xhr.open("GET", "./tp8serverGet.php?uid=16")
xhr.send()
