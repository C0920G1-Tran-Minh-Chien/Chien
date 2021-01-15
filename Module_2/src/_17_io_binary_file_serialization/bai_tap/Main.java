package _17_io_binary_file_serialization.bai_tap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ManagerProduct product = new ManagerProduct();
        product.readDataVilla();
        boolean check = true;
        do {
            System.out.println(" 1: Thêm sản phẩm mới " +
                    "\n 2: Hiển thị sản phẩm" +
                    "\n 3: Exit" +
                    "\n 4: Xóa sản phẩm theo id" +
                    "\n 5: TÌm kiếm sản phẩm theo tên."+
                    "\n 6: Sắp xếp sản phẩm theo số lượng từ bé tới lớn"+
                    "\n 7: Sắp xếp sản phẩm theo số lượng từ Lớn tới bé"+
                    "\n 8: Edit sản phẩm theo id");
            switch (getInput().nextInt()){
                case 1:{
                    product.addProductNew();
                    break;
                }
                case 2:{
                    product.displayProduct();
                    break;
                }
                case 3:{
                    check = false ;
                    break;
                }
                case 4:{
                    product.removeProduct();
                    break;
                }
                case 5:{
                    product.searchProduct();
                    break;
                }
//                case 6:{
//                    product.sortProduct();
//                    break;
//                }
//                case 7:{
//                    product.sortedProduct();
//                    break;
//                }
                case 8:{
                    product.editProduct();
                    break;
                }
            }
        }
        while (check);
    }
    public static Scanner getInput(){
        Scanner input = new Scanner(System.in);
        return input;
    }
}

