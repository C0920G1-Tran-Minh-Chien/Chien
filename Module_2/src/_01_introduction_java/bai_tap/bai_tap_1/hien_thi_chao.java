package introduction_java.bai_tap.bai_tap_1;

import java.util.Scanner;

public class hien_thi_chao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = input.nextLine();
        System.out.println("Chào " + name);
    }
}
