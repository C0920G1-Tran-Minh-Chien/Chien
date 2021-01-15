package _02_vong_lap_java.thuc_hanh.kiem_tra_so_nguyen_to;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số cần kiểm tra: ");
        int number = input.nextInt();
//        Kiểm tra số nhập vào < 0.
        while (number < 1){
            System.out.println("Nhập lại số cần kiểm tra > 0: ");
            number = input.nextInt();
        }
//        Kiểm tra số nguyên tố.
        if (number < 2 ) {
            System.out.println(number + " là số nguyên tố!");
        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check){
                System.out.println(number + " là số nguyên tố!");
            } else {
                System.out.println( number + " Không phải số nguyên tố!");
            }
        }
    }
}
