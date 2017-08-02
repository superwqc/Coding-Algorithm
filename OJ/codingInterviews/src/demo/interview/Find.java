package demo.interview;

/**
 * Created by Administrator on 2017/7/24.
 */
public class Find {
    public boolean find(int target,int [][]arr){
        int column=arr[0].length;
        int i=arr.length;
        int j=0;
        while (i>=0&&j<column){
            if (arr[i][j]<target) {
                j++;
            }else if (arr[i][j]>target){
                i--;
            }else{
                return true;
            }
        }
        return false;
    }
}
