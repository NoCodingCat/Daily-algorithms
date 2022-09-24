package sort;

/**
 * selectionSort
 * 稳定性：不稳定
 * 时间复杂度 ：最佳：O(n2) ，最差：O(n2)， 平均：O(n2)
 * 空间复杂度 ：O(1)
 * 排序方式 ：In-place

 * @time 2022-09-24-10:22
 */
public class SelectionSort {

    public int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//n个元素只要从0比较到倒数第二个元素就行了
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minIndex = j;//记录最小的值的下标
                }
            }

            if (minIndex != i) {//swap
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

}
