class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        int[] lps = buildLPS(s);

        int longestPrefixSuffix = lps[n - 1];

        if (longestPrefixSuffix == 0) {
            return false;
        }

        int patternLength = n - longestPrefixSuffix;

        return n % patternLength == 0;
    }

    private int[] buildLPS(String s) {
        int[] lps = new int[s.length()];

        int length = 0;
        int i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}