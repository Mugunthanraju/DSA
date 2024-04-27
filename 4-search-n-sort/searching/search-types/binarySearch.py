def binary_search(items, target):
    head = 0
    tail = len(items) - 1
    mid = (head + tail) // 2

    while head <= tail:
        if items[mid] == target:
            return True
        elif items[mid] > target:
            tail = mid - 1
            mid = (head + tail) // 2
        else:
            head = mid + 1
            mid = (head + tail) // 2
    
    return False

def binary_search_for_index(items, target):
    head = 0
    tail = len(items) - 1
    mid = (head + tail) // 2

    while head <= tail:
        if items[mid] == target:
            return mid
        elif items[mid] > target:
            tail = mid - 1
            mid = (head + tail) // 2
        else:
            head = mid + 1
            mid = (head + tail) // 2
    
    return -1

def binary_search_recursive(items, target, head, tail):
    
    mid = (head + tail) // 2

    if head <= tail:
        if items[mid] == target:
            return True
        elif items[mid] > target:
            return binary_search_recursive(items, target, head, mid - 1)
        else:
            return binary_search_recursive(items, target, mid + 1, tail)
    
    return False

def binary_search_recursive_for_index(items, target, head, tail):
    
    mid = (head + tail) // 2

    if head <= tail:
        if items[mid] == target:
            return mid
        elif items[mid] > target:
            return binary_search_recursive_for_index(items, target, head, mid - 1)
        else:
            return binary_search_recursive_for_index(items, target, mid + 1, tail)
    
    return -1

if __name__ == '__main__':

    items_one = [2, 6, 1, 5, 9, 4, 4.5, 4.6, 4.4]
    target_value = 4
    print(binary_search(sorted(items_one), target_value))
    print(binary_search_for_index(sorted(items_one), target_value))
    head = 0
    tail = len(items_one) - 1
    print(binary_search_recursive(sorted(items_one), target_value, head, tail))
    print(binary_search_recursive_for_index(sorted(items_one), target_value, head, tail))