package _06_ke_thua.bai_tap.point2d_and_point3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z ;
    private float[] h = new float[3];
    public Point3D(){}

    public Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float z){
        this.z = z;
    }
    public float[] getXYZ(){
        h[0] = super.getX();
        h[1] = super.getY();
        h[2] = this.z;
        return h;
    }

    @Override
    public String toString() {
        return "mảng chứa x,y"
                + Arrays.toString(getXYZ());
    }
}
