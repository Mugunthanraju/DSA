class Stack:

    def __init__(self, items = []) -> None:
        self.items = items
    
    def s_push(self, item):
        self.items.append(item)
    
    def s_pop(self):
        if self.s_isEmpty():
            print("Stack is empty.")
        else: 
            self.items.pop()
    
    def s_peek(self):
        if self.s_isEmpty():
            return "Stack is empty"
        else:
            return self.items[-1]
    
    def s_isEmpty(self):
        if self.s_size() > 0:
            return False
        return True
    
    def s_size(self):
        return len(self.items)
    
    def s_display(self):
        if self.s_isEmpty():
            print("Stack is empty.")
        else:
            print(self.items)



if __name__ == "__main__":
    stack = Stack([5,1,8,3])
    stack.s_display()
    stack.s_push(6)
    stack.s_display()
    print(stack.s_isEmpty())
    stack.s_display()
    print(stack.s_size())
    stack.s_display()
    print(stack.s_peek())
    stack.s_display()
    stack.s_pop()
    stack.s_display()
