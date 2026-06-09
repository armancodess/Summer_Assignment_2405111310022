import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        if (isSame(pFreq, windowFreq)) {
            ans.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++;
            windowFreq[s.charAt(i - p.length()) - 'a']--;

            if (isSame(pFreq, windowFreq)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }

    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}