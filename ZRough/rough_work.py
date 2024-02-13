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
def anagram(s1, s2):
    if len(s1) == len(s2):
        d1 = dict.fromkeys(s1, 0)
        d2 = dict.fromkeys(s2, 0)

        for c1 in s1:
            d1[c1] += 1
        for c2 in s2:
            d2[c2] += 1
        
        # print(d1, "\n", d2, "\n")
        return d1 == d2
    return False

print(anagram("earth", "heart"))
# ************************************************************