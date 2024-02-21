# given = "coompuuter"
# vowels = "aAeEiIoOuU"
# output = []

# for x in range(len(given)):
#     if given[x] in vowels:
#         if x < len(given)-1 and given[x+1] == given[x]:
#             output.append(given[x:x+2])
#         else:
#             pass
#     else:
#         output.append(given[x])

# print("".join(output))
# ************************************************************
# import math
# print(math.sqrt(16))
# ************************************************************
# def summing(n):
#     return ((n*n)+n)//2
# total = summing(3)
# print(total)
# ************************************************************
# def anagram(s1, s2):
#     if len(s1) == len(s2):
#         d1 = dict.fromkeys(s1, 0)
#         d2 = dict.fromkeys(s2, 0)

#         for c1 in s1:
#             d1[c1] += 1
#         for c2 in s2:
#             d2[c2] += 1
        
#         # print(d1, "\n", d2, "\n")
#         return d1 == d2
#     return False

# print(anagram("earth", "heart"))
# ************************************************************
def next_greater_element_non_circle(nums):
    stack = []
    results = [-1] * len(nums)

    for i in range(len(nums)-1, -1, -1):
        while stack and stack[-1] <= nums[i]:
            stack.pop()
        if stack:
            results[i] = stack[-1]
        stack.append(nums[i])
    
    stack.clear()
    return nums, results

print(next_greater_element_non_circle([2,4,1,3,1,6]))
print(next_greater_element_non_circle([11,13,3,10,7,21,26]))

print()

def next_smaller_element_non_circle(nums):
    stack = []
    results = [-1] * len(nums)

    for i in range(len(nums)-1, -1, -1):
        while stack and stack[-1] > nums[i]:
            stack.pop()
        if stack:
            results[i] = stack[-1]
        stack.append(nums[i])
    
    stack.clear()
    return nums, results

print(next_smaller_element_non_circle([2,4,1,3,1,6]))
print(next_smaller_element_non_circle([11,13,3,10,7,21,26]))
# ************************************************************