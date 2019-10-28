package com.yzy.leetcode.s1;

import java.util.Stack;

public class S155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> mins;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (mins.empty() || mins.peek() >= x) {
            mins.push(x);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == mins.peek()) {
            mins.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
