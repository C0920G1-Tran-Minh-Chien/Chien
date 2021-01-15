package _03_mang_va_phuong_thuc.thuc_hanh.tim_gia_tri_nho_nhat;

import java.util.Scanner;

public class FindMinValue {
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
        System.out.println(minValue(array));
    }
    public static int minValue(int[] array){
        int j = 0;
        int min = array[0]  ;
        for (int i = 1; i < array.length ; i++){
            if (array[i] < min){
                min = array[i] ;
                j++;
            }
        }
        System.out.println (min + " là giá trị nhỏn nhất, vị trí thứ " + j + " trong mảng!");
        return min;
    }
}
