class Node:
    def __init__(self, data, next=None) -> None:
        self.data = data
        self.next = next

def output(head):
    temp = head
    while temp != None:
        print(temp.data, end=" ")
        temp = temp.next
    print()

def convertToLinkedList(arr):
    if len(arr) == 0:
        return Node(None)

    head = temp = Node(arr[0])
    if len(arr) > 1:
        for i in arr[1:]:
            temp.next = Node(i)
            temp = temp.next
    return head

def removeXth(head, x):
    if not head:
        return head
    if x == 1:
        return head.next
    
    total = 0
    temp, prev = head, None
    while temp != None:
        total += 1
        if total == x:
            prev.next = prev.next.next
            break
        prev = temp
        temp = temp.next
    return head

def removeValue(head, value):
    if not head:
        return head
    if value == head.data:
        return head.next
    
    temp, prev = head, None
    while temp != None:
        if value == temp.data:
            prev.next = prev.next.next
            break
        prev = temp
        temp = temp.next
    return head

def insertHead(head, value):
    return Node(value, head)

def insertTail(head, value):
    if not head:
        return insertHead(head, value) 
    
    temp = head
    while temp.next != None:
        temp = temp.next
    temp.next = Node(value)
    return head

def insertKthElement(head, value, k):
    if not head:
        return Node(value) if k == 1 else head
    if k == 1:
        return Node(value, head)
    
    total, temp = 0, head
    while temp != None:
        total += 1
        if total == k-1:
            # < if node accept next parameter>
            temp.next = Node(value, temp.next)

            # < if node doesn't accept next parameter >
            # after = temp.next
            # temp.next = Node(value)
            # temp = temp.next
            # temp.next = after

            break
        temp = temp.next
    return head

def insertAtTarget(head, value, target):
    """
    Inseet the value at the target place 
    and move the target as next element of value
    """
    if not head:
        return  head
    if head.data == target:
        return Node(value, head)
    
    temp = head
    while temp.next != None:
        if target == temp.next.data:
            # < if node accept next parameter>
            temp.next = Node(value, temp.next)

            # < if node doesn't accept next parameter >
            # after = temp.next
            # temp.next = Node(value)
            # temp = temp.next
            # temp.next = after

            break
        temp = temp.next
    return head



def main():
    print("Linked List implementation \n")
    head = convertToLinkedList([2,4,6,8])
    # result = removeXth(head, 2)
    # result = removeValue(head,4)
    # result = insertHead(head,1)
    # result = insertTail(head,1)
    # result = insertKthElement(head,1, 3)
    result = insertAtTarget(head,1, 6)
    output(result)



if __name__ == '__main__':
    main()