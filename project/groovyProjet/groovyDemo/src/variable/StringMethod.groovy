package variable


def str = "Groovy"
println str.center(8, 'a')// 字符串填充
println str.padLeft(8, 'A')
// aGroovya
// AAGroovy
println str.getAt(0) // G
println str[0]  // G
println str[0..2] //0~2 Gro

def str2 = "roov"

println str.minus(str2)// Gy
println str - str2 // Gy

println str.reverse()// yvoorG

println str2.capitalize() // 首字母大写 Roov

def str3 = "2222"

println str3.isNumber()// true

def str4 = "111"

def str5 = "111"


println str4 == str5 // true

def str6 = new String("111")

println str5 == str6 // true