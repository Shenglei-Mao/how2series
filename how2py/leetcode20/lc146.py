class Node:
    def __init__(self, key=None, val=None, next=None, prev=None):
        self.key = key
        self.val = val
        self.next = next
        self.prev = prev


class LRUCache:

    def __init__(self, capacity: int):
        # Init Data Structure: A Hashmap and A DoubleLinkedList
        self.capacity = capacity
        self.lookup = dict()
        self.head = Node()
        self.tail = Node()
        self.head.next, self.tail.prev = self.tail, self.head

    def insert_front(self, node):
        next_node = self.head.next
        node.next = next_node
        node.prev = self.head
        self.head.next = node
        next_node.prev = node

    def delete_end(self):  # head -> node1 -> tail
        """return key"""
        node = self.tail.prev
        prev_node = self.tail.prev.prev
        prev_node.next = self.tail
        self.tail.prev = prev_node
        return node

    def update(self, key):
        """refresh the Node in DList by putting it into the front"""
        node = self.lookup[key]
        next_node = node.next
        prev_node = node.prev
        next_node.prev = prev_node
        prev_node.next = next_node
        self.insert_front(node)

    def get(self, key: int) -> int:
        if key in self.lookup:
            self.update(key)
            return self.lookup[key].val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.lookup:
            self.lookup[key].val = value
            self.update(key)
        else:
            node = Node(key, value)
            self.lookup[key] = node
            self.insert_front(node)
            if len(self.lookup) > self.capacity:
                node = self.delete_end()
                self.lookup.pop(node.key)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
