package _07_abstract_interface.bai_tap.interface_resizeable;

import _06_ke_thua.thuc_hanh.Rectangle;


public class ResizeRectangle extends Rectangle implements Resizeable {
    public ResizeRectangle() {
    }

    public ResizeRectangle(double width, double length) {
        super(width, length);
    }




    @Override
    public void resize(double percent) {
        super.setWidth(getWidth()*percent);
        super.setLength(getLength()*percent);
    }
}
