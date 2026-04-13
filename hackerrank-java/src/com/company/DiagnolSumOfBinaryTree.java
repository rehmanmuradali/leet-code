package com.company;

import java.util.*;

public class DiagnolSumOfBinaryTree {

    class TreeNode
    {
        int data; //node data
        int vd; //vertical distance diagonally
        TreeNode left, right; //left and right child's reference

        // Tree node constructor
        public TreeNode(int data)
        {
            this.data = data;
            vd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    // Tree class
    class Tree
    {
        TreeNode root;//Tree root

        // Tree constructor
        public Tree(TreeNode root)  {  this.root = root;  }

        // Diagonal sum method
        public void diagonalSum()
        {
            // Queue which stores tree nodes
            Queue<TreeNode> queue = new LinkedList<TreeNode>();

            // Map to store sum of node's data lying diagonally
            Map<Integer, Integer> map = new TreeMap<>();

            // Assign the root's vertical distance as 0.
            root.vd = 0;

            // Add root node to the queue
            queue.add(root);

            // Loop while the queue is not empty
            while (!queue.isEmpty())
            {
                // Remove the front tree node from queue.
                TreeNode curr = queue.remove();

                // Get the vertical distance of the dequeued node.
                int vd = curr.vd;

                // Sum over this node's right-child, right-of-right-child
                // and so on
                while (curr != null)
                {
                    int prevSum = (map.get(vd) == null)? 0: map.get(vd);
                    map.put(vd, prevSum + curr.data);

                    // If for any node the left child is not null add
                    // it to the queue for future processing.
                    if (curr.left != null)
                    {
                        curr.left.vd = vd+1;
                        queue.add(curr.left);
                    }

                    // Move to the current node's right child.
                    curr = curr.right;
                }
            }

            // Make an entry set from map.
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();

            // Make an iterator
            Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

            // Traverse the map elements using the iterator.
            System.out.print("Diagonal sum in a binary tree is - ");
            while (iterator.hasNext())
            {
                Map.Entry<Integer, Integer> me = iterator.next();

                System.out.print(me.getValue()+" ");
            }
        }
    }

}
