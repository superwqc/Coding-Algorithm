package sort.quick;

/**
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此实现整个数据变成有序序列。
 */
public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && array[high] >= pivot) {
                    high--;
                }
                array[low] = array[high];

                while (low < high && array[low] <= pivot) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = pivot;
            quickSort(array, left, low - 1);
            quickSort(array, low + 1, right);
        }
    }

}
