class Node:
    def __init__(self, val) -> None:
        self.val = val
        self.left = None
        self.right = None


def demoBT():
    root = Node(2)
    root.left = Node(-1)
    root.right = Node(4)
    root.left.left = Node(-2)
    root.left.right = Node(1)
    root.right.left = Node(3)
    root.right.right = Node(5)

    # root = Node(1)
    # root.left = Node(2)
    # root.right = Node(3)
    # root.right.left = Node(4)
    # root.right.right = Node(5)
    return root


"""
Above are the required class and a method to crete demo binary tree.
"""
# ************************************************************************
"""
There are two types of travasal in Trees : (i) Depth First Search [DFS] (ii) Breadth First Search [BFS]

Again DFS, consist of three types orders : 
(i) Pre Order Traversal     [Root, Left, Right]
(ii) In Order Traversal     [Left, Root, Right]
(iii) Post Order Traversal  [Left, Right, Root]
"""

def is_leaf(node) -> bool:
        return node and node.left is None and node.right is None

# DFS
def preOrder(root):
    """
    [Root, Left, Right]
    TC : O(N) <No. of Nodes>
    SC : O(N) <Auxiliary space of recursion but extra space>
    """
    if root:
        print(root.val, end=" ")
        preOrder(root.left)
        preOrder(root.right)
    return

# DFS
def iterPreOrder(root):
    # [Root, Left, Right]
    po = list()
    if root:
        stack = [root]
        while stack:
            value = stack.pop()
            po.append(value.val)
            # Since stack is FILO, we append right first to pop right at last and pop left at first
            if value.right:
                stack.append(value.right)
            if value.left:
                stack.append(value.left)
    return po  # pre order in list

# DFS
def inOrder(root):
    """
    # [Left, Root, Right]
    TC : O(N) <No. of Nodes>
    SC : O(N) <Auxiliary space of recursion but extra space>
    """
    if root:
        inOrder(root.left)
        print(root.val, end=" ")
        inOrder(root.right)
    return

def iterInOrder(root):
    # [Left, Root, Right]
    io = list()
    stack = []
    node = root
    while True:
        """
        Since stack follows FILO, we push 
        """
        if node:
            stack.append(node)
            node = node.left
        else:
            if not stack:
                break
            node = stack.pop()
            io.append(node.val)
            node = node.right
    return io  # in order in list

def postOrder(root):
    """
    # [Left, Right, Root]
    TC : O(N) <No. of Nodes>
    SC : O(N) <Auxiliary space of recursion but extra space>
    """
    if root:
        postOrder(root.left)
        postOrder(root.right)
        print(root.val, end=" ")
    return

def iterPostOrder(root):
    post = list()
    stack1 = list()
    stack2 = list()
    if root:
        stack1.append(root)
        while stack1:
            value = stack1.pop()
            stack2.append(value)
            if value.left: stack1.append(value.left)
            if value.right: stack1.append(value.right)
        while stack2:
            post.append(stack2.pop().val)
    return post


# BFS
def bfs(root):
    """
    TC : O(N) < considering traversing to all the nodes in the tree >
    SC : O(N) < in worst case queue can carry all the nodes > { Rememeber we output DS which is 'result' }
    """
    result = list()
    if root:
        from collections import deque

        queue = deque([root])

        while queue:
            part = list()
            """
            the for loop's range uses pass by value, which means that the loop is set up to iterate over a range based on the length of the list at the beginning of the iteration. The range is determined at the start of the loop, and the loop uses this predetermined range for its iteration.

            However, if someone gets confused, we can use additional variable to store the initial length of the queue and use it for loop.
            """
            for i in range(len(queue)):
                value = queue.popleft()
                part.append(value.val)
                if value.left:
                    queue.append(value.left)
                if value.right:
                    queue.append(value.right)
            result.append(part)
    return result

def levels(node):
    """
    Height or Depth of a tree
    TC : O(N)
    SC : O(N) <at the worst case if it is a queue tree>
    """
    if not node:
        return 0
    left, right = levels(node.left), levels(node.right)
    return 1 + max(left, right)

def checkBalanced(node):
    """
    We are making use of height/depth finding method to solve this problem.
    TC : O(N x N) ~ O(N^2) < N {finding the height/depth} x N {checking subtrees whether it is balanced or not} >
    SC : O(N)
    """
    if not node: return True
    left = levels(node.left)
    right = levels(node.right)

    if abs(right - left) > 1: return False
    leftBool = checkBalanced(node.left)
    rightBool = checkBalanced(node.right)

    if not leftBool or not rightBool: 
        return False
    return True

def checkBalancedOptimize(node):
    """
    By tweaking height/depth finding intution (as you can see its similar to that), we can able to optimize it.
    TC : O(N)
    SC : O(N)
    """
    if not node: return 0
    leftHeight = checkBalancedOptimize(node.left)
    rightHeight = checkBalancedOptimize(node.right)

    if leftHeight == -1 or rightHeight == -1 or abs(rightHeight - leftHeight) > 1:
        return -1
    return 1 + max(leftHeight, rightHeight)

