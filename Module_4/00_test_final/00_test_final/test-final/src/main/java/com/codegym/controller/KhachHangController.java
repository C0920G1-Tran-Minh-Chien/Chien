package com.codegym.controller;


import com.codegym.entity.GiaoDich;
import com.codegym.service.GiaoDichService;
import com.codegym.service.KhachHangService;
import com.codegym.validator.GiaoDichValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping({"/", "home"})
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private GiaoDichService giaoDichService;

    @Autowired
    private GiaoDichValidator giaoDichValidator;



    @GetMapping
    public String goLishGiaoDich(Model model,
                                 @PageableDefault Pageable pageable,
                                 @RequestParam(defaultValue = "") String loaiDichVu,
                                 @RequestParam(defaultValue = "") String tenKhachHang) {



        if (!loaiDichVu.equals("") && tenKhachHang.equals("")) {
            model.addAttribute("giaoDichList", giaoDichService.findAllByLoaiDichVy(loaiDichVu));
        } else if (!tenKhachHang.equals("") && loaiDichVu.equals("")) {
            model.addAttribute("giaoDichList", giaoDichService.findByAllTenKhachHang(tenKhachHang));
        } else if (!loaiDichVu.equals("") && !tenKhachHang.equals("")) {
            model.addAttribute("giaoDichList",giaoDichService.findAllByTenAndLoaiDichVu(loaiDichVu, tenKhachHang));
        } else {
            model.addAttribute("giaoDichList", giaoDichService.findAll(pageable));
        }

        return "view/giao-dich/list";
    }


    @GetMapping("/create-giao-dich")
    public String goCreateGiaoDich(Model model) {
        model.addAttribute("giaoDich", new GiaoDich());
        model.addAttribute("khacHangList", khachHangService.findAll());

        return "view/giao-dich/create";
    }

    @PostMapping("/create-giao-dich")
    public String createGiaoDich(@Valid @ModelAttribute GiaoDich giaoDich,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        giaoDichValidator.validate(giaoDich, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("khacHangList", khachHangService.findAll());
            return "view/giao-dich/create";
        }

        giaoDichService.save(giaoDich);

        redirectAttributes.addFlashAttribute("success", "Them moi thanh cong");
        return "redirect:/home";
    }


    @GetMapping("/detail/{id}")
    public String goDetail(Model model, @PathVariable String id) {
        model.addAttribute("giaoDich", giaoDichService.findById(id));

        return "view/giao-dich/detail";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id, RedirectAttributes redirectAttributes) {

        giaoDichService.deleteById(id);

        redirectAttributes.addFlashAttribute("success", "Xoa thanh cong");

        return "redirect:/home";
    }


}
