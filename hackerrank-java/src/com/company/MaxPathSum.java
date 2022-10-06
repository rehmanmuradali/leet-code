package com.company;

import java.util.Queue;

public class MaxPathSum {

    //         -10
    //       9     20
    //           15     7
    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        return Math.max(max[0], maxPath(root, max));
    }
    public static int maxPath(TreeNode root, int[] max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxPath(root.left, max);
        int right = maxPath(root.right, max);
        if (left < 0) left = 0;
        if (right < 0) right = 0;

        int resultRootAsCurrentNode = root.val + left + right;
        max[0] = Math.max(Math.max(max[0], resultRootAsCurrentNode), root.val);
        return Math.max(left, right) + root.val;
    }




    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;


        TreeNode s21 = new TreeNode(-2);
        s21.left = new TreeNode(1);

        System.out.println(maxPathSum(s21));
    }
}
