class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] rightHis = new int[51];
        int rightDiffCount = 0;
        for (int i = 1; i < nums.length; ++i) {
            rightHis[nums[i]]++;
            if (rightHis[nums[i]] == 1) rightDiffCount++;
        }

        int[] leftHis = new int[51];
        leftHis[nums[0]]++;
        int leftDiffCount = 1;
        nums[0] = leftDiffCount - rightDiffCount;
        for (int i = 1; i < nums.length; ++i) {

            rightHis[nums[i]]--;
            if (rightHis[nums[i]] == 0) rightDiffCount--;
            leftHis[nums[i]]++;
            if (leftHis[nums[i]] == 1) leftDiffCount++;
            // System.out.println(leftDiffCount + " - " + rightDiffCount + " = " + (leftDiffCount - rightDiffCount));
            nums[i] = leftDiffCount - rightDiffCount;
        }

        return nums;
    }
}