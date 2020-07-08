package variable

int fab(int number, Closure closure) {
    int product = 1
    product = closure.call(number, product);
//    //10执行到number
//    10.upto(number, { num ->
//        {
//            return product *= num
//        }
//    })
    return product;
}

int result = fab(12, {
    int num, int product ->
        {
            10.upto(num, { numbers ->
                {
                    product *= numbers;
                }
            })
            return product
        }
});
println result //1320 10*11*12
// number,times {
//      闭包体
// }
println fab(5, {
    int num, int product ->
        {
            num.downto(1, { numbers ->
                {
                    product *= numbers
                }
            })
            return product
        }
})// 120 5 * 4 * 3 * 2 *1


/** ==============字符串============== */

//each 循环
def str = 'this 2 is 3'
str.each {
    String temp ->
        {
            print temp
        }
}
//t
//h
//i
//s
//
//2
//
//i
//s
//
//3

//find 寻找匹配的第一个
println str.find {
    String temp ->
        {
            temp.isNumber()
        }
}// 2

println str.findAll {
        //[2, 3]
    String temp ->
        {
            temp.isNumber()
        }
}

// 只要 anY
println str.any {
    String temp ->
        {
            temp.isNumber();
        }
}

// 每一个
println str.every {
    String temp ->
        {
            temp.isNumber()
        }
}

//遍历，然后闭包化处理，然后添加到List中
println str.collect {
    it.toUpperCase()
}
// [T, H, I, S,  , 2,  , I, S,  , 3]

/**
 * 闭包中三个重要的变量 this, owner delegate
 */

def scriptClosure = {
    println this // 代表闭包定义处的类
    println owner// 代码闭包定义处的类或者对象 嵌套闭包的情况
    println delegate // 代表任意对象，默认等于owner
    def scpClosure = {
        println this
        println owner
        println delegate
    }
    scpClosure.call()
}
// @4dde8976 这一点表示一个对象，如果没有这个，比如加上了static 的话，表示指向类
// variable.BlockDemo2@6cd15072
//variable.BlockDemo2@6cd15072
//variable.BlockDemo2@6cd15072
//variable.BlockDemo2@6cd15072
//variable.BlockDemo2$_run_closure9@4dde8976
//variable.BlockDemo2$_run_closure9@4dde8976
scriptClosure.call()

/**
 * 闭包的委托策略
 */

class Student {
    String name;
    def say = {
        println "My name is ${name}"
    }
    String toString() {
        say.call()
    }
}
class Teacher {
    String name;
}
Student student = new Student(name: "student")
Teacher teacher = new Teacher(name: "teacher")

student.say.resolveStrategy = Closure.DELEGATE_FIRST //修改为委托优先，默认是OWNER 优先
student.say.delegate = teacher

student.toString()// My name is teacher