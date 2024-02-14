class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int e = 0;
        int o = 1;

        for (int n : nums) {
            if (n > 0) {
                ans[e] = n;
                e += 2;
            } else {
                ans[o] = n;
                o += 2;
            }
        }

        return ans;
    }
    public int[] rearrangeArray2(int[] nums) {
        int[][] ary = new int[2][nums.length/2];
        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ary[0][a++] = nums[i];
            } else {
                ary[1][b++] = nums[i];
            }
        }

        a = 0;
        b = 0;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = ary[0][a++];
            nums[i+1] = ary[1][b++];
        }

        return nums;
    }
}