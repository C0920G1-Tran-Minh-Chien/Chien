package _03_mang_va_phuong_thuc.thuc_hanh.tim_gia_tri_lon_nhat;

import java.util.Arrays;
import java.util.Scanner;

public class FindValueMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int size ;
//        Kiểm tra kích thước mảng
        do {
            System.out.println("Nhập kích thước mảng: ");
            size = input.nextInt() ;
            if (size > 20){
                System.out.println("Nhập lại, kích thước phải < 20");
            }
        } while (size > 20);

//        NHập mảng
        int[] array = new int[size] ;
        for (int i = 0; i < size ; i++){
            System.out.println("Nhập phần tử array[" + i + "]");
            array[i] = input.nextInt() ;
        }
//        TÌm giá trị lớn nhất
        int j = 0;
        int max = array[0]  ;
        for (int i = 1; i < size ; i++){
            if (array[i] > max){
                max = array[i] ;
                j++;
            }
        }
        System.out.println (max + " là giá trị lớn nhất, vị trí thứ " + j + " trong mảng!");

        System.out.println(Arrays.toString(array));
    }
}
