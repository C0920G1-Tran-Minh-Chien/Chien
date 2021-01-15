package introduction_java.thuc_hanh.thuc_hanh_7;

import java.util.Scanner;

public class kiem_tra_can_nang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("NHập cân nặng(kg): ");
        float weight = input.nextFloat() ;
        System.out.println("NHập chiều cao(m): ");
        float height = input.nextFloat() ;

        float bmi = weight/(height*height) ;
        System.out.println("BMI = " + bmi );

        if (bmi < 18.5){
            System.out.println("Underưeight");
        } else if (bmi < 25 ){
            System.out.println("Normal");
        } else if (bmi < 30){
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
