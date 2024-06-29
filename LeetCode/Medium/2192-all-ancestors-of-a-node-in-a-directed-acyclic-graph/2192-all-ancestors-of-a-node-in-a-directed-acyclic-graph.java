class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) ans.add(new ArrayList<>());

        boolean[][] reverseMap = new boolean[n][n];

        for (int[] e : edges) reverseMap[e[1]][e[0]] = true;

        boolean[][] reverseFullMap = new boolean[n][n];

        this.makeMap(reverseFullMap, reverseMap);

        for (int i = 0; i < reverseFullMap.length; ++i) {
            List<Integer> temp = ans.get(i);
            for (int j = 0; j < reverseFullMap[i].length; ++j) {
                if (reverseFullMap[i][j]) {
                    temp.add(j);
                }
            }
        }


        return ans;
    }

    private void makeMap(boolean[][] reverseFullMap, boolean[][] reverseMap) {
        for (int i = 0; i < reverseFullMap.length; ++i) {
            this.dfs(reverseFullMap[i], reverseMap, i);
        }
    }

    private void dfs(boolean[] fullMap, boolean[][] reverseMap, int i) {
        for (int j = 0; j < reverseMap[i].length; ++j) {
            if (!fullMap[j] && reverseMap[i][j]) {
                fullMap[j] = true;
                this.dfs(fullMap, reverseMap, j);
            }
        }
    }
}