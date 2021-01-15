package _03_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddValueToArray {
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
            System.out.printf("%-20s%s", "Mảng vừa nhập : ", "");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "\t");
            }

            System.out.print("\n.Nhập phàn tử muốn thêm :");
            int x = Integer.valueOf(scanner.nextLine());
            System.out.print("\n.Nhập vị trí muốn thêm :");
            int index = Integer.valueOf(scanner.nextLine());
            int[] arr2 = new int[arr.length + 1];
            for (int j = arr.length; j >= 0; j--) {
                if (j > index) {
                    arr2[j] = arr[j - 1];
                } else if (j == index) {
                    arr2[index] = x;
                } else {
                    arr2[j] = arr[j];
                }
            }
            System.out.println(Arrays.toString(arr2));
        }
}



