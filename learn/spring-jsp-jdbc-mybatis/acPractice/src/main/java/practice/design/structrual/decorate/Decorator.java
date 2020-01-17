package practice.design.structrual.decorate;

/**
 * @author yu.zhang
 * @Description: 龟苓膏的装饰
 * @date 2019/8/7 9:47
 */
public abstract class Decorator extends HerbalJelly {

    private HerbalJelly herbalJelly;

    public Decorator(HerbalJelly herbalJelly) {
        this.herbalJelly = herbalJelly;
    }

    @Override
    public void process() {
        this.herbalJelly.process();
    }
}
