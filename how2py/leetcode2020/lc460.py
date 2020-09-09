"""
A LookUp Map (Key: key, Value: Node of a LinkedList)

List of Bucket -> a Map of Bucket (Key: frequency, Value: LinkedList) yes (In Java -> TreeMap), a simple map in py not work
               -> a List of Bucket (Min_freq = 1, Max_freq = N/A) x
               -> Double LinkedList of Bucket, update O(1)
                                               insert into bucket O(1) yes (PS: always insert in to freq = 1
Where each Bucket is a LinkedList that contains the all the keys that have same frequency (new key append to list head)
Since O(1) for lookup
update_freq +1
envict_lastone
insert into bucket
for get op (key): check key in LookUp map, if not found, return -1
                                           elif found, update_frequency, return value
for put op(key, value): check key in LookUp map, if found, update_freq
                                                 elif not found, add_node in lookup
                                                               insert into bucket
                                                 if capacity exceed, envict_lastone
"""

# TODO try using ordered dict
from collections import defaultdict


class _Node:
    def __init__(self, key=None, value=None, freq=None, prev=None, next=None):
        self.key = key
        self.value = value
        self.freq = freq
        self.prev = prev
        self.next = next


class LinkedList:
    def __init__(self):
        self.sentinel = _Node()
        self.sentinel.prev = self.sentinel
        self.sentinel.next = self.sentinel
        self.size = 0

    def insert_head(self, node):
        next_node = self.sentinel.next
        node.prev = self.sentinel
        node.next = next_node
        next_node.prev = node
        self.sentinel.next = node
        self.size += 1

    def pop_tail(self) -> _Node:
        if self.size == 0: raise Exception("Current list contain no element, should not see this meg")
        node = self.sentinel.prev
        prev_node = node.prev
        prev_node.next = self.sentinel
        self.sentinel.prev = prev_node
        self.size -= 1
        return node

    def pop_node(self, node):
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node
        self.size -= 1


class LFUCache:
    def __init__(self, capacity: int):
        self._size = 0
        self._capacity = capacity
        self._node_dict = dict()
        self._freq_dict = defaultdict(LinkedList)
        self._min_freq = 0

    def update_freq(self, node: _Node):
        """
        increment freq by 1, break it out from current linked list, insert it into a new linked list
        """
        if not node.freq: raise Exception("Sentinel Node have not freq, should not see this meg")
        # break out from old list
        old_list = self._freq_dict[node.freq]
        old_list.pop_node(node)
        if old_list.size == 0:
            del self._freq_dict[node.freq]
            if node.freq == self._min_freq:
                self._min_freq += 1
        # increment freq by 1
        node.freq += 1
        # add into new list
        linked_list = self._freq_dict[node.freq]
        linked_list.insert_head(node)

    def get(self, key: int) -> int:
        if key not in self._node_dict:
            return -1
        else:
            node = self._node_dict[key]
            self.update_freq(node)
            return node.value

    def put(self, key: int, value: int) -> None:
        if self._capacity == 0: return
        if key in self._node_dict:
            node = self._node_dict[key]
            node.value = value
            self.update_freq(node)
        else:
            if self._size == self._capacity:
                linked_list = self._freq_dict[self._min_freq]
                node = linked_list.pop_tail()
                del self._node_dict[node.key]
                self._size -= 1
            node = _Node(key=key, value=value, freq=1)
            self._node_dict[key] = node
            linked_list = self._freq_dict[1]
            if linked_list.size == 0: self._min_freq = 1
            linked_list.insert_head(node)
            self._size += 1


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

cache = LFUCache(2)
cache.put(1,1)
cache.put(2,2)
print(cache.get(1))
cache.put(3, 3)
print(cache.get(2))