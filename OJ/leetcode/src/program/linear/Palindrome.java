package program.linear;

/**
 * Created by Administrator on 2017/6/8.
 */
public class Palindrome {
    public static void main(String[] args) {
        int x=123321;
        System.out.println(isPalindrome(x));
    }

    public static  boolean isPalindrome(int x){
        if(x<0)
            return false;
        int quotient=x;
        int digits=0;
        while(quotient!=0){
            quotient /= 10;
            digits++;
        }
        for (int i = 1; i <digits ; i++) {
            int high =digits-i+1;
            int low =i;
            if (getDigits(x,high)!=getDigits(x,low)){
                return false;

            }

        }return true;
    }


        private static  int getDigits(int x,int i){
        if(i==1)
            return x%10;
        return (x/(int)Math.pow(10,i-1))%10;
    }
    }
