def shellSort(array):

    # Rearrange elements at each n/2, n/4, n/8, ... intervals
    interval = len(array) // 2
    while interval > 0:
        for i in range(interval, len(array)):
            temp = array[i]
            j = i
            while j >= interval and array[j - interval] > temp:
                array[j] = array[j - interval]
                j -= interval

            array[j] = temp
        interval //= 2

if __name__ == '__main__':
    data = [9, 8, 3, 7, 5, 6, 4, 1]
    print('Unsorted Array:')
    print(data)
    shellSort(data)
    print('Sorted Array in Ascending Order:')
    print(data)