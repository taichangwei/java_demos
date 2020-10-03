package indi.taicw.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author taichangwei
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        int length = 30;
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i< arr.length; i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println("排序前:  " + Arrays.toString(arr));

//        bubbleSort(arr);
//        System.out.println("冒泡排序：" + Arrays.toString(arr));

//        insertionSort(arr);
//        System.out.println("插入排序：" + Arrays.toString(arr));

//        selectionSort(arr);
//        System.out.println("选择排序：" + Arrays.toString(arr));

//        mergerSort(arr);
//        System.out.println("归并排序：" + Arrays.toString(arr));

        quickSort(arr);
        System.out.println("快速排序：" + Arrays.toString(arr));


    }

    //===========================================================================
    /**
     * 冒泡排序
     * @param arr 待排序数组
     */
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }

        for(int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i -1; j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }


    //============================================================================
    /**
     * 插入排序
     * @param arr 待排序数组
     */
    public static void insertionSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }

        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--){
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }


    //===========================================================================
    /**
     * 选择排序
     * @param arr 待排序数组
     */
    public static void selectionSort(int [] arr){
        int length = arr.length;
        if (length <= 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (arr[i] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    //===========================================================================
    /**
     * 归并排序
     * @param arr 待排序数组
     */
    public static void mergerSort(int[] arr){
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        mergeSortInternally(arr, 0, length-1);
    }
    /**
     * 递归拆分合并内部数组
     * @param arr 待排序数组
     * @param p 首部索引
     * @param r 尾部索引
     */
    public static void mergeSortInternally(int[] arr, int p, int r){
        if (p >= r) {
            return;
        }
        int q = (p+r)/2;
        mergeSortInternally(arr, p, q);
        mergeSortInternally(arr, q + 1, r);
        merge(arr, p, q, r);
    }
    /**
     * 合并数组 arr[p..q], arr[q+1..r]
     * @param arr 待排序数组
     * @param p 左边数组首部索引
     * @param q 左边数组尾部索引（q+1 为右边数组首部索引）
     * @param r 右边数组尾部索引
     */
    private static void merge(int[] arr, int p, int q, int r) {
        if (p >= r) {
            return;
        }
        int[] temp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        int start = i, end = q;
        if (i > q) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[p + i] = temp[i];
        }
    }



    //===========================================================================
    /**
     * 快速排序
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr){
        int length = arr.length;
        if (length <= 1) {
            return;
        }

        quickSortInternally(arr, 0, length - 1);
    }

    /**
     * 递归排序子数组
     * @param arr 待排序数组
     * @param p 首部索引
     * @param r 尾部索引
     */
    public static  void quickSortInternally(int[] arr, int p, int r) {
        if (p >=r) {
            return;
        }
        int q = partition(arr, p, r);
        quickSortInternally(arr, p, q-1);
        quickSortInternally(arr, q+1, r);

    }

    /**
     * 分区, 选定数组最后一个元素值作为比较的中心点，把小于中心点的都移到中心点左边，否者移到中心点右边
     * @param arr 待排序数组
     * @param p 首部索引
     * @param r 尾部索引
     * @return 中心点的索引
     */
    private static int partition(int[] arr, int p, int r) {
        if (p >= r) {
            return p;
        }
        int middleValue = arr[r];
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (arr[j] < middleValue) {
                if (i == j) {
                    i++;
                } else {
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        arr[r] = arr[i];
        arr[i] = middleValue;

        return i;
    }

}