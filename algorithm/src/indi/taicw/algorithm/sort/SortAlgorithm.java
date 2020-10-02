package indi.taicw.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author taichangwei
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        int length = 10;
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

        selectionSort(arr);
        System.out.println("选择排序：" + Arrays.toString(arr));


    }

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

}