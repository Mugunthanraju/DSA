given_input = [5, 5, 5, 6, 6, 6, 6, 7, 8, 9, 10, 10, 10]

def remove_duplicates(arr):
    # result = []
    # for item in arr:
    #     if item not in result:
    #         result.append(item)
    # return result

    if len(arr) < 2:
        return arr
    i = 0
    j = 1

    while j < len(arr):
        if arr[i] == arr[j]:
            j += 1
        else:
            i += 1
            arr[i] = arr[j]

    return arr[: i + 1]  # return the result


print("Result :", remove_duplicates(given_input))
