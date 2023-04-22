class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] sorted = score.clone();
        Arrays.sort(sorted);

        String[] ans = new String[score.length];
        int[] ranked = new int[sorted[sorted.length - 1] + 1];

        for(int i = 0; i < sorted.length; ++i) {
            ranked[sorted[i]] = sorted.length - 1 - i;
        }

        for(int i = 0; i < score.length; ++i) {
            if(ranked[score[i]] >= 3) ans[i] = Integer.toString(ranked[score[i]] + 1);
            else {
                if (ranked[score[i]] == 0) ans[i] = "Gold Medal";
                else if (ranked[score[i]] == 1) ans[i] = "Silver Medal";
                else if (ranked[score[i]] == 2) ans[i] = "Bronze Medal";
            }
        }

        return ans;
    }
}