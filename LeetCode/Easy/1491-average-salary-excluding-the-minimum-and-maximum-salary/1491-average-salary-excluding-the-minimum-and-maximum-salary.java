class Solution {
    public double average(int[] salary) {
        double ans = 0D;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < salary.length; ++i) {
            ans += salary[i];
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
        }

        if(max == min) {
            ans -= max;
            return ans / (salary.length - 1);
        } else {
            ans -= max;
            ans -= min;
            return ans / (salary.length - 2);
        }
    }
}