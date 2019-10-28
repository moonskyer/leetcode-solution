package com.yzy.leetcode.s1;

import com.yzy.leetcode.common.TreeNode;

import java.util.*;

public class S145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        return iteration(root);
//        List<Integer> result = new ArrayList<>();
//        if (root == null)
//            return result;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root;
//        TreeNode last = null;
//        do {
//            while (current != null) {
//                stack.push(current);
////                current = current.left;
//            }
//
//            while (!stack.empty()) {
//                current = stack.peek();
//                if (current.right == null || current.right == last) {
//                    result.add(current.val);
//                    last = stack.pop();
//                } else {
//                    current = current.right;
//                    break;
//                }
//            }
//        } while (!stack.empty());
//
//        return result;
    }

    private List<Integer> recursion(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        if (root.left != null)
            result.addAll(recursion(root.left));
        if (root.right != null)
            result.addAll(recursion(root.right));
        result.add(root.val);
        return result;
    }

    private List<Integer> iteration(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        TreeNode current = root;
        while (!stack.empty() || current != null) {
            //将当前预备节点和所有右节点入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            //peek栈顶节点
            TreeNode peek = stack.peek();
            // 如果栈顶节点无右子节点或者上个访问节点恰好是右子节点时,访问该节点，并弹出
            if (peek.right == null || peek.right == last) {
                result.add(peek.val);
                stack.pop();
                last = peek;
                current = null;
            } else {
                //否则将预备节点设置为不为null的右子节点
                current = peek.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S145 s145 = new S145();
        TreeNode root = create();
        System.out.println(s145.postorderTraversal(root));
    }

    private static TreeNode create() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

}
