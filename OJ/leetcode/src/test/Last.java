package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Last {

    public static int getMaxSubArray(List<Integer> list) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < list.size(); ++i) {
            currentSum = Math.max(currentSum + list.get(i), list.get(i));
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        while (sc.hasNext()){
            list.add(sc.nextInt());
        }
        System.out.println(getMaxSubArray(list));
    }
}