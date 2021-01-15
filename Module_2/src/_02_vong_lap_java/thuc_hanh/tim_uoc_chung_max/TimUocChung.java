package _02_vong_lap_java.thuc_hanh.tim_uoc_chung_max;

import java.util.Scanner;

public class TimUocChung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("NHập số a: ");
        int a = input.nextInt() ;
        System.out.println("NHập b: ");
        int b = input.nextInt() ;
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0){
            System.out.println("K có ước chung lớn nhất");
        }
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("Ước chung lớn nhất là: " + a);
    }
}
