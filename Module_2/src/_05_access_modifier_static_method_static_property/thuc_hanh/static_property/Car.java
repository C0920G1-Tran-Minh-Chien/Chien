package _05_access_modifier_static_method_static_property.thuc_hanh.static_property;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;
    public Car(String name, String engine) {
//        Mỗi đối tượng được khởi tạo thì number + 1 ;
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }
}
