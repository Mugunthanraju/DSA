class Deque:
    def __init__(self, items = []) -> None:
        self.items = items
    
    def d_enqueue_rear(self, item):
        self.items.append(item)
    
    def d_enqueue_front(self, item):
        self.items.insert(0, item)
    
    def d_size(self):
        return len(self.items)
    
    def d_isEmpty(self):
        if self.d_size() > 0:
            return False
        return True
    
    def d_dequeue_front(self):
        if self.d_isEmpty():
            return
        return self.items.pop(0)
    
    def d_dequeue_rear(self):
        if self.d_isEmpty():
            return
        return self.items.pop()
    
    def d_display(self):
        if self.d_isEmpty(): print("Deque is empty.")
        else: print(self.items)
    
    def d_clear(self):
        self.items.clear()

if __name__ == '__main__':
    deque = Deque()
    deque.d_display()
    deque.d_dequeue_front()
    deque.d_dequeue_rear()
    deque.d_enqueue_rear(8)
    deque.d_display()
    deque.d_enqueue_front(3)
    deque.d_display()
    deque.d_enqueue_front(4)
    deque.d_display()
    print("Deque size:", deque.d_size())
    deque.d_dequeue_front()
    deque.d_display()
    deque.d_clear()
    deque.d_display()