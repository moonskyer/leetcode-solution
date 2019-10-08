package com.yzy.p0;

import com.yzy.common.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        return iteration(root);
    }

    //左中右的顺序
    private List<Integer> recursion(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new LinkedList<>();
        if (root.left != null)
            result.addAll(recursion(root.left));
        result.add(root.val);
        if (root.right != null)
            result.addAll(recursion(root.right));
        return result;
    }

    private List<Integer> iteration(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            //将当前节点的左子节点全部入栈。
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            //此时栈顶应该是需要访问的节点，取出来
            current = stack.pop();
            result.add(current.val);
            //转向当前节点的右子节点进行处理
            current = current.right;
        }
        return result;
    }

    public static void main(String[] args) {
        S094 s094 = new S094();
        TreeNode root = create();
        System.out.println(s094.inorderTraversal(root));
    }

    private static TreeNode create() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }
}
