class LL:
    def __init__(self, data, next=None) -> None:
        self.data = data
        self.next = next

class DD:
    def __init__(self, data, next=None, back=None) -> None:
        self.data = data
        self.next = next
        self.back = back

def convertLL(items):
    if len(items) == 0:
        return LL(None)

    head = temp = LL(items[0])
    if len(items) > 1:
        for i in items[1:]:
            temp.next = LL(i)
            temp = temp.next
    return head

def convertDD(items):
    head = None
    if len(items) < 1:
        return head
    
    head = temp = DD(items[0])
    for item in items[1:]:
        temp.next = DD(item)
        temp.next.back = temp
        temp = temp.next
    return head

def output(head):
    temp = head
    print("| Output |")
    while temp:
        print(temp.data, end=" ")
        temp = temp.next
    print()
##################################################################
def reverseDLL(head):
    """
    Using Stack and traversing for 2 times (1 for storing data and 2 for replacing data)
    TC : O(2N)
    SC : O(N)
    (or)
    Below Solution : Just swapping pointers
    TC : O(N)
    SC : O(1)
    """
    if not head:
        return
    temp = head
    while temp:
        head = temp
        temp.next, temp.back = temp.back, temp.next
        temp = temp.back
    return head

def addTwoNumbers(num1=None, num2=None):
    num1 = convertLL([1,2,3])
    num2 = convertLL([4,5,6])
    # total =  [1,2,3] + [4,5,6] = [5, 7, 9]
    """
    The below solution :
    TC : O(M+N)
    SC : O(M+N) # considering the space of the output
    """
    if not num1 and not num2:
        return
    if num1 and not num2:
        return num1
    if num2 and not num1:
        return num2

    start = result = LL(-1)
    carry = 0
    while num1 or num2:
        item = carry
        item += num1.data if num1 else 0
        item += num2.data if num2 else 0
        carry = item // 10
        result.next = LL(item % 10)
        result = result.next
        if num1: num1 = num1.next
        if num2: num2 = num2.next
    if carry > 0:
        result.next = LL(carry)
    return start.next

def oddEven(head=None):
    head = convertLL([1,2,3,4,5])
    #  o e o e o e
    # [1,2,3,4,5]

    # head = convertLL([1,2,3,4,5,6])
    #  o e o e o e o e
    # [1,2,3,4,5,6]
    if head and head.next:
        odd = head
        evenHead = even = head.next
        while even and even.next:
            odd.next = odd.next.next
            even.next = even.next.next
            odd = odd.next
            even = even.next
        odd.next = evenHead
    return head

def zot(head=None):
    head = convertLL([1,2,0,2,1,2,0])
    """
    Sorting Linked List of 0's 1's and 2's
    TC : O(N)
    SC : O(3) ~ O(1) <including the output>
    """
    if head and head.next:
        zero = zeroh = LL(-1)
        one = oneh = LL(-1)
        two = twoh = LL(-1)
        temp = head
        while temp:
            if temp.data == 0:
                zero.next = temp
                zero = zero.next
            elif temp.data == 1:
                one.next = temp
                one = one.next
            else:
                two.next = temp
                two = two.next
            temp = temp.next
        zero.next = oneh.next if oneh.next else twoh.next
        one.next = twoh.next
        two.next = None
        head = zeroh.next
    return head

            


    
            





##################################################################
def main():
    array = [29, 47, 65, 83]
    head1 = convertLL(array)
    # output(head1)
    head2 = convertDD(array)
    # output(head2)
    # result = reverseDLL(head2)
    # output(result)
    # result = addTwoNumbers()
    # output(result)
    # result = oddEven()
    # output(result)
    result = zot()
    output(result)




##################################################################
if __name__ == '__main__':
    main()