# function callback
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
3. the querySelector(CSS)
```
var e =document.querySelector('*') //all element of all types
var e =document.querySelector('h1') //first h1 element
var e =document.querySelector('div>p') // first child of div of type p
var e =document.queryselecor('.myclass') // select his class
var e =document.queryselecor('[href]') // select node with the attr href 
var e =document.querySelectorAll('') // 
```
## Navigation between DOM Nodes

You causes use `` first[Element]Child ``  or ``second[Element]Child`` or
or ``childNodes``...

Check more attributes for node in course

## types of DOM Nodes
the tree consist of different types of nodes.

every node has ``nodeType``

_write the table here_

## Changing HTML content
the easiest way is use the innerHTML property
```
element.innerHTML="new text"
```
## Creer et inserer des elements (important)

1. create element
```
var element =document.createElement('div')
```
2. effect attributs to it 
```
element.id="myId";
//or
element.setAttribute('id',`myId');
```
3. add the node to the document
```
var p=document.querySelector('.id');
p.appendChild(element);
```
## EVENTS
```
<input type="button" onclick="console.log('clicked')"/>
or 
<input type="button" id="button"/>
.
.
.
<script>
button.onclick=func
</script>
```
dom o doesn't allow assiging two listeners at once
dom-2 allows that using `.addEentListener(event,handler{,phase})` and
`.removeEvenListener` which you have to use the same name of the
fucntion to use but other than that they have the same parameters.
lm
- event: string of the event like "click", "load", "mousesover".
- handler: the js function that is executed each time the event happens. 
- phase: a boolean by default false permet de gerer le sens de
		propagation de l'evenment. important quend les elements sont
		imbriqus

### this
This is used to refernce the element inside the handler of the event
### l\'objet event
gives information about the event that triggered the function
like:

- `type`: "focus"/"load"/etc
- `currentTarget`: the element that has the event listener. 
- `clientX`, `clientY`: get the x and y position of mouse 
- `target`: the element that triggered the event
- `keyCode`: get's the code of the key pressed.


## JSON
1. Ensemble nom, valeur
2. Can create a table with`[ ]`

- JSON.parse(txt)
- JSON.stringify(object)

## Synchronous and asynchronous in JS
- Concurrency: multiple tasks t the same time but no simultaneously
- Prallelism: multiple taks simultaneously
- synchronous programming: tasks one after the other
- Asynchronous programming: one task can execute while the other one
	pauses 
## Asynchronous in JS	
- from call stack to webapi
- from webapi to callback queue
- the event loop checks the call stack if empty check callback queue


