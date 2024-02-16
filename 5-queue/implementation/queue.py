class Queue:
    def __init__(self, items = []) -> None:
        self.items = items
    
    def q_enqueue(self, item):
        self.items.append(item)
    
    def q_size(self):
        return len(self.items)
    
    def q_isEmpty(self):
        if self.q_size() > 0:
            return False
        return True
    
    def q_dequeue(self):
        if self.q_isEmpty():
            return
        return self.items.pop(0)
    
    def q_display(self):
        if self.q_isEmpty(): print("Queue is empty.")
        else: print(self.items)
    
    def q_clear(self):
        self.items.clear()

if __name__ == '__main__':
    queue = Queue()
    print(queue.q_isEmpty())
    queue.q_display()
    queue.q_enqueue(1)
    queue.q_display()
    queue.q_enqueue(2)
    print(queue.q_size())
    queue.q_display()
    queue.q_enqueue(3)
    print(queue.q_isEmpty())
    queue.q_display()
    queue.q_dequeue()
    queue.q_display()
    queue.q_enqueue(4)
    queue.q_display()
    print("Clearing the queue...")
    queue.q_clear()
    queue.q_display()


# Queue can used for problems like :
    # reverse first k elements in queue
