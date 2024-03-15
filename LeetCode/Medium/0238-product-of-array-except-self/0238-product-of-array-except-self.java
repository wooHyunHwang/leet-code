class Solution {
    public int[] productExceptSelf(int[] nums) {

        int s = 1;
        int z = -1;
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                if (z != -1) {
                    // 0 1개 초과 = 전부 0
                    return answer;
                }
                z = i;
            }
            else s *= nums[i];
        }

        if (z != -1) {
            // 0 1개 = 0인 애만 구해주면 됨
            answer[z] = s;
        }
        else {
            for (int i = 0; i < nums.length; ++i) {
                s /= nums[i];
                if (i > 0) s *= nums[i-1];
                answer[i] = s;
            }
        }

        return answer;
    }
}