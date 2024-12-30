let card = document.querySelectorAll(".card");
let Submit = document.getElementById("Submit");
let num =0;
document.querySelector(".cartitems").style.display="none"
card.forEach(function(cards){
    cards.addEventListener("click",function(){
        console.log(cards);

        document.querySelector(".cartitems").style.display="block"

        num++;
        document.querySelector("#cartnum").innerHTML=num;
        let div = document.createElement("div");
        div.classList.add("cartList");
        div.innerHTML=`
        <i class="fa-solid fa-xmark" onclick="remove()"></i>
        <img src=${cards.firstElementChild.src}>
            <p>$199</p>
            `
            document.querySelector(".cartitems").appendChild(div)   
         })
})
function remove(){
    num--;
    let cartList = document.querySelectorAll(".cartList");
    cartList.forEach(function(currentItem){
        currentItem.addEventListener("click",function(){
            if(num==0){
                document.querySelector(".cartitems").style.display="none"
            }
            currentItem.style.display = "none"
            document.querySelector("#cartnum").innerHTML=num;
        })
    })
}

//contact
Submit.addEventListener("click",function(){
    let email = document.getElementById("email");
    let pass = document.getElementById("pass");
    if(email.value == "" && pass.value == ""){
        alert("Enter email and password")
    }else{
        alert("Thanks you logged in")
    }

})