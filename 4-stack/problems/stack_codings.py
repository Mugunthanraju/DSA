class Stack:

    def __init__(self, items = []) -> None:
        self.items = items
    
    def s_push(self, item):
        self.items.append(item)
    
    def s_pop(self):
        if not self.s_isEmpty():
            return self.items.pop()
        return None
    
    def s_peek(self):
        if not self.s_isEmpty():
            return self.items[-1]
        return None
    
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
    
    def s_clearup(self):
        self.items.clear()

def is_brackets_balanced(bracket_list):
    stack = Stack()

    for bracket in bracket_list:
        if bracket == '(':
            stack.s_push(bracket)
        else:
            if stack.s_isEmpty():
                stack.s_clearup()
                return False
            else:
                stack.s_pop()

    if stack.s_size() > 0:
        stack.s_clearup()
        return False
    
    return True

def is_symbols_balanced(symbol_list):
    stack = Stack()
    match_symbol = {
        ')' : '(',
        '}' : '{',
        ']' : '[',
        '>' : '<'
    }
    opening_symbols = ['(', '[', '{', '<']

    for symbol in symbol_list:
        if symbol in opening_symbols:
            stack.s_push(symbol)
        else:
            if stack.s_isEmpty() or not match_symbol[symbol] == stack.s_peek():
                stack.s_clearup()
                return False
            else:
                stack.s_pop()

    if stack.s_size() > 0:
        stack.s_clearup()
        return False
    
    return True

def dec_to_bin(num):
    stack = Stack()

    while num != 0:
        reminder = num % 2
        num = num // 2
        stack.s_push(reminder)

    bin_list = []

    while not stack.s_isEmpty():
        bin_list.append(stack.s_pop())
    
    return ''.join(map(str, bin_list))

def infix_to_postfix(expersion):
    # TODO : Implement this method in couple of days.
    pass
        

if __name__ == '__main__':
    # group_brackets_list = [
    #     ['(', '(', '(', ')', '(', ')', ')', ')'], 
    #     [')', '(', '(', ')'],
    #     ['(',')','(',')','(',')'],
    #     ['(', ')', ')'],
    # ]
    # for bracket_list in group_brackets_list:
    #     print(is_symbols_balanced(bracket_list))
    for decimal in range(231, 240):
        print(decimal, ":", dec_to_bin(decimal))