package practice.design.creational.factorymethod;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/7/16 11:40
 */
public class ADelegateFactory extends AFactortyMethod {
    private static String PREFIX = "com.zhangyu.practice.firstspringboot.practicedemo.design.creational.factorymethod";
    private String value ;
    @Override
    public Parent getChild() {
        if(value != null){
            try {
                String clazzName = PREFIX +"."+ this.value;
                AFactortyMethod factory = (AFactortyMethod) Class.forName(clazzName).newInstance();
                return factory.getChild();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public ADelegateFactory(String value) {
        this.value = value;
    }
}
