package _19_solid_ooad.models;

import _00.Main.Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiamThi {
    public  static final String REGEX_INPUT_ID = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)\n";

    public static void main(String[] args) {
        GiamThi giamThi = new GiamThi();
        giamThi.thenHocSinh();
        giamThi.hienThi();

    }
    public static Scanner enter(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public static List<Students> studentsList = new ArrayList<>();
    public void hienThi(){
        System.out.println(studentsList.toString());
    }
    public void thenHocSinh(){
        boolean temp = true;
        String name = themTen();
        String ngaySinh = themNgaySinh();
        String hocLuc = themHocLuc();
        String raTruong = themraTruong();
        do {
            if (soSanh(ngaySinh,raTruong)){
                System.out.println("Sai!");
                raTruong = themraTruong();

            } else {
                System.out.println("ĐÚng!");
                HocSinhNgu hocSinhNgu = new HocSinhNgu(name,ngaySinh,hocLuc,raTruong);
                studentsList.add(hocSinhNgu);
                temp = false;
                break;
            }
        }while (temp);


    }
    public boolean soSanh(String truoc, String sau){
        boolean check = false;
        String[] element1 = truoc.split("/");
        String[] element2 = sau.split("/");
        for (int i = 2; i >= 0; i--){
            if (Integer.parseInt(element1[i]) > Integer.parseInt(element2[i])){
                check = true;
                break;
            }
        }
        return check;
    }
    public String themTen(){
        System.out.println("Nhập tên");
        return enter().nextLine();
    }
    public String themNgaySinh(){
        System.out.println("Nhap ngay sinh");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INPUT_ID);

    }
    public String themHocLuc(){
        System.out.println("Nhập học lực");
        return enter().nextLine();
    }
    public String themraTruong(){
        System.out.println("Nhập ra trường");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INPUT_ID);
    }
}
