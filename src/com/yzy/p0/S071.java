package com.yzy.p0;

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

    public static void main(String[] args) {
        S071 s071 = new S071();
        System.out.println(s071.simplifyPath("/home/"));
        System.out.println(s071.simplifyPath("/../"));
        System.out.println(s071.simplifyPath("/home//foo/"));
        System.out.println(s071.simplifyPath("/a/./b/../../c/"));
        System.out.println(s071.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(s071.simplifyPath("/a//b////c/d//././/.."));
    }
}
