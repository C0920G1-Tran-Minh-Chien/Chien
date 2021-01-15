package _10_dsa_list.thuc_hanh.base_linked_list;

public class MyLinkedList {
    private  Node head;
    private int numNodes ;

    public MyLinkedList(Object data) {
        head = new Node(data);
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

// Thêm phần tử vào
    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }
//    Thếm 1 phần tử vào đầu
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
//    Lấy ra 1 phần tử(Địa chỉ, Node là 1 đối tượng)
    public Node get(int index){
        Node temp=head;
        for(int i=0; i < index; i++) {
            temp = temp.next;
        }
//        System.out.println(temp.data);
        return temp;
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

//In ra List
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
