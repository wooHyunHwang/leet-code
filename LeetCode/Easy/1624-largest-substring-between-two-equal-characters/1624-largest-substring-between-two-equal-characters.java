class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        int ans = -1;
        int[] minIdx = new int[26];
        for (int i = 0; i < 26; ++i) minIdx[i] = -1;

        for (int i = 0; i < s.length(); ++i) {
            int no = s.charAt(i) - 'a';
            if (minIdx[no] == -1) {
                minIdx[no] = i;
            } else {
                ans = Math.max(ans, i - minIdx[no] - 1);
            }
        }

        return ans;
    }
}