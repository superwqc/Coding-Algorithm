package program.linear;

import java.util.Scanner;

public class Amy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i=1;
        int[] arr = new int[n+1];
        while(i<=n){
            int p = scanner.nextInt();
                arr[0] = 1;
                arr[i] = arr[i-1] + p;
                i++;
        }
        int ele = scanner.nextInt();
        int a = 0;
        while(a < ele){
            int b = scanner.nextInt();
            if(b < arr[1]){
                System.out.println(1);
            }
            for(int j = 0;j < arr.length ; j++){
                if(arr[j] < b && b < arr[j+1]){
                    System.out.println(j+1);
                }
            }
        }
    }
}

