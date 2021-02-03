package com.codegym.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "khach_hang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ten;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    private String email;

    @OneToMany(mappedBy = "khachHang")
    private List<GiaoDich> giaoDichList;

    public KhachHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GiaoDich> getGiaoDichList() {
        return giaoDichList;
    }

    public void setGiaoDichList(List<GiaoDich> giaoDichList) {
        this.giaoDichList = giaoDichList;
    }
}
