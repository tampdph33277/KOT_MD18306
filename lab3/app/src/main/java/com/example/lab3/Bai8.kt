package com.example.lab3
import java.util.Scanner
class ThuVien {
    private val danhSachTheMuon = mutableListOf<TheMuon>()

    fun themTheMuon(theMuon: TheMuon) {
        danhSachTheMuon.add(theMuon)
        println("Thêm thẻ mượn thành công.")
    }

    fun xoaTheMuon(maPhieuMuon: String) {
        val theMuon = danhSachTheMuon.find { it.maPhieuMuon == maPhieuMuon }
        if (theMuon != null) {
            danhSachTheMuon.remove(theMuon)
            println("Xóa thẻ mượn thành công.")
        } else {
            println("Không tìm thấy thẻ mượn có mã phiếu $maPhieuMuon.")
        }
    }

    fun hienThiDanhSachTheMuon() {
        if (danhSachTheMuon.isEmpty()) {
            println("Danh sách thẻ mượn hiện đang trống.")
        } else {
            println("Danh sách thẻ mượn:")
            for (theMuon in danhSachTheMuon) {
                println("Mã phiếu mượn: ${theMuon.maPhieuMuon}")
                println("Ngày mượn: ${theMuon.ngayMuon}")
                println("Hạn trả: ${theMuon.hanTra}")
                println("Số hiệu sách: ${theMuon.soHieuSach}")
                println("Thông tin sinh viên:")
                println("Họ tên: ${theMuon.sinhVien.hoTen}")
                println("Tuổi: ${theMuon.sinhVien.tuoi}")
                println("Lớp: ${theMuon.sinhVien.lop}")
                println("---------------------")
            }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val thuVien = ThuVien()
    val theMuon1 = TheMuon("PM001", 10, 15, "SH001", SinhVien("Nguyễn Văn Nam", 20, "Lớp A"))
    val theMuon2 = TheMuon("PM002", 12, 17, "SH002", SinhVien("Trần Thị Hợi", 22, "Lớp B"))
    val theMuon3 = TheMuon("PM003", 14, 19, "SH003", SinhVien("Lê Văn Lợi", 25, "Lớp C"))
    thuVien.themTheMuon(theMuon1)
    thuVien.themTheMuon(theMuon2)
    thuVien.themTheMuon(theMuon3)
    while (true) {
        // Hiển thị menu
        println("             Chức năng             ")
        println("+---------------------------------")
        println("+-- 1. Thêm thẻ mượn              --")
        println("+-- 2. Xóa thẻ mượn               --")
        println("+-- 3. Hiển thị danh sách thẻ mượn --")
        println("+-- 4. Thoát                      --")
        print("+--  Nhập lựa chọn của bạn (1-4):  ")
        println("\n+---------------------------------")
        println("Mời nhập lựa chọn:")
        val choice = scanner.nextInt()

        when (choice) {
            1 -> {
                // Thêm thẻ mượn
                println("Thêm thẻ mượn:")
                print("Nhập mã phiếu mượn: ")
                val maPhieuMuon = scanner.next()

                print("Nhập ngày mượn: ")
                val ngayMuon = scanner.nextInt()

                print("Nhập hạn trả: ")
                val hanTra = scanner.nextInt()

                print("Nhập số hiệu sách: ")
                val soHieuSach = scanner.next()

                scanner.nextLine()

                print("Nhập họ tên sinh viên: ")
                val hoTen = scanner.nextLine()

                print("Nhập tuổi sinh viên: ")
                val tuoi = scanner.nextInt()

                scanner.nextLine()

                print("Nhập lớp sinh viên: ")
                val lop = scanner.nextLine()

                val sinhVien = SinhVien(hoTen, tuoi, lop)
                val theMuon = TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien)

                thuVien.themTheMuon(theMuon)
            }
            2 -> {
                // Xóa thẻ mượn
                println("Xóa thẻ mượn:")
                print("Nhập mã phiếu mượn cần xóa: ")
                val maPhieuMuon = scanner.next()

                thuVien.xoaTheMuon(maPhieuMuon)
            }
            3 -> {

                thuVien.hienThiDanhSachTheMuon()
            }
            4 -> {

                println("Chương trình kết thúc.")
                return
            }
            else -> {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            }
        }
    }
}