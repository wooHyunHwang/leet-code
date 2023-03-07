class Solution {
    public int addDigits(int num) {

        int ans = 0;
        
        while (true) {
            ans += num % 10;
            if (num < 10) break;
            num /= 10;
        }

        if (ans > 9) {
            return addDigits(ans);
        } else {
            return ans;
        }
    }
}