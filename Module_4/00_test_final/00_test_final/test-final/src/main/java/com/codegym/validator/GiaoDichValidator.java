package com.codegym.validator;

import com.codegym.entity.GiaoDich;
import com.codegym.entity.KhachHang;
import com.codegym.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Component
public class GiaoDichValidator implements Validator {

    @Autowired
    GiaoDichService giaoDichService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        GiaoDich giaoDich = (GiaoDich) target;
        LocalDate ngayHienTai = LocalDate.now();



        if (giaoDichService.findById(giaoDich.getId()) != null) {
            errors.rejectValue("id", "id.duplicate");
        }

        if (giaoDich.getKhachHang() == null) {
            errors.rejectValue("khachHang", "khach-hang.format");
        }

        try {
            if (giaoDich.getLoaiDichVu() == null) {
                errors.rejectValue("loaiDichVu", "loai-dich-vu.format");
            }

        } catch (Exception e) {
        }


        try {
            LocalDate ngayGiaodich = LocalDate.parse(giaoDich.getNgayGiaoDich());
            if (ngayHienTai.compareTo(ngayGiaodich) >= 0) {
                errors.rejectValue("ngayGiaoDich", "ngay-giao-dich.format");
            }
        } catch (Exception e) {
            errors.rejectValue("ngayGiaoDich", "ngay-giao-dich.format");
        }


        if (!Pattern.compile("^MGD-\\d{4}$").matcher(giaoDich.getId()).find()) {
            errors.rejectValue("id", "id.format");
        }


        if (giaoDich.getDonGia() == null) {
            errors.rejectValue("donGia", "don-gia.format");

        } else if (giaoDich.getDonGia() < 500000) {
            errors.rejectValue("donGia", "don-gia.format");
        }



        if (giaoDich.getDienTich() == null) {
            errors.rejectValue("dienTich", "dien-tich.format");
        } else if (giaoDich.getDienTich() < 20) {
            errors.rejectValue("dienTich", "dien-tich.format");
        }
    }
}
