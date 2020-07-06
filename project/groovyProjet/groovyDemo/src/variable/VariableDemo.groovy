package variable

// 强定义
int x = 10
long y = 10
long z = 10L
println x.class
println y.class
println z.class
// class java.lang.Integer
// class java.lang.Long
// class java.lang.Long

def x_1 = 10
def x_2 = 10L
def y_1 = 3.14
def y_2 = 3.14f
def s = 'zhang'

println x_1.class
println x_2.class
println y_1.class
println y_2.class
println s.class

// class java.lang.Integer
// class java.lang.Long
// class java.math.BigDecimal
// class java.lang.Float
// class java.lang.String
// 说明，在定义弱类型的时候，对于整型，默认使用Integer 而对于浮点，则默认使用BigDecimal 字符串当然是使用String 自用的话，def 而对于与外界交互的情况，则使用强类型来规范

x_1 = "zhang" // 可以直接转化，可以理解为Object


// ------------------------------String 部分以下-------------------------

// 说明： 字符串可以用单引号或者是双引号或者是三引号定义，其中：单引号与JAVA中的String使用一致，而对于三引号''' line one ''' 可以指定格式 而双引号可以引用变量
def name = 'zhang'
// 有格式的情况，使用
def notice = '''\
line one 
line two 
line three; 
'''
// 可以理解未，三引号里引用的值就是固定值，不需要转义，默认输出即可
println notice

def hello = "Hello "
def world = "World;"
def say = "${hello} : ${world}"
println say // Hello  : World;
println say.class // class org.codehaus.groovy.runtime.GStringImpl 如果使用了 ${} 变量会变成这个

def sum = "the result = ${2 + 3}" // 可以是任意的表达式
println sum // the result = 5

def result = echo(sum)
println result; // the result = 5

String echo(String msg) {
    return msg;
}
/**  =====字符串==== */
def str = "groovy"
println str.center(8, 'a');