def linear_search(items, target):
    pos = 0

    while pos < len(items):
        if items[pos] == target:
            return True
        pos += 1

    return False

def linear_search_for_index(items, target):
    pos = 0

    while pos < len(items):
        if items[pos] == target:
            return pos
        pos += 1

    return -1

if __name__ == '__main__':

    items_one = [2, 6, 1, 5, 9, 4]
    target_value = 8 // 2
    print(linear_search(items_one, target_value))
    print(linear_search_for_index(items_one, target_value))