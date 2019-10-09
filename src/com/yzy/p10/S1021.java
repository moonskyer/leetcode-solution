package com.yzy.p10;

import java.util.LinkedList;
import java.util.List;

public class S1021 {
    public String removeOuterParentheses(String S) {
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int top = -1;
        while (index < S.length()) {
            sb.append(S.charAt(index));
            index++;
            top = 0;
            while (index < S.length() && top > -1) {
                char ch = S.charAt(index);
                if (ch == '(') {
                    top++;
                    sb.append(ch);
                } else {
                    top--;
                    sb.append(ch);
                }
                index++;
            }
            list.add(sb.toString());
            sb.delete(0, sb.length());
        }
        for (String s : list) {
            if (s.length() > 2) {
                sb.append(s, 1, s.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        S1021 s1021 = new S1021();
        String result = s1021.removeOuterParentheses("(()())(())");
        System.out.println("->" + result);
        result = s1021.removeOuterParentheses("(()())(())(()(()))");
        System.out.println("->" + result);
        result = s1021.removeOuterParentheses("()()");
        System.out.println("->" + result);
    }
}
