public class IsSubsequence {
    public static boolean isSubseq(String s, String t) {
        int i = 0, n = s.length();

        for (char c : t.toCharArray()) {
            if (i == n)
                return true;

            if (s.charAt(i) == c)
                i++;
        }

        return i == n;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Is " + s1 + " subsequence of " + t1 + " ? " + isSubseq(s1, t1));
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Is " + s2 + " subsequence of " + t2 + " ? " + isSubseq(s2, t2));
    }
}
