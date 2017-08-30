package test;


import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nums = scan.nextLine();
        int K =scan.nextInt();
        int res = function(nums,K);
        System.out.println(res);

    }

    private static int function(String nums, int k) {
        String str[] = nums.split(" ");
        int array[] = new int [str.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(array);

        return array[array.length-k];
    }
}
