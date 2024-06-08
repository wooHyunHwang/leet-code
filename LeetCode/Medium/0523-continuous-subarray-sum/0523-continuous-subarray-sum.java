class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];
            int remain = sum % k;

            if (map.containsKey(remain)) {
                if (i - map.get(remain) > 1) return true;
            }
            else {
                map.put(remain, i);
            }
        }
        return false;
    }
    // Timeout
    public boolean checkSubarraySum2(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;

        return this.recursive(nums, k, sum, 0, nums.length - 1);
    }

    private boolean recursive(int[] nums, int k, int sum, int left, int right) {

        if (left == right) return false;
        if (sum % k == 0) {
            // System.out.println("sum : " + sum + " ::::: " + left + " , " + right);
            return true;
        }
        

        return this.recursive(nums, k, sum - nums[left], left+1, right) ||
            this.recursive(nums, k, sum - nums[right], left, right-1);
    }
}

// 23 2  2 4  4 6  6 7
// 23 2 4  2 4 6  4 6 7
// 23 2 4 6    2 4 6 7
// 23,2,4,6,7

// 5, 2, 4, 0, 1
// 5, 2, 0, 4, 1
// 10, 2, 6, 4, 7

// 23 25 29 35 42 ===> 5 1 5 5 0
// 23 25 31 35 42 ===> 5 1 1 5 0
// 23 25 31 35 42 ===> 10 12 5 12 3