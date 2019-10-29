package com.yzy.leetcode.s6;

import org.junit.Assert;
import org.junit.Test;

public class S062 {

    private static int[][] arr = new int[100][100];

    {
        for (int i = 0; i < 100; i++) {
            arr[0][i] = 1;
            arr[i][0] = 1;
        }
    }

    public int uniquePaths(int m, int n) {
        if (arr[m - 1][n - 1] != 0) {
            return arr[m - 1][n - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(28, uniquePaths(7, 3));
    }
}
