class Solution {
    public int heightChecker(int[] heights) {
        int[] sort = new int[heights.length];
        System.arraycopy(heights, 0, sort, 0, heights.length);

        Arrays.sort(sort);

        int ans = 0;
        for (int i = 0; i < sort.length; ++i) {
            if (heights[i] != sort[i]) ans++;
        }
        return ans;
    }
}