package com.yzy.p4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return solution2(nums1, nums2);
    }

    //单调栈解法
    private int[] solution2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = generate2(nums2);
        return get(nums1, map);
    }

    private Map<Integer, Integer> generate2(int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.empty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        return map;
    }

    private int[] solution1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = generate(nums2);
        return get(nums1, map);
    }

    private int[] get(int[] nums, Map<Integer, Integer> map) {
        return Arrays.stream(nums).map(map::get).toArray();
    }

    private Map<Integer, Integer> generate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    map.put(nums[i], nums[j]);
                    break;
                }
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], -1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        S496 s496 = new S496();
        System.out.println(Arrays.toString(s496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(s496.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

}
