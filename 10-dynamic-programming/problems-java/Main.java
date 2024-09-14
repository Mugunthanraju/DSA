public class Main {

    // To find longest Common Substing
    public static String longestSubstring(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int[][] lcs = new int[len1 + 1][len2 + 1];

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 0;
            }
        }

        int maxLen = 0;
        int endIndex = 0;

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    if (maxLen < lcs[i][j]) {
                        maxLen = lcs[i][j];
                        endIndex = i;
                    }
                } else {
                    lcs[i][j] = 0;
                }
            }
        }

        // return maxLen; // To return LCS lenght

        if (maxLen == 0)
            return "";

        return word1.substring(endIndex - maxLen, endIndex);
    }

    public static void main(String[] args) {
        String result = longestSubstring("abcdaf", "bcdf");
        // String result = longestSubstring("abcdef", "zcdemf");
        System.out.println(result);
    }
}
