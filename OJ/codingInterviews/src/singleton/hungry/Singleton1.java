package singleton.hungry;


/**
 * 饿汉式 方法调用前，实例已经创建好
 */
public class Singleton1 {

    private static  Singleton1 singleton1=new Singleton1();

    private  Singleton1 (){}

    public static Singleton1 getInstance(){
        return singleton1;
    }

}


