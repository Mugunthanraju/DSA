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
    precedence = {
        '^': 4,
        '*': 3,
        '/': 3,
        '+': 2,
        '-': 2,
        '(': 1,
    }
    output = []
    stack = Stack()

    for char in expersion:
        if char.isalnum():
            output.append(char)
        elif char == '(':
            stack.s_push(char)
        elif char == ')':
            while stack.s_peek() != '(':
                output.append(stack.s_pop())
            stack.s_pop()
        else:
            while (not stack.s_isEmpty()) and precedence[char] <= precedence[stack.s_peek()]:
                output.append(stack.s_pop())
            stack.s_push(char)
    
    while (not stack.s_isEmpty()):
        output.append(stack.s_pop())
    stack.s_clearup()
# ))2-7(+)4*5(( = ((2-7)+(4*5)) = 
    return ' '.join(output)

def infix_to_prefix(expression):
    tokens = list(expression)[::-1]

    for i in range(len(tokens)):
        if tokens[i] == '(': 
            tokens[i] = ')'
        elif tokens[i] == ')': 
            tokens[i] = '('
        else: continue
    
    prefix =  infix_to_postfix(''.join(tokens))
    return prefix[::-1]

def to_infix(expression , prefix = True):
    stack = []
    tokens = expression.split()
    if prefix:
        # We're doing this because operators are in first.
        tokens = tokens[::-1]
        # It can be also done using another stack.

    for token in tokens:
        # print(token, ':', stack)
        if token.isalnum():
            stack.append(token)
        elif token in ['+', '-', '*', '/']:
            operand1 = stack.pop()
            operand2 = stack.pop()
            infix_expression = f'({operand1} {token} {operand2})' if prefix else f'({operand2} {token} {operand1})'
            stack.append(infix_expression)

    if len(stack) == 1:
        return stack[0]
    else:
        raise ValueError("Invalid prefix expression")
        

if __name__ == '__main__':
    # group_brackets_list = [
    #     ['(', '(', '(', ')', '(', ')', ')', ')'], 
    #     [')', '(', '(', ')'],
    #     ['(',')','(',')','(',')'],
    #     ['(', ')', ')'],
    # ]
    # for bracket_list in group_brackets_list:
    #     print(is_symbols_balanced(bracket_list))
    # ************************************************************

    # for decimal in range(231, 240):
    #     print(decimal, ":", dec_to_bin(decimal))
    # ************************************************************

    expressions = ['((5*4)+(7-2))', 'A*B+C/D', '(A-B/C)*(A/K-L)', '4*2+5*(2+1)/2', '4^2+5*(2+1)/2',  'A*(B+C)/D']
    for expr in expressions:
        print( 'Infix : ', expr, '<=> Postfix : ' ,infix_to_postfix(expr))
        print( 'Infix : ', expr, '<=> Prefix : ' ,infix_to_prefix(expr))
        print()
    # ************************************************************

    # prefix_expression = "+ * 5 4 - 7 2"
    # infix_expression = to_infix(prefix_expression)
    # print("Prefix Expression:", prefix_expression)
    # print("Infix Expression:", infix_expression)
    # print()
    # # postfix_expression = "a b * c +"
    # postfix_expression = "A B C / - A K / L - *"
    # infix_expression = to_infix(postfix_expression, False)
    # print("Postfix Expression:", postfix_expression)
    # print("Infix Expression:", infix_expression)
    # ************************************************************