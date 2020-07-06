package variable

// 再JAVA中 switch 只支持，int char String 以及enum

def condition = 3.14
def result

switch (condition) {
    case "condition1":
        result = "condition1"
        break
    case 1..4:
        result = "range"
        break
// 以下的case 是list的形式
    case [1, 2, 3, 4, 5, "six", 3.14]:
        result = "list"
        break
    case Integer:
        result = "Integer"
        break
    case BigDecimal:
        result = "BigDecimal"
        break
    default:
        result = "default"
        break
}
println result // list

def x = 1..4
println x

def sum = 0
for (i in 0..9) { // 45
    sum += i
}
println sum

// list 和Map 定义类似

def map = [22: 33, 44: 55]

def sumMap = 0
for (i in map) {
    sum += i.key
}