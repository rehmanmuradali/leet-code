package com.company;

import com.sun.source.tree.Tree;

import java.util.*;

public class ZigZagTraversal {
    //      3
    //    9   20
    //      15  7





    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean isLeftOriented = false;
        while(!q.isEmpty()) {
            TreeNode node = q.remove();

            if(node == null){
                isLeftOriented = !isLeftOriented;
                continue;
            }

            if (isLeftOriented){
                addNode(q, root.left);
                addNode(q, root.right);
            } else {
                addNode(q, root.right);
                addNode(q, root.left);
            }

            q.add(null);
        }


        return null;
    }

    public static Queue<TreeNode> addNode(Queue<TreeNode> q, TreeNode n) {
        if (n!=null) q.add(n);
        return q;
    }

    //                5
    //          4               7
    //                    6           8
    //
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean isEven = false;
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<levelNum;i++){
                if(isEven){
                    TreeNode pop = q.pollLast();
                    list.add(pop.val);
                    if(pop.right != null) q.addFirst(pop.right);
                    if(pop.left != null) q.addFirst(pop.left);
                }else{
                    TreeNode pop = q.pollFirst();
                    list.add(pop.val);
                    if(pop.left != null) q.addLast(pop.left);
                    if(pop.right != null) q.addLast(pop.right);
                }
            }
            isEven = !isEven;
            res.add(list);
        }
        return res;
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


        PriorityQueue<Integer> numbers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        numbers.add(4);
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        System.out.print("PriorityQueue: " + numbers);
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
