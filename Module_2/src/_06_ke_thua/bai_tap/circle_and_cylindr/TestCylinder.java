package _06_ke_thua.bai_tap.circle_and_cylindr;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(10, "blue", 10);
        System.out.println(cylinder);
    }
}
