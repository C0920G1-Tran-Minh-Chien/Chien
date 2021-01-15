
class Customer {
    constructor(name, cmnd, birthDay, address, email, typeService, typeRoom, typeCustomer, discount, amount, rentDays, totalPays) {
        this.name = name;
        this.cmnd = cmnd;
        this.birthDay = birthDay;
        this.address = address;
        this.email = email;
        this.typeService = typeService;
        this.typeRoom = typeRoom;
        this.typeCustomer = typeCustomer ;
        this.discount = discount;
        this.amount = amount;
        this.rentDays = rentDays;
        this.totalPays = totalPays ;
    }
    setName (name){
        this.name = name;
    };
    setCmnd (cmnd){
        this.cmnd = cmnd;
    };
    setBirthDay (birthDay){
        this.birthDay = birthDay;
    };
    setAddress (address){
        this.address = address;
    };
    setEmail (email){
        this.email = email;
    };
    setTypeService (typeService){
        this.typeService = typeService;
    };
    setTypeRoom (typeRoom){
        this.typeRoom = typeRoom;
    };
    setTypeCustomer (typeCustomer) {
        this.typeCustomer = typeCustomer;
    };
    setDiscount (discount){
        this.discount = discount;
    };
    setAmount (amount){
        this.amount = amount;
    };
    setRentDays (rentDays){
        this.rentDays = rentDays;
    };
    setTotalPays (totalPays) {
        this.totalPays = totalPays;
    }

    getName (){
        return this.name;
    };
    getCmnd (){
        return this.cmnd;
    };
    getBirthDay (){
        return this.birthDay;
    };
    getAddress (){
        return this.address;
    };
    getEmail (){
        return this.email;
    };
    getTypeService (){
        return this.typeService;
    };
    getTypeRoom (){
        return this.typeRoom;
    };
    getTypeCustomer (){
        return this.typeCustomer;
    };
    getDiscount (){
        return this.discount;
    };
    getRentDays (){
        return this.rentDays;
    };
    getAmount (){
        return this.amount;
    };

    getTotalPays(){
            let money1 = 0 ;
            if (this.getTypeService() === "Villa" ){
                money1 = 500;
            } else if (this.getTypeService() === "House"){
                money1 = 300;
            } else if (this.getTypeService() === "Room"){
                money1 = 100;
            }

            let money2 = 0;
            if (this.getAddress() === "Đà Nẵng" ){
                money2 = 50;
            } else if (this.getAddress() === "Huế"){
                money2 = 30;
            } else if (this.getAddress() === "Quảng Nam"){
                money2 = 10;
            }

            let money3 = 0;
            if (this.getTypeCustomer() === "Diamond" ){
                money3 = 50;
            } else if (this.getTypeService() === "Platium"){
                money3 = 30;
            } else if (this.getTypeService() === "Gold"){
                money3 = 10;
            }

            let money4 = 0;
            if (this.getRentDays() > 7){
                money4 = 50;
            } else if (this.getRentDays() > 5){
                money4 = 30;
            } else if (this.getRentDays() > 2){
                money4 = 10;
            }

            this.totalPays = this.getRentDays()*money1*(1-this.getDiscount()/100)  - money2 - money3 - money4;
            return this.totalPays;
        }
}