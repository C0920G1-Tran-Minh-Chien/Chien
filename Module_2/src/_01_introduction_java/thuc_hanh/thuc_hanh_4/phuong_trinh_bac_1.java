package introduction_java.thuc_hanh.thuc_hanh_4;

import java.util.Scanner;

public class phuong_trinh_bac_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("a: ");
        float a = input.nextFloat() ;
        System.out.println("b: ");
        float b = input.nextFloat() ;
        System.out.println("c: ");
        float c = input.nextFloat() ;

        if (a != 0){
            float x = -b/c ;
            System.out.println("x = "+x);
        } else {
            if (b == 0) {
                System.out.print("Vô số nghiệm");
            } else {
                System.out.print("Vô nghiệm");
            }
        }
    }
}
