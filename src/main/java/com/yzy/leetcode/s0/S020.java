package com.yzy.leetcode.s0;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class S020 {

    public boolean isValid(String s) {
        if (s == null || "".equals(s))
            return true;

        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else if (top == -1) {
                return false;
            } else if (get(c) == stack[top]) {
                top--;
            } else {
                return false;
            }
        }
        return top == -1;
    }

    private char get(char c) {
        switch (c) {
            case ')':
                return '(';
            case '}':
                return '{';
            default:
                return '[';
        }
    }

    @Test
    public void test() {
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
        assertFalse(isValid("([)]"));
        assertTrue(isValid("{[]}"));
    }
    
}
