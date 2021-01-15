package _03_mang_va_phuong_thuc.thuc_hanh.tim_gia_tri_trong_mang;

import java.util.Scanner;

public class FindValueInArray {
    public static void main(String[] args) {
        String[] nameArray = {"Phuc" , "Anh", "Chien"} ;
        Scanner input = new Scanner(System.in) ;
        System.out.println("Nhập tên cần tìm: ");
        String name = input.nextLine();
        boolean check = true;

        for (int i = 0; i < nameArray.length ; i++){
            if (nameArray[i].equals(name)){
                System.out.println("Có tên trong danh sách, vị trí thứ " + i + " trong mảng!");
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("Không tìm thấy");
        }
    }
}
