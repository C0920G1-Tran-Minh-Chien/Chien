package introduction_java.bai_tap.bai_tap_3;

import java.util.Scanner;

public class chuyen_doi_usd_vnd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("Nhập số tiền USD: ");
        float usd = input.nextFloat();
        float vnd = usd*23000 ;
        System.out.println(usd + " USD" + " = " + vnd + "VND" );
    }
}
