package _02_vong_lap_java.bai_tap.in_ra_so_nguyen_to_be_hon_100;

import java.util.Arrays;
import java.util.Scanner;

public class DisplayPrimesLessThan100 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("nhập số muốn in ra dãy số nguyên tố bé hơn số đó: ");
        int number = input.nextInt();
        int n = 2;
        while (n < number){
            int count = 0;
            for ( int i = 1; i <= n; i++ ) {
                if (n % i == 0) {
                    count++;
                }
            }
            if (count == 2){
                System.out.println(n);
            }
            n++;
        }
}
}
