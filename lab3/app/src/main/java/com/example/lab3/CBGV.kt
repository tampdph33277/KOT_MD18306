package com.example.lab3

class CBGV(
    hoTen: String,
           tuoi: Int,
    queQuan: String,
    var maSoGV: String,
    var luongCung: Float,
    var luongThuong: Float,
    var tienPhat: Float) :
    Nguoi(hoTen, tuoi, queQuan) {
    // Phương thức tính lương thực lĩnh
    fun tinhLuongThucLinh(): Float {
        val luongThuc = luongCung + luongThuong - tienPhat
        return luongThuc
    }
}