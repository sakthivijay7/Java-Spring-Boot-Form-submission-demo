
function submituser(){
let name =document.getElementById("name").value;
let id=document.getElementById("id").value;
let age=document.getElementById("age").value;
let phone=document.getElementById("phone").value;


try{
 
    // post to the springboot
fetch("http://localhost:8080/home",{
    method:"POST",
    headers:{
        "Content-Type":"application/json"
        },

    // json format :left and right variable of js
    body:JSON.stringify({name,id,age,phone })
}) .then(response => response.text())

    .then(data =>{
        document.getElementById("userinfo").innerHTML=data;

    })
}
catch(error){
    document.getElementById("userinfo").innerText="Error in data fetching";
}

}



    
   

