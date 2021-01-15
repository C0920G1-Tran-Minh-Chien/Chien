package model;

import java.util.ArrayList;
import java.util.List;

public class DataCustomer {
    public static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("1" , "Chien", "20", "nam")) ;
        customerList.add(new Customer("2" , "The", "20", "nam")) ;
        customerList.add(new Customer("3" , "Anh", "20", "nam")) ;
        customerList.add(new Customer("4" , "Phuc", "20", "nam")) ;
    }

    public static List<Customer> getCustomerList(){
        return customerList;
    }
}
