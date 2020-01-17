package practice.design.structrual.decorate;

/**
 * @author yu.zhang
 * @Description: 总结：需要一个普通的基础类，然后使用抽象装饰类继承基础类，这样可以获得方法，后续继承的情况下，还是属于基础的子类
 *                     将基础类以成员变量的形式，以构造方法注入，方法调用，调用基类的方法。
 *                     子类继承，调用装饰器方法，再调用本地方法。
 *                     思考：如果直接继承基础类的方法，然后先调用父类的方法，再调用子类的方法。有何不同
 *
 * @date 2019/8/7 9:59
 */
public class DecorateTest {

    public static void main(String[] args) {
//      普通版
        ComHerbalJelly comHerbalJelly = new ComHerbalJelly();
        comHerbalJelly.process();

        HoneyHerbalJelly honeyHerbalJelly = new HoneyHerbalJelly(comHerbalJelly);
        honeyHerbalJelly.process();

        MilkHerbalJelly milkHerbalJelly = new MilkHerbalJelly(comHerbalJelly);
        milkHerbalJelly.process();

        MilkHerbalJelly milkHoneyJelly = new MilkHerbalJelly(honeyHerbalJelly);
        milkHoneyJelly.process();
    }
}
