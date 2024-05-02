class Solution {
    public int findMaxK(int[] nums) {

        int[] twin = new int[1001];

        int ans = -1;

        for (int n : nums) {
            int abs = Math.abs(n);
            if (n < 0 && twin[abs] != -1) {
                twin[abs]--;
            } else if (n > 0 && twin[abs] != 1) {
                twin[abs]++;
            }

            if (twin[abs] == 0 && ans < abs) {
                ans = abs;
            }
        }


        return ans;
    }
}