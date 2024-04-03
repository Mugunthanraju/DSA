def reverseAlpha(sentence):
    words = sentence.split(" ")
    left = 0
    right = len(words) - 1
    while left < right:
        if words[left].isalpha() and words[right].isalpha():
            words[left], words[right] = words[right], words[left]
            left += 1
            right -= 1
            continue
        elif not words[left].isalpha():
            left += 1
            continue
        elif not words[right].isalpha():
            right -= 1
    
    result = " ".join(words)
    return result

def main():
    print(reverseAlpha("Player 18 is facing bowler #"))
    """
    bowler 18 facing is Player #
    """

if __name__ == "__main__":
    main()