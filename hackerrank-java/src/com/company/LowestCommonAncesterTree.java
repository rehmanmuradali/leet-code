package com.company;

import com.sun.source.tree.Tree;

public class LowestCommonAncesterTree {

    class Solution {

        private TreeNode ans;

        public Solution() {
            // Variable to store LCA node.
            this.ans = null;
        }

        private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

            // If reached the end of a branch, return false.
            if (currentNode == null) {
                return false;
            }

            // Left Recursion. If left recursion returns true, set left = 1 else 0
            int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

            // Right Recursion
            int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            // If the current node is one of p or q
            int mid = (currentNode == p || currentNode == q) ? 1 : 0;


            // If any two of the flags left, right or mid become True
            if (mid + left + right >= 2) {
                this.ans = currentNode;
            }

            // Return true if any one of the three bool values is True.
            return (mid + left + right > 0);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Traverse the tree
            this.recurseTree(root, p, q);
            return this.ans;
        }
    }



    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);
    }


    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) {
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode lNode = lca (root.left, p, q);
        TreeNode rNode = lca(root.right, p, q);


        if (lNode == null && rNode==null) {
            return null;
        }

        if (lNode != null && rNode!=null) {
            return root;
        }

        return lNode == null ? rNode : lNode;
    }

    //               5
    //      4                           7
    //                              6           8


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


        System.out.println(lowestCommonAncestor(node1, node3, node5).val);
    }

}
