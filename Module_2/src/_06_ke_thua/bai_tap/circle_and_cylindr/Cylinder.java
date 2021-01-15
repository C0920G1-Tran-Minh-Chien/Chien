package _06_ke_thua.bai_tap.circle_and_cylindr;

public class Cylinder extends Circle{
    private double height ;

    public Cylinder(){}

    public Cylinder(double radius, String color, double height){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getCapacity(){
        return height*super.getRadius() ;
    }

    @Override
    public String toString() {
        return  "Chiều cao của Cylinder:"
                + getHeight()
                + "\n Thể tích: "
                + getCapacity();
    }
}
