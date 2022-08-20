package com.company;

import java.util.HashMap;
import java.util.Map;

class QNode {
    int val;
    QNode next;
    QNode random;

    public QNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomPointer {

    //
    //
    // 7 -> 1
    // 13 -> 7
    // 11 -> null
    // 10 -> 11
    //  1 -> 7
    //
    // 7   13  11  10   1
    //  current  head    newHead  currentNew    new Node            Map
    //    7       7       -1         -1           7
    //                              -1,7                            7 -> 7
    //                                7
    //    13                        7,13           13               13->13
    //                                13
    //
    //
    //

    public QNode copyRandomList(QNode head) {
        QNode current = head;
        QNode newHead = new QNode(-1);
        QNode currenNew = newHead;
        Map<QNode, QNode> nodesMap = new HashMap<>();

        while(current != null) {
            QNode newNode = new QNode(current.val);
            currenNew.next = newNode;
            nodesMap.put(current, newNode);
            currenNew = currenNew.next;
            current = current.next;
        }

        current = head;
        currenNew = newHead.next;
        while(current != null) {
            currenNew.random = nodesMap.get(current.random);
            currenNew = currenNew.next;
            current = current.next;
        }
        return newHead;
    }

    public static void main(String[] args) {

    }


}
