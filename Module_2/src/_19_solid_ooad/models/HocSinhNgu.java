package _19_solid_ooad.models;
import java.text.DateFormat;

public class HocSinhNgu extends Students {
    private String hocLuc;
    private String raTruong;
    public HocSinhNgu(String name, String ngaySinh, String hocLuc, String raTruong) {
        super(name, ngaySinh);
        this.hocLuc = hocLuc;
        this.raTruong = raTruong;
    }
    public String getHocLuc() {
        return hocLuc;
    }
    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }

    public String getRaTruong() {
        return raTruong;
    }

    public void setRaTruong(String raTruong) {
        this.raTruong = raTruong;
    }

    @Override
    public String toString() {
        return super.toString()
                +"HocSinhNgu{" +
                "hocLuc=" + hocLuc +
                "ra Truong"+ raTruong+
                '}';
    }
}
