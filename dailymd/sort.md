# 排序：

[排序_牛客题霸_牛客网 (nowcoder.com)](https://www.nowcoder.com/practice/2baf799ea0594abd974d37139de27896?tpId=202&tqId=38851&rp=1&ru=/ta/code-written-high&qru=/ta/code-written-high&difficulty=&judgeStatus=&tags=/question-ranking)

![十大排序算法](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/github/javaguide/cs-basics/sorting-algorithms/sort1.png)

[十大经典排序算法总结 | JavaGuide](https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#简介)

## 冒泡排序

### 1. 算法步骤

比较相邻的元素。如果第一个比第二个大，就交换他们两个。

对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。

针对所有的元素重复以上的步骤，除了最后一个。

持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

```java
/**
 * bubbleSort
 * 稳定性：稳定
 * 时间复杂度 ：最佳：O(n) ，最差：O(n2)， 平均：O(n2)
 * 空间复杂度 ：O(1)
 * 排序方式 ：In-place

 * @time 2022-09-24-9:52
 */


//第一种写法
public int[] bubbleSort(int[] arr) {
        int P = arr.length - 1;//进行排序的趟数 如[3， 2 ，1]需要进行2趟冒泡
        for (int j = P; j > 0; j--) {
            boolean flag = true;//标记数组是否本来就有序
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {//交换
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        return arr;
    }
//第二种写法
public static int[] bubbleSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        boolean flag = true;
        for (int j = 0; j < arr.length - i; j++) {
            if (arr[j] > arr[j + 1]) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
                flag = false;
            }
        }
        if (flag) {
            break;
        }
    }
    return arr;
}
```

flag标记数组是否有序，若本来就有序，时间复杂度可降为**O(n)**



## 选择排序



### 1. 算法步骤

首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。

再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。

重复第二步，直到所有元素均排序完毕。

```java
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

```



## 插入排序

### 1. 算法步骤

将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。

从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）

```java
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

```



## 归并排序

### 1. 算法步骤

1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
4. 重复步骤 3 直到某一指针达到序列尾；
5. 将另一序列剩下的所有元素直接复制到合并序列尾。



### 2.递归过程：

[(7条消息) 归并排序算法的过程图解_zg1g的博客-CSDN博客_归并排序算法过程图解](https://blog.csdn.net/daigualu/article/details/78399168)写的挺好

![这里写图片描述](https://img-blog.csdn.net/20171031075901288?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZGFpZ3VhbHU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

```java
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
    //包装一下，有统一接口
    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        return mergesort(arr, 0, arr.length - 1);
    }

    /**
     * 真正的归并排序
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
}

```





```java
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

```



## 快速排序