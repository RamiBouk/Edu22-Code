let  response={data:{user:'adem',admin:true}}

const fetchUser=()=>new Promise((resolve,reject)=>{
	setTimeout(()=>reject(new Error("wrong user")),1000)})

const userAdmin=async()=>{
	try {
		let data=await fetchUser()
		console.log("done");
		console.log(JSON.stringify(data.data))
	}
	catch (error) {
		console.log(`\u001b[31m  ${error}\u001b[0m`);
	}}
userAdmin()

