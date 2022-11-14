let count=true
let promise=new Promise(function(resolve,reject){
	// do something
	if(count)
		resolve('{"name":"rami","lastname":"bouk","id":1}')
	else
		reject(0)
})


promise.then((res)=>{
	return res
}).then((r)=>{
	let obj=JSON.parse(r)
	console.log(obj.name);
	})
