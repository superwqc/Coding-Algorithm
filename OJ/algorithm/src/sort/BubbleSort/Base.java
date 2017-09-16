package sort.BubbleSort;

/**
 * 从待排序序列的起始位置开始，从前往后依次比较各个位置和其后一位置的大小
 * 如果当前位置的值大于其后一位置的值，就把他俩的值交换（完成一次全序列比较后，序列最后位置的值即此序列最大值，所以其不需要再参与冒泡）。
 * 将序列的最后位置从待排序序列中移除。若移除后的待排序序列不为空则继续前后比较，否则冒泡结束。
 */
public class Base {
    public static void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
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
