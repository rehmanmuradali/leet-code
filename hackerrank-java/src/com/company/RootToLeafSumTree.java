package com.company;

public class RootToLeafSumTree {

    public static boolean rootToTreeSum(TreeNode node, int target){
        if (node == null) {
            return false;
        }

        boolean exists = rootToTreeSum(node.left, target - node.val);
        if (exists) {
            return true;
        }

        if (node.left == null && node.right == null && target == node.val) {
            return true;
        }

        return rootToTreeSum(node.right, target - node.val);
    }


    //                  10
    //          7                   15
    //  3           8           12          30
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

        System.out.println(rootToTreeSum(node1, 55));
    }   
}
