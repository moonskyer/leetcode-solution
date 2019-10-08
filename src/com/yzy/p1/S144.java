package com.yzy.p1;

import com.yzy.common.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return iteration(root);
    }

    public List<Integer> recursion(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new LinkedList<>();
        result.add(root.val);
        if (root.left != null)
            result.addAll(recursion(root.left));
        if (root.right != null)
            result.addAll(recursion(root.right));
        return result;
    }

    public List<Integer> iteration(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //当栈不为空时，此时栈顶为访问节点
        while (!stack.empty()) {
            //取出栈顶节点并访问
            TreeNode current = stack.pop();
            result.add(current.val);
            //依次压入右左子节点
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
        return result;
    }

    public static void main(String[] args) {
        S144 s144 = new S144();
        TreeNode root = create();
        System.out.println(s144.preorderTraversal(root));
    }

    private static TreeNode create() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }
}
