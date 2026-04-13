package com.company.rightView;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;
    Max_level max = new Max_level();

    // Recursive function to print right view of a binary
    // tree.
    void rightViewUtil(Node node, int level,
                       Max_level max_level)
    {

        // Base Case
        if (node == null)
            return;

        // If this is the last Node of its level
        if (max_level.max_level < level) {
            System.out.print(node.data + " ");
            max_level.max_level = level;
        }

        // Recur for right subtree first, then left subtree
        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);
    }

    void rightView() { rightView(root); }

    // A wrapper over rightViewUtil()
    void rightView(Node node)
    {

        rightViewUtil(node, 1, max);
    }


    public void rightViewIterative() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            int length = queue.size();
            Node node = queue.peek();
            for (int i = 0 ; i< length; i++) {
                 node = queue.poll();
                 if(node.left != null) {
                     queue.add(node.left);
                 }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            System.out.print(node.data + " ");
        }
    }
}
