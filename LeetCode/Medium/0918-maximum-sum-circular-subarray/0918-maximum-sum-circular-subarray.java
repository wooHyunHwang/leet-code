class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // print(nums);
        int n = nums.length;
        int total = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        int globalMax = nums[0];
        int globalMin = nums[0];
        
        for(int i = 1; i < nums.length; ++i) {
            // System.out.println("==================================");

            // int next = ( i - 1 + n ) % n;

            total += nums[i];
            
            curMax = Math.max(nums[i], nums[i] + curMax);
            curMin = Math.min(nums[i], nums[i] + curMin);
            globalMax = Math.max(globalMax, curMax);
            globalMin = Math.min(globalMin, curMin);

            // System.out.println("이번값 : " + curMax + " / 이전값 " + curMin);
            // System.out.println("이번값 : " + globalMax + " / 이전값 " + globalMin);
        }

        return globalMax > 0 ? Math.max(globalMax, total - globalMin) : globalMax;
    }

    public void print(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; ++i ) {
            System.out.print(nums[i]);
            if( i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");
        System.out.println();
        
    }
}