package com.ljq;


/**
 * @author : LJQ
 * @date : 2019/5/24 20:12
 */
public class 寻找两个有序数组的中位数 {

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] num = new int[l1 + l2];
        int i = 0, j = 0, k = 0;
        while (i < l1 && j < l2) {

            if (nums1[i] < nums2[j]) {
                num[k] = nums1[i];
                i++;
                k++;
            } else {
                num[k] = nums2[j];
                j++;
                k++;

            }

        }
        while (i < l1) {
            num[k] = nums1[i];
            i++;
            k++;
        }
        while (j < l2) {
            num[k] = nums2[j];
            j++;
            k++;
        }

        double result = 0;

        int l = (l1 + l2) ;
        if (l %2 == 0) {

            result = (num[l/2 - 1] + num[l/2]) * 1.0 / 2;
        } else {

            result = num[l/2];
        }

        return result;
    }

}
