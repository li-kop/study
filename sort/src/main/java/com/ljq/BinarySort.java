package com.ljq;

/**
 * @author : LJQ
 * @date : 2019/5/19 13:27
 */
public class BinarySort {
    /***
     *   二分查找第一次出现的位置
     * @param arr
     * @param target
     * @return
     */
    private static int binarySort(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid=(left+right)/2;

        while (left < right){
            if(target>arr[mid]){

                left=mid+1;
            }
            if(target<arr[mid]){

                right=mid-1;
            }

            return mid;
        }

        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 6, 7, 8, 9};

        System.out.println( binarySort(arr, 5));

    }

}
