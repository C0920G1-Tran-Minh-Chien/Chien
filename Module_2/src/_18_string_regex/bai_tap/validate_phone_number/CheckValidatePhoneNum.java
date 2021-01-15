package _18_string_regex.bai_tap.validate_phone_number;

import _18_string_regex.bai_tap.validate_class.ValidateClass;

import java.util.regex.Pattern;

public class CheckValidatePhoneNum {
    private static ValidatePhoneNumber validatePhoneNumber;
    public static final String[] validEmail = new String[] { "(84)-(0978489648)", "(84)-(0978489648)", "abc@C0912H.com" };
    public static final String[] invalidEmail = new String[] { "(84)-(0978489648)", "(a8)-(22222222)", "(11)-(02222222)", "(1)-(09)" };

    public static void main(String args[]) {
        validatePhoneNumber = new ValidatePhoneNumber();
        for (String email : validEmail) {
            boolean isvalid = validatePhoneNumber.validate(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = validatePhoneNumber.validate(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
//        String[] arrCheck = { "(84)-(0978489648)", "(a8)-(22222222)", "(11)-(02222222)", "(1)-(09)"};
//        String regex = "^[(]\\d{2}[)][-][(][0]\\d{9}[)]$";
//        boolean check;
//        for (String x : arrCheck){
//            check = Pattern.matches(regex, x);
//            System.out.println(check);
//        }
        }
    }
}
