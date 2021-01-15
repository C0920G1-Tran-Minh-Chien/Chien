package introduction_java.bai_tap.bai_tap_2;

import java.util.Scanner;

public class chuyen_so_thanh_chu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("Nhập số cần đọc: ");
        int number = input.nextInt();
        int hangTram = number / 100 ;
        int hangChuc = (number - hangTram*100) / 10;
        int hangDonVi = (number - hangTram*100 - hangChuc*10);
        if (number > 9 && number < 20){
            switch (number){
                case 10:
                    System.out.println("ten");
                    break;
                case 11:
                    System.out.println("eleven");
                    break;
                case 12:
                    System.out.println("Twelve");
                    break;
                case 13:
                    System.out.println("Thirteen");
                    break;
                case 14:
                    System.out.println("Fourteen");
                    break;
                case 15:
                    System.out.println("Fifteen");
                    break;
                case 16:
                    System.out.println("Sixteen");
                    break;
                case 17:
                    System.out.println("Seventeen");
                    break;
                case 18:
                    System.out.println("Eighteen");
                    break;
                case 19:
                    System.out.println("Nineteen");
                    break;
                case 20:
                    System.out.println("Twenty");
                    break;
            }
        } else if (number < 0 || number > 999){
            System.out.println("Số bạn nhập sai(1-999)");
        }
        else {
            hangTram( hangTram);
            hangChuc(hangChuc);
            hangDonVi(hangDonVi);
        }
    }
    public static void hangDonVi(int donVi){
        switch (donVi) {

            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
                break;
        }

    }

    public static void hangChuc( int chuc){
        switch (chuc) {
            case 2:
                System.out.println("twenty");
                break;
            case 3:
                System.out.println("thirty");
                break;
            case 4:
                System.out.println("forty");
                break;
            case 5:
                System.out.println("fifty");
                break;
            case 6:
                System.out.println("sixty");
                break;
            case 7:
                System.out.println("seventy");
                break;
            case 8:
                System.out.println("eighty");
                break;
            case 9:
                System.out.println("ninety");
                break;
        }
    }
    public static void hangTram( int tram){
        switch (tram) {
            case 1:
                System.out.println("one hundred");
                break ;
            case 2:
                System.out.println("two hundred");
                break;
            case 3:
                System.out.println("three hundred");
                break;
            case 4:
                System.out.println("four hundred");
                break;
            case 5:
                System.out.println("five hundred");
                break;
            case 6:
                System.out.println("six hundred");
                break;
            case 7:
                System.out.println("seven hundred");
                break;
            case 8:
                System.out.println("eight hundred");
                break;
            case 9:
                System.out.println("nine hundred");
                break;
    }
}
}
