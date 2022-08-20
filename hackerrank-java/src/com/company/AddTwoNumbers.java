package com.company;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultHead = new ListNode();
        ListNode current = resultHead;
        while (l1 !=null || l2!=null){
            int sum =  carry;
            if (l1 != null) {
                sum += l1.val;
            }
            if(l2 != null) {
                sum += l2.val;
            }

            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            current.next = new ListNode(sum);

            if (l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

            current = current.next;
        }

        if (carry > 0 ) {
            current.next = new ListNode(1);
        }
        return resultHead.next;
    }

    public static void main(String[] args) {
        ListNode list11 = new ListNode(2) ;
        ListNode list12 = new ListNode(4) ;
        ListNode list13 = new ListNode(3) ;
        list11.next = list12; list12.next = list13;
        ListNode list21 = new ListNode(5) ;
        ListNode list22 = new ListNode(6) ;
        ListNode list23 = new ListNode(4) ;
        list21.next = list22; list22.next = list23;
        ListNode list31 = addTwoNumbers(list11, list21);
        while(list31 != null) {
            System.out.print(list31.val+  " ");
            list31 = list31.next;
        }
    }
}
