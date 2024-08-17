# input

"""
friends_name : seen / not_seen
"""

# output

"""
friends_name : available / missing / undetermined (opt)
"""


class ParkSimulation:
    def __init__(self) -> None:
        self.friends_list = ["Rachel", "Ross", "Chandler", "Joey", "Phoebe"]
        # self.missing_list = list()
        # self.undetermined = list() # Opt
        self.friend_status = dict()
        for friend_name in self.friends_list:
            self.friend_status[friend_name] = 0
        self.times = 0

    def reporting(self):
        # observer
        print(
            f"\nLog : 15 mins iteration now at {self.times // 4} : {(self.times % 4) * 15} "
        )
        for name, count in self.friend_status.items():
            if count < 6:
                print(f"{name} : Available")
            elif count < 12 and count >= 6:
                print(f"{name} : Undertermined")
            else:
                print(f"{name} : Missing")

    def recieve_simulation(self):
        for name in self.friends_list:
            print(f"\nProvide status for {name} :")
            input_value = input()
            if input_value == "seen":
                self.friend_status[name] = 0
            elif input_value == "unseen":
                self.friend_status[name] += 1

    def scheduling_simulation(self):
        while self.times < (24 * 4):
            self.recieve_simulation()
            self.reporting()
            self.times += 1
        return


def ciruclarPallindrome(text=None):
    text = "rbaab"

    if len(text) < 2:
        return True
    if len(text) == 2:
        return text[::-1] == text[:]

    mid = len(text) // 2
    print(f"Mid = {mid}")

    left = mid
    right = mid + 1
    print(f"Left = {left} : Right = {right}")

    while left > -1 and right < len(text):

        print(f"Char at left index = {text[left]} and right index = {text[right]}")

        if text[left] == text[right]:
            left -= 1
            right += 1
        else:
            return False

    if (left == 0 and right == len(text) - 2) or (left == 1 and right == len(text) - 1):
        return True

    right = mid
    left = mid - 1
    print(f"Left = {left} : Right = {right}")

    while left > -1 and right < len(text):

        print(f"Char at left index = {text[left]} and right index = {text[right]}")

        if text[left] == text[right]:
            left -= 1
            right += 1
        else:
            return False

    if (left == 0 and right == len(text) - 2) or (left == 1 and right == len(text) - 1):
        return True

    return False


def is_palindrome(s):
    """Check if the given string s is a palindrome."""
    return s == s[::-1]


def is_circular_palindrome(s):
    """Check if any rotation of the string s is a palindrome."""
    print(f"Original String : {s}")
    n = len(s)
    if n == 0:
        return True  # An empty string is considered a palindrome
    # Check each rotation
    for i in range(n):
        rotated = s[i:] + s[:i]
        print(f"Rotated String : {rotated}")  # Create the rotated version
        if is_palindrome(rotated):
            return True
    return False


def is_circular_palindrome_optimized(s):
    """Check if any rotation of the string s is a palindrome using the doubled string method."""
    n = len(s)
    if n == 0:
        return True  # An empty string is a palindrome
    doubled_s = s + s  # Create the doubled string
    print(f"Double String : {doubled_s}")
    for i in range(n):
        print(f"Double String rotation : {doubled_s[i:i+n]}")
        if is_palindrome(doubled_s[i : i + n]):
            return True
    return False


def main():
    # park_simulation = ParkSimulation()
    # park_simulation.scheduling_simulation()
    # print(ciruclarPallindrome())
    print(is_circular_palindrome("rbaab"))  # Output: True
    print(is_circular_palindrome("baabr"))  # Output: True
    print(is_circular_palindrome_optimized("rbaab"))  # Output: True
    print(is_circular_palindrome_optimized("baabr"))  # Output: False


if __name__ == "__main__":
    main()
