package com.yzy.leetcode.s3;

import org.junit.Assert;
import org.junit.Test;

public class S392 {

    public boolean isSubsequence(String s, String t) {
        //特例处理
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        //双层数组
        boolean[][] ans = new boolean[2][t.length()];
        int layer = 0;
        int loop = 0;
        //循环
        while (loop < s.length()) {
            //每一层的处理
            int index = loop;
            while (index < t.length()) {
                ans[layer][index] = s.charAt(loop) == t.charAt(index) && (loop == 0 || ans[1 - layer][index - 1]);
                if (ans[layer][index++]) {
                    break;
                }
            }
            while (index < t.length()) {
                ans[layer][index++] = true;
            }
            layer = 1 - layer;
            loop++;
        }
        return ans[1 - layer][t.length() - 1];
    }

    @Test
    public void test() {
        Assert.assertTrue(isSubsequence("abc", "ahbgdc"));
        Assert.assertFalse(isSubsequence("axc", "ahbgdc"));
    }
}
