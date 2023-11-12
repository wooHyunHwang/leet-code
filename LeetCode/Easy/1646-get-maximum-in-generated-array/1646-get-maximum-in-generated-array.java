class Solution {
    public int getMaximumGenerated(int n) {

        if (n == 0) return 0;

        int max = 1;
        int[] nums = new int[n+1];

        nums[0] = 0;
        nums[1] = 1;

        int realI = 2;
        int i = 1;

        while(realI < nums.length) {

            int next = oddGen(nums, realI++, i);
            max = Math.max(max, next);

            if (realI >= nums.length) break;

            next = evenGen(nums, realI++, i++);
            max = Math.max(max, next);
        }

        return max;
    }

    // 홀수 생성
    private int oddGen(int[] nums, int realI, int i) {
        nums[realI] = nums[i];
        return nums[realI];
    }

    // 짝수 생성
    private int evenGen(int[] nums, int realI, int i) {
        nums[realI] = nums[i] + nums[i+1];
        return nums[realI];
    }
}