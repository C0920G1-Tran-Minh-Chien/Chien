package _11_dsa_stack_queue.thuc_hanh.queue_linkedlist;

public class MyLinkedListQueue {
    private  Node head;
    private  Node tail;

    public MyLinkedListQueue(){
        this.head = null;
        this.tail = null;
    }
//    THêm phần tử
    public void enqueue(int key) {
        Node temp = new Node(key);
//        Nếu rỗng thì chạy if
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }
//    Lấy ra phần tử
    public Node dequeue() {
//        Kiểm tra có rỗng k.
        if (this.head == null)
            return null;
//        Tạo biến tạm để lấy ra phần tử đầu tiên, rồi dời phần tử sau tới phần tử đàu tiên
        Node temp = this.head;
        this.head = this.head.next;

        if (this.head == null)
            this.tail = null;
        return temp;
    }
}
