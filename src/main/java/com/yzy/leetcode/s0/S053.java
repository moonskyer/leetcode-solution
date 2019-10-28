package com.yzy.leetcode.s0;

import org.junit.Assert;
import org.junit.Test;

public class S053 {

    public int maxSubArray(int[] nums) {
        return maxSubArray2(nums);
    }

    public int maxSubArray1(int[] nums) {
        /**
         * S[j]表示以下标j结尾数组的最大值，状态方程如下
         * S[j+1]=max(S[j]+a[j+1],a[j+1])  S[0]=a[0]
         * 在规划过程中寻找S数组中的最大值即可
         */
        //特例
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //初始化
        int[] S = new int[nums.length];
        S[0] = nums[0];
        int max = S[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            S[i] = Math.max(S[i - 1], 0) + nums[i];
            max = Math.max(max, S[i]);
        }
        //结果
        return max;
    }

    public int maxSubArray2(int[] nums) {
        /**
         * 在maxSubArray1基础上减少空间
         */
        //特例
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //初始化
        int S = nums[0];
        int max = S;

        for (int i = 1; i < nums.length; i++) {
            S = Math.max(S, 0) + nums[i];
            max = Math.max(max, S);
        }
        return max;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(-1, maxSubArray(new int[]{-1}));
    }

}
