package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class IsValidBST {
        public static boolean isValidBST(TreeNode root) {
            //return isValidBSTRecursive(root, null, null);
            //return isValidBSTInOrderTraversal(root);
            return checkTreeIsBST(root);
        }
    
        public static boolean isValidBSTInOrderTraversal(TreeNode root) {
            List<Integer> elements = inOrderTraversal(root, new ArrayList<>());
            return isSorted(elements);
        }
    
        private static boolean isSorted(List<Integer> elements) {
            Integer prev = null;
            for (Integer current :
                 elements) {
                if(prev!=null && prev >= current) {
                    return false;
                }
                prev = current;
            }
            return true;
        }
    
        public static List<Integer> inOrderTraversal(TreeNode root, List<Integer> elements){
            if (root == null) {
                return  elements;
            }
            List<Integer> elemAfterLeft = inOrderTraversal(root.left, elements);
            elemAfterLeft.add(root.val);
            return inOrderTraversal(root.right, elemAfterLeft);
        }



    public static boolean isValidBSTRecursive(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null){
            return true;
        }
        if (min != null && root.val <= min.val){
            return false;
        }
        if (max != null && root.val >= max.val){
            return false;
        }
        return  isValidBSTRecursive(root.left, min , root ) && isValidBSTRecursive(root.right, root, max);
    }



    static boolean checkTreeIsBST(TreeNode root)
    {
        // Stores root node and left
        // subtree of each node
        Stack<TreeNode > stack = new Stack< >();

        // Stores previous visited node
        TreeNode prev = null;

        // Traverse the binary tree
        //                5
        //          4               7
        //                    6           8
        while (!stack.isEmpty() ||
                root != null) {

            // Traverse left subtree
            while (root != null) {

                // Insert root into Stack
                stack.add(root);

                // Update root
                root = root.left;
            }

            // Stores top element of Stack
            root = stack.peek();

            // Remove the top element of Stack
            stack.pop();

            // If data value of root node less
            // than data value of left subtree
            if(prev != null &&
                    root.val <= prev.val) {
                return false;
            }

            // Update prev
            prev = root;

            // Traverse right subtree
            // of the tree
            root = root.right;
        }
        return true;
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


        System.out.println(isValidBST(node1));

    }

}
