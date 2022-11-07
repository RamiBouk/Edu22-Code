let x='[{"type":"dog","age":3},{"type":"cat","age":2}]'
let y='{"animals":[{"type":"dog","age":3},{"type":"cat","age":2}]}'
	// obj must be in the form key/value
let obj=JSON.parse(x)
console.log(obj)
console.log("Using X:");
obj.forEach(element => {
	console.log(`Type: ${element.type}, Age:${element.age}`)
	
});

obj=JSON.parse(y)
console.log("using y");
obj.animals.forEach(element => {
	console.log(`Type: ${element.type}, Age:${element.age}`)
	
});
