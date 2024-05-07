package com.example.lab1

import kotlin.io.readLine

fun main() {
    var a = 0.0
    var b = 0.0
    println("Nhập a: ")
    var s = readLine()
    if (s != null) {
        try {
            a = s.toDouble()
        } catch (e: NumberFormatException) {
            println("Giá trị nhập vào không hợp lệ cho a.")
            return
        }
    }
    println("Nhập b:")
    s = readLine()
    if (s != null) {
        try {
            b = s.toDouble()
        } catch (e: NumberFormatException) {
            println("Giá trị nhập vào không hợp lệ cho b.")
            return
        }
    }
    println("Tổng: " + (a + b))
    println("Hiệu: " + (a - b))
    println("Tích: " + (a * b))
    println("Thương: " + (a / b))
}