class Solution {
    public int largestAltitude(int[] gain) {
        int high = 0;
        int ans = 0;

        for(int i : gain) {
            high += i;
            ans = Math.max(ans, high);
        }

        return ans;
    }
}