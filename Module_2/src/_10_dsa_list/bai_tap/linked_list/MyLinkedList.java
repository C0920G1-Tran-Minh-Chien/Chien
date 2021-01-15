package _10_dsa_list.bai_tap.linked_list;

public class MyLinkedList {
    private Node head;
    private int currentNodes ;

    public MyLinkedList(Object data){
        head = new Node(data);
        currentNodes++;
    }
    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
// thêm vào đầu node
    public void addFirst (Object data){
        Node jump = head;
        head = new Node(data);
        head.next = jump;
        currentNodes++;
        }
//        THêm vào cuối node
    public void addLast(Object data) {
        Node newNode = new Node(data);
        Node jump = head;
        for (int i = 0; i < currentNodes - 1; i++) {
            jump = jump.next;
        }
        jump.next = newNode;
        this.currentNodes++;
    }
    // Lấy ra giá trị của phần tử, phải ép kiểu từ Object -> int để in ra.
    public int getValue(int index){
        Node temp=head;
        for(int i=0; i < index; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
//        Ép kiểu sáng int để in ra giá trị
        return ((int) temp.data) ;
    }
//    Xóa ohaanf tử đầu tiên
    public Node removeFirst() {
        if (currentNodes == 0) return null; // Nothing to delete
        else {
            Node temp = head;
            head = head.next;
            currentNodes--;
            return temp;
        }
    }
//    Xóa phần tử cuối cùng
    public Node removeLast() {
        if (currentNodes == 0) return null;
        else if (currentNodes == 1) {
            Node temp = head;
            head = null;
            currentNodes = 0;
            return temp;
        } else {
            Node current = head;
            for (int i = 0; i < currentNodes - 2; i++){
                current = current.next;
            }
            Node tail = null;
            Node temp = tail;
            tail = current;
            tail.next = null;
            currentNodes--;
            return temp;
        }
    }
    // Hiển thị
    public void displayList() {
        Node jump = head;
        while (jump != null) {
            System.out.println(jump.data);
            jump = jump.next;
        }
    }
}
