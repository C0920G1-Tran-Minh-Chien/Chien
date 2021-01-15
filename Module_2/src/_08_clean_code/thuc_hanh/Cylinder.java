package _08_clean_code.thuc_hanh;

public class Cylinder {
        public static double getVolume(int radius, int height){
            double baseArea = Math.PI * radius * radius;
            double perimeter = 2 * Math.PI  * radius;
            double volume = perimeter * height + 2 * baseArea;
            return volume;
    }

    public static void main(String[] args) {
        System.out.println(getVolume(1,2));
    }
}
