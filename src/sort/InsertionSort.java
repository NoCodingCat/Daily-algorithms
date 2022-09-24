package sort;

/**
 * InsertionSort
 *
 * 稳定性：稳定
 * 时间复杂度 ：最佳：O(n) ，最差：O(n2)， 平均：O(n2)
 * 空间复杂度 ：O(1)
 * 排序方式 ：In-place
 *
 * @time 2022-09-24-10:34
 */
public class InsertionSort {
    public int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;//记录前一个节点下标
            int currentVal = arr[i];
            while (preIndex >= 0 && arr[preIndex] > currentVal) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = currentVal;

        }
        return arr;
    }
}
