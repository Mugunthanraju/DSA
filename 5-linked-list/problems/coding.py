class LL:
    def __init__(self, val, next=None) -> None:
        self.val = val
        self.next = next

class DD:
    def __init__(self, val, next=None, back=None) -> None:
        self.val = val
        self.next = next
        self.back = back

def convertLL(items, last=False):
    prev = None
    if len(items) == 0:
        return LL(None)
    head = temp = LL(items[0])
    if len(items) > 1:
        for i in items[1:]:
            temp.next = LL(i)
            prev = temp
            temp = temp.next
    return [head, prev] if last else head

def convertDD(items, last=False):
    prev = None
    if len(items) < 1:
        return None
    
    head = temp = DD(items[0])
    for item in items[1:]:
        temp.next = DD(item)
        temp.next.back = temp
        prev = temp
        temp = temp.next
    return [head, prev] if last else head

def output(head):
    temp = head
    print("| Output |")
    while temp:
        print(temp.val, end=" ")
        temp = temp.next
    print()
##################################################################
# Singlly Linked List ( Medium Level)

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
        item += num1.val if num1 else 0
        item += num2.val if num2 else 0
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
    Sorting Linked List of (z)0's (o)1's and (t)2's
    TC : O(N)
    SC : O(3) ~ O(1) <including the output>
    """
    if head and head.next:
        zero = zeroh = LL(-1)
        one = oneh = LL(-1)
        two = twoh = LL(-1)
        temp = head
        while temp:
            if temp.val == 0:
                zero.next = temp
                zero = zero.next
            elif temp.val == 1:
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

def removeNthFromEnd(n=2, head=None):
    head = convertLL([1,2,3,4,5])
    """
    19.LC
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
    TC : O(N)
    SC : O(2) ~ O(1) <including the output and pointers {fast, slow}>
    """
    if head:
        fast = slow = head
        for i in range(n):
            fast = fast.next
        if not fast:
            # If n = length of linked list and remove nth element (i.e., first element)
            return head.next
        while fast.next:
            slow = slow.next
            fast = fast.next
        slow.next = slow.next.next
    return head

def reverseList(head = None):
    # head = convertLL([1,2,3,4,5])
    """
    206.LC
    Given the head of a singly linked list, reverse the list, and return the reversed list.
    TC : O(N)
    SC : O(2) ~ O(1) <including the output and pointers {prev, curr, front}>
    """
    if head and head.next:
        prev, curr = None, head
        while curr:
            front = curr.next
            curr.next = prev
            prev = curr
            curr = front
        head = prev
    return head
    
def recursivlyReverseList(head):
    pass

def isPalindrome(head=None):
    head = convertLL([1,2,3,2,1])

    """
    234.LC
    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    Approach : fast & slow (i.e., Hare & Tortoise) pointer :  
        :> a pointer algorithm that uses two pointers which move through the array (or sequence/LinkedList) at different speeds.
    TC : O(2N) ~ O(N)
    SC : O(5) ~ O(1) <including the output and pointers {fast, slow, half, part1, part2}>
    """

    if head and head.next:
        fast = slow = part1 = head
        while fast.next and fast.next.next:     # O(N/2)
            slow = slow.next
            fast = fast.next.next
        part2 = half = reverseList(slow.next)   # O(N/2)
        while part2:                            # O(N/2)
            if part1.val != part2.val:
                reverseList(half)               # O(N/2) (either this or below; not both)
                return False
            part1 = part1.next
            part2 = part2.next
        reverseList(half)                       # O(N/2)
    return True

def addOne(head=None):
    head = convertLL([1,5,2])

    """
    Approach 1 (Best): Reverse and add number and reverse (this doesn't use any extra space)
    TC : O(2N) ~ O(N)
    SC : O(N) <including the output>
    
    (or)

    Approach (Not good; below is the implementation) 2: Using string store as resulted number
    TC : O(2N) ~ O(N)
    SC : O(N + 4) ~ O(N) <including the output and String number>
    """

    if head:
        total = 0
        num = 0
        temp = head
        while temp:
            total += 1
            num = (num * 10) + temp.val
            temp = temp.next
        num = num + 1
        numStr = str(num)
        i = 0
        temp = head
        if len(numStr) == total:
            while temp and i < total:
                temp.val = int(numStr[i])
                temp = temp.next
                i += 1
        else:
            first = LL(int(numStr[i]), head)
            i += 1
            while temp and i < total+1:
                temp.val = int(numStr[i])
                i += 1
                temp = temp.next
            head = first
    return head

def getIntersectionNode(headA=None, headB=None):
    headA, tailA = convertLL([1,2,3,4], True)
    headB, tailB = convertLL([9,8], True)
    headC = convertLL([5,6,7])
    tailA.next = headC
    tailB.next = headC

    """
    160.LC : https://leetcode.com/problems/intersection-of-two-linked-lists/
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

    """
    if headA and headB:
        aLength = bLength = 0 
        aTemp = headA
        while aTemp:
            aLength += 1
            aTemp = aTemp.next
        bTemp = headB
        while bTemp:
            bLength += 1
            bTemp = bTemp.next
        startA = headA
        startB = headB
        diff = abs(aLength - bLength)
        if aLength > bLength:
            for i in range(diff):
                startA = startA.next
        elif bLength > aLength:
            for i in range(diff):
                startB = startB.next
        while startA and startB:
            if startA == startB:
                return startA
            startA = startA.next
            startB = startB.next
    return None

def middleNode(head = None):
    head = convertLL([1,2,3,4,5,6], False)
    """
    876.LC
    Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.
    
    Approach 1 : Count the node and use the formuala for finding the middle element (n/2 + 1) eg. for n = 6 :{6/2 + 1 = 3 + 1 = 4} for n = 5 :{5/2 + 1 = 2 + 1 = 3}. 
    TC : O(N + N/2)
    SC = O(1)

    (or)

    Approach 2 : Use fast & slow (Hare & Tortoise) pointer to find the middle element.
    TC : O(N/2)
    SC : O(1)
    """
    if head and head.next:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    return head

def deleteMiddle(head=None):
    head = convertLL([1,2,3,4,5,6], False)
    """
    2095.LC :  Delete the Middle Node of a Linked List
    Brute Force : Count the nodes and find the middle element position (by n/2 + 1) then traverse to that pos and delete it.
    (or)
    Optimal Approach : Use fast & slow (Hare & Tortoise) pointer to find the middle element.
    TC : O(N/2)
    SC : O(1)
    """
    fast = slow = head
    prev = None
    while fast and fast.next:
        prev = slow
        slow = slow.next
        fast = fast.next.next
    if not prev:
        return None
    prev.next = slow.next if slow else None
    return head

def hasCycle(head=None):
    head, tail = convertLL([1,2], True)
    looph, loopt = convertLL([3,4,5,6,7], True)
    tail.next = loopt.next = looph

    """
    141.LC : Linked List Cycle
    Brute Force Approach : Using HashMap or HashSet and storing every node while traversing; if we find a node which is also stored then its a loop.
    TC : O(N x log2N)
    SC : O(N)

    (or)

    Optimal Approach (below solution): Using Fast and Slow (Hare and Tortoise) pointer to find the loop if slow == fast while traversing.
    TC : O(N)
    SC : O(1)
    """
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            print(slow.val)
            return True
    return False

def lengthLoop(head=None):
    head, tail = convertLL([1, 8, 9], True)
    looph, loopt = convertLL([2,3,4,5,6,7], True)
    tail.next = loopt.next = looph

    count = 0
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            count += 1
            fast = fast.next
            while fast != slow:
                count += 1
                fast = fast.next
            return count
    return count

def detectCycleStart(head=None):
    head, tail = convertLL([1, 8, 9], True)
    looph, loopt = convertLL([2,3,4,5,6,7], True)
    tail.next = loopt.next = looph
    """
    142.LC : Linked List Cycle II
    Brute Force Approach : Using HashMap or HashSet and storing every node while traversing; if we find a node which is also stored then its a loop's staring pointing
    TC : O(N x log2N)
    SC : O(N)

    (or)

    Optimal Approach (below solution): Using Fast and Slow (Hare and Tortoise) pointer to find the loop if slow == fast while traversing then take a pointer (i.e., ans) and start traversing from head while slow pointer traversing if ans == slow then its a loop's staring pointing.
    TC : O(N + M) {N = Total node count, M = From head to start of loop}
    SC : O(1)
    """
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            ans = head
            while ans != slow:
                ans = ans.next
                slow = slow.next
            return ans
    return None
##################################################################
# Doubly Linked List ( Medium Level)

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

def deleteAllOccurrences(head = None, k = 0):
    head = convertDD([10, 4, 10, 3, 5, 20, 10])
    k = 10

    """
    TC : O(N)
    SC : O(1)
    """
    
    temp = head
    while temp:
        if temp.val == k:
            if temp == head:
                head = temp.next
            
            prev = temp.back
            after = temp.next
            if after: after.back = prev
            if prev: prev.next = after

            #TODO: Make deleted node pointing NULL for both back and next.
            temp.back = None
            temp.next = None
            temp = after
        
        else: temp = temp.next
    return head

def pairSum(head=None, addUp=1):
    head = convertDD([1,2,3,4,5,9])
    addUp = 6

    """
    You are given a SORTED doubly linked list of size 'n', consisting of DISTINCT positive integers, and a number 'addUp'.
    Find out all the pairs in the doubly linked list with sum equal to 'addUp'.

    Approach 1 >| TC : O(N^2) & SC : O(1) {if we don't consider resultant storage} or O(N) {inclusive of resultant storage}

    resultant = []
    temp = head
    while temp:
        after = temp.next
        while after:
            if temp.val + after.val == addUp:
                resultant.append([temp.val, after.val])
            after = after.next
        temp = temp.next
    return resultant

    Approach 2 (Below solution):

    TC : O(2N)
    SC : O(1) {if we don't consider pairs storage} or O(N) {inclusive of pairs storage}
    """

    temp = tail = head
    pairs = []
    while tail.next:
        tail = tail.next
    
    while temp != tail and temp.val <= tail.val:
        if temp.val + tail.val == addUp:
            pairs.append([temp.val, tail.val])
            temp = temp.next
            tail = tail.back
        elif temp.val + tail.val < addUp:
            temp = temp.next
        else:
            tail = tail.back
    
    return pairs

def removeDuplicates(head=None):
    head = convertDD([1, 1, 2, 2, 2, 3, 3, 4, 4])
    """
    You are given a sorted doubly linked list of size 'n'.
    Remove all the duplicate nodes present in the linked list.
    TC : O(N)
    SC : O(1)
    """
    temp = head
    while temp and temp.next:
        after = temp.next
        while after and temp.val == after.val:
            after = after.next
        if after: after.back = temp
        temp.next = after
        temp = after
    return head
##################################################################
# Singlly Linked List ( Hard Level)

def reverseKGroup(head=None, k=2):
    # head = convertLL([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    # k = 3
    head = convertLL([1, 2, 3, 4, 5,])

    """
    25.LC : Reverse Nodes in k-Group

    Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

    TC : O(N) {Reversing the list} + O(N) {finding the Kth node} ~ O(2N)
    SC : O(1) {We aren't using extra space rather we just changing the pointers}
    """
    def reversell(top): # Helper method for reversing the given linked list
        current, before = top, None
        while current:
            after = current.next
            current.next = before
            before = current
            current = after
    def kthNode(temp, k): # Helper method for finding the kth linked list node
        while temp and k > 1:
            temp = temp.next
            k -= 1
        return temp
    
    temp = head
    prev= None
    while temp:
        kth = kthNode(temp, k)
        if not kth:
            if prev: prev.next = temp
            break
        then = kth.next
        kth.next = None
        reversell(temp)
        if temp == head:
            head = kth
        else:
            prev.next = kth
        prev = temp
        temp = then
    return head

def rotateRight(head=None, k=1):
    head = convertLL([1,2,3,4,5])
    k = 2

    """
    61.LC Rotate List
    Given the head of a linked list, rotate the list to the right by k places.

    TC : O(N + (N - K % N))
    SC : O(1)
    """
    n = 1
    tail = head    
    while tail and tail.next:
        n += 1
        tail = tail.next
    if n > 0:
        tail.next = head
        # k % n = will show the node which is gonna be head 
        # n - k % n = will show the node which is gonna be last node in LL.
        cut = n - k % n
        if cut > 0:
            temp = head
            cut -= 1
            while temp and cut > 0:
                cut -= 1
                temp = temp.next
            head = temp.next
            temp.next = None
    return head


        
##################################################################
def main():
    array = [29, 47, 65, 83]
    head1 = convertLL(array)
    # output(head1)
    head2 = convertDD(array)
    # output(head2)

    #TODO: # Singlly Linked List (Hard Level)
    # result = reverseKGroup()
    # output(result)
    result = rotateRight()
    output(result)



    #TODO: Doubly Linked List (Medium Level)
    # result = deleteAllOccurrences()
    # output(result)
    # result = pairSum()
    # print(result)
    # result = removeDuplicates()
    # output(result)



    #TODO: Singlly Linked List (Medium Level)

    # result = reverseDLL(head2)
    # output(result)
    # result = addTwoNumbers()
    # output(result)
    # result = oddEven()
    # output(result)
    # result = zot()
    # output(result)
    # result = removeNthFromEnd()
    # output(result)
    # result = reverseList()
    # output(result)
    # result = isPalindrome()
    # print(result)
    # result = addOne()
    # output(result)
    # result = getIntersectionNode()
    # print(result.val)
    # result = middleNode()
    # print(result.val if result else None)
    # result = deleteMiddle()
    # output(result)
    # result = hasCycle()
    # print(result)
    # result = lengthLoop()
    # print(result)
    # result = detectCycleStart()
    # print(result.val if result else "None")

##################################################################
if __name__ == '__main__':
    main()