package object

/**
 * 1/默认都是public 不管是变量还是方法
 * 并且都会继承GroovyObject接口
 */
class GroovyObj {
    String name ;
    def say() {
        println super.getClass()
    }

    /**
     * 方法找不到时候的替换
     */
    def invokeMethod(String name, Object args){
        println "invokeMethod"
    }
}