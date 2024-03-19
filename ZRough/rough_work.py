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
# def next_greater_element_non_circle(nums):
#     stack = []
#     results = [-1] * len(nums)

#     for i in range(len(nums)-1, -1, -1):
#         while stack and stack[-1] <= nums[i]:
#             stack.pop()
#         if stack:
#             results[i] = stack[-1]
#         stack.append(nums[i])
    
#     stack.clear()
#     return nums, results

# print(next_greater_element_non_circle([2,4,1,3,1,6]))
# print(next_greater_element_non_circle([11,13,3,10,7,21,26]))

# print()

# def next_smaller_element_non_circle(nums):
#     stack = []
#     results = [-1] * len(nums)

#     for i in range(len(nums)-1, -1, -1):
#         while stack and stack[-1] > nums[i]:
#             stack.pop()
#         if stack:
#             results[i] = stack[-1]
#         stack.append(nums[i])
    
#     stack.clear()
#     return nums, results

# print(next_smaller_element_non_circle([2,4,1,3,1,6]))
# print(next_smaller_element_non_circle([11,13,3,10,7,21,26]))
# ************************************************************
# LC: 347. Top K Frequent Elements
# def topKFrequent(nums, k):
#     frequency = dict.fromkeys(nums, 0)
#     grouping = [[] for i in range(len(nums))]
#     result = []

#     for num in nums:
#         frequency[num] += 1

#     for key, value in frequency.items():
#         grouping[value - 1].append(key)

#     for group in grouping[::-1]:
#         if group:
#             for num in group:
#                 result.append(num)
#                 if len(result) == k:
#                     return result
        
#     return []
        
# print(topKFrequent([3,0,1,0], 1))       # [0]
# print(topKFrequent([1,1,1,2,2,3], 2))   # [1, 2]
# print(topKFrequent([1], 1))             # [1]
# ************************************************************
# LC: 735. Asteroid Collision
def asteroidCollision(asteroids):
    stack = []

    for asteroid in asteroids:

        if stack and stack[-1] > 0 and asteroid < 0:
            popin = False
            while stack and stack[-1] > 0 and asteroid < 0:
                if abs(stack[-1]) < abs(asteroid):
                    popin = True
                    stack.pop()
                elif abs(stack[-1]) > abs(asteroid):
                    popin = False
                    break
                else:
                    popin = False
                    stack.pop()
                    break
            if popin:
                stack.append(asteroid)
        else:
            stack.append(asteroid)
                
    return stack
# print(asteroidCollision([-2,-2,1,-2]))
# ************************************************************
def romanToInt(s):
    """
    13.LC : Roman numbers to Integer
    Approach : We traverse roman numbers from left to right; if a current is less than next then subract the current from total.
    """
    rom_nums = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000,
    }
    
    ans = 0
    for n in range(len(s)):
        if n < len(s) - 1 and rom_nums[s[n]] < rom_nums[s[n+1]]:
            ans -= rom_nums[s[n]]
        else:
            ans += rom_nums[s[n]]
    
    return ans
print(romanToInt("MDCCCLXXXIV")) # 1884
# ************************************************************