package _07_abstract_interface.bai_tap.interface_resizeable;

import _06_ke_thua.thuc_hanh.Square;

public class ResizeableSquare extends Square implements Resizeable {
    public ResizeableSquare() {
    }

    public ResizeableSquare(double side) {
        super(side);
    }

    @Override
    public void resize(double percent) {
        super.setSide(getSide()*percent);
    }
}
