package _05_access_modifier_static_method_static_property.bai_tap;

public class Circle {
    private double radius = 1;
    private String color = "red";
    double area ;
    static int count ;

    Circle (){

    }

    Circle (double radius ) {
        this.radius = radius ;
        count++;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        area = this.radius*Math.PI ;
        return area;
    }

}
