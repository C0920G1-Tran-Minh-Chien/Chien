package _05_class_object.bai_tap.bai_1;

import java.util.Scanner;

public class QuadraticEquation {
    double a,b,c;

    public QuadraticEquation(double a,double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }

    public double getDiscriminant(){
        double delta = 0;
        delta = Math.pow(this.b,2) - 4 * this.a * this.c;
        return delta;
    }

    public double getRoot1(){
        double r1 = (-(this.b) + Math.pow(getDiscriminant(),0.5)) / (2 * this.a);
        return r1;
    }

    public double getRoot2(){
        double r2 = (-(this.b) - Math.pow(getDiscriminant(),0.5)) / (2 * this.a);
        return r2;
    }

    public String result(){
        double delta = getDiscriminant();
        String result = "";
        if (delta > 0){
            result = "Phương trình có 2 nghiệm : " + getRoot1()+ " và " + getRoot2();
        }else if (delta == 0){
            result = "Phương trình có 1 nghiệm : "+ getRoot1();
        }else if (delta < 0){
            result = "Vô nghiệm";
        }
        return result;
    }

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Nhập a: ");
    double a = input.nextDouble() ;
    System.out.println("Nhập b: ");
    double b = input.nextDouble() ;
    System.out.println("Nhập c: ");
    double c = input.nextDouble() ;

    QuadraticEquation quadraticEquation = new QuadraticEquation(a , b, c) ;
    System.out.println(quadraticEquation.result());
}
}
