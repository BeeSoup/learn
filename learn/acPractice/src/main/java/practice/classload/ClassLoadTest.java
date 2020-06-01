package practice.classload;

public class ClassLoadTest {


    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(ClassLoader.getSystemClassLoader()); //系统类加载器

        System.out.println(ClassLoader.getSystemClassLoader().getParent()); //扩展类加载器

        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent()); //启动类加载器
    }
}
