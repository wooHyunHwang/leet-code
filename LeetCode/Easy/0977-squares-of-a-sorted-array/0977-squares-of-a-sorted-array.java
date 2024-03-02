class Solution {
    public int[] sortedSquares(int[] nums) {

        int lastIdx = nums.length - 1;

        if (nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }

        int i = 0;
        int[] ans = new int[nums.length];

        int center = 0;
        // System.out.println("center...");

        // 중간 찾고
        for (; center < lastIdx; ++center) {
            if (Math.abs(nums[center+1]) > Math.abs(nums[center])) {
                break;
            }
        }
        /*
        while(true) {
            System.out.println(center);

            if (center == 0) {
                if (Math.abs(nums[center+1]) < Math.abs(nums[center])) {
                    center++;
                    continue;
                }
                else break;
            }
            else if (center == lastIdx) {
                if (Math.abs(nums[center-1]) < Math.abs(nums[center])) {
                    center--;
                    continue;
                }
                else break;
            }

            if (Math.abs(nums[center-1]) > Math.abs(nums[center]) &&
                Math.abs(nums[center+1]) > Math.abs(nums[center])
            ) {
                break;
            }

            if (Math.abs(nums[center-1]) < Math.abs(nums[center])) center--;
            else center++;
        }
        */

        ans[i++] = nums[center] * nums[center];
        int left = center-1;
        int right = center+1;
        // System.out.println("set - " + center);

        while(left > -1 || right < nums.length) {
            if (left < 0) {
                ans[i++] = nums[right] * nums[right++];
            }
            else if (right >= nums.length) {
                ans[i++] = nums[left] * nums[left--];
            }
            else if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                ans[i++] = nums[left] * nums[left--];
            }
            else {
                ans[i++] = nums[right] * nums[right++];
            }
        }


        return ans;
    }
}