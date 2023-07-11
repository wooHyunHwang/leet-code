class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; ++i) graph.add(new ArrayList<>());

        for(int i = 0; i < connections.length; ++i) {
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(-connections[i][0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Init
        int ans = 0;
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()) {
            int idx = queue.poll();

            List<Integer> temp = graph.get(Math.abs(idx));
            for(int i = 0; i < temp.size(); ++i) {
                int abs = Math.abs(temp.get(i));

                if(!visited[abs]) {
                    visited[abs] = true;
                    queue.add(temp.get(i));
                    if(temp.get(i) > 0) ans++;
                }
            }
        }

        return ans;
    }





    int ansTimeout = 0;
    public int minReorderTimeout(int n, int[][] connections) {
        ansTimeout = 0;

        this.dfsTimeout(connections, new boolean[n], 0, -1);

        return ansTimeout;
    }

    private void dfsTimeout(int[][] connections, boolean[] ordered, int findIdx, int reverse) {

        System.out.println("d");

        // 처리했던 findStart면 return
        if(ordered[findIdx]) return;
        

        for(int i = 0; i < connections.length; ++i) {
            
            if(i == reverse) continue;
            System.out.println("for");

            if(connections[i][0] == findIdx) {
                // System.out.println("start : " + i);
                ordered[findIdx] = true;
                if(!ordered[connections[i][1]]) this.dfsTimeout(connections, ordered, connections[i][1], -1);

                this.ansTimeout++;

                int temp = connections[i][0];
                connections[i][0] = connections[i][1];
                connections[i][1] = temp;

            }
            else if(connections[i][1] == findIdx) {
                // System.out.println("end : " + i);
                ordered[findIdx] = true;
                if(!ordered[connections[i][0]]) this.dfsTimeout(connections, ordered, connections[i][0], i);
            }
        }
    }
}