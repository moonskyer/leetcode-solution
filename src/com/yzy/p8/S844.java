package com.yzy.p8;

import java.util.Stack;

public class S844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        generate(S, stackS);
        generate(T, stackT);
        if (stackS.size() != stackT.size())
            return false;
        while (!stackS.empty()) {
            if (stackS.pop() != stackT.pop())
                return false;
        }
        return true;
    }

    private void generate(String s, Stack<Character> stackS) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if (!stackS.empty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(ch);
            }
        }
    }

    public static void main(String[] args) {
        S844 s844 = new S844();
        System.out.println(s844.backspaceCompare("ab#c", "ad#c"));
        System.out.println(s844.backspaceCompare("ab##", "c#d#"));
        System.out.println(s844.backspaceCompare("a##c", "#a#c"));
        System.out.println(s844.backspaceCompare("a#c", "b"));
    }
}
