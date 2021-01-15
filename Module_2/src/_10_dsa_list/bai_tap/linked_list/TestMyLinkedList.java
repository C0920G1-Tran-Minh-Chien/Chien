package _10_dsa_list.bai_tap.linked_list;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList myLinkedList = new MyLinkedList(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.removeFirst();
//        myLinkedList.addLast(2);
//        myLinkedList.addLast(2);
//        myLinkedList.addFirst(1);
        myLinkedList.removeLast();

        myLinkedList.displayList();
    }
}
