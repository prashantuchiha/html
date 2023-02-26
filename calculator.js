function dis(val){
    document.getElementById("input").value+=val
}
function clr(){
    document.getElementById("input").value=""
}
function solve(){
    let x=document.getElementById("input").value
    let y=eval(x)
    document.getElementById("input").value=y
}