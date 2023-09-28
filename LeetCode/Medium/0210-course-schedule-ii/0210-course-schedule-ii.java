class Solution {
    List<Integer>[] graph = new List[0];
    boolean[] visit = new boolean[0];
    boolean[] checking = new boolean[0];

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        graph = new List[numCourses];
        visit = new boolean[numCourses];
        checking = new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            graph[p[0]].add(p[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (!this.dfs(i, queue)) {
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        for (int i = 0; !queue.isEmpty(); ++i) {
            ans[i] = queue.poll();
        }

        return ans;
    }

    private boolean dfs(int num, Queue<Integer> queue) {

        if (this.visit[num]) return true;
        if (this.checking[num]) return false; // 충돌

        this.checking[num] = true;

        for (int next : this.graph[num]) {
            if (!this.dfs(next, queue)) {
                return false;
            }
        }

        this.checking[num] = false;
        this.visit[num] = true;

        queue.add(num);

        return true;

    }
}