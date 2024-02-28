# hash_table = [None] * 11
# def h(item): return item % 11
# def puts(item): hash_table[h(item)] = item
# def contains(item): return hash_table[h(item)] == item
# ************************************************************

"""
Hash Search is basically making use of Hash Table (Dictionary in Python)
"""
# sample = dict()
# ************************************************************

def hash_strings(word):
    total = 0
    for c in word:
        # TODO: ord method is to convert character to integer
        total += ord(c)
    return total
# ************************************************************

if __name__ == '__main__':
    
    # puts(13)
    # puts(43)
    # puts(30)
    # puts(88)
    # print(hash_table)
    # print("contains 77?", contains(77))
    # print("contains 88?", contains(88))
# ************************************************************
    
    # sample['one'] = 1 # o(1)
    # sample['two'] = 2
    # sample['three'] = 3
    # print(sample['two']) # O(1)
# ************************************************************

    print(hash_strings('apple'))
# ************************************************************