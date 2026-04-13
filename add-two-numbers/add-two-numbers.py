class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    carry = 0
    result_head = ListNode()
    current = result_head

    while l1 is not None or l2 is not None or carry != 0:
        total = carry

        if l1 is not None:
            total += l1.val
        if l2 is not None:
            total += l2.val

        carry = total // 10
        digit = total % 10

        current.next = ListNode(digit)
        current = current.next

        if l1 is not None:
            l1 = l1.next
        if l2 is not None:
            l2 = l2.next

    return result_head.next


# ---- main ----
if __name__ == "__main__":
    # First number: 2 -> 4 -> 3
    list11 = ListNode(2)
    list12 = ListNode(4)
    list13 = ListNode(3)
    list11.next = list12
    list12.next = list13

    # Second number: 5 -> 6 -> 4
    list21 = ListNode(5)
    list22 = ListNode(6)
    list23 = ListNode(4)
    list21.next = list22
    list22.next = list23

    result = addTwoNumbers(list11, list21)

    while result is not None:
        print(result.val, end=" ")
        result = result.next
