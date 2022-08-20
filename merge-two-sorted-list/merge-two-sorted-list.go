package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

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
	list31 := mergeTwoLists(&list11, &list21)
	for list31 != nil {
		fmt.Printf("%d ", list31.Val)
		list31 = list31.Next
	}
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	result := ListNode{}
	current := &result
	for list1 != nil || list2 != nil {
		if list1 != nil && list2 != nil {
			if list1.Val < list2.Val {
				current.Next = list1
				list1 = list1.Next
			} else {
				current.Next = list2
				list2 = list2.Next
			}
		} else if list2 != nil {
			current.Next = list2
			list2 = list2.Next
		} else {
			current.Next = list1
			list1 = list1.Next
		}
		current = current.Next
	}
	return result.Next
}
