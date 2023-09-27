class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];
        int[] history = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            history[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (history[i] == 0) queue.add(i);
        }

        int count = 0;
        while(!queue.isEmpty()) {
            count++;
            int temp = queue.poll();

            for (int i : graph[temp]) {
                history[i]--;
                if (history[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return count == numCourses;
    }
}