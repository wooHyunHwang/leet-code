class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int n : nums) {

            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if (n > max2) {
                max3 = max2;
                max2 = n;
            }
            else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            }
            else if (n < min2) {
                min2 = n;
            }
        }


        return Math.max(
            max1 * max2 * max3,
            max1 * min1 * min2
        );
    }
    public int maximumProduct1(int[] nums) {
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