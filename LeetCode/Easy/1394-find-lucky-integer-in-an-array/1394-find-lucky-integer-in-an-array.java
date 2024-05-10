class Solution {
    public int findLucky(int[] arr) {
        int[] counter = new int[501];
        int lucky = -1;
        for (int n : arr) {
            counter[n]++;
        }
        for (int i = 1; i < counter.length; ++i) {
            if (i == counter[i] && lucky < i) {
                lucky = i;
            }
        }
        return lucky;
    }
}