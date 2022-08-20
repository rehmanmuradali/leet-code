package main

import "fmt"

func main() {
	list11 := ListNode{2, nil}
	list12 := ListNode{4, nil}
	list13 := ListNode{3, nil}
	list11.Next = &list12
	list12.Next = &list13
	list21 := ListNode{5, nil}
	list22 := ListNode{6, nil}
	list23 := ListNode{4, nil}
	list21.Next = &list22
	list22.Next = &list23
	list31 := addTwoNumbers(&list11, &list21)
	for list31 != nil {
		fmt.Printf("%d ", list31.Val)
		list31 = list31.Next
	}
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	carry := 0
	resultHead := ListNode{}
	current := &resultHead
	for l1 != nil || l2 != nil || carry != 0 {
		sum := carry
		if l1 != nil {
			sum += l1.Val
		}
		if l2 != nil {
			sum += l2.Val
		}

		carry = sum / 10
		sum %= 10

		current.Next = &ListNode{sum, nil}

		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}

		current = current.Next
	}
	return resultHead.Next
}
