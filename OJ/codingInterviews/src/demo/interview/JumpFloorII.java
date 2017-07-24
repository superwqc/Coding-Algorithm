package demo.interview;

/**
 * Created by Qi on 2017/7/24.
 *
    n = 1时，只有1种跳法，f(1) = 1
    n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2) 
    n = 3时，会有三种跳得方式，1阶、2阶、3阶，
    那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
    因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
    n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：

     f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) =>
     f(0) + f(1) + f(2) + f(3) + ... + f(n-1)

 */
public class JumpFloorII {

        public int jumpFloorII(int target) {

            if(target<=0) {
                return -1;
            }
            else if(target==1){
                return 1;
            }else return 2*jumpFloorII(target-1);

        }

    }
