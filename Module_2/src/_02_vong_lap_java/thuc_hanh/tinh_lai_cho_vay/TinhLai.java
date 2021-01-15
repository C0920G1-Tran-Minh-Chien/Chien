package _02_vong_lap_java.thuc_hanh.tinh_lai_cho_vay;

import java.util.Scanner;

public class TinhLai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("NHập số tiền gửi: ");
        double money = input.nextFloat() ;
        System.out.println("NHập lãi suất theo tháng: ");
        double interest = input.nextFloat() ;
        System.out.println("Số tháng gửi: ");
        double month = input.nextFloat() ;

        for (int i = 0; i < month ; i++){
            money += money*(interest/100);
        }
        System.out.println("Tổng số tiền sau khi gửi " + month + " tháng là: " + money );
    }
}
