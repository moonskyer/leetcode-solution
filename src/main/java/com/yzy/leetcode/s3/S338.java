package com.yzy.leetcode.s3;

import org.junit.Test;

import java.util.Arrays;

public class S338 {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        if (num == 1) return new int[]{0, 1};
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        int lastLoop = 1;
        int index = 2;
        int count = 0;
        while (index <= num) {
            while (count < lastLoop && index <= num) {
                result[index] = result[index - lastLoop];
                index++;
                count++;
            }
            count = 0;
            while (count < lastLoop && index <= num) {
                result[index] = result[index - lastLoop] + 1;
                index++;
                count++;
            }
            lastLoop = lastLoop << 1;
            count = 0;
        }
        return result;
    }


    @Test
    public void test() {
        System.out.println(Arrays.toString(countBits(32)));
    }
}
