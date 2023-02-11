class Solution {
    public int removeElement(int[] nums, int val) {

        int k = 0;
        
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == val) {
                
                k++;
            } else {
                // 지우는 값이 아니므로 값 입력
                nums[i - k] = nums[i];
            }

       

        }

        // 제거하고 남은 값의 수
        return nums.length - k;
    }
}