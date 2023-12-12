class Solution {
    public int maxProduct(int[] nums) {

        int l = 0;
        int r = 0;
        
        // for (int i = 0; i < nums.length; ++i) {

        // }

        for (int n : nums) {
            int nl = n - 1;
            if (nl > l) {
                r = l;
                l = nl;
            } else if (nl > r) {
                r = nl;
            }
        }

        return l * r;
    }
}