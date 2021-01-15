package _11_dsa_stack_queue.bai_tap.dao_nguoc_array_stack;

import _11_dsa_stack_queue.thuc_hanh.stack_linkedlist.MyGenericStack;

import java.util.Arrays;
import java.util.Scanner;

public class TestReserveStack {
    private static void stackOfIStrings() {
        ReserveStack<String> stack = new ReserveStack();
        int lengthArr;
        String[] arr;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng: ");
        lengthArr = Integer.valueOf(scanner.nextLine());

        arr = new String[lengthArr];
        int j = 0;
        while (j < arr.length) {
            System.out.print("Nhập phần tử mảng thứ " + (j + 1) + ": ");
            arr[j] = String.valueOf(scanner.nextLine());
//            NHập phàn tử vào và đưa phần tử vào stack
            stack.push(arr[j]);
            j++;
        }

        System.out.printf("%-20s%s", " Mảng vừa nhập : ", "");
        for (int g = 0; g < arr.length; g++) {
            System.out.print(arr[g] + "\t");
        }

//Gán phần tử từ stack trở lại mảng ban đầu
        System.out.printf("%-20s%s", " \nSau khi đảo: ", "");
        for (int a = 0; a < arr.length; a++ ){
            arr[a] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void stackOfIntegers() {
        ReserveStack<Integer> stack = new ReserveStack();
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
//            NHập phàn tử vào và đưa phần tử vào stack
            stack.push(arr[i]);
            i++;
        }

        System.out.printf("%-20s%s", " Mảng vừa nhập : ", "");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }

//Gán phần tử từ stack trở lại mảng ban đầu
        System.out.printf("%-20s%s", " \nSau khi đảo: ", "");
        for (int a = 0; a < arr.length; a++ ){
            arr[a] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("\n2. Stack of Strings");
        stackOfIStrings();
    }
}
