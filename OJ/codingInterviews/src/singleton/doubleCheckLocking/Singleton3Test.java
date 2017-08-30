package singleton.doubleCheckLocking;


public class Singleton3Test extends Thread{
        @Override
        public void run() {
            System.out.println(Singleton3.getInstance().hashCode());
        }

        public static void main(String[] args) {

            Singleton3Test [] s3=new Singleton3Test[10];

            for (int i=0;i<s3.length;i++){
                s3[i]=new Singleton3Test();
            }

            for (int j=0;j<s3.length;j++){
                s3[j].start();
            }
        }
    }

