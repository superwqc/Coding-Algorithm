package singleton.hungry;

/**
 * 饿汉式单例在多线程条件下运行
 */
public class Singleton1Test  extends  Thread{

    @Override
    public void run() {
        System.out.println(Singleton1.getInstance().hashCode());
    }

    public static void main(String[] args) {
        Singleton1Test [] s=new Singleton1Test[10];
        for (int i=0;i<s.length;i++){
            s[i]=new Singleton1Test();
        }
        for (int j=0;j<s.length;j++){
            s[j].start();
        }
    }
}

/*
* 运行结果可以看出实例变量额hashCode值一致，这说明对象是同一个，饿汉式单例实现了。
* */