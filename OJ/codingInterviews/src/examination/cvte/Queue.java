package examination.cvte;

import java.util.Scanner;
public class Queue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        int N=sc.nextInt();


        int M=sc.nextInt();
//建立布尔型的数组，长度为总人数
        Boolean rs[]=new Boolean[N];
//初始化布尔型数组，初始值均为true
        for(int i=0;i<N;i++){
            rs[i]=true;
//System.out.println(rs[i]);
        }
        int n=N;//剩余的人数
        int m=0;//报数的编号
        while(n>1){
            for(int j=0;j<N;j++){
                if(rs[j]){
                    m++;
                    if(m==M){
                        m=0;
                        rs[j]=false;
                        n--;
//System.out.println(rs[j]);
                    }
                }
            }
        }
//打印出最后留下来的人员的编号
        for(int k=0;k<N;k++){
            if(rs[k]){
                System.out.println("最后留下的是第"+(k+1)+"号");
                break;
            }
        }
    }
}