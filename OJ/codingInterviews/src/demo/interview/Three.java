package demo.interview;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in );
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int num = recu(n,k);
            System.out.println(num);
   }

    private static int recu(int n, int k) {
        int [] [] dp = new int[k+1][n+1];
        for(int i =1 ;i<k+1;i++){
            dp[i][1] = 1;
        }
        for(int i =1 ;i<n+1;i++){
            dp[1][i] = 1;
        }
        for(int i = 2 ; i < n+1;i++){
            for(int j = 2; j < k +1;j++){
                dp[i][j] = dp[i-1][j-1] * +dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[k][n];
    }

}
