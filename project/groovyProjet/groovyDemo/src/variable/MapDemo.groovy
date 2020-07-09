package variable

import com.beust.jcommander.IValueValidator

// key 使用单引号字符串 或者是number 默认使用 单引号 使用的是LinkHashMap
def myMap = [red: 'ff0000', number: 10]

// 索引方式
println myMap.get('red')
println myMap['red']
println myMap.red

//添加元素
myMap.good = 'very good'

println myMap.toMapString() // [red:ff0000, number:10, good:very good]
// 遍历
myMap.each { def item ->
        println item.key
        println item.value
}
// 遍历 带索引
myMap.eachWithIndex { def entry, int i ->

}

myMap.each {
     key, value ->
         println key
         println value
}

def group = myMap.groupBy {
    def item ->
        return item.value == 10 ? 'yes': 'No'
}
println group.toMapString() // [No:[red:ff0000, good:very good], yes:[number:10]]