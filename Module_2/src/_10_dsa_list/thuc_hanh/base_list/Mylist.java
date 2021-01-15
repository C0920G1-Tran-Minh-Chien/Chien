package _10_dsa_list.thuc_hanh.base_list;

import java.util.Arrays;

public class Mylist {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[] ;

    public Mylist(){
        elements = new Object[DEFAULT_CAPACITY];
    }
//    Mở rộng mảng
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
//
    public void add(Object e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
//Lấy phần tử từ mảng
    public Object get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (Object) elements[i];
    }
}
