package singleton.doubleCheckLocking;

/**
 * 双检查锁机制 Double Check Locking
 */
public class Singleton3 {

    volatile private  static Singleton3 instance=null;

    private  Singleton3(){}

    public static Singleton3 getInstance() {
        try {
            if (instance==null){
                //懒汉式
            }else {

                Thread.sleep(300);
                synchronized (Singleton3.class){
                    //二次检查
                    if (instance==null){
                            instance=new Singleton3();
                    }
                }
            }
        }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        return instance;
    }

}
