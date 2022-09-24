package sort;

/**
 * bubbleSort
 * 稳定性：稳定
 * 时间复杂度 ：最佳：O(n) ，最差：O(n2)， 平均：O(n2)
 * 空间复杂度 ：O(1)
 * 排序方式 ：In-place

 * @time 2022-09-24-9:52
 */
public class BubbleSort {

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


//    public static int[] bubbleSort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            boolean flag = true;
//            for (int j = 0; j < arr.length - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//                    // Change flag
//                    flag = false;
//                }
//            }
//            if (flag) {
//                break;
//            }
//        }
//        return arr;
//    }

}
