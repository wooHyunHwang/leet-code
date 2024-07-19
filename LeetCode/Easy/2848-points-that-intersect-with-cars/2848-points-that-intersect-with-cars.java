class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] history = new boolean[101];
        for (List<Integer> num : nums) {
            int end = num.get(1)+1;
            for (int i = num.get(0); i < end; ++i) {
                history[i] = true;
            }
        }

        int count = 0;
        for (boolean b : history) {
            if (b) count++;
        }
        return count;
    }
}