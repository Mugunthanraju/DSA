class TrieNode:
    def __init__(self):
        self.edge_to_kids = {}
        self.is_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.edge_to_kids:
                node.edge_to_kids[c] = TrieNode()
            node = node.edge_to_kids[c]
        node.is_word = True
        node.word = word

    def search(self, word: str) -> bool:
        node = self.root
        for c in word:
            if c not in node.edge_to_kids: return False
            node = node.edge_to_kids[c]
        return node.is_word
    
    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for c in prefix:
            if c not in node.edge_to_kids: return False
            node = node.edge_to_kids[c]
        return True