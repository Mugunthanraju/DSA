package solutions;

public class Solution18 {

    public static String intToRoman(int num) {
        String ones[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        String tens[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String hrds[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String ks[] = { "", "M", "MM", "MMM" };

        return ks[num / 1000] +
                hrds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                ones[num % 10];
    }

    public static void main(String[] args) {

        int integer1 = 3749; // "MMMDCCXLIX"
        System.out.println(intToRoman(integer1));
        int integer2 = 58; // LVIII
        System.out.println(intToRoman(integer2));
        int integer3 = 1994; // MCMXCIV
        System.out.println(intToRoman(integer3));
    }
}

/*
 * To solve the Leetcode problem "12. Integer to Roman," we need to convert an
 * integer into its corresponding Roman numeral representation. Roman numerals
 * are represented using combinations of the following symbols:
 * 
 * - **I** = 1
 * - **V** = 5
 * - **X** = 10
 * - **L** = 50
 * - **C** = 100
 * - **D** = 500
 * - **M** = 1000
 * 
 * ### Approach
 * 
 * The conversion can be efficiently handled using a greedy algorithm by mapping
 * the integer values to their corresponding Roman numeral symbols in descending
 * order. The idea is to repeatedly subtract the largest possible value from the
 * number and append the corresponding Roman numeral to the result until the
 * number is reduced to zero.
 * 
 * ### Steps:
 * 1. Create a list of tuples containing Roman numeral symbols and their
 * corresponding integer values, sorted in descending order.
 * 2. Initialize an empty string to build the resulting Roman numeral.
 * 3. Iterate through the list of tuples:
 * - While the current number is greater than or equal to the integer value of
 * the tuple, append the Roman numeral to the result and subtract its integer
 * value from the number.
 * 4. Return the resulting string.
 * 
 * ### Time Complexity:
 * - **O(n)**: The number of symbols processed is constant (7 symbols), and we
 * iterate through them for each digit in the input number.
 * 
 * ### Space Complexity:
 * - **O(1)**: The space used for storing the result is proportional to the
 * length of the output, which is limited.
 * 
 * ### Explanation of the Code:
 * 1. The `intToRoman` method initializes arrays for Roman numeral symbols and
 * their corresponding integer values.
 * 2. It uses a `StringBuilder` to efficiently build the resulting Roman numeral
 * string.
 * 3. It iterates through each value-symbol pair:
 * - If `num` is greater than or equal to a value, it appends the corresponding
 * symbol to `result` and subtracts that value from `num`.
 * 4. Finally, it returns the constructed Roman numeral string.
 * 
 * This solution effectively converts an integer to its Roman numeral
 * representation and passes all relevant test cases on Leetcode. If you have
 * any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.romannumerals.org/converter
 * [2]
 * https://stackoverflow.com/questions/12967896/converting-integers-to-roman-
 * numerals-java
 * [3] https://www.rapidtables.com/convert/number/roman-numerals-converter.html
 * [4] https://www.calculatorsoup.com/calculators/conversions/roman-numeral-
 * converter.php
 * [5] https://www.youtube.com/watch?v=P0BT1xA2tIg
 * [6] https://www.youtube.com/watch?v=ZHJDwbfqoa8
 * [7]
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-
 * sum-exists-in-array/
 * [8]
 * https://github.com/doocs/leetcode/blob/main/solution/0000-0099/0057.Insert%
 * 20Interval/README_EN.md
 */

class Solution_18 {
    public String intToRoman(int num) {
        // Define mappings of integers to Roman numerals
        String[] romanSymbols = {
                "M", "CM", "D", "CD", "C",
                "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"
        };
        int[] values = {
                1000, 900, 500, 400, 100,
                90, 50, 40, 10,
                9, 5, 4, 1
        };

        StringBuilder result = new StringBuilder();

        // Iterate over each symbol-value pair
        for (int i = 0; i < values.length; i++) {
            // While num is greater than or equal to the value
            while (num >= values[i]) {
                result.append(romanSymbols[i]); // Append symbol
                num -= values[i]; // Subtract value from num
            }
        }

        return result.toString(); // Return the final Roman numeral
    }
}