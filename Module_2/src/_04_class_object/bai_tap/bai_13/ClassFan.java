package _05_class_object.bai_tap.bai_13;

public class ClassFan {
        private final int SLOW = 1;
        private final int MEDIUM = 2;
        private final int FAST = 3;
        private int speed = 1;
        private boolean on = false;
        private double radius = 5;
        private String color = "blue";

        public ClassFan(int speed, boolean on, double radius, String color){
            this.speed = speed;
            this.on = on;
            this.radius = radius;
            this.color = color;
        }
        public double getRadius() {
            return this.radius;
        }

        public int getFAST() {
            return this.FAST;
        }

        public int getMEDIUM() {
            return this.MEDIUM;
        }

        public int getSLOW() {
            return this.SLOW;
        }

        public String getSpeed() {
            String speedStr = "";
            if (this.speed == getSLOW()){
                speedStr = "SLOW";
            }else if (this.speed == getMEDIUM()){
                speedStr = "MEDIUM";
            }
            else if (this.speed == getFAST()){
                speedStr = "FAST";
            }
            return speedStr;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public String on(){
            String status = "";
            if (on){
                status = "Turning ON";
            }else {
                status = "Turning OFF";
            }
            return status;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public String Fan1() {
            String fan1 = "Speed: " + getSpeed() +". Radius: " + getRadius() + ". Color: " + getColor() + ". Status: " + on();
            return fan1;
        }
    public static void main(String[] args) {
        ClassFan fan2 = new ClassFan(2,true,5,"red");
        System.out.println(fan2.Fan1());
        fan2 = new ClassFan(3,true,2,"blue");
        System.out.println(fan2.Fan1());
    }
}
