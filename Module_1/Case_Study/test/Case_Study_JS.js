let name = document.getElementById('name');
let cmnd = document.getElementById('cmnd');
let email = document.getElementById('email');
let birthDate = document.getElementById('birthDate');
let address = document.getElementById('address');
let customer = document.getElementById('customer');
let discount = document.getElementById('discount');
let amount = document.getElementById('amount');
let rentDays = document.getElementById('rentDays');
let service = document.getElementById('service');
let room = document.getElementById('room');
let check1 = true ;
let displayName = document.getElementById('displayName');
let displayCmnd = document.getElementById('displayCmnd');
let displayEmail = document.getElementById('displayEmail');
let displayBirthDate = document.getElementById('displayBirthDate');
let displayAddress = document.getElementById('displayAddress');
let displayCustomer = document.getElementById('displayCustomer');
let displayDiscount = document.getElementById('displayDiscount');
let displayAmount = document.getElementById('displayAmount');
let displayRentDays = document.getElementById('displayRentDays');
let displayService = document.getElementById('displayService');
let displayRoom = document.getElementById('displayRoom');
//Hàm lấy thông tin xuống hồ sơ
function enter() {
    // document.getElementById('displayName').innerText = name.value;
    document.getElementById('displayCmnd').innerText = cmnd.value;
    document.getElementById('displayEmail').innerText = email.value;
    document.getElementById('displayBirthDate').innerText = birthDate.value;
    document.getElementById('displayAddress').innerText = address.value;
    document.getElementById('displayCustomer').innerText = customer.value;
    document.getElementById('displayDiscount').innerText = discount.value;
    document.getElementById('displayAmount').innerText = amount.value;
    document.getElementById('displayRentDays').innerText = rentDays.value;
    document.getElementById('displayService').innerText = service.value;
    document.getElementById('displayRoom').innerText = room.value;
    //Tính Tiền phải trả
    let discountUp = parseInt(discount.value);
    let rentDay = parseInt(rentDays.value);
    let cost;
    switch (service.value) {
        case "Villa" :
            cost = 500 * rentDay * (1 - discountUp / 100 ) + linkAddress() + linkCustomer() + linkRentDays();
            break;
        case "House" :
            cost = 300 * rentDay * (1 - discountUp / 100 )+ linkAddress() + linkCustomer()+ linkRentDays();
            break;
        case "Room" :
            cost = 100 * rentDay * (1 - discountUp / 100 )+ linkAddress() + linkCustomer()+ linkRentDays();
            break;
    }
    document.getElementById('displayCost').innerHTML = cost;
}
//Giảm giá từ Địa Chỉ.
function linkAddress() {
    let discountAddress;
    switch (address.value) {
        case "Đà Nẵng" :
            discountAddress = - 20 ;
            break;
        case "Huế" :
            discountAddress = - 10;
            break;
        case "Quảng Nam" :
            discountAddress = - 5;
            break;
        default :
            discountAddress = 0;
    }
    return discountAddress;
}
//Giảm giá từ Loại Khách Hàng
function linkCustomer() {
    let discountCustomer;
    switch (customer.value) {
        case "Diamond" :
            discountCustomer = - 15 ;
            break;
        case "Platium" :
            discountCustomer = - 10;
            break;
        case "Gold" :
            discountCustomer = - 5;
            break;
        case "Silver" :
            discountCustomer = - 2;
            break;
        default :
            discountCustomer = 0;
    }
    return discountCustomer;
}
//Giảm giá từ Ngày Thuê
function linkRentDays() {
    let discountRentDays ;
    if (rentDays.value > 7 ){
        discountRentDays = -30;
    } else if (rentDays.value >5){
        discountRentDays = -20;
    } else if (rentDays.value >2){
        discountRentDays = -10;
    } else {
        discountRentDays = 0;
    }
    return discountRentDays;
}

// Tạo mảng lưu thông tin khách hàng.
let products = ["abc","áds"];
//THêm dữ liệu
function add() {
    products.push(name.value);
    show();
    name.value = "";
    name.focus();
}
//Xóa dữ liẹu
function remove(index) {
    products = products.filter(function(e, i) {
        return i !== index;
    });
    show();
}
//Cập nhật dữ liệu
function update(index) {
    products[index] = document.getElementById("edit").value;
    document.getElementById("formEdit").innerHTML = "";
    show();
}
//Hiển thị edit dữ liệu
function showEdit(index) {
    document.getElementById("formEdit").innerHTML = `
          <input id="edit" type="text" name="" value='${products[index]}'>
          <button onclick="update(${index});">Update</button>
          `;
    document.getElementById("edit").focus();
}
// hiển thị dữ liệu
function show() {
    let tableProduct = "<table>";
    for (let i = 0; i < products.length; i++) {
        tableProduct += `
          <tr>
            <td>${products[i]}</td>
            <td><button onclick='showEdit(${i});'>Edit</button></td>
            <td><button onclick='remove(${i});'>Delete</button></td>
          </tr>
          `;
    }
    tableProduct += "</table>";
    document.getElementById("displayName").innerHTML = tableProduct;
}
show();





// Kiểm tra định dạng input
// function checkInput() {
//     let filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
//     //nếu email sai định dạng thì báo lỗi
//     if (!filter.test(displayEmail)) {
//         document.getElementById("errorEmail").innerText = "Please provide a valid email address";
//         email.focus;
//     }
//     // nếu cmnd sai định dạng thì báo lỗi
//         if(!isNaN(cmnd.value)){
//             cmnd.value = Number.parseFloat(cmnd.value)
//         }
//         if (!Number.isInteger(cmnd.value)){
//             document.getElementById("errorCmnd").innerText = "Please";
//         } if (cmnd.value < 10000000 || cmnd.value > 99999999){
//             document.getElementById("errorCmnd").innerText = "Please";
//         }
// }