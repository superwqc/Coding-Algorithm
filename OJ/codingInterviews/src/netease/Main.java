package netease;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int arr[]=new int[n];
        int sum=0,avg=0,f1=0,f2=0;
        for(int i=0;i<n;i++){
            int curNum=scanner.nextInt();
            sum+=curNum;
            arr[i]=curNum;
        }
        avg=(int) Math.ceil(sum*1.0/n);
        for(int i=0;i<n;i++){
            if(arr[i]<avg){
                a[f1++]=arr[i];
            }else{
                b[f2++]=arr[i];
            }
        }

        System.out.println(cal(a,f1)+cal(b,f2));
    }

    public static int cal(int arr[],int length){
        int i=1;
        int num=0;
        if(arr.length<=1){
            return arr[0];
        }
        for(;i<length;i++){
            num+=Math.abs(arr[i]-arr[i-1]);
        }
        return num;
    }
}
