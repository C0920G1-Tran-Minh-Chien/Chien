package _07_abstract_interface.thuc_hanh.animals_interface_edible.comparable;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[4];
        circles[0] = new ComparableCircle(3.5, "blue");
        circles[1] = new ComparableCircle(2, "yellow");
        circles[2] = new ComparableCircle(3.5, "red");
        circles[3] = new ComparableCircle(3.5, "green");

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
//sắp xếp mảng theo như ComparableCircle
        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
