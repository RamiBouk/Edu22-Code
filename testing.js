let arr=[1,2,3,4,5]
arr.forEach((e,i,a)=>a=[1])
console.log(arr)

arr.forEach((e,i,a)=>a.push(0))
console.log(arr)
