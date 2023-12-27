class Solution {
    public int minCost(String colors, int[] neededTime) {

        int cost = 0;
        char[] color = colors.toCharArray();
        char before = color[0];
        int sum = neededTime[0];
        int currentMax = neededTime[0];
        int cnt = 1;

        for (int i = 1; i < color.length; ++i) {
            if (before == color[i]) {
                sum += neededTime[i];
                currentMax = Math.max(currentMax, neededTime[i]);
                cnt++;
            } else {
                if (cnt > 1) {
                    cost += sum - currentMax;
                }
                before = color[i];
                sum = neededTime[i];
                currentMax = neededTime[i];
                cnt = 1;
            }
        }

        if (cnt > 1) {
            cost += sum - currentMax;
        }

        return cost;
    }
}