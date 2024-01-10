class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while(n > 0) {
            int calc = n % 10;
            product *= calc;
            sum += calc;
            n /= 10;
        }
        return product - sum;
    }
}