package singleton.innerClass;

/**
 * 静态内部类实现线程安全的单例模式
 */
public class Singleton4 {
    //私有构造
    private Singleton4(){}
    //内部类
    private static class SingletonHandler{

        private static Singleton4 instance=null;
    }

    public static Singleton4 getInstance(){
        return  SingletonHandler.instance;
    }

}