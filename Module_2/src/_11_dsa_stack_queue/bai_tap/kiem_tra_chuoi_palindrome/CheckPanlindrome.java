package _11_dsa_stack_queue.bai_tap.kiem_tra_chuoi_palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPanlindrome {
    public void Check(String str){
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        int check = 0 ;
        for (int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
            queue.add(str.charAt(i));
            count++;
        }
        while (!stack.isEmpty()){
            if (stack.pop() == queue.poll()){
                check++;
            }
            if (check == count){
                System.out.println("Chuỗi "+ str + " là chuỗi panlindrome!");
                return;
            } else {
                System.out.println("Chuỗi "+ str + " không phải là chuỗi panlindrome!");
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi muốn kiểm tra: ");
        String str = input.nextLine();
        new CheckPanlindrome().Check(str);
    }
}
