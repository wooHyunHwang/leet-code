class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> history = new HashMap<>();

        int x = 0, y = 0;

        this.saveHistory(history, x, y);

        for (char p : path.toCharArray()) {

            switch(p) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }

            if (this.saveHistory(history, x, y)) return true;
        }

        return false;
    }

    private boolean saveHistory(Map<Integer, Set<Integer>> history, int x, int y) {
        
        Set<Integer> yData = history.getOrDefault(x, new HashSet<>());

        if (yData.contains(y)) return true;

        yData.add(y);

        history.put(x, yData);

        return false;
    }
}