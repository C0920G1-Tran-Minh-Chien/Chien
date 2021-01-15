package _06_ke_thua.bai_tap.point_and_moveablepoint;

import org.w3c.dom.ls.LSOutput;

public class TestMoveAblePoint {
    public static void main(String[] args) {
        MoveAblePoint a = new MoveAblePoint();
//        System.out.println(a);

        a = new MoveAblePoint(1,2) ;
        System.out.println(a);

        System.out.println(a.move().toString());
    }
}
