package demo.interview;

/**
 * 对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以
 F(n) = F(n-1) + F(n-2)
 同斐波拉契数序列题目，
 初始条件
    n=1:只能一种方法
    n=2:两种
 */
public class JumpFloor {
    public static  int jumpFloor(int target){
        if(target<=0) return 0;
        if(target==1) return 1;
        if(target==2) return 2;
        int one=1;
        int two=2;
        int result =0;
        for (int i = 2; i <target; i++) {
            result=one+two;
            one=two;
            two=result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(9));
    }
}
