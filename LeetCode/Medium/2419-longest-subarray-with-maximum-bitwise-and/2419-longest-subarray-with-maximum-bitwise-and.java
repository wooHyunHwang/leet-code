class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int beforeIdx = 0;
        int max = nums[0];
        boolean contiguous = true;
        for (int i = 1; i < nums.length; ++i) {
            if (max < nums[i]) {
                count = 0;
                beforeIdx = i;
                max = nums[i];
                contiguous = true;
            }
            else if (max == nums[i]) {
                if (!contiguous) {
                    contiguous = true;
                    beforeIdx = i;
                }
            }
            else {
                if (contiguous) {
                    count = Math.max(count, i - beforeIdx);
                }
                contiguous = false;
            }
            // System.out.print(max + "|");
        }
        if (contiguous) {
            count = Math.max(count, nums.length - beforeIdx);
        }
        // System.out.println();
        // System.out.println(max);
        return count;
    }
}