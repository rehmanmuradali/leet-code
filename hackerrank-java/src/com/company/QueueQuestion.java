package com.company;

import java.util.*;

class Node {
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class QueueQuestion {



    public static void main(String[] args) {

        Queue<Node> q = new LinkedList<>();
        int i = 1;
        q.add(new Node(i));
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.data);
            while (i < 10)  {
                q.add(new Node(++i));
            }
        }


        Map<String, Node> m = new HashMap<>();
        m.put("1", new Node(1));
        m.put("2", new Node(2));
        m.put("3",  new Node(3));
        for (Map.Entry<String, Node> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().data);
        }

    }
}

