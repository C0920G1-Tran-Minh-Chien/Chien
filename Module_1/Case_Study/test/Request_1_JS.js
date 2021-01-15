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


//Hàm lấy thông tin xuống hồ sơ

function input() {
    document.getElementById('displayName').innerText = name.value;
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
//Đẩy thoogn tin từ Hồ sơ len trên
function edit() {
    let tempName = document.getElementById('displayName').textContent;
    name.value = tempName;
    let tempCmnd = document.getElementById('displayCmnd').textContent;
    cmnd.value = tempCmnd;
    let tempEmail = document.getElementById('displayEmail').textContent;
    email.value = tempEmail;
    let tempBirthDate = document.getElementById('displayBirthDate').textContent;
    birthDate.value = tempBirthDate;
    let tempAddress = document.getElementById('displayAddress').textContent;
    address.value = tempAddress;
    let tempCustomer = document.getElementById('displayCustomer').textContent;
    customer.value = tempCustomer;
    let tempDiscount = document.getElementById('displayDiscount').textContent;
    discount.value = tempDiscount;
    let tempAmount = document.getElementById('displayAmount').textContent;
    amount.value = tempAmount;
    let tempRentDays = document.getElementById('displayRentDays').textContent;
    rentDays.value = tempRentDays;
    let tempService = document.getElementById('displayService').textContent;
    service.value = tempService;
    let tempRoom = document.getElementById('displayRoom').textContent;
    room.value = tempRoom;
}


