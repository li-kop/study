package com.ljq;

import java.util.Arrays;

/**
 * @author : LJQ
 * @date : 2019/5/24 17:50
 */
public class LeetCode01_1 {
    public static void main(String[] args) {
        int [] nums={2,7,8,10};
        Arrays.stream(twoSum(nums, 9)).forEach(i -> System.out.println(i));

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] num=new int[2];
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    num[0]=i;
                    num[1]=j;
                    break;

                }
            }
        }


        return num;
    }
}
