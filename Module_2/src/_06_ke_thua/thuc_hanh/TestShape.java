package _06_ke_thua.thuc_hanh;

public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("blue", false);
        System.out.println(shape);
    }
}
