class Solution {
    public int singleNumber(int[] nums) {
        int res =0;
        for(int i=0;i<32;i++) {
            int sum =0;

            for(int var: nums) {
                sum = sum+((var>>i)&1);
            }

            if(sum%3 == 1) {
                res = res | ((sum%3)<<i);
            }
        }
        return res;
    }
}