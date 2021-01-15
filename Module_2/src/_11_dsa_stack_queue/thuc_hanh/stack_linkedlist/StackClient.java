package _11_dsa_stack_queue.thuc_hanh.stack_linkedlist;

public class StackClient {
    private static void stackOfIStrings() {
        MyGenericStack<String> stack = new MyGenericStack();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("1.1 kích thước stack sau khi thêm : " + stack.size());
        System.out.printf("1.2. In ra stack : ");
        while (!stack.isEmpty()) {
//            lấy ra và xóa phần tử trogn stack
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n1.3. kích thước stack sau khi chạy while : " + stack.size());
    }
    private static void stackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("2.1. kích thước stack sau khi thêm: " + stack.size());
        System.out.printf("2.2. In ra stack : ");
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
        System.out.println("\n3.3 kích thước stack sau khi chạy while : " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("\n2. Stack of Strings");
        stackOfIStrings();
    }
}
