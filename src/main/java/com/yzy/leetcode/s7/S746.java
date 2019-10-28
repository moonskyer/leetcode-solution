package com.yzy.leetcode.s7;

import org.junit.Assert;
import org.junit.Test;

public class S746 {
    public int minCostClimbingStairs(int[] cost) {
        //特例
        if (cost == null || cost.length <= 1) {
            return 0;
        }
        if (cost.length == 2) {
            return Math.max(cost[0], cost[1]);
        }
        int[] S = new int[cost.length];
        S[0] = cost[0];
        S[1] = cost[1];
        for (int i = 2; i < S.length; i++) {
            S[i] = Math.min(S[i - 2], S[i - 1]) + cost[i];
        }
        return Math.min(S[S.length - 1], S[S.length - 2]);
    }

    @Test
    public void test() {
        Assert.assertEquals(15, minCostClimbingStairs(new int[]{10, 15, 20}));
        Assert.assertEquals(6, minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
