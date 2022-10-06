package com.company;

import com.sun.source.tree.Tree;

public class KthSmallestInBST {


    static int current = 0;
    //              10
    //           7         15
    //       3      8    12    30
    public static int kthSmallestInBST(TreeNode node, int k){
        int[] result = new int[1];
        return kthSmallest(node, k, result).val;
    }

    public static TreeNode kthSmallest(TreeNode node, int k, int[] result){
        if (node == null) {
            return null;
        }
        TreeNode currentNode = kthSmallest(node.left, k, result);
        if (currentNode!= null) {
            return currentNode;
        }
        result[0]++;
        if(result[0] == k) {
            return node;
        }
        return kthSmallest(node.right, k, result);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(30);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(kthSmallestInBST(node1, 4));
    }
}
