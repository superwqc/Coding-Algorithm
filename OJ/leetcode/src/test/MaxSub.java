package test;


import java.util.Scanner;

public class MaxSub {


        public static void main(String[] args) {

            Scanner scanner =new Scanner(System.in);
            int n=scanner.nextInt();
            int arr[]=new int[n];
            int i;
            for(i=0;i<n;i++)
            {
                arr[i]=scanner.nextInt();
            }

            //int[] a = {-23,17,-7,11,-2,1,-34};
            System.out.println(max(arr));
        }

        private static int max(int[] a){
            int maxSum = 0;
            int thisSum = 0;
            for (int anA : a) {
                thisSum += anA;
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                } else if (thisSum < 0) {
                    thisSum = 0;
                }
            }
            return maxSum;
        }
    }

