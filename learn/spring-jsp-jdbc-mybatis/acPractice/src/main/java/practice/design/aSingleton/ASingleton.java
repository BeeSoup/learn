package practice.design.aSingleton;

/**
 * 单例实现
 */
public class ASingleton {
//    private enum SingletonEnum{
//        INSTANCE;
//        private Singleton singleton = null;
//        private SingletonEnum(){
//            singleton = new Singleton();
//        }
//        private Singleton getInstance(){
//            return singleton;
//        }
//    }
//    public static Singleton getInstance(){
//        return SingletonEnum.INSTANCE.getInstance();
//    }

    private static volatile ASingleton singleton = null;
    private ASingleton(){}
    public static ASingleton getInstance(){
        if(singleton ==null){
            synchronized(ASingleton.class){
                if (singleton == null){
                    singleton = new ASingleton();
                }
            }
        }
        return singleton;
    }
}
