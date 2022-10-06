package com.company;

import java.util.List;

public class MergeTwoSortedList {

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


    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {

        ListNode current = new ListNode();
        ListNode head = mergeTwoListsRecursiveInternal(list1, list2, current);
        return current.next;
    }

    // 1 3 5 7 9
    // 2 4 6 8 10

    // 1  2
    // dummy ->
    //
    //

    private static ListNode mergeTwoListsRecursiveInternal(ListNode list1, ListNode list2, ListNode current) {

        if (list1 != null && list2 != null){
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                return mergeTwoListsRecursiveInternal(list1.next, list2, current.next);
            } else {
                current.next = new ListNode(list2.val);
                return mergeTwoListsRecursiveInternal(list1, list2.next, current.next);
            }
        }

        if ( list1 != null ){
            current.next = new ListNode(list1.val);
            return mergeTwoListsRecursiveInternal(list1.next, null, current.next);
        }
        if ( list2 != null ){
            current.next = new ListNode(list2.val);
            return mergeTwoListsRecursiveInternal(null, list2.next, current.next);
        }
        return null;
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
        ListNode list31 = mergeTwoListsRecursive(list11, list21);
        while(list31 != null) {
            System.out.print(list31.val+  " ");
            list31 = list31.next;
        }
    }
}
