package introduction_java.thuc_hanh.thuc_hanh_6;

import java.util.Scanner;

public class kiem_tra_nam_nhuan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("NHập năm muốn kiểm tra: ");
        int year = input.nextInt() ;

        if ( year % 4 == 0 && year % 100 != 0 ){
            System.out.println( year + " là năm nhuận! ");
        } else if ( year % 100 == 0 && year % 400 != 0){
            System.out.println( year + " không phải là năm nhuận! ");
        } else if ( year % 100 == 0 && year % 400 == 0){
            System.out.println( year + " là năm nhuận! ");
        } else {
            System.out.println( year + " không phải là năm nhuận! ");
        }
    }
}
