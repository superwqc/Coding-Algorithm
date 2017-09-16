package create.singleton.staticCode;

/**
 * 使用static代码块实现单例
 *
 * 静态代码块中的代码在使用类的时候就已经执行了，所以可以应用静态代码块的这个特性的实现单例设计模式。
 */
public class Singleton5 {
    private  static Singleton5 singleton5=null;

    private  Singleton5(){}

    static {
        singleton5=new Singleton5();
    }

    public static Singleton5 getSingleton5() {
        return singleton5;
    }
}
