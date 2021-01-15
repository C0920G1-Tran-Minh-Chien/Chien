package _07_abstract_interface.bai_tap.colorable;

import _06_ke_thua.thuc_hanh.Square;

public class ColorableSquare extends Square implements Colorable {
    public ColorableSquare() {
    }

    public ColorableSquare(double side) {
        super(side);
    }

    @Override
    public double getPerimeter() {
        return super.getSide()*super.getSide() ;
    }

    @Override
    public void howToColor() {
        System.out.println("\n Đúng là 1 Colorable");
        System.out.println(" Diện tích square: " + getPerimeter());
    }
}
