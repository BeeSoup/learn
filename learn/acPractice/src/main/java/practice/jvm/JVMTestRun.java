package practice.jvm;

public class JVMTestRun {

    public static void main(String[] args) {
        //str1.intern() == str1 : true
        //str2.intern() == str2 : false
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.printf("str1.intern() == str1 : %s\n", str1.intern() == str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.printf("str2.intern() == str2 : %s\n", str2.intern() == str2);
    }
}
