package _07_abstract_interface.thuc_hanh.animals_interface_edible.comparable;

import _06_ke_thua.bai_tap.circle_and_cylindr.Circle;

class ComparableCircle extends Circle
        implements Comparable<ComparableCircle> {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color) {
        super(radius, color);
    }

    @Override
    public int compareTo(ComparableCircle o) {
//        so sánh radius rồi tới màu sắc để sắp xếp .
        if (this.getRadius() > o.getRadius()) return 1;
        else if (this.getRadius() < o.getRadius()) return -1;
        else if (this.getColor().compareTo(o.getColor()) > 0){
            return 1;
        } else if (this.getColor().compareTo(o.getColor()) < 0){
            return -1;
        } else {
            return 0;
        }
    }
}