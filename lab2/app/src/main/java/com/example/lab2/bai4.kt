package com.example.lab2

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val listDS = mutableListOf<SinhVienModel>()

    // Thêm sinh viên mẫu vào danh sách
    val sv1 = SinhVienModel("Hoàng Trọng Cường", "PH34555", 8.5f)
    val sv2 = SinhVienModel("Phùng Đức Tâm", "PH12333", 9.5f)
    val sv3 = SinhVienModel("Nguyễn Tất Công", "PH67899", 7.5f, false, 19)
    listDS.addAll(listOf(sv1, sv2, sv3))

    var choice: Int
    var s: String?

    while (true) {
        // Hiển thị menu
        println("                 Chức năng                ")
        println("+--------------------------------------")
        println("+-- 1. Hiển thị danh sách sinh viên ---")
        println("+-- 2. Thêm sinh viên               ---")
        println("+-- 3. Xóa sinh viên                ---")
        println("+-- 4. Sửa thông tin sinh viên      ---")
        print("+--  Nhập lựa chọn của bạn (1-4):   ------")
        println("\n+--------------------------------------")
        println("Mời nhập lựa chọn:")
        choice = scanner.nextInt()
        when (choice) {
            1 -> {
                // Hiển thị danh sách sinh viên
                println("Danh sách sinh viên:")
                for (sv in listDS) {
                    println(sv.getThongTin())
                }
            }
            2 -> {
                // Thêm sinh viên
                print("Nhập tên sinh viên: ")
                var ten = scanner.nextLine()
                ten = scanner.nextLine()
                print("\nNhập mã sinh viên: ")
                val maSV = scanner.nextLine()

                print("Nhập điểm trung bình: ")
                val diemTB = scanner.nextFloat()

                print("Sinh viên đã tốt nghiệp? (true/false): ")
                val daTotNghiep = scanner.nextBoolean()

                print("Nhập tuổi sinh viên: ")
                val tuoi = scanner.nextInt()

                val sinhVien = SinhVienModel(ten, maSV, diemTB, daTotNghiep, tuoi)
                listDS.add(sinhVien)

                println("Sinh viên đã được thêm vào danh sách.")
            }
            3 -> {
                // Xóa sinh viên
                println("Xóa sinh viên:")
                print("Nhập tên sinh viên cần xóa: ")
                var tenXoa = scanner.nextLine()
                tenXoa = scanner.nextLine()
                val svXoa = listDS.find { it.tenSV == tenXoa }
                if (svXoa != null) {
                    listDS.remove(svXoa)
                    println("Đã xóa sinh viên $tenXoa khỏi danh sách.")
                } else {
                    println("Không tìm thấy sinh viên $tenXoa trong danh sách.")
                }
            }
            4 -> {
                // Sửa thông tin sinh viên
                println("Sửa thông tin sinh viên:")
                print("Nhập tên sinh viên cần sửa: ")
                var tenSua = scanner.nextLine()
                tenSua = scanner.nextLine()
                val svSua = listDS.find { it.tenSV == tenSua }
                if (svSua != null) {
                    println("Nhập thông tin mới:")
                    print("Tên mới: ")
                    svSua.tenSV = scanner.nextLine()
                    print("Mã sinh viên mới: ")
                    svSua.mssv = scanner.nextLine()
                    print("Điểm trung bình mới: ")
                    svSua.diemTB = scanner.nextFloat()
                    print("Sinh viên đã tốt nghiệp? (true/false): ")
                    svSua.daTotNghiep = scanner.nextBoolean()
                    print("Tuổi mới: ")
                    svSua.tuoi = scanner.nextInt()
                    println("Đã cập nhật thông tin cho sinh viên $tenSua")
                } else {
                    println("Không tìm thấy sinh viên $tenSua trong danh sách.")
                }
            }
            else -> {
                println("Lựa chọn không hợp lệ.")
            }
        }

        // Hỏi người dùng có muốn tiếp tục không
        println("Tiếp không? (c/k): ")
        s = readLine()
        if (s == "k") {
            break
        }
    }

    scanner.close()
}