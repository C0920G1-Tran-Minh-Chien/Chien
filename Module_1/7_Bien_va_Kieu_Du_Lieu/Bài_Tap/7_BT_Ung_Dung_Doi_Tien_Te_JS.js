
function doiTien(){

let input = document.getElementById("amount").value;
let from = document.getElementById("fromCurrency").value;
let to = document.getElementById("toCurrency").value;
let tranfres;
let same = parseInt(input);
//Loại tiền tự trùng nhau
if (from === to){
    tranfres = same
};
//CHuyển từ tiền VN->USD
if (from === "VietNam" && to === "USD"){
    tranfres = input/23000;
};
//CHuyển từ tiền USD->VN
if (from === "USD" && to === "VietNam"){
    tranfres = 23000*input;
};

alert("Đổi " + input + " tiền từ " + from + " sang " + to + " là " +tranfres);
};

// function myFunction() {
//