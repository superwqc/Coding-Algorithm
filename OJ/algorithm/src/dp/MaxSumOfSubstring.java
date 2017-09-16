package dp;


public class MaxSumOfSubstring {
    public static void main(String[] args) {
       int [] arr={-2, 11, -4, 13, -5, -2 };
        System.out.println(maxSubstring(arr,6));

    }
    /**
     * @Description 最大连续子序列和只可能是以位置0～n-1中某个位置结尾。当遍历到第i个元素时，判断在它前面的连续子序列和是否大于0，
     * 如果大于0，则以位置i结尾的最大连续子序列和为元素i和前门的连续子序列和相加；否则，则以位置i结尾的最大连续子序列和为元素i。

     状态转移方程：sum[i]=max(sum[i-1]+a[i].a[i])
     */
    public static  int maxSubstring(int []arr,int len){
        int maxSum,maxHere;
        maxHere=maxSum=arr[0];//初始化最大为a[0]
        for (int i=0;i<len;i++){
            if (maxHere<=0){
                maxHere=arr[i];//如果前边连续子序列之和小于等于0，则以当前位置结尾的最大连续子序列和为a[i]
            }
            else
                maxHere+=arr[i];//如果前边连续子序列之和大于0，则当前啊最大子序列为maxHere+a[i]

            if (maxHere>maxSum){
                maxSum=maxHere;//更新最大子序列
            }
        }
        return  maxSum;

    }
}