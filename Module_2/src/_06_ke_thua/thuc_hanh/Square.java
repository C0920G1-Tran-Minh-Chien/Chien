package _06_ke_thua.thuc_hanh;

import _07_abstract_interface.bai_tap.colorable.Colorable;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

//    public Square(double side, String color, boolean filled) {
//        super(side, side, color, filled);
//    }

    public double getSide() {
        return this.getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

//    @Override
//    public void setWidth(double width) {
//        setSide(width);
//    }

//    @Override
//    public void setLength(double length) {
//        setSide(length);
//    }

    @Override
    public String toString() {
        return "A Square with side="
                + getWidth()
                + getColor()
                ;

    }
}
