package com.example.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    private List<SanPham> danhSachSanPham = new ArrayList<>();


    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void themSanPham(SanPham sp) {
        danhSachSanPham.add(sp);
    }

    public boolean xoaSanPham(String ma) {
        return danhSachSanPham.removeIf(sanPham -> sanPham.getMa().equals(ma));
    }

    public boolean kiemTraMaTonTai(String ma) {
        return danhSachSanPham.stream().anyMatch(sp -> sp.getMa().equals(ma));
    }

    public boolean suaSanPham(String ma ,String ten, float giaMoi,int soluongMoi){
        //validate k để trống
        if (ma == null || ma.trim().isEmpty() || ten == null || ten.trim().isEmpty() || giaMoi <= 0 || soluongMoi <= 0) {
            return false; // Không cập nhật nếu dữ liệu không hợp lệ
        }

        for (SanPham sp:danhSachSanPham){
            if (sp.getMa().equals(ma)){
                sp.setTen(ten);
                sp.setGia(giaMoi);
                sp.setSoLuong(soluongMoi);
                return true;
            }
        }
        return false;
            }
}
