package CaseStudy.common;
import CaseStudy.exception.NameException;
import CaseStudy.view.Main;

public class RegexData {
    public static String regexStr(String temp, String regex, String error){
        boolean check = true;
        do {
            if (temp.matches(regex)){
                check = false;
            } else {
                System.out.println(error);
                temp = Main.inputScanner().nextLine();
            }
        } while (check);
        return temp;
    }

    public static String regexCustomer(String temp, String regex){
        boolean check = true;
        do {
            try{
                if (temp.matches(regex)){
                    check = false;
                } else {
                    throw new NameException("Enter the wrong format, please enter again!");
                }
            }catch (NameException e ){
                System.err.println(e.getMessage());
                temp = Main.inputScanner().nextLine();
            }
        } while (check);
        return temp;
    }
}
