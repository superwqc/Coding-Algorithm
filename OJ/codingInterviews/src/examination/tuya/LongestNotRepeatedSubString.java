package examination.tuya;


import java.util.TreeMap;

/**
 * Created by Qi on 2017/9/7.
 */
public class LongestNotRepeatedSubString {
    public static void max_unique_substring3(String str) {
        int maxlen = 0;
        int begin = 0;
        int n = str.length();
        int[] next = new int[n]; //next[i]记录了下一个与str[i]重复的字符的位置
        int[] first = new int[n+1]; //first[i]记录str[i]后面最近的一个重复点

        TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
        // 初始化   tm 这个数组，用0补充
        for(int k=0; k<n; k++){
            tm.put(str.charAt(k), n);
        }
        first[n] = n;
        for(int i=n-1; i>=0; i--){
            // next[i]记录了下一个与str[i]重复的字符的位置,first[i]记录str[i]后面最近的一个重复点
            // tm中存放的就是  下一个与str[i]重复的字符的位置 ，
            next[i] = tm.get(str.charAt(i));
            // 在这会进行 更新 tm
            tm.put(str.charAt(i),i);
            // 如果next存放的这个 索引 小于 str[i]后面最近的 1 个重复点。如果无，就是 n 这个数字
            if (next[i] < first[i+1])
                first[i] = next[i];
            else
                first[i] = first[i+1]; //生成first[]表，复杂度是O(N)的
        }
        for(int i=0; i<n; i++) {
            if (first[i]-i > maxlen){
                maxlen = first[i]-i;
                begin = i;
            }
        }
        System.out.println(maxlen + " " + str.substring(begin, begin+maxlen));

    }

}
