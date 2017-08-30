package program.linear;

import java.util.Scanner;

public class Apple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int[] arr=new int[10];
            for(int i=0;i<10;i++){
                arr[i]=sc.nextInt();
            }
            int hight=sc.nextInt()+30;
            int cnt=0;
            for(int i=0;i<10;i++){
                if(hight>=arr[i]){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
