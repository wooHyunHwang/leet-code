class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleDigit = 0;
        int doubleDigit = 0;
        for (int n : nums) {
            if (n > 9) doubleDigit += n;
            else singleDigit += n;
        }
        return singleDigit != doubleDigit;
    }
}