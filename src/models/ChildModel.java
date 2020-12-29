/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author LONG
 */
public class ChildModel {
       private int ID;
       private String tenTre;
       private Date ngaySinh;
       private String tenChuHo;
       private String thanhTich;
       private String gioiTinh;
       private String diaChi;
       private boolean daNhanQua;
       private Date ngayNhanQua;
       private String loaiQua;
       private int soLuongQua;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
       
    public String getTenTre() {
        return tenTre;
    }

    public void setTenTre(String tenTre) {
        this.tenTre = tenTre;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public String getThanhTich() {
        return thanhTich;
    }

    public void setThanhTich(String thanhTich) {
        this.thanhTich = thanhTich;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isDaNhanQua() {
        return daNhanQua;
    }

    public void setDaNhanQua(boolean daNhanQua) {
        this.daNhanQua = daNhanQua;
    }

    public Date getNgayNhanQua() {
        return ngayNhanQua;
    }

    public void setNgayNhanQua(Date ngayNhanQua) {
        this.ngayNhanQua = ngayNhanQua;
    }

    public String getLoaiQua() {
        return loaiQua;
    }

    public void setLoaiQua(String loaiQua) {
        this.loaiQua = loaiQua;
    }

    public int getSoLuongQua() {
        return soLuongQua;
    }

    public void setSoLuongQua(int soLuongQua) {
        this.soLuongQua = soLuongQua;
    }
}
