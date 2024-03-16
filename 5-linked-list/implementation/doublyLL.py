class Node:
    def __init__(self, data, next=None, back=None) -> None:
        self.data = data
        self.next = next
        self.back = back
# --------------------------------------------------------------
def output(head):
    temp = head
    print("| Doubly Linked List in given Order |")
    while temp:
        print(temp.data, end=" ")
        temp = temp.next
    print()

def reverseOutput(tail):
    temp = tail
    print("| Doubly Linked List in given Reverser Order |")
    while temp:
        print(temp.data, end=" ")
        temp = temp.back
    print()

def dllConversion(items):
    head = tail = None
    if len(items) < 1:
        return [head, tail]
    
    head = tail = Node(items[0])

    for item in items[1:]:
        tail.next = Node(item)
        tail.next.back = tail
        tail = tail.next
    
    return [head, tail]

def deleteHead(head):
    if not head or not head.next:
        return 
    temp = head
    head = head.next
    head.back = None
    temp.next = None
    return head
    
def deleteTail(tail):
    # Using Tail
    if not tail or not tail.back:
        return
    temp = tail
    tail = tail.back
    tail.next = None
    temp.back = None
    return tail

def deleteLast(head):
    if not head or not head.next:
        return
    temp = head
    while temp.next:
        temp = temp.next
    temp.back.next = None
    temp.back = None
    return head

def deleteKth(head, k):
    total, temp, present = 0, head, False
    while temp:
        total += 1
        if total == k:
            present = True
            break
        temp = temp.next

    if present:
        before, after = temp.back, temp.next
        if not before and not after:
            return 
        if not before:
            head = head.next
            head.back = None
            temp.next = None
        elif not after:
            temp.back.next = None
            temp.back = None
        elif present:
            temp.back.next = after
            temp.next.back = before
            temp.back = None
            temp.next = None
    return head

def deleteTarget(head, target):
    temp, present = head, False
    while temp:
        if temp.data == target:
            present = True
            break
        temp = temp.next
    
    if present:
        before, after = temp.back, temp.next
        if not before and not after:
            return 
        if not before:
            head = head.next
            head.back = None
            temp.next = None
        elif not after:
            temp.back.next = None
            temp.back = None
        elif present:
            temp.back.next = after
            temp.next.back = before
            temp.back = None
            temp.next = None
    return head

def insertBefore(head, value, pos):
    if not head:
        return Node(value)
    newNode = Node(value)
    temp, total, present = head, 0, False
    while temp:
        total += 1
        if total == pos:
            present = True
            break
        temp = temp.next
    
    if present:
        before, after = temp.back, temp.next
        if not before and not after:
            newNode.next = head
            head.back = newNode
            head = newNode
        elif not before:
            temp.back = newNode
            newNode.next = head
            head = newNode
        elif not after:
            temp.back.next = newNode
            newNode.back = before
            newNode.next = temp
            temp.back = newNode
        else:
            temp.back.next = newNode
            newNode.back = temp.back
            newNode.next = temp
            temp.back = newNode
    return head

def insertAfter(head, value, pos):
    
    if not head:
        return
    newNode = Node(value)
    temp, total, present = head, 0, False
    while temp:
        total += 1
        if total == pos:
            present = True
            break
        temp = temp.next
    if present:
        if not temp.back and not temp.next:
            head.next = newNode
            newNode.back = head
        elif not temp.back:
            newNode.back = head
            newNode.next = head.next
            newNode.next.back = newNode
            head.next = newNode
        elif not temp.next:
            temp.next = newNode
            newNode.back = temp
        else:
            newNode.back = temp
            newNode.next = temp.next
            temp.next.back = newNode
            temp.next = newNode
    return head


# --------------------------------------------------------------
def main():
    print("< Doubly Linked List > \n")
    head, tail = dllConversion([29,47,65,83])
    # output(head)
    # print()
    # print()
    # reverseOutput(tail)
    # front = deleteHead(head)
    # output(front)
    # rear = deleteTail(tail)
    # reverseOutput(rear)
    # result = deleteLast(head)
    # output(result)
    # result = deleteKth(head, 3)
    # output(result)
    # result = deleteTarget(head, 65)
    # output(result)
    # result = insertBefore(head, 1, 3)
    # output(result)
    result = insertAfter(head, 1, 0)
    output(result)


if __name__ == '__main__':
    main()