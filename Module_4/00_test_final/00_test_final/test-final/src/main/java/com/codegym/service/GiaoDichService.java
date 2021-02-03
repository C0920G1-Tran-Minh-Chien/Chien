package com.codegym.service;

import com.codegym.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GiaoDichService {
    Page<GiaoDich> findAll(Pageable pageable);

    void save(GiaoDich giaoDich);

    GiaoDich findById(String id);

    void deleteById(String id);

    List<GiaoDich> findAllByLoaiDichVy(String loaiDichVu);

    List<GiaoDich> findByAllTenKhachHang(String tenKhachHang);

    List<GiaoDich> findAllByTenAndLoaiDichVu(String loaiDichVu, String tenKhachHang);
}
