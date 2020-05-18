package practice.test;

public class LoadDemo {

    public static void main(String[] args) {
       System.out.println("start");
       new LoadDemo();
       new LoadDemo();
       new LoadDemo();
       //static load  //类加载的时候创建
        //start
        //load    //每次对象的创建都会加载一次
        //load
        //load
    }

    static {
        System.out.println("static load");
    }
    {
        System.out.println("load");
    }
}
