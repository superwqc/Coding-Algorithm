import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String input = scan.nextLine();
        String[] split=input.split(" ");
        int[] num=new int[4];

        for(int i=0;i<4;i++){
            num[i]=Integer.valueOf(split[i]);
        }
        int a=getDays(num[0],num[1],num[2],num[3]);
        System.out.println(a);
        scan.close();
    }

    public static int getDays(int x, int f, int d, int p) {
        if ( x * f > d ) {
            return d / x;
        } else {
            return f + ( d - x * f ) / (x + p);
        }
    }
}