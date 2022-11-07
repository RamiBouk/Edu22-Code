async function inOrder(f1,f2){
	await new promise((f2)=>{
		f1()
		f2()
	})
	f2()
}

function logOne(){
	setTimeout(function(){
	console.log("one!")
	},Math.random()*1000)}

function logTwo(){
	setTimeout(function() {
		console.log("two")
	}, Math.random()*1000)
}
inOrder(logOne,logTwo)

