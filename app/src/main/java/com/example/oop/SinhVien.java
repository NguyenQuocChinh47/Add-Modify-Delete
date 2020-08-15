package com.example.oop;

public class SinhVien {
    private String hoTen;
    private String diaChi;
    private int namSinh;

    public SinhVien(String hoTen, String diaChi, int namSinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.namSinh = namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        hoTen="Nguyen Van A";
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        diaChi = "Hai Phong";
        this.diaChi = diaChi;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        namSinh = 1997;
        this.namSinh = namSinh;
    }

    //    public void setNamSinh(int ns){
//        if (ns>1999) {
//            ns = 1999;
//        }
//        namSinh = ns;
//    }

//    public int getNamSinh() {
//        return namSinh;
//    }
}
