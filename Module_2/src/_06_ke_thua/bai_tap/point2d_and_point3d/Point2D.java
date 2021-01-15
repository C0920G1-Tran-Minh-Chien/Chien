package _06_ke_thua.bai_tap.point2d_and_point3d;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;
    private float[] t = new float[2];

    public Point2D(){}

    public Point2D(float x, float y){
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
        t[1] = y;
        return t;
    }

    @Override
    public String toString() {
        return "mảng chứa x,y"
                + Arrays.toString(getXY());
    }
}
