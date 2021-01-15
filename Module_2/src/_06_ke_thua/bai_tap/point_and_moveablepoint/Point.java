package _06_ke_thua.bai_tap.point_and_moveablepoint;

import java.util.Arrays;

public class Point {
    private float x;
    private float y;
    private float[] t = new float[2];

    public Point(){}

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }



    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY( float x, float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        t[0] = this.x;
        t[1] = this.y;
        return t;
    }

    @Override
    public String toString() {
        return "mảng chứa x,y"
                + Arrays.toString(getXY());
    }
}
