package _03_mang_va_phuong_thuc.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveValueArray {
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
        System.out.printf("%-20s%s", "Mảng : ", "");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        System.out.println("\n.Nhập số muốn xóa!");
        int x = Integer.valueOf(scanner.nextLine());
        int[] arr2 = new int[arr.length-1];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == x){

                System.out.println("Giá trị muốn xóa " + x + " tại vị trí " + j);
                System.out.println("Bạn muốn xóa? " + x + "\n1. Có\n2. Không");
                int choose = Integer.valueOf(scanner.nextLine());
                if (choose == 1){
                    for (int z = 0; z < j; z++){
                        arr2[z] = arr[z];
                    }
                    for (int k = j; k < arr.length-1; k++){
                        arr2[k] = arr[k + 1];
                    }
                }else {
                    continue;
                }
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}