class Solution {
    public boolean isPowerOfTwo(int n) {

        if (n <= 0) return false;

        int div = n / 2;
        int remain = n % 2;

        while(div > 1) {
            if (remain != 0) return false;
            remain = div % 2;
            div = div / 2;
        }
        if (n > 1 && remain != 0) return false;


        return true;
    }
}