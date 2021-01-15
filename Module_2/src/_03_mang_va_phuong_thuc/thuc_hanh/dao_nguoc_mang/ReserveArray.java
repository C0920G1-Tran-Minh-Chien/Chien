package _03_mang_va_phuong_thuc.thuc_hanh.dao_nguoc_mang;

import java.util.Arrays;
import java.util.Scanner;

public class ReserveArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int size ;
        int[] array ;
//        Kiểm tra kích thước mảng
        do {
            System.out.println("Nhập kích thước mảng: ");
             size = input.nextInt() ;
            if (size > 20){
                System.out.println("Nhập lại, kích thước phải < 20");
            }
        } while (size > 20);

//NHập mảng
        array = new int[size] ;
        for (int i = 0; i < size ; i++) {
            System.out.println("Nhập phần tử array[" + i + "]");
            array[i] = input.nextInt() ;
        }
//        Đảo ngược phàn tử mảng
        for (int j = 0; j < size / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
//        In mảng
        System.out.println(Arrays.toString(array));
    }
}
