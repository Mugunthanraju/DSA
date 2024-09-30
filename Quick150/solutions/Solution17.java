package solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution17 {

    public static int romanToInt(String s) {
        Map<Character, Integer> romInt = new HashMap<>();
        romInt.put('I', 1);
        romInt.put('V', 5);
        romInt.put('X', 10);
        romInt.put('L', 50);
        romInt.put('C', 100);
        romInt.put('D', 500);
        romInt.put('M', 1000);

        int total = 0, len = s.length(), i, nextNum, num;

        num = romInt.get(s.charAt(0));
        for (i = 0; i < len - 1; i++) {
            nextNum = romInt.get(s.charAt(i + 1));

            if (num < nextNum)
                total -= num;
            else
                total += num;

            num = nextNum;
        }
        return total + num;
    }

    public static void main(String[] args) {

        String roman1 = "III"; // 3
        System.out.println(romanToInt(roman1));
        String roman2 = "LVIII"; // 58
        System.out.println(romanToInt(roman2));
        String roman3 = "MCMXCIV"; // 1994
        System.out.println(romanToInt(roman3));
    }
}
