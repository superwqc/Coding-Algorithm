package demo.interview;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;
/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

 解决思路：先不考虑是否出现重读字符，要对一个字符进行全排列，可以把第一个字符和后面的字符看成两部分，
 而第一个字符后面的字符又可看成第一个字符与后面两部分，这显然是一个递归的过程，
 只要第一个字符的位置没有到达字符串的末尾就分别将第一个字符与后面的字符进行交换。这里有一点需要注意：
 那就是比如第一个字符与后面的某个位置的字符发生交换后，需要再次发生交换，不然顺序就会被打乱。
 举个例子，在字符串abc中，在把第一个字符看成是a，后面的字符b、c看成一个整体的时候，abc这个相对顺序不能改变，
 所以当b与c发生交换变成了acb之后，需要再次交换两个字符，重新回到abc。
 */

public class All {
    public static  ArrayList<String> permutation(String str) {
        //使用TressSet是因为它是有序的
        TreeSet<String> tree = new TreeSet<String>();
        //创建一个栈保存每次排列的字符组合
        Stack<String[]> stack = new Stack<String[]>();
        //存放最终的排列结果
        ArrayList<String> results = new ArrayList<String>();
        stack.push(new String[] { str, "" });
        do {
            //这里的popStrs就是str输入的字符串
            String[] popStrs = stack.pop();
            //空串
            String oldStr = popStrs[1];
            //str
            String statckStr = popStrs[0];
            for (int i = statckStr.length() - 1; i >= 0; i--) {
                String[] strs = new String[] {
                        statckStr.substring(0, i) + statckStr.substring(i + 1),
                        oldStr + statckStr.substring(i, i + 1) };
                if (strs[0].length() == 0) {
                    tree.add(strs[1]);
                } else {
                    stack.push(strs);
                }
            }
        } while (!stack.isEmpty());
        for (String s : tree)
            results.add(s);
        return results;
    }

    public static void main(String[] args) {
        String  str="abcc";
        System.out.println(permutation(str));
    }
}
