class Solution {
    public String longestPalindrome(String s) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = expandFromCenter(s, i, i);
            String evenPalindrome = expandFromCenter(s, i, i + 1);

            if (oddPalindrome.length() > answer.length()) {
                answer = oddPalindrome;
            }

            if (evenPalindrome.length() > answer.length()) {
                answer = evenPalindrome;
            }
        }

        return answer;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}