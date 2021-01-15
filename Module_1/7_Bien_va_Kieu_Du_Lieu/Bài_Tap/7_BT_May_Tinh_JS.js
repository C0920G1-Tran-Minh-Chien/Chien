
function display(value){
    if (value === "="){
        document.getElementById("hangTren").innerText = document.getElementById("hangDuoi").value;
        document.getElementById("hangDuoi").value = eval(document.getElementById("hangDuoi").value);
    }else {
        document.getElementById("hangDuoi").value +=value;
    }
}
//xóa dữ liệu
// let clear = document.getElementById("c");
// clear.addEventListener("click", clear1);
function clear1() {
    document.getElementById("hangDuoi").value = "";
}

