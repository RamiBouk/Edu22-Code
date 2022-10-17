function  uniqueIdFunc(){let i=1;return ()=>i++}
uniqueId=uniqueIdFunc()
console.log(uniqueId())
console.log(uniqueId())
console.log(uniqueId())
console.log(uniqueId())
