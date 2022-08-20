package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedLinkedList {

    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));

        while(listNodes.size() > 1) {
            ListNode merged = mergeTwoLists(listNodes.get(0),listNodes.get(1));
            listNodes.remove(0);
            listNodes.remove(0);
            listNodes.add(merged);
        }
        return listNodes.size() > 0 ? listNodes.get(0) : null;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null){
                if (list1.val < list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                }
            } else if(list2 != null) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode list11 = new ListNode(1) ;
        ListNode list12 = new ListNode(3) ;
        ListNode list13 = new ListNode(5) ;
        list11.next = list12; list12.next = list13;
        ListNode list21 = new ListNode(2) ;
        ListNode list22 = new ListNode(4) ;
        ListNode list23 = new ListNode(6) ;
        list21.next = list22; list22.next = list23;



        ListNode list31 = mergeKLists(new ListNode[] {list11, list21});
        while(list31 != null) {
            System.out.print(list31.val+  " ");
            list31 = list31.next;
        }
    }
}
