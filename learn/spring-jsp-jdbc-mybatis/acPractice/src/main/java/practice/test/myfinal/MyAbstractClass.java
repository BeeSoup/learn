package practice.test.myfinal;

/**
 * final 保障子类不能复写我的方法
 *
 * final 成员变量可以使用构造函数来填充
 */
public abstract class MyAbstractClass {

    private final char[] member;

    protected MyAbstractClass(String member) {
        this.member = member.toCharArray();
    }


    public final void getFinalMethod() {

    }

    protected abstract void noFinalMethod();
}
