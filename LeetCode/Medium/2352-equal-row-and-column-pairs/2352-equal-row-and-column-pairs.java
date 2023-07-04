class Solution {
    public int equalPairs(int[][] grid) {

        int ans = 0;
        int len = grid.length;
        int lastIdx = len - 1;
        
        Map<String, Integer> line = new HashMap<>();
        StringBuilder sbHor = new StringBuilder();
        StringBuilder[] sbVer = new StringBuilder[len];

        for(int i = 0; i < grid.length; ++i) {

            for(int j = 0; j < grid[i].length; ++j) {
                sbHor.append(grid[i][j]).append(",");
                if(j == grid[i].length - 1) {
                    String s = sbHor.toString();
                    line.put(
                        s,
                        line.getOrDefault(s, 0) + 1
                    );
                    sbHor.setLength(0);
                }

                if(sbVer[j] == null) sbVer[j] = new StringBuilder();
                sbVer[j].append(grid[i][j]).append(",");
            }
        }

        for(StringBuilder sb : sbVer) {
            String s = sb.toString();
            if(line.containsKey(s)) ans += line.get(s);
        }

        return ans;
    }
}