let func = function(callback){
	setTimeout(() => {
		callback("ehy");
	}, 5000)
}
func(console.log)

