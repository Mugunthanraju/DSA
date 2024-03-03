"""
Not a matured binary tree. It's just an example how we can implement a binary tree using list.
"""

class BinaryTree:
    def __init__(self, root_val = None) -> None:
        self.tree = [root_val, [], []]
    
    def setRoot(self, val):
        self.tree[0] = val
    
    def getRoot(self, printit = False):
        if printit: print(f"Root value of this tree -> {self.tree[0]}")
        return self.tree[0]
    
    def setLeft(self, val):
        temp = self.tree[1]
        self.tree[1] = [val, temp, []]
        return self.tree
    
    def setRight(self, val):
        temp = self.tree[2]
        self.tree[2] = [val, [], temp]
        return self.tree
    
    def getLeft(self, printit = False):
        if printit: print(f"Left branch of this tree -> {self.tree[1]}")
        return self.tree[1]
    
    def getRight(self, printit = False):
        if printit: print(f"Right branch of this tree -> {self.tree[2]}")
        return self.tree[2]
    
    def getEntireTree(self, printit = False):
        if printit: print(f"The entire tree -> {self.tree}")
        return self.tree

def main():
    bt = BinaryTree(1)
    bt.setLeft(2)
    bt.setRight(3)
    bt.getRoot(True)
    bt.setLeft(4)
    bt.getLeft(True)
    bt.setRight(5)
    bt.getRight(True)
    bt.setLeft(6)
    bt.setRight(7)
    bt.getEntireTree(True)
    pass

if __name__ == '__main__':
    main()