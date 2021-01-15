package _12_java_collection_framework.bai_tap.arraylist_linkedlist_java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagerProduct extends Product {
    public static int count = 0;
    public static List<Product> list = new ArrayList<>();
    public ManagerProduct() {
    }

    public ManagerProduct(int id, String name, int amount) {
        super(id, name, amount);
    }

    public void addProductNew(){
        setId(count++);
        setName(inputName());
        setAmount(inputAmount());
        Product product = new Product(getId(),getName(),getAmount());
        list.add(product);
        System.out.println("Đã nhaaph thành công!");
    }
    public String inputName(){
        System.out.println("Nhập tên: ");
        return Main.getInput().nextLine();
    }
    public int inputAmount(){
        System.out.println("Nhập số lượng: ");
        return Main.getInput().nextInt();
    }
    public void displayProduct(){
        for (Product p : list) {
            System.out.println("ID : " + p.getId());
            System.out.println("Tên : " + p.getName());
            System.out.println("Số lượng : " + p.getAmount());
            System.out.println("\n ---------------------------------");
        }
    }
    public  void removeProduct(){
        System.out.println("Nhập id của sản phẩm muốn xóa: ");
        int id = Main.getInput().nextInt();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == id){
                list.remove(i);
                System.out.println("Đã xóa thành công");
            } else {
                System.out.println("Không có trong listProduct");
            }
        }
    }

    public void searchProduct(){
        boolean check = false;
        System.out.println("Nhập tên sản phẩm muốn tìm: ");
        String  name = Main.getInput().nextLine();
        for (Product p : list){
                if (p.getName().equals(name)) {
                    System.out.println("ID " + p.getId() +
                            "\n Tên: " + p.getName() +
                            "\n Số lượng: " + p.getAmount());
                    check = true;
                }
        } if (!check){
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    public void sortProduct(){
        AmountComparator amountComparator = new AmountComparator(true);
        Collections.sort(list, amountComparator);
        System.out.println("Đã sắp xếp từ bé tới lơn!");
    }
    public void sortedProduct(){
        AmountComparator amountComparator = new AmountComparator(false);
        Collections.sort(list, amountComparator);
        System.out.println("Đã sắp xếp từ lớn tới bé!");
    }
    public void editProduct(){
        boolean check = false;
        System.out.println("Nhập id sản phẩn muốn edit: ");
        int id = Main.getInput().nextInt();
        for (Product p : list){
            if (p.getId() == id){
                System.out.println("Nhập lại tên sản phẩm: ");
                p.setName(Main.getInput().nextLine());
                System.out.println("Nhập lại số lượng: ");
                p.setAmount(Main.getInput().nextInt());
                System.out.println("Đã edit thành công!");
                check = true;
            }
        } if (!check){
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

}

