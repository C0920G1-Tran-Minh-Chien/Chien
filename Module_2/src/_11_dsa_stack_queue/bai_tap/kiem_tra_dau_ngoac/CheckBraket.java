package _11_dsa_stack_queue.bai_tap.kiem_tra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class CheckBraket {

public static boolean check(String str) {
    Stack<Character> stack = new Stack<Character>();
    char left;
    for(int i=0; i < str.length(); i++) {
        left = str.charAt(i);
//        Nếu là dấu ngoặc trái: đưa vào stack
        if( left == '(') {
            stack.push(left);
        }
//         Nếu sym là dấu ngoặc phải:
//         Nếu bStack rỗng, return false.
//         Còn Nếu phần tử trên cùng của stack là ngoặc trái thì xóa nó. Không thì return false
        else if( left == ')')
            if(stack.empty()) {
                return false;
            } else if(stack.peek() == '(') {
                stack.pop();
            }
            else {
                return false;
            }
    }
    return stack.empty();
}
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập chuối kiểm tra dấu ngoặc!");
            String str = input.nextLine();
            System.out.println(check(str));
    }
}
