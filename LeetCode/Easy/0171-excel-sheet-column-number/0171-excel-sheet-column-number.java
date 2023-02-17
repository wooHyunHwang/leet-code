class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;

        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            int cur = (int) (columnTitle.charAt(i) - 'A');

            int multiple = (int)Math.pow(26, columnTitle.length() - 1 - i);

            int calc = multiple * (cur + 1);

            // System.out.println(cur + " : " + multiple + " : " + calc);

            ans += calc;
        }

        return ans;
    }
}