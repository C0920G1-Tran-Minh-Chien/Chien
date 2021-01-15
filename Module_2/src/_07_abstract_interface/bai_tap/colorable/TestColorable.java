package _07_abstract_interface.bai_tap.colorable;

import _06_ke_thua.thuc_hanh.Circle;
import _06_ke_thua.thuc_hanh.Shape;


public class TestColorable {
    public static void main(String[] args) {
//        Tạo mảng kiểu Shape
        Shape[] h = new Shape[3];
//        Tạo đối tượng là các kiểu hình học rồi gán vào mảng
        h[0] = new ColorableSquare(2);
        h[1] = new Circle(2);
        h[2] = new ColorableSquare(3);

//        KIểm tra nếu phần tử nào coskieeur Colorable.
        for (Shape s : h){
            if (s instanceof Colorable){
//                Lúc này s đang ở kiểu Shape phải ép quá Colorable để dùng đc howToColor();
                ((Colorable) s).howToColor();

//                ColorableSquare shape = (ColorableSquare) s;
//                Colorable shape1 = (Colorable) shape;
//                shape1.howToColor();
            } else {
                System.out.println("\n Không phải là Colorable");
                System.out.println(s);
            }
        }
    }
}
