package _10_dsa_list.bai_tap.array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(Object[] elements) {
        this.elements = elements;
    }
    //    Mở rộng mảng
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    //    Thêm phần tử vào mảng
    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
        return true;
    }

    //    Thêm phần tử vào mảng phần tử đc chỉ đinh
    public void add(int index, E e) {
// Chuyển phần tử sang phải
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i] ;
        }
// chèn phần tử vào
        elements[index] = e;
// Tăng kích thước lên 1
        size++;
    }
//    Lấy ra phần tử
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }

//    Xóa phần tử khỏi mảng
public Object remove(int index) {
    Object e = elements[index];
    // Chuyển phần tử mảng sang trái
    for (int j = index; j < size - 1; j++)
        elements[j] = elements[j + 1];
    //Xóa phần tử
    elements[size - 1] = null;
    // giảm kích thước
    size--;
    return e;
}
//Sao chép mảng (clone)
    public E[] clone(){
        E[] newData = (E[]) (new Object[size]);
        System.arraycopy(elements, 0, newData, 0, size);
        newData = (E[]) elements;
        return (E[]) newData;
    }
//KIểm tra xem có phần tử đó trong mảng hay không
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i]))
                return true;
        return false;
    }
// KIểm tra phần tử có trong mảng không, có thì trả về index đầu tiên nó xuất hiện
    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }
//    Xóa mảng
public void clear() {
    elements = (E[]) new Object[DEFAULT_CAPACITY];
    size = 0;
}

}
