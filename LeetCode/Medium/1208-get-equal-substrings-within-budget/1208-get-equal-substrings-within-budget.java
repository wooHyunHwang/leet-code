class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        int[] diff = new int[sC.length];

        for (int i = 0; i < diff.length; ++i) {
            diff[i] = Math.abs(sC[i] - tC[i]);
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int max = 0;

        for (; r < diff.length; ++r) {
            sum += diff[r];
            if (sum > maxCost) {
                sum -= diff[l++];
            }
            max = Math.max(max, r-l+1);
        }

        return max;
    }
}