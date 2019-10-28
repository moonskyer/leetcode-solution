package com.yzy.leetcode.s1;

import org.junit.Assert;
import org.junit.Test;

public class S198 {
    public int rob(int[] nums) {
        return rob1(nums);
    }


    public int rob1(int[] nums) {

        //特例
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //初始化
        int[] S = new int[nums.length];
        S[0] = nums[0];
        S[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            S[i] = Math.max(S[i - 1], S[i - 2] + nums[i]);
        }
        //结果
        return S[nums.length - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(4, rob(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
    }
}
