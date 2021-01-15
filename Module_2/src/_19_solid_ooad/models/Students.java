package _19_solid_ooad.models;

import java.text.DateFormat;

public abstract class Students {
    private String name;
    private String ngaySinh;

    public Students(String name, String ngaySinh) {
        this.name = name;
        this.ngaySinh = ngaySinh;
    }


    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", ngaySinh=" + ngaySinh +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
