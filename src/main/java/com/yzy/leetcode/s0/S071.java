package com.yzy.leetcode.s0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class S071 {
    public String simplifyPath(String path) {
        String[] stack = new String[255];
        int top = -1;
        int index = 0;
        while (index < path.length()) {
            //跳过'/'
            while (index < path.length() && path.charAt(index) == '/') {
                index++;
            }
            if (index == path.length()) {
                break;
            }
            //获取当前目录
            int start = index;
            while (index < path.length() && path.charAt(index) != '/') {
                index++;
            }
            String dir = path.substring(start, index);

            //对当前目录分情况套路
            if ("..".equals(dir)) {
                if (top > -1) {
                    top--;
                }
            } else if (!".".equals(dir)) {
                stack[++top] = dir;
            }
        }

        //构造结果
        if (top == -1) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append("/").append(stack[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals("/home", simplifyPath("/home/"));
        assertEquals("/", simplifyPath("/../"));
        assertEquals("/home/foo", simplifyPath("/home//foo/"));
        assertEquals("/c", simplifyPath("/a/./b/../../c/"));
        assertEquals("/c", simplifyPath("/a/../../b/../c//.//"));
        assertEquals("/a/b/c", simplifyPath("/a//b////c/d//././/.."));
    }
}
