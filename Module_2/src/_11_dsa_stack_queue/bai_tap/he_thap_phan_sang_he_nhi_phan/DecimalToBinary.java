package _11_dsa_stack_queue.bai_tap.he_thap_phan_sang_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public void convertBinary(int num){
        Stack<Integer> stack = new Stack();
        while(num != 0){
            int i = num % 2;
            stack.push(i);
            num /= 2;
        }
        while(!(stack.isEmpty())){
            System.out.print(stack.pop());
        }
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số muốn chuyển sang nhị phân: ");
        int decimalNumber = input.nextInt();
        System.out.print("Hệ nhị phân của " + decimalNumber +" là :");
        new DecimalToBinary().convertBinary(decimalNumber);
    }
}
