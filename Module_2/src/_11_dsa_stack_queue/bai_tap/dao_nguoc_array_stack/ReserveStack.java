package _11_dsa_stack_queue.bai_tap.dao_nguoc_array_stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class ReserveStack<E> {

    private LinkedList<E> stack;
    public ReserveStack(){
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
