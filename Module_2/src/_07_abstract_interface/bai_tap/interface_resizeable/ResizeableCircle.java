package _07_abstract_interface.bai_tap.interface_resizeable;

import _06_ke_thua.bai_tap.circle_and_cylindr.Circle;

public class ResizeableCircle extends Circle implements Resizeable {
    public ResizeableCircle() {
    }

//    public ResizeableCircle(double radius, String color) {
//        super(radius, color);
//    }

    public ResizeableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(double percent) {
         super.setRadius(getRadius()*percent);
    }
}
