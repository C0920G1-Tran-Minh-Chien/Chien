package _05_access_modifier_static_method_static_property.bai_tap;

import _05_access_modifier_static_method_static_property.thuc_hanh.static_property.Car;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(10) ;
        Circle c2 = new Circle(1) ;
        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
        System.out.println(Circle.count);
    }
}
