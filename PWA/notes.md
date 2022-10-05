## function callback
when you use a function is used as a parameter for another function
we use callback in jQuery
## arrays in js 
1. can hold mixed values
2. dynamic size

you can define an array in two different ways 
```
let scores = nwee Array(9,10,8,7,6);
//or 
let scores=[1,3,4]
```

use the property length
### adding an element
add to the end and return the new length

```
scores.push(5);
```

add to the start:
```
scores.unshift();
```
### Removing elements
remove at the end:
```
poped=scores.pop()
````
remove at the start:
```
shifted=scores.shift();
```


## the map method
invoces a function over each element in the list and returns a new list

Note:

Does not effect the original list

```
// adding 1 to each element
f=(i)=>i+1;
scores.map(f)
```
## the forEach function
works like map but does not return a function

has three parameters (currentValuem index , arr)
```
scores.forEach(console.log);
```

## the filter() function
return an array where the condition in the filter is correct
``` 
scores.filter((i)=>i>5);
```

## Closures: [EXTREMLY IMPORTANT]

 a function that is returned from a function can use the context of the
 original function as well
 ```
 function f(x){
 return function g(y){
 reutrn x+y;}}
 g1=f(1)
 g2=f(2)

 console.log(g1(5))// prints 6
 console.log(g2(5))//  prints 7 becuase it keeps x=2 in the context of
 the function
 ```
 make a unique id generator as an exercise.