def findDiameter(node):
    """
    TC : O(N)
    SC : O(N)
    """
    maxi = [0]
    def calc(node, m):
        if not node:
            return 0
        left = calc(node.left, m)
        right = calc(node.right,m)
        m[-1] = max(left + right, m[-1])
        return 1 + max(left, right)
    calc(node, maxi)
    return maxi[-1]

def maxPathSum(node):
    """
    TC : O(N)
    SC : O(N)
    """
    import math
    maxi = -math.inf
    def calc(node):
        nonlocal maxi
        if not node:
            return 0

        left = max(0, calc(node.left))  # If the value is in negative then we consider the value zero
        right = max(0, calc(node.right))# If the value is in negative then we consider the value zero
        curr = node.val + left + right
        maxi = max(curr, maxi)

        return node.val + max(left, right) 
    calc(node)
    return maxi

def isSameTree(p, q) -> bool:
    """
    We can use any DFS traversal here.
    TC : O(N)
    SC : O(N) <Auxiliary space of recursion stack (if tree is in queue form)>
    """
    if (not p and q) or (p and not q): 
        return False
    if not p and not q: 
        return True
    if p.val != q.val: 
        return False
    
    left = isSameTree(p.left, q.left)
    right = isSameTree(p.right, q.right)
    return left and right

def zigzagLevelOrder(root):
    """
    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

    Intution : Using BFS we can achieve above stated result.

    TC : O(N) < considering traversing to all the nodes in the tree >
    SC : O(N) < in worst case queue can carry all the nodes > { Rememeber we output DS which is 'result' } 
    """
    result = list()
    if root:
        from collections import deque
        queue = deque([root])
        i = 0
        while queue:
            part = list()
            for _ in range(len(queue)):
                value = queue.popleft()
                if value.left: queue.append(value.left)
                if value.right: queue.append(value.right)
                part.append(value.val)
            result.append(part if i % 2 == 0 else part[::-1])
            i += 1
    return result

def boundaryOfBinaryTree(root):
    """
    545.LC : https://leetcode.com/problems/boundary-of-binary-tree/
    The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and the reverse order of the right boundary.

    TC : O(H + H + N) ~ O(N) < left & right boundaries takes H times each and For leaves it uses inorder so N times >
    SC : O(N) < Auxiliary space of the algorithms and not considering the result list  >
    """
    res = []

    def add_leaves(root):
        if is_leaf(root):
            res.append(root.val)
            return
        if root.left:
            add_leaves(root.left)
        if root.right:
            add_leaves(root.right)
    
    if not root:
        return res
    # root
    if not is_leaf(root):
        res.append(root.val)
    # left boundary
    t = root.left
    while t:
        if not is_leaf(t):
            res.append(t.val)
        t = t.left if t.left else t.right
    # leaves
    add_leaves(root)
    # right boundary(reverse order)
    s = []
    t = root.right
    while t:
        if not is_leaf(t):
            s.append(t.val)
        t = t.right if t.right else t.left
    while s:
        res.append(s.pop())
    # output
    return res

def verticalTraversal(root):
    """
    987.LC : Vertical Order Traversal of a Binary Tree (N = number of nodes)
    TC : O(N x logN) 
    SC : O(N)
    """
    cv = list()

    def traverse(node, x, y):
        nonlocal cv
        if node:
            cv.append((x, y, node.val))
            traverse(node.left, x-1, y+1)
            traverse(node.right, x+1, y+1)
        return
    traverse(root, 0, 0)
    cv.sort()
    
    result = list()
    prevx = -1111
    for x, y, v in cv:
        if prevx != x:
            result.append(list())
            prevx = x
        result[-1].append(v)
    del cv
    return result

def isSymmetric(root) -> bool:
    if not root:
        return True

    def isSymmetricHelp(left, right):
        if left is None or right is None:
            return left == right
        if left.val != right.val:
            return False
        return isSymmetricHelp(left.left, right.right) and isSymmetricHelp(left.right, right.left)
    
    return isSymmetricHelp(root.left, root.right)


def main():
    root = demoBT()
    """
    All DFS Traversal method calls
    """
    # preOrder(root)
    # print()
    # inOrder(root)
    # print()
    # postOrder(root)
    # print()
    """
    BFS Traversal method call
    """
    # print("BFS Traversal:", bfs(root))

    """
    All DFS Traversal iterative method calls
    """
    # print("Iterative Pre Order:", iterPreOrder(root))
    # print("Iterative In Order:", iterInOrder(root))
    # print("Iterative Post Order:", iterPostOrder(root))

    """
    Other kind of problems
    """
    # print("Height/Depth of a tree:", levels(root))
    # print("(non Optimized way): Is given binary tree balanced?", checkBalanced(root))
    # print("(Optimized way): Is given binary tree balanced?", checkBalancedOptimize(root) != -1)
    # print("Diameter of a binary tree:", findDiameter(root))
    # print("is both the binary tree are indentical?", isSameTree(tree1, tree2))
    # print("Maximum path sum:", maxPathSum(root))
    # print("Print the tree in zigzag level order", zigzagLevelOrder(root))
    # print("Boundary Traversal of binary tree :", boundaryOfBinaryTree(root))
    # print("Vertical Traversal of binary tree :", verticalTraversal(root))
    print("Is binary tree symmetric ?", isSymmetric(root))




if __name__ == "__main__":
    main()
