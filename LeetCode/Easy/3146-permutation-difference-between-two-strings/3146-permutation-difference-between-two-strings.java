class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] idx = new int[26];
        int length = s.length();
        int permutation = 0;
        for (int i = 0; i < length; ++i) {
            idx[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < length; ++i) {
            permutation += Math.abs(idx[t.charAt(i) - 'a'] - i);
        }

        return permutation;
    }
}