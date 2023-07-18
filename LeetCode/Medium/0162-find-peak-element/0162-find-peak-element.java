class Solution {
    public int findPeakElement(int[] nums) {

        if(nums.length == 1) return 0;
        if(nums.length == 2) {
            if(nums[0] < nums[1]) return 1;
            else return 0;
        }

        Integer first = null;
        Integer second = null;

        for(int i = 0; i < nums.length; i = i + 2) {
            

            if(first != null && second != null) {
                if(first < second && second > nums[i]) return i - 1;
                if(i < nums.length - 1) {
                    if(second < nums[i] && nums[i] > nums[i+1]) return i;
                    if (i+1 == nums.length - 1 && nums[i] < nums[i+1]) return i+1;
                }
                else if (i == nums.length - 1) {
                    if (second < nums[i]) return i;
                }
            }

            first = nums[i];
            second = i + 1 < nums.length ? nums[i+1] : null;
        }

        return 0;
    }
}