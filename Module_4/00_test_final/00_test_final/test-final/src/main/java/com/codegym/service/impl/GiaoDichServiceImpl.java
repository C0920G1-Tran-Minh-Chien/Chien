package com.codegym.service.impl;


import com.codegym.entity.GiaoDich;
import com.codegym.repository.GiaoDichRepository;
import com.codegym.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichServiceImpl implements GiaoDichService {

    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @Override
    public Page<GiaoDich> findAll(Pageable pageable) {
        return giaoDichRepository.findAll(pageable);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public GiaoDich findById(String id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public List<GiaoDich> findAllByLoaiDichVy(String loaiDichVu) {
        return giaoDichRepository.findAllByLoaiDichVu(loaiDichVu);
    }

    @Override
    public List<GiaoDich> findByAllTenKhachHang(String tenKhachHang) {
        return giaoDichRepository.findAllByKhachHang_TenContaining(tenKhachHang);
    }

    @Override
    public List<GiaoDich> findAllByTenAndLoaiDichVu(String loaiDichVu, String tenKhachHang) {
        return giaoDichRepository.findAllByLoaiDichVuAndKhachHang_TenContaining(loaiDichVu,tenKhachHang);
    }
}
