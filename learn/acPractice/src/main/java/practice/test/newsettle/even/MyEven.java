package practice.test.newsettle.even;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/9/24 17:27
 */
public class MyEven implements MyEvenInter{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void initEven() {
        System.out.println("initEven");
    }


}
