package practice.design.structrual.facade;

/**
 * @author yu.zhang
 * @Description: 主管为门面，用来沟通子系统和客户（需求系统） 开发和需求也就是子系统不对外开放
 * 可以对接口进行编程增加扩展性
 * @date 2019/8/6 17:35
 */
public class Leader {

    private Developer developer = new Developer();
    private Tester tester = new Tester();
//  接受需求
    public void receiew(String name) {
        developer.develop(name);
        tester.test(name);
    }
}
