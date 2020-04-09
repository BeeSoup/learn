package practice.test.newsettle.aop;

import org.springframework.stereotype.Component;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/14 10:17
 */
//@Component
public class PersonServiceImpl implements PersonService {

    @Override
    public String aopsave(boolean flag) {
        System.out.println("我是save()方法");
        if (flag) {
            throw new RuntimeException("save()Exception");
        }
        return "save";
    }

    protected String aopupdate(boolean flag) {
        System.out.println("我是update()方法");
        if (flag) {
            throw new RuntimeException("update()Exception");
        }
        return "update";
    }

    private String aopselect(boolean flag) {
        System.out.println("我是select()方法");
        if (flag) {
            throw new RuntimeException("select()Exception");
        }
        return "select";
    }

    @Override
    public String outsideUpdate(boolean flag) {
        System.out.println("我是outsideUpdate()方法");
        aopupdate(flag);
        return "outsideUpdate";
    }

    @Override
    public String outsideSelect(boolean flag) {
        System.out.println("我是outsideSelect()方法");
        aopselect(flag);
        return "outsideSelect";
    }
}
