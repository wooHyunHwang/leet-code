class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] history = new boolean[10_001];
        int[] ans = new int[2];
        
        for (int no : nums) {

            if (history[no]) ans[0] = no;
            else history[no] = true;

        }

        for (int i = 1; i < history.length; ++i) {
            if (!history[i]) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}