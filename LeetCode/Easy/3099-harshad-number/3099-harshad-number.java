class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int div = x;
        int digitSum = 0;

        while(div > 0) {
            digitSum += div % 10;
            div /= 10;
        }
        
        return x % digitSum == 0 ? digitSum : -1;
    }
}
