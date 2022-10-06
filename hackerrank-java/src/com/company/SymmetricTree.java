package com.company;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
       //return isSymmetricIterative(root);
       return isSymmetricRecursive(root);
    }

    private static boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRecursive(root.left, root.right);
    }
    private static boolean isSymmetricRecursive(TreeNode left, TreeNode right) {

        if(left == null || right == null) {
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left);
    }


    public static boolean isSymmetricIterative(TreeNode root) {
        List<Integer> left = depthFirstSearch(root.left, false);
        List<Integer> right = depthFirstSearch(root.right, true);
        return left.equals(right);
    }

    //                1
    //          2               2
    //      null    3      null     3
    public static List<Integer> depthFirstSearch(TreeNode root, boolean isLeftOriented) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> elements = new ArrayList<>();
        if(root == null) {
            return new ArrayList<>();
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            elements.add(current == null? Integer.MIN_VALUE : current.val);
            if (current == null){
                continue;
            }

            stack.push(isLeftOriented ? current.left: current.right );
            stack.push(isLeftOriented ? current.right: current.left );


        }
        return elements;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        //node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        //node3.right = node7;





        //                1
        //          2               2
        //      3       4       4           3
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


        System.out.println(isSymmetric(node1));

    }
}
