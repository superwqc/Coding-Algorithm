package program.linear;

/**
 * Created by Qi on 2017/8/4.
 */
public class PalindromeII {

    public static  boolean isPalindrome(int x){

        if (x==0||(x>0&&x%10==0))
            return false;

        int rev=0;
        while(rev<x){
            rev=rev*10+x%10;
            x=x/10;
        }
        return (rev==x)||(x==rev/10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
