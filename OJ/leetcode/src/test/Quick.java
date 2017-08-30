package test;

import java.util.Scanner;

public class Quick {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String tmpLine = scanner.nextLine();
        String tmpstr[]=tmpLine.split(" ");
        int k = scanner.nextInt();
        int[]tmp=new int[tmpstr.length];
        for(int i=0;i<tmpstr.length;i++){
            tmp[i]=Integer.parseInt(tmpstr[i]);
        }
        System.out.print(getVal(tmp,0,tmp.length-1,k));
    }

    public static int findKMaxNum(){
        return 0;
    }

    public static int getVal(int[]a,int low,int high,int index){
        if(low<high){
            int k=swap(a,low,high);
            int h=k-low;
            if(h+1==index) return a[k];
            if(h<index)
                return getVal(a,k+1,high,index-h-1);
            else
                return getVal(a,low,k-1,index);
        }
        return a[low];
    }
    public static int swap(int[]a,int low,int high){
        int key=a[low];
        while(low<high){
            while(low<high&&a[high]<=key) high--;
            a[low]=a[high];
            while(low<high&&a[low]>=key) low++;
            a[high]=a[low];
        }
        a[low]=key;
        return low;
    }
}