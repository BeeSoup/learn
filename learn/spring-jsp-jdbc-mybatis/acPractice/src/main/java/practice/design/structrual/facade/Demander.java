package practice.design.structrual.facade;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/6 17:33
 */
public class Demander {

    private Leader leader = new Leader();

    public void demand(String name) {
        System.out.println("需求" +  name);
        leader.receiew(name);
    }

}
