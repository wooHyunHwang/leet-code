class Solution {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        int sqrt = (int)Math.sqrt(area);
        int max = 1;


        for (int i = 2; i <= sqrt; i++) {
            if(area % i == 0) {
                max = i;
            }
        }

        ans[0] = area / max;
        ans[1] = max;

        return ans;
    }
}