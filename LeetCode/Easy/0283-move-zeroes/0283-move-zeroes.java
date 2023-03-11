class Solution {
    public void moveZeroes(int[] nums) {
        int checkedZero = 0;
        for (int i = 0; i < nums.length; ++i) {
            // System.out.println(i + " / " + checkedZero);
            if (nums[i] == 0) {
                // 0
                checkedZero++;
            } else {
                // 0이 아님
                nums[i - checkedZero] = nums[i];

                // if (i + checkedZero >= nums.length) {
                    // 0으로 채움
                //     nums[i] = 0;
                // }
            }
        }
        // N번 이상 수행하지만 빠름..?
        for (; checkedZero > 0; --checkedZero) {
            nums[nums.length - checkedZero] = 0;
        }
    }
}