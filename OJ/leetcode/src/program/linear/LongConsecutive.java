package program.linear;

import java.util.HashSet;

/**
 * Created by Administrator on 2017/6/1.
 */


public class LongConsecutive {


    public static  int longConsecutive(int [] num){
        final HashSet<Integer> set=new HashSet<Integer>();
        for (int i:num) {
            set.add(i);
        }
        int longest=0;

        for (int i:num) {
            int length=1;
            for (int j = i-1; set.contains(j); j--) {
                set.remove(j);
                length++;

            }
            for (int j = i+1;set.contains(j) ; j++) {
                set.remove(j);
                length++;
            }
            longest=Math.max(longest,length);
        }

        return longest;
    }
    public static void main(String[] args) {
        int [] n={1,2,3,100,4,6,7,89,5};
        int result=longConsecutive(n);
        System.out.println(result);
    }


}
