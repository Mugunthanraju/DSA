class Node:
    def __init__(self, data, left = None, right = None) -> None:
        self.data = data
        self.left = left
        self.right = right

    def setData(self, value): self.data = value
    
    def setLeft(self, valueL): self.left = valueL
    
    def setRight(self, valueR): self.right = valueR

def setNode(value, root = None):
    if not root:
        return Node(value)
    
    if root.data >= value: root.left = setNode(value, root.left)
    else: root.right = setNode(value, root.right)

def inorder(root):
    if root:
        inorder(root.left)
        print(root.data, end=' | ')
        inorder(root.right)
 
def preorder(root):
    if root:
        print(root.data, end=' | ')
        preorder(root.left)
        preorder(root.right)
 
def postorder(root):
    if root:
        postorder(root.left)
        postorder(root.right)
        print(root.data, end=' | ')
 
if __name__ == '__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(6)

    # r = setNode(1)
    # setNode(2, r)
    # setNode(3, r)
    # setNode(4, r)
    # setNode(5, r)
    # setNode(6, r)

    print("Postorder traversal of binary tree is:")
    preorder(root)
    print()
    inorder(root)
    print()
    postorder(root)
