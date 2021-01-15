package _06_ke_thua.bai_tap.point_and_moveablepoint;

import java.util.Arrays;

public class MoveAblePoint extends Point {
    private float xSpeed ;
    private float ySpeed ;
    private float[] z = new float[2];

    public MoveAblePoint(){}
    public MoveAblePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveAblePoint( float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        z[0] = this.xSpeed;
        z[1] = this.ySpeed;
        return z;
    }

    @Override
    public String toString() {
        return "mảng chứa x,y"
                + "\n" + getX() + " " + getY()
                + "\n" + Arrays.toString(getSpeed());
    }

    public MoveAblePoint move(){
        super.setX(super.getX()+xSpeed);
        super.setY(super.getY()+ySpeed);
        return this;
    }
}
