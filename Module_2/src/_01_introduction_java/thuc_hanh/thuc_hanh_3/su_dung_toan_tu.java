package intruction_java.thuc_hanh.thuc_hanh_3;

import java.util.Scanner;

public class su_dung_toan_tu {
    public static void main(String[] args) {
        float width ;
        float height ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều rộng: ");
        width =  sc.nextFloat();
        System.out.println("Nhập chiều dài: ");
        height = sc.nextFloat();

        float area = width*height ;
        System.out.println("diện tích: " + area);
    }
}
