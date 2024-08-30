class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] ans = new int[2];
        int[] num1Count = new int[101];
        boolean[] num1Checked = new boolean[101];

        for (int n : nums1) num1Count[n]++;

        for (int n2 : nums2) { 
            if (num1Count[n2] > 0) {
                ans[1]++;
                if (!num1Checked[n2]) {
                    num1Checked[n2] = true;
                    ans[0] += num1Count[n2];
                }
            }
        }

        num1Count = null;
        num1Checked = null;

        return ans;
    }
}