class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while(left != right) {
            // System.out.println("left : " + left + " / right : " + right);
            ans = Math.max(
                ans,
                this.calc(height[left], height[right], right - left)
            );

            if(height[left] < height[right]) left++;
            else right--;
        }
        // System.out.println("끝");

        return ans;
    }

    private int calc(int leftV, int rightV, int length) {
        return Math.min(leftV, rightV) * length;
    }
}