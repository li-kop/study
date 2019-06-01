package com.ljq;


import java.util.Arrays;

/**
 * @author : LJQ
 * @date : 2019/5/19 12:50
 */
public class QuickSort {
    /***
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        int temp = 0;

        if (l <= r) {
            temp = arr[l];
            while (l != r) {

                while (r > l && arr[r] >= temp) {
                    r--;
                }
                arr[l] = arr[r];

                while (l < r && arr[l] <= temp) {
                    l++;
                }
                arr[r] = arr[l];
            }
            arr[r] = temp;
            quickSort(arr, left, l - 1);
            quickSort(arr, r + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 8, 7, 9, 5, 4, 4, 9};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.asList(arr));
    }
}
