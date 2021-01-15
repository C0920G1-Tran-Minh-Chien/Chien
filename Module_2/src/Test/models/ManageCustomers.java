package Test.models;

import Test.common.ReadAndWriteFile;
import Test.validate.Validate;
import Test.view.Main;
import _00.models.Products;

import java.util.ArrayList;
import java.util.List;

public class ManageCustomers {
    public  static final String REGEX_INPUT_DATE = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)\n";
    public  static final String STR_ERROR = "Enter the wrong format, please enter again!";
    public  static final String COMMA = ",";
    private static List<Customers> customersList = new ArrayList<>();
    public static void addNewCustomer(){
            String id = inputId();
            String name = inputName();
            String dateOfBirth = dateOfBirth();
            String gender = gender();
            String phone = phone();
            String address = address();
            Customers customers = new Customers(id,name,dateOfBirth,gender,phone,address);
            customersList.add(customers);
            String line = customers.getIdCustomer() + COMMA + customers.getName() + COMMA + customers.getDateOfBirth()
                    + COMMA + customers.getGender() + COMMA + customers.getPhone() + COMMA + customers.getAddress();
            ReadAndWriteFile.writeFile("src/Test/data/customer.csv", line);
            ManageSavingBook.addNewSavingBook();
    }
    private static String inputId(){
        System.out.println("Nhập Id : ");
        return Main.enter().nextLine();
    }
    private static String inputName(){
        System.out.println("Nhập tên : ");
        return Main.enter().nextLine();
    }

    private static String dateOfBirth(){
        System.out.println("Nhập dateOfBirth : ");
        return Validate.regexStr(Main.enter().nextLine(), REGEX_INPUT_DATE, STR_ERROR);
    }
    private static String gender(){
        System.out.println("Nhập gioi tinh : ");
        return Main.enter().nextLine();
    }
    private static String phone(){
        System.out.println("Nhập number phone : ");
        return Main.enter().nextLine();
    }
    private static String address(){
        System.out.println("Nhập address : ");
        return Main.enter().nextLine();
    }
    public static List<Customers> read() {
        List<String[]> list = _00.common.ReadAndWriteFile.readFile("src/Test/data/customer.csv");
        customersList.clear();
        for (String[] s : list) {
            if (s.length == 0) {
                System.out.println("Empty!");
            } else {
                Customers customers = new Customers(s[0], s[1], s[2], s[3], s[4],
                        s[5]);
                customersList.add(customers);
            }
        }
        return customersList;
    }

    public static void displayCustomer(){
        read();
        System.out.println("-------------------");
        for (Customers customers : customersList){
            customers.showInfor();
        }
    }
}
