package clientsort;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 38, 5, 15, 9, 67, 21};
        printArray(arr);
//        BubbleSort bubbleSort = new BubbleSort();
//        int[] res = bubbleSort.bubbleSort(arr);

//        SelectionSort selectSort = new SelectionSort();
//        int[] res = selectSort.selectSort(arr);

//        InsertionSort insertionSort = new InsertionSort();
//        int[] res = insertionSort.insertionSort(arr);

//        MergeSort mergeSort = new MergeSort();
//        int[] res = mergeSort.mergeSort(arr);

//        printArray(res);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
