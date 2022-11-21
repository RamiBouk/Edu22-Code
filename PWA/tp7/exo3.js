let goGetCandies=()=> new Promise((resolve,reject)=>
setTimeout(() => {

	resolve({candy:'sourkeys',quanity:10});
},2000 ))

let sellCandies=(candies)=> new Promise((resolve,reject)=>

setTimeout(() => {
	resolve(25*candies.quanity);
},2000 ))

let main=async ()=>{
	console.log("getting candies");
	let candies =await goGetCandies()

	console.log("selling candies");
	let result=await sellCandies(candies)

	console.log(`\n Sold ${candies.quanity} of ${candies.candy} for ${result}`);
}
main()

