package _15_xu_ly_ngoai_le.bai_tap;

public class IllagelTriangleException extends Exception{
    public IllagelTriangleException(double side) {
        super(side + " Lỗi tổng 2 cạnh bé hơn cạnh còn lại");
    }

    public IllagelTriangleException(){
        super("Cạnh bé hơn 0");
    }
}
