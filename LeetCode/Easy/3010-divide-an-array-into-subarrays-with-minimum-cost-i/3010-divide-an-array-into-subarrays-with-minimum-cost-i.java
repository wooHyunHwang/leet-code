class Solution {
    public int minimumCost(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; ++i) {
            if (second > nums[i]) {
                first = second;
                second = nums[i];
            } else if (first > nums[i]) {
                first = nums[i];
            }
        }

        return nums[0] + first + second;
    }

    public int minimumCost2(int[] nums) {

        int first = 0;
        int second = 0;

        if (nums[2] > nums[1]) {
            first = nums[1];
            second = nums[2];
        } else {
            first = nums[2];
            second = nums[1];
        }


        for (int i = 3; i < nums.length; ++i) {
            if (second > nums[i]) {
                if (first > second) first = second;
                second = nums[i];
            } else if (first > nums[i]) {
                first = second;
                second = nums[i];
            }
        }

        return nums[0] + first + second;
    }
}