package singleton.lazy;

/**
 * 懒汉式 方法调用获取实例后，才开始创建实例
 *
 * 方法中声明synchronized关键字或同步代码块可实现线程安全，但是效率低下
 */
public class Singleton2 {

    private  static Singleton2 singleton2=null;

    private  Singleton2(){}

    //public  synchronized  static  Singleton2 getInstance(){

    public static Singleton2 getInstance(){
        try {
            synchronized (Singleton2.class){

            if (singleton2==null) {
            //懒汉式
            }else {

                    Thread.sleep(300);
                    singleton2 = new Singleton2();
                }
            }
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        return  singleton2;
    }
}
