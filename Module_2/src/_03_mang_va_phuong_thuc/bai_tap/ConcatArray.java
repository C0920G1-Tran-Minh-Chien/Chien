package _03_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;


public class ConcatArray {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        float[] a = null;
        float[] b = null;
        float[] c = null;

        System.out.println("---Nhập mảng a---");
        a = input(a);
        System.out.println("---Nhập mảng b---");
        b = input(b);

        // trộn mảng a và b thành c
        c = concat(a, b);

        // in mảng c ra màn hình
        show(c);
    }

   public static float[] input(float[] arr) {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        // khởi tạo arr
        arr = new float[n];
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static float[] concat(float[] a, float[] b) {
        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        int cIndex = a.length + b.length - 1;
        float[] c = new float[cIndex + 1];


        // trộn mảng a và b thành c
        for (int i = cIndex; i > -1; i--) {
            if (aIndex > -1 && bIndex > -1) {
                if (a[aIndex] > b[bIndex]) {
                    c[i] = a[aIndex--];
                } else {
                    c[i] = b[bIndex--];
                }
            } else if (bIndex == -1) {
                c[i] = a[aIndex--];
            } else if (aIndex == -1) {
                c[i] = b[bIndex--];
            }
        }
        return c;
    }

    public static void show(float[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}