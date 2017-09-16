package sort.BubbleSort;

/**
 * 若某一趟排序中未进行一次交换，则排序结束
 */
public class Optimize {
    public static void bubbleSort(int[] array) {
        int len = array.length;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < len - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    flag = true;
                }
            }
            len--;
        }
    }
    public static void main(String[] args) {
        int [] arr={2,3,5,7,1,4,0};
        bubbleSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
}
