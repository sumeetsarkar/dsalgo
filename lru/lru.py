"""
LRU cache implementation
"""


class LRU:

    class Node:
        def __init__(self, key, data):
            self.key, self.data = key, data
            self.prevnode, self.nextnode = None, None

    def __init__(self, size = 10):
        self.__size = size
        self.__lookup = {}
        self.__front = self.__rear = None

    def additem(self, key, data):
        itemfound = self.getitem(key)
        if itemfound is not None:
            itemfound.data = data
            return itemfound
        if len(self.__lookup) == self.__size:
            self.removeitem(self.__rear)
            self.__lookup.pop(self.__rear.key)
        node = LRU.Node(key, data)
        self.__move_item_to_front(node)
        self.__lookup[key] = node

    def getitem(self, key):
        itemfound = self.__lookup.get(key, None)
        if itemfound is None:
            return None
        self.removeitem(itemfound)
        self.__move_item_to_front(itemfound)
        return itemfound

    def removeitem(self, item):
        if item is None:
            raise ValueError('Item cannot be None')
        if item.prevnode is not None:
            item.prevnode.nextnode = item.nextnode
        else:
            self.__front = item.nextnode
        if item.nextnode is not None:
            item.nextnode.prevnode = item.prevnode
        else:
            self.__rear = item.prevnode

    def __move_item_to_front(self, item):
        if item is None:
            raise ValueError('Item cannot be None')
        item.prevnode = None
        item.nextnode = self.__front
        if self.__front is not None:
            self.__front.prevnode = item
        self.__front = item
        if self.__rear is None:
            self.__rear = self.__front

    def print(self, print_separator = False):
        if print_separator:
            print('\n\nPrinting Items...')
        temp = self.__front
        while temp is not None:
            print(temp.key, temp.data)
            temp = temp.nextnode


if __name__ == '__main__':
    lru = LRU(5)
    lru.additem(1, 'A')
    lru.additem(2, 'B')
    lru.additem(3, 'C')
    lru.additem(4, 'D')
    lru.additem(5, 'E')
    lru.additem(1, 'ABC')
    lru.additem(1, 'ABCDF')

    lru.print(True)
    
    lru.getitem(3)
    lru.getitem(2)
    
    lru.print(True)
