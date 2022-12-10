## Arrays
```
// Defining
let arr=new Array(1,2,3,4,5)
let arr=[1,2,3]

// Remove
arr.pop()
arr.shift()

// Add
arr.push(5)
arr.unshift(5)

// Methodes
arr.forEach(function (element,_index,__array){...},thisArg)
arr.filter(function (element,_index,__array){...],thisArg)
new_arr=arr.map(function (elment,_index,__array){...},thisArg)

// Closures
let mutliby=function(a){
return (b)=>(a*b)}

```

## DOM
API for accessing the HTML tree.
```
e = document.getElementById('elementId');

arr=Array.from(<collection>document.getElementByTagName('div'));

e=documnet.querySelector('css_selector');
arr=documnet.querySelectorAll('css_selector');
css_selector={*, e, e.e, e.class, e>e,e e , #id, .class, [att],''}

```
## navigating between dom node
```
p.first[Element]Child.nodeName
p.last[Element]Child.nodeName
p.parentNode
p.previousSibling
p.nextSibling

if(p.hasChildNodes) let children=p.childNodes
if(p.hasChildNodes) let children=p.children

nodeType: 
	1:element
	2:text
	3:comment
	4:document
	5:document type

p.innerHTML='new content'
console.log(p.textContent)
```
## creating and inserting elements
```
let newE=document.createElement('h1')

newE.id='MyId'
newE.setAttribute('color','red')

document.querySelector('body').appendChild(newE)

```

## Events 
### DOM-0
```
elem.onclick = ()=>{...}
```
can't assign multiple ones
### DOM-2
```
elem.addEventListener(event,handler[,phase])
elem.removeEventListener(event,handler[,phase])

event: {click,load,change,mouseover,keypress}
handler: function
phase: when going down or up
```

### This

refrences the current elemnt
### Event object
```
elem.onclick=functino(event){
alert(event.type+"event func at"+event.target)
alert(event.type+"clicker on"+event.currentTarget)
alert("Cooredinates"+event.clientX+":"+event.clientY)

//onkeydown
alert(e.keyCode)
```






