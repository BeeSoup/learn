package variable

/** ============闭包============ */
// 一定有返回值闭包
def block = {
    println "Hello Block"
}

block.call()// Hello Block
block()// Hello Block

def block_param = {
    String name, int age -> println "Hello ${name} , age: ${age}"
}

block_param("Groovy", 5)// Hello Groovy , age: 5

// it 默认隐式参数 如果指定了参数，就不会有隐式参数
def blockParamDefault = {
    println "Hello is ${it}"
}

def result = blockParamDefault('NAME')// Hello is NAME
println result // null

int tab(int sum, int x) {
    if (x == 0) {
        return sum;
    }
    sum += x
    x--;
    tab(sum, x)
}
def sumResult = tab(0,10);
println sumResult // 55
