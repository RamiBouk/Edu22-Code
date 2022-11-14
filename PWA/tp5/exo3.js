console.log("Program started")

let p1 =new Promise((accept,reject)=>{
	setTimeout(()=>
		accept()
		,3*1000);
})

console.log(p1)

p1.then((r)=>{
	console.log("step1 complete")
	 return new Promise((accept,reject)=>{
		 setTimeout(()=>{
		 accept(1)},3*1000)
	})})
	.then((r)=>
		 console.log('step 2 complete'))

