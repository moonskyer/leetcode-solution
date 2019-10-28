package com.yzy.leetcode.s6;

import java.util.Stack;

public class S682 {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int next = stack.pop();
                    int prior = stack.pop();
                    stack.push(prior);
                    stack.push(next);
                    stack.push(prior + next);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!stack.empty())
            sum += stack.pop();
        return sum;
    }

    public static void main(String[] args) {
        S682 s682 = new S682();
        System.out.println(s682.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(s682.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
