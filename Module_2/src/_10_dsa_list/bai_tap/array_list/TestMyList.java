package _10_dsa_list.bai_tap.array_list;

import _10_dsa_list.thuc_hanh.base_list.Mylist;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class TestMyList {
    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(10);
//        arrayList.add(11);
//        arrayList.add(4,2);
//        for (Integer integer : arrayList){
//            System.out.println(integer);
//        }

       MyList<Integer> myList = new MyList<>();
       myList.add(0,1);
       myList.add(2);
       myList.add(3);
       myList.add(1);
        System.out.println(myList.indexOf(3));

//       myList.add(2,5);
//       myList.add(3,6);
//       myList.add(4,7);
//       myList.add(7,7);
//       myList.add(11,2);
//        System.out.println(myList);
//        myList.remove(2);
        System.out.println(myList.get(3));
//        System.out.println(Arrays.toString(myList.clone()));
//        System.out.println(myList.contains(1));
    }
}
