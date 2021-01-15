package _07_abstract_interface.bai_tap.interface_resizeable;

public class TestResizeable   {
    public static void main(String[] args) {
//        Phần trăm resize
        double percent = Math.random()*100;
// Tạo mảng có kiểu là interface của 3 hình
        Resizeable[] resize = new Resizeable[3];

//        tạo đối tượng của 3 hình rồi bỏ vào mảng trên.
        resize[0] = new ResizeableCircle(1);
        ResizeableSquare square = new ResizeableSquare(10);
        resize[1] = square;
        ResizeRectangle rectangle = new ResizeRectangle(11,1);
        resize[2] = rectangle;

//        In ra kích thước trước khi resize
        System.out.println("pre resize: ");
        for (Resizeable h : resize){
            System.out.println(h);
        }

//        Kích thước sau khi resize
        System.out.println("after resize: ");
        for (Resizeable h : resize){
            h.resize(1.2);
            System.out.println(h);
        }
    }
}
