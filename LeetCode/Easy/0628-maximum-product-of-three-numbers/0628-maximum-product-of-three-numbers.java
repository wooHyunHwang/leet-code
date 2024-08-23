class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(
            nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3],
            nums[nums.length-1] * nums[0] * nums[1]
        );
    }
    public int maximumProduct2(int[] nums) {
        int swap1 = Integer.MIN_VALUE;
        int swap2 = Integer.MIN_VALUE;
        int swap3 = Integer.MIN_VALUE;


        for (int n : nums) {

            if (n > swap1) {
                swap3 = swap2;
                swap2 = swap1;
                swap1 = n;
            }
            else if (n > swap2) {
                swap3 = swap2;
                swap2 = n;
            }
            else if (n > swap3) {
                swap3 = n;
            }
        }


        return swap1 * swap2 * swap3;
    }
}