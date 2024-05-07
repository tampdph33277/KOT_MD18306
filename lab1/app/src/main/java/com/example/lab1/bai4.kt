package com.example.lab1

class bai4 {
    fun vd1 (){
        println("Hello, World!")
    }
    fun printTin_nhan(tin_nhan: String): Unit {
        println(tin_nhan)
    }

    fun printTin_nhan_Prefix(tin_nhan: String, prefix: String = "Info") {
        println("[$prefix] $tin_nhan")
    }

    fun tong(x: Int, y: Int): Int {
        return x + y
    }

    fun multiply(x: Int, y: Int) = x * y

    fun vd2 (){
        printTin_nhan("Xin Chào")
        printTin_nhan_Prefix("Xin Chào", "Log")
        printTin_nhan_Prefix("Xin Chào")
        printTin_nhan_Prefix(prefix = "Log", tin_nhan = "Xin Chào")
        println(tong(1, 2))
        println(multiply(2, 4))
    }
    fun vd3() {
        operator fun Int.times(str: String) = str.repeat(this)
        println(2 * "Bye ")

        operator fun String.get(range: IntRange) = substring(range)
        val str = "Always forgive your enemies; nothing annoys them so much."
        println(str[0..19])
    }
    fun vd4() {
        var a: String = "initial"
        println(a)
        val b: Int = 1
        val c = 3
    }
    fun describeString(maybeString: String?): String {
        if (maybeString != null && maybeString.length > 0) {
            return "Chuỗi có độ dài ${maybeString.length}"
        } else {
            return "Chuỗi trống hoặc rỗng"
        }
    }
    fun vd5() {
        println(describeString(null))
    }
    class Contact(val id: Int, var email: String)
    class Customer
    fun vd6() {

        val customer = Customer()

        val contact = Contact(1, "tam@gmail.com")

        println(contact.id)
        contact.email = "cuong@gmail.com"
    }
    open class Dog {
        open fun sayHello() {
            println("ôi ôi ôi!")
        }
    }

    class Yorkshire : Dog() {
        override fun sayHello() {
            println("wi wi wi")
        }
    }

    fun vd7() {
        val dog: Dog = Yorkshire()
        dog.sayHello()
    }
    fun vd8() {
        val cakes = listOf("Bánh", "phô mai", "sữa")

        for (cake in cakes) {
            println("oh, nó là  $cake !")
        }

    }
    fun vd9() {
        for(i in 0..3) {
            print(i)
        }
        print(" ")

        for(i in 0 until 3) {
            print(i)
        }
        print(" ")

        for(i in 2..8 step 2) {
            print(i)
        }
        print(" ")

        for (i in 3 downTo 0) {
            print(i)
        }
        print(" ")

    }
    fun vd10() {
        val x = 2
        if (x in 1..5) {
            print("x nằm trong khoảng từ 1 đến 5")
        }
        println()

        if (x !in 6..10) {
            print("x nằm trong khoảng từ 6 dến  10")
        }
    }

}
fun main (){
    val bai4 = bai4()
    println("Ví dụ 1---------------")
    bai4.vd1()
    println("Ví dụ 2----------------")
    bai4.vd2()
    println("Ví dụ 3----------------")
    bai4.vd3()
    println("Ví dụ 4----------------")
    bai4.vd4()
    println("Ví dụ 5----------------")
    bai4.vd5()
    println("Ví dụ 6----------------")
    bai4.vd6()
    println("Ví dụ 7----------------")
    bai4.vd7()
    println("Ví dụ 8----------------")
    bai4.vd8()
    println("Ví dụ 9----------------")
    bai4.vd9()
    println("Ví dụ 10----------------")
    bai4.vd10()
}