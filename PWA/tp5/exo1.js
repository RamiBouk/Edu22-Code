console.log("Program started")
let p =new Promise((accept,reject)=>{

	setTimeout(()=>accept(1)
		,3*1000);

	setTimeout(()=>reject(2)
		,2*1000);
})
console.log(`pending: ${p}`)
p.then((r)=>console.log(`Program done ${r}`))
 .catch((e)=>console.log(`Program failed ${e}`))

