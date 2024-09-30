package solutions;

public class Solution19 {

    public static int lengthOfLastWord(String s) {

        int size = 0;
        /******************************************************************/

        /* First two approaches need spliting of string */
        // String[] stringArray = s.split(" ");

        /* Approach : 1 */

        // for (int i = stringArray.length - 1; i > -1; i--) {
        // size = stringArray[i].length();
        // if (!stringArray[i].isBlank())
        // break;
        // }

        /* Approach : 2 */

        // String lastWord = stringArray[stringArray.length - 1];
        // size = lastWord.length();

        /******************************************************************/

        /* Approach : 3 - Most Optimized */

        // We are looking for the last word so let's go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // a letter is found so count
                size++;
            } else { // it's a white space instead
                // Did we already started to count a word ? Yes so we found the last word
                if (size > 0)
                    return size;
            }
        }

        /******************************************************************/
        return size;
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        System.out.println(lengthOfLastWord(s1)); // 5
        String s2 = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s2)); // 4
        String s3 = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s3)); // 6
    }
}