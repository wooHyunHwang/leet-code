class Solution {
    int middle;
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) return 0;

        middle = (nums.length - 1) / 2;
        // System.out.println(middle);

        if (nums[middle] > target) {
            // System.out.println("Left");
            // 좌탐색
            return binaryLeft(nums, target);
        } else if (nums[middle] == target) {
            return middle;
        } else {
            // System.out.println("Right");
            // 우탐색
            return binaryRight(nums, target);
        }
    }

    public int binaryLeft(int[] nums, int target) {

        for (int i = middle - 1; i >= 0; --i) {
            if(target < nums[i]) {
                continue;
            } else if(target == nums[i]) {
                return i;
            } else {
                if (target < nums[i + 1]) {
                    return i + 1;
                } else {
                    return i;
                }
            }
        }
        return 0;

    }

    public int binaryRight(int[] nums, int target) {

        for (int i = middle + 1; i < nums.length; ++i) {
            if(target > nums[i]) {
                continue;
            } else if(target == nums[i]) {
                return i;
            } else {
                if (target > nums[i - 1]) {
                    return i;
                } else {
                    return i - 1;
                }
                
            }
        }
        return nums.length;
    }
}