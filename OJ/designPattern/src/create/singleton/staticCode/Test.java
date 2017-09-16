package create.singleton.staticCode;


public class Test extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Singleton5.getSingleton5().hashCode());
        }
    }

    public static void main(String[] args) {

        Test[] mts = new Test[3];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new Test();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
}