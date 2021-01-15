package _02_vong_lap_java.bai_tap.in_20_so_nguyen_to_dau_tien;

import java.util.Scanner;

public class First20Primes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("Nhập số lương số nguyên tố muốn in ra: ");
        int number = input.nextInt();
        int count = 0 ;
        int n = 2 ;
        while (count < number){
            int dem = 0;
            for ( int i = 1; i <= n; i++ ) {
                if (n % i == 0) {
                    dem++;
                }
            }
                if (dem == 2){
                    System.out.println(n);
                    count++;
                }
            n++;
        }
    }
}
