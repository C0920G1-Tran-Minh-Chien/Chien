package com.codegym.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "giao_dich")
public class GiaoDich {

    @Id
    private String id;
    @Column(name = "ngay_giao_dich", columnDefinition = "DATE")
    private String ngayGiaoDich;

    @Column(name = "loai_dich_vu")
    private String loaiDichVu;

    @Column(name = "don_gia")
    private Double donGia;

    @Column(name = "dien_tich")
    private Double dienTich;


    @ManyToOne
    @JoinColumn(name = "id_khach_hang", referencedColumnName = "id")
    private KhachHang khachHang;

    public GiaoDich() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
