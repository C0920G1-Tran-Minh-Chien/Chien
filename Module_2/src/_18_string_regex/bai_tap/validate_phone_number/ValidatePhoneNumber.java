package _18_string_regex.bai_tap.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Số điện thoại hợp lệ cần đạt theo mẫu sau: (xx)-(0xxxxxxxxx)
//
//x là ký tự số
//
//Không chứa các ký tự đặc biệt
public class ValidatePhoneNumber {
    private static final String ACCOUNT_REGEX = "^[(]\\d{2}[)][-][(][0]\\d{9}[)]$";
    public ValidatePhoneNumber() {
    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
