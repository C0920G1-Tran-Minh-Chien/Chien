package _18_string_regex.bai_tap.validate_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
//Tên một lớp học hợp lệ cần đạt các yêu cầu sau:
//
//Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P
//
//Không chứa các ký tự đặc biệt
//
//Theo sau ký tự bắt đầu là 4 ký tự số
//
//Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M
    private static final String ACCOUNT_REGEX = "^[ABC]\\d{4}[GHIKLM]$";
    public ValidateClass() {
    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
