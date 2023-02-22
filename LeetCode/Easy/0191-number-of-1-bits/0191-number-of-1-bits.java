public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        for(int i = 0; i < 32; ++i) {
            if((n & 1) == 1) {
                // 첫번째 자리가 1
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}