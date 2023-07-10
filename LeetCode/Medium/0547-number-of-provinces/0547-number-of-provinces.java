class Solution {
    public int findCircleNum(int[][] isConnected) {

        int connected = 0;
        int len = isConnected.length;
        boolean[] history = new boolean[len];
        
        for(int i = 0; i < len; ++i) {

            if(history[i]) continue;

            this.dfs(isConnected, history, i);

            connected++;

        }

        return connected;
    }

    private void dfs(int[][] isConnected, boolean[] history, int i) {

        for(int j = 0; j < isConnected.length; ++j) {
            if(history[j]) continue;
            if(isConnected[i][j] == 1) {
                history[j] = true;
                this.dfs(isConnected, history, j);
            }
        }
    }

    
}