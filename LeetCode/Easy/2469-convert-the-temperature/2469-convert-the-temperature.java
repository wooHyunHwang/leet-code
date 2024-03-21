class Solution {
    public double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15D;
        ans[1] = celsius * 1.80D + 32.00D;
        return ans;
    }
}