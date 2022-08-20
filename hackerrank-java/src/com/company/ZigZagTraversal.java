package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {



    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();

//            if (node.val)
        }


        return null;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);
//
//        node1.left = node2;
//        node1.right = node3;




        //                5
        //          2               4
        //      1       4       6           8
        //
        //    Root          Min             Max     Node
        //     5            min             max      l
        //     4            min             5        l
        //     3            min             4        l
        //
        //    6             5               max
        //
        //
        //
        //


        List<List<Integer>> result =  zigzagLevelOrder(node1);

        for (List<Integer> list:
             result) {

            for (Integer elem:
                 list) {
                System.out.println(elem + " ");
            }
            System.out.println();
        }


        System.out.println();

    }
}
