package _11_dsa_stack_queue.thuc_hanh.stack_linkedlist;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<E> {
    private LinkedList<E> stack;
    public MyGenericStack(){
        stack = new LinkedList();
    }
    public  void push(E elements){
        stack.addFirst(elements);
    }
    public E pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public int size(){
        return stack.size();
    }
    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

}
