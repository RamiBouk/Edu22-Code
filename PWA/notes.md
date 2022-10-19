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

# document object model DOM
it's an interface of the html page for example (APi). it allows to
access access to the html code.

The web page is translated to a tree.

the mos timportant object on dom si node
## Accessing the DOM
1. get element using an id

```
const p = document.getElementById('elementId');
```
2. using the html element tag.
```
const p1=document.getElementByTagName();
//this returns an HTML collection
```
2. the querySelector(CSS)
```
var e =doument.querySeletor('*') //all element of all types
var e =doument.querySeletor('h1') //first h1 element
var e =doument.querySeletor('div>p') // first child of div of type p
var e =document.queryselecor('.myclass') // select his class
var e =document.queryselecor('[href]') // select node with the attr href 
var e =document.querySelectorAll('') // 
```
## Navigation between DOM Nodes

you cuaes use `` first[Element]Child ``  or ``second[Element]Child``
or ``childNodes``

chekc more attributes for node in course`
