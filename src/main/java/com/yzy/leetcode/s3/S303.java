package com.yzy.leetcode.s3;

import org.junit.Assert;
import org.junit.Test;

public class S303 {

    private int[] S;

    public void setS(int[] nums) {
        S = new int[nums.length];
        if (nums.length == 0)
            return;
        S[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            S[i] = S[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (S.length == 0 || i == 0) {
            return S[j];
        }
        return S[j] - S[i - 1];
    }

    @Test
    public void test() {
        setS(new int[]{-2, 0, 3, -5, 2, -1});
        Assert.assertEquals(1, sumRange(0, 2));
        Assert.assertEquals(-1, sumRange(2, 5));
        Assert.assertEquals(-3, sumRange(0, 5));
    }

}
