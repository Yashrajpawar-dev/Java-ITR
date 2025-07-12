



let hello = ()=>{
   const name = 'dharmaraj Thorat';
   for (let index = 0; index < 5; index++) {
  console.log(name);
    
   }
  
}; 
// hello();


let pattern = ()=>{
    for (let index = 0; index < 5; index++) {
     console.log(" ");
     
        for(let j = 0 ; j < index;j++){
            console.log("*")
        }
        console.log();
    }
}
 //pattern();

 const button = document.querySelector('#button')
 let CurrentMode = 'white'

 button.addEventListener("click",function(e){
if(CurrentMode === 'white'){
    document.body.style.backgroundColor = 'black'
    CurrentMode = 'black'
}else if(CurrentMode === 'black') {
   document.body.style.backgroundColor = 'white'  
    CurrentMode = 'white'
}
 })