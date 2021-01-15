package _18_string_regex.bai_tap.validate_class;

import _18_string_regex.thuc_hanh.validate_email.EmailExample;

public class CheckClassName {
    private static ValidateClass validateClass;
    public static final String[] validEmail = new String[] { "C0912H", "C0sáa912H", "abc@C0912H.com" };
    public static final String[] invalidEmail = new String[] { "C0912L", "M0200H", "@#abc@gmail.com" };

    public static void main(String args[]) {
        validateClass = new ValidateClass();
        for (String email : validEmail) {
            boolean isvalid = validateClass.validate(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = validateClass.validate(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
    }
}
