




// function dataOne(){
//     console.log("data 1");
    
// }
// setTimeout(dataOne,dataTwo,dataThree,3000)


// function dataTwo(){
//     console.log("data 2");
    
// }
// setTimeout(dataTwo,6000)


// function dataThree(){
//     console.log("data 3");
    
// }
// setTimeout(dataThree,9000)

// let arrowExe = ()=>{
//  function dataOne(){
//     console.log("data 1");
// } 
//dataOne();
// function datafive(){
//    for (let index = 0; index < 11; index++) {
//    console.log("hello");
   
    
//    }
// } 
//datafive();

// }
//setTimeout(arrowExe,10000)

function greet(name, callback) {
  console.log("Hi, " + name);
  callback();
}

function sayBye() {
  console.log("Bye!");
}

//greet("Yashraj", sayBye);



// const PromiseOne = new Promise((resolve,reject)=>{

// })
for (let index = 0; index < 1000; index++) {
    setTimeout(() => {
        console.log("hello");
    }, 1 * index);
}
