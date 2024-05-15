package com.example.lab3
import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    val listCBGV = mutableListOf<CBGV>()
    val cbgv1 = CBGV("Nguyễn Văn Cường", 35, "Hà Nội", "GV001", 5000f, 1000f, 200f)
    val cbgv2 = CBGV("Trần Thành", 40, "Hồ Chí Minh", "GV002", 5500f, 1200f, 300f)
    val cbgv3 = CBGV("Phùng Đức Nam", 30, "Đà Nẵng", "GV003", 4500f, 900f, 100f)
    listCBGV.addAll(listOf(cbgv1, cbgv2, cbgv3))
    var choice: Int
    var s: String?

    while (true) {
        // Hiển thị menu
        println("                 Chức năng                ")
        println("+--------------------------------------")
        println("+-- 1. Hiển thị danh sách cán bộ giáo viên ---")
        println("+-- 2. Thêm cán bộ giáo viên               ---")
        println("+-- 3. Xóa cán bộ giáo viên                ---")
        println("+-- 4. Tính lương thực lĩnh của giáo viên   ---")
        print("+--  Nhập lựa chọn của bạn (1-4):   ------")
        println("\n+--------------------------------------")
        println("Mời nhập lựa chọn:")
        choice = scanner.nextInt()
        when (choice) {
            1 -> {

                println("Danh sách cán bộ giáo viên:")
                for (cbgv in listCBGV) {
                    println("Mã số giáo viên: ${cbgv.maSoGV}")
                    println("Họ tên: ${cbgv.hoTen}")
                    println("Tuổi: ${cbgv.tuoi}")
                    println("Quê quán: ${cbgv.queQuan}")
                    println("Lương cứng: ${cbgv.luongCung}")
                    println("Lương thưởng: ${cbgv.luongThuong}")
                    println("Tiền phạt: ${cbgv.tienPhat}")
                    println("Lương thực lĩnh: ${cbgv.tinhLuongThucLinh()}")
                    println("---------------------")
                }
            }
            2 -> {
                // Thêm cán bộ giáo viên
                print("Nhập mã số giáo viên: ")
                var maGV = scanner.nextLine()
                 maGV = scanner.nextLine()


                print("Nhập họ tên: ")
                val hoTen = scanner.nextLine()

                print("Nhập tuổi: ")
                val tuoi = scanner.nextInt()

                print("Nhập quê quán: ")
                val queQuan = scanner.nextLine()
                scanner.nextLine()

                print("Nhập lương cứng: ")
                val luongCung = scanner.nextFloat()

                print("Nhập lương thưởng: ")
                val luongThuong = scanner.nextFloat()

                print("Nhập tiền phạt: ")
                val tienPhat = scanner.nextFloat()

                val cbgv = CBGV(hoTen, tuoi, queQuan, maGV, luongCung, luongThuong, tienPhat)
                listCBGV.add(cbgv)

                println("Cán bộ giáo viên đã được thêm vào danh sách.")
            }
            3 -> {
                // Xóa cán bộ giáo viên
                println("Xóa cán bộ giáo viên:")
                print("Nhập mã số giáo viên cần xóa: ")
                var maXoa = scanner.nextLine()
                maXoa = scanner.nextLine()
                val cbgvXoa = listCBGV.find { it.maSoGV == maXoa }
                if (cbgvXoa != null) {
                    listCBGV.remove(cbgvXoa)
                    println("Đã xóa sinh viên $maXoa khỏi danh sách.")
                } else {
                    println("Không tìm thấy sinh viên $maXoa trong danh sách.")
                }
            }


            4 -> {
                // Tính lương thực lĩnh của giáo viên
                println("Tính lương thực lĩnh của giáo viên:")
                print("Nhập mã số giáo viên cần tính lương: ")
                var maTinhLuong = scanner.nextLine()
                maTinhLuong = scanner.nextLine()
                val cbgvTinhLuong = listCBGV.find { it.maSoGV == maTinhLuong }
                if (cbgvTinhLuong != null) {
                    val luongThucLinh = cbgvTinhLuong.tinhLuongThucLinh()
                    println("Lương thực lĩnh của giáo viên có mã số $maTinhLuong là: $luongThucLinh")
                } else {
                    println("Không tìm thấy cán bộ giáo viên có mã số $maTinhLuong trong danh sách.")
                }
            }
            else -> {
                println("Lựa chọn không hợp lệ.")
            }
        }


        println("Tiếp không? (c/k): ")
        s = scanner.nextLine()
        if (s.equals("k", ignoreCase = true)) {
            break
        }
    }

    scanner.close()
}