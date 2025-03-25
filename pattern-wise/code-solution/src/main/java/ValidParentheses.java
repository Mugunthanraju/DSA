import java.util.Stack;

public class ValidParentheses {
    // LC : 20. Valid Parentheses
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if ('(' == c || '{' == c || '[' == c) {
                stack.add(c);
            }
            else {
                if (stack.isEmpty())
                    return false; // First Closing Occurrance
                if (
                        (stack.peek() == '{' && c == '}')
                                || (stack.peek() == '(' && c == ')')
                                || (stack.peek() == '[' && c == ']')
                ) {
                    stack.pop();
                }
                else {
                    return false; //
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([})";

        System.out.println(s1 + " is this valid? " + isValid(s1));
        System.out.println(s2 + " is this valid? " + isValid(s2));
    }
}
