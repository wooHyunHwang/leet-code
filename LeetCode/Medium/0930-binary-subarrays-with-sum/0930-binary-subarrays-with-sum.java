class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int center = 0;
        int[] array = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            array[i] = nums[i];
            if (array[i] == goal) center++;
        }

        int side = 0;
        for (int i = 0; i < nums.length; ++i) {

            for (int j = i+1; j < nums.length; ++j) {
                array[i] += nums[j];
                if (array[i] == goal) side++;
                else if (array[i] > goal) break;
            }
        }

        return center + side;
    }
}

// /   1 0 1 0 1

// 1   1 1 2 2 3
// 0   1 0 1 1 2
// 1   2 1 1 1 2
// 0   2 1 1 0 1
// 1   3 2 2 1 1

//    0 0 0 0 0
//    0 0 0 0 0
//    0 0   0 0
//    0 0 0 0 0
//    0 0 0 0 0