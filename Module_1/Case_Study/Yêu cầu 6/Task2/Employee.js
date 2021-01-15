
 class Employee {
     constructor(name, cmnd, birthDay, phone, email, level, location, salary) {
         this.name = name;
         this.cmnd = cmnd;
         this.birthDay = birthDay;
         this.phone = phone;
         this.email = email;
         this.level = level;
         this.location = location;
         this.salary = salary ;
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
     setPhone (phone){
          this.phone = phone;
     };
     setEmail (email){
          this.email = email;
     };
     setLevel (level){
          this.level = level;
     };
     setLocation (location){
          this.location = location;
     };
     setSalary (salary) {
         this.salary = salary;
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
     getPhone (){
         return this.phone;
     };
     getEmail (){
         return this.email;
     };
     getLevel (){
         return this.level;
     };
     getLocation (){
         return this.location;
     };
     getSalary(){
         if (this.getLocation() === "Manager"){
                        this.salary = 500 ;
                    } else if (this.getLocation() === "Sale") {
                        this.salary = 300 ;
                    } else if (this.getLocation() === "Marketing"){
                        this.salary = 200 ;
                    }
                    return this.salary ;
     }
 }
 // let Employee1 = new Employee() ;