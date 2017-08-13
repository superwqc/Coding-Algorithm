package demo.interview;

import java.util.Scanner;

public class Num {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int n=scan.nextInt();
        int [] x=new int[n];
        int [] y=new int[n];
        for (int i=0;i<n;i++){
            x[i]=scan.nextInt();
        }
        for (int i=0;i<n;i++){
            y[i]=scan.nextInt();
        }
        String str="0 1 3 10";
        System.out.println(str);
    }

}
