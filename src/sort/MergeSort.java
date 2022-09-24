package sort;

import java.util.Arrays;

/**
 * MergeSort
 *
 * 算法分析
 * 稳定性：稳定
 * 时间复杂度 ：最佳：O(nlogn)， 最差：O(nlogn)， 平均：O(nlogn)
 * 空间复杂度 ：O(n)
 * 排序方式 ：Out-place
 *
 * @time 2022-09-24-10:49
 */
public class MergeSort {
    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        return mergesort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr  数组
     * @param low  数组最左端  能取到
     * @param high 数组最右端  能取到
     * @return
     */
    public int[] mergesort(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
        return arr;
    }

    /**
     * 合并数组
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        //将有序的数组temp赋给子数组arr
        for (int l = 0; l < temp.length; l++) {
            arr[l + low] = temp[l];
        }
    }


    /**
     * 归并排序第二种写法
     * 选自JavaGuide
     * https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#%E5%9B%BE%E8%A7%A3%E7%AE%97%E6%B3%95-4
     *
     * @param arr
     * @return arr
     */
    public static int[] mergeSort2(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] arr_1 = Arrays.copyOfRange(arr, 0, middle);
        int[] arr_2 = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort2(arr_1), mergeSort2(arr_2));
    }

    /**
     * Merge two sorted arrays
     *
     * @param arr_1
     * @param arr_2
     * @return sorted_arr
     */
    public static int[] merge(int[] arr_1, int[] arr_2) {
        int[] sorted_arr = new int[arr_1.length + arr_2.length];
        int idx = 0, idx_1 = 0, idx_2 = 0;
        while (idx_1 < arr_1.length && idx_2 < arr_2.length) {
            if (arr_1[idx_1] < arr_2[idx_2]) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
            } else {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
            }
            idx += 1;
        }
        if (idx_1 < arr_1.length) {
            while (idx_1 < arr_1.length) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
                idx += 1;
            }
        } else {
            while (idx_2 < arr_2.length) {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
                idx += 1;
            }
        }
        return sorted_arr;
    }

}
