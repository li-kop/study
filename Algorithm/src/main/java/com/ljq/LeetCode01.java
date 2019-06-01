package com.ljq;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : LJQ
 * @date : 2019/5/24 17:06
 */
public class LeetCode01 {
    public static void main(String[] args) {
  int []nums={2,7,5,4,10};
        Arrays.stream(twoSum(nums, 9)).forEach(i -> System.out.println(i));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        int[] data = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (map.containsKey(k) && map.get(k) != i) {
                data[0] = i;
                data[1] = map.get(k);
                break;
            }

        }
        return data;
    }


}
