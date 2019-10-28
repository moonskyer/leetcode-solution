package com.yzy.leetcode.s0;

import org.junit.Assert;
import org.junit.Test;

public class S070 {
    public int climbStairs(int n) {
        //特例
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        //初始化
        int[] arr = new int[]{1, 2};
        boolean nextIsFirst = true;
        //循环
        for (int i = 3; i <= n; i++) {
            if (nextIsFirst) {
                arr[0] = arr[0] + arr[1];
            } else {
                arr[1] = arr[0] + arr[1];
            }
            nextIsFirst = !nextIsFirst;
        }
        //返回结果
        return nextIsFirst ? arr[1] : arr[0];
    }

    @Test
    public void test() {
        Assert.assertEquals(2, climbStairs(2));
        Assert.assertEquals(3, climbStairs(3));
    }
}
