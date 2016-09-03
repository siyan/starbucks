def heapify(lst):
    i = len(lst) // 2
    heap = BinHeap()
    heap.size = len(lst)
    heap.data = [[None]] + lst
    heap.indices = {lst[i][1]: i + 1 for i in range(heap.size)}
    while i > 0:
        heap.shift_down(i)
        i -= 1
    return heap

class BinHeap:  # Min heap
    def __init__(self):
        self.data = [None]  # never accessed (0th index just to make accessing simpler)
        self.indices = {}
        self.size = 0

    def push(self, value):
        self.shift_up(self.size)
        self.size += 1
        self.indices[value] = self.size
        self.data.append(value)

    def pop(self):
        smallest = self.data[1]
        self.indices.pop(self.data[1][1])
        self.indices[self.data[self.size][1]] = 1
        self.data[1] = self.data[self.size]
        self.size -= 1
        self.data.pop()
        self.shift_down(1)
        return smallest

    def min_child(self, index):
        if index * 2 + 1 > self.size:
            return index * 2
        else:
            if self.data[index * 2] < self.data[index * 2 + 1]:
                return index * 2
            else:
                return index * 2 + 1

    def shift_up(self, index):
        while index // 2 > 0:
            if self.data[index] < self.data[index // 2]:
                self.indices[self.data[index // 2][1]], self.indices[self.data[index][1]] = index, index // 2
                self.data[index // 2], self.data[index] = self.data[index], self.data[index // 2]
            index //= 2

    def shift_down(self, index):
        while (index * 2) <= self.size:
            mc = self.min_child(index)
            if self.data[index] > self.data[mc]:
                self.indices[self.data[index][1]], self.indices[self.data[mc][1]] = mc, index
                self.data[index], self.data[mc] = self.data[mc], self.data[index]
            index = mc

    def peek(self):
        return self.data[1]

    def is_empty(self):
        return self.size == 0

    def decrease_key(self, value, new_key):
        item_index = self.indices[value]
        self.data[item_index][0] = new_key
        self.shift_up(item_index)


