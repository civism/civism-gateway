package com.civism.gateway;

import java.util.Arrays;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/9/22 17:47
 * @E-mail:695234456@qq.com
 * @return
 */
public class MainTest {

    public static void main(String[] args) {


        int[] nums = {0,1,0};
         moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    int n = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = n;
                }
            }
        }
    }
}
