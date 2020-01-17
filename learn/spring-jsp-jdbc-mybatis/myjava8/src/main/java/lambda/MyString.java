package lambda;

public class MyString {

    public static void main(String[] args) {
        String time = "2019-11-05";
        System.out.println("原来字符串 ： " + time + ", 现在的字符串：" + time.replaceAll("-", ""));
    }

}
