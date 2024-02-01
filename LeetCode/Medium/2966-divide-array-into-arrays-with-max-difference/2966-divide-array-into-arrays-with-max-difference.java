class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int div = nums.length / 3;
        int[][] ans = new int[div][3];

        int max = 0;

        for (int n : nums) {
            if (max < n) max = n;
        }
        
        int[] table = new int[max+1];

        for (int n : nums) {
            table[n]++;
        }

        for (int i = 0, left = 0, right = 0; i < table.length;) {
            if (table[i] != 0) {
                table[i]--;
                ans[left][right++] = i;
                if (right > 2) {

                    if (ans[left][2] - ans[left][0] > k) return new int[0][0];

                    left++;
                    right = 0;
                }
            }
            else {
                i++;
            }
            
        }

        return ans;
    }
    public int[][] divideArray2(int[] nums, int k) {
        Arrays.sort(nums);
        int div = nums.length / 3;
        int[][] ans = new int[div][3];

        for (int i = 0; i < div; ++i) {
            int idx = i * 3;
            ans[i][0] = nums[idx];
            ans[i][1] = nums[idx+1];
            ans[i][2] = nums[idx+2];

            if (ans[i][2] - ans[i][0] > k) return new int[0][0];
        }

        return ans;
    }
}