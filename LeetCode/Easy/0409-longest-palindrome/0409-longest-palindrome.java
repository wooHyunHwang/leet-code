class Solution {
    public int longestPalindrome(String s) {

        int[] dictionary = new int['z' - 'A' + 1];

        for (char c : s.toCharArray()) {
            dictionary[c - 'A']++;
        }

        int ans = 0;
        boolean single = false;

        for (int count : dictionary) {
            
            if (count > 0) {
                if (count % 2 == 1) {
                    single = true;
                    ans += count - 1;
                } else {
                    ans += count;
                }
            }
        }

        if (single) ans++;

        return ans;
    }
}