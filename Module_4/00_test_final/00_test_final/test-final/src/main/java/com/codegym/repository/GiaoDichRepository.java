package com.codegym.repository;

import com.codegym.entity.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiaoDichRepository extends JpaRepository<GiaoDich, String> {

    List<GiaoDich> findAllByLoaiDichVu(String loaiDichVu);

    List<GiaoDich> findAllByKhachHang_TenContaining(String ten);

    List<GiaoDich> findAllByLoaiDichVuAndKhachHang_TenContaining(String loaiDichVu, String khachHang_ten);
}
