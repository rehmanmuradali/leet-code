package com.company;

import javax.print.DocFlavor;

public class DiameterOfBinaryTree {

    //                     4
    //            -7            -3
    //                      -9       -3
    //                    9   -7  -4
    //                  6  -6  -6
    //
    public static int diameterOfBinaryTree(TreeNode root) {

        int[] result = new int[1];
        diameterOfBT(root, result);
        return result[0];
    }

    public static int diameterOfBT(TreeNode root, int[] result) {
        if(root == null) return 0;
        int left = diameterOfBT(root.left, result);
        int right = diameterOfBT(root.right, result);
        result[0] = Math.max(result[0], left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(-7);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(-9);
        TreeNode node5 = new TreeNode(-3);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;


        System.out.println(diameterOfBinaryTree(node1));
    }
}
