from com.sywood.starbucks.andi.Resources.Python.ds.binary_heap import *

class PriorityQueue:
    def __init__(self, data=None):
        if data is not None:
            self.heap = heapify(data)
        else:
            self.heap = BinHeap()

    def push(self, key, item):
        self.heap.push((key, item))

    def pop(self):
        return self.heap.pop()

    def peek(self):
        return self.heap.peek()

    def increase_priority(self, value, new_key):
        self.heap.decrease_key(value, new_key)

    @property
    def is_empty(self):
        return self.heap.is_empty()
