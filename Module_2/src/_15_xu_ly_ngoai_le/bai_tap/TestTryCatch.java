package _15_xu_ly_ngoai_le.bai_tap;

import java.util.Scanner;

public class TestTryCatch {
    public static void main(String[] args) throws IllagelTriangleException {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập 3 cạnh! ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        Triangle triangle = new Triangle(a,b,c) ;
        System.out.println("jhjjjhhjjhjjhjjhjhjhjh");
    }

}


