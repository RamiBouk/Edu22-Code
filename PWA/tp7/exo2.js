let fetchFast=()=> new Promise((resolve,reject)=>
	setTimeout(()=>resolve('Fast Done!'),5000))

let fetchSlow=()=> new Promise((resolve,reject)=>
	setTimeout(()=>resolve('Slow Done!'),6000))

let waitData= async ()=>{
	
	console.log(await Promise.all(
		[fetchSlow(),fetchFast()]
	));}
if(true){
	console.log("Program1 starting");
	waitData()
	console.log("program1 comlete!");
}
// take the sum of both
// solution
else{
	let waitDataFast= async ()=>{
		console.log(await fetchSlow());}
	let waitDataSlow= async ()=>{
		console.log(await fetchFast());}

	console.log("Program1 starting");
	waitDataFast()
	waitDataSlow()

}
