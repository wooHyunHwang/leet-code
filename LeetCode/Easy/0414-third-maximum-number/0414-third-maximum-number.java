class Solution {
    public int thirdMax(int[] nums) {

        Set<Integer> set = new HashSet<>();
        
        int i = 0;
        int in = 0;
        int max = Integer.MIN_VALUE;
        int middle = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;

        while(i < nums.length) {

            if(set.contains(nums[i])) {
                i++;
                continue;
            }

            set.add(nums[i]);

            if (nums[i] > max) {
                min = middle;
                middle = max;
                max = nums[i];
                in++;
            }
            else if (nums[i] > middle) {
                min = middle;
                middle = nums[i];
                in++;
            }
            else if (nums[i] >= min) {
                min = nums[i];
                in++;
            }

            i++;
        }

        if (in >= 3) {
            return min;
        } else {
            return max;
        }
    }
}