package singleton.lazy;

/**
 * Created by Qi on 2017/8/30.
 */
public class Singleton2Test extends Thread{
    @Override
    public void run() {
        System.out.println(Singleton2.getInstance().hashCode());
    }

    public static void main(String[] args) {

        Singleton2Test [] s2=new Singleton2Test[10];

        for (int i=0;i<s2.length;i++){
            s2[i]=new Singleton2Test();
        }

        for (int j=0;j<s2.length;j++){
            s2[j].start();
        }
    }
}
