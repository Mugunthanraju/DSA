def sum_list(nums):
    if len(nums) < 1:
        return 0
    return nums[0] + sum_list(nums[1:])

def convert_to_base(num, base):
    digits = '0123456789ABCDEF'

    if num < base:
        return digits[num]
    return convert_to_base(num // base, base) \
           + digits[num % base]

if __name__ == '__main__':
    # print(sum_list([1, 2, 3, 4, 5])) # 15
    # *************************************
    print(convert_to_base(9145, 16)) # 23B9
    print(convert_to_base(9145, 10)) # 9145
    print(convert_to_base(9145, 8)) # 21671
    print(convert_to_base(9145, 2)) # 10001110111001
    # *************************************
