"""
Trie dictionary of words implementation
"""


class Trie:

    class Node:
        def __init__(self):
            self.lookup = {}
            self.is_end = False

    def __init__(self):
        self.__root = Trie.Node()
    
    def add_word(self, word):
        if word is None:
            raise ValueError('None word not allowed')
        self.__add_word(self.__root, word.lower())

    def __add_word(self, node, word):
        if word == '':
            node.is_end = True
        else:
            firstchar, rest = word[0], word[1:len(word)]
            if node.lookup.get(firstchar, None) is None:
                node.lookup[firstchar] = Trie.Node()
            self.__add_word(node.lookup[firstchar], rest)

    def find_word(self, word):
        if word is None:
            return False
        return self.__find_word(self.__root, word.lower())

    def __find_word(self, node, word):
        if word == '':
            return node.is_end
        else:
            firstchar, rest = word[0], word[1:len(word)]
            if node.lookup.get(firstchar, None) is None:
                return False
            else:
                return self.__find_word(node.lookup[firstchar], rest)


if __name__ == '__main__':
    words = 'The quick brown fox jumped over the lazy dog'.split(' ')
    trie = Trie()
    print('\nAdd words in Trie...')
    for word in words:
        print(word)
        trie.add_word(word)

    print('\nTry to find the same words in trie...')
    for word in words:
        print(word, trie.find_word(word))
    
    print('\nTry to find other words...')
    otherwords = 'some random words to find if lucky'.split(' ')
    for word in otherwords:
        print(word, trie.find_word(word))
