package _03_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class FindMinMaxValue {
    public static void main(String[] args) {
        int lengthArr;
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng: ");
        lengthArr = Integer.valueOf(scanner.nextLine());

        arr = new int[lengthArr];
        int i = 0;
        while (i < arr.length) {
            System.out.print("Nhập phần tử mảng thứ " + (i + 1) + ": ");
            arr[i] = Integer.valueOf(scanner.nextLine());
            i++;
        }
        System.out.println("Mảng vừa nhập : ") ;
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        int min = arr[0] ;
        int max = arr[0] ;

        for (int n = 1; n < arr.length; n++){
            if (arr[n] > max){
                max =  arr[n]  ;
            }
            if (arr[n] < min){
                min = arr[n]  ;
            }
        }
        System.out.println("\n" + " Phần tử lớn nhất trong mảng: " + max);
        System.out.println(" Phần tử bé nhất trong mảng: " + min);
    }
}
