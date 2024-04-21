class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (edges.length == 0) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {

            List<Integer> coord0 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> coord1 = graph.getOrDefault(edge[1], new ArrayList<>());

            coord0.add(edge[1]);
            coord1.add(edge[0]);

            graph.put(edge[0], coord0);
            graph.put(edge[1], coord1);

        }

        return this.findPath(graph, source, destination, new HashSet<>());
    }

    private boolean findPath(Map<Integer, List<Integer>> graph,
                            int target, int destination,
                            Set<Integer> history) {

        if (!graph.containsKey(target)) return false;
        if (history.contains(target)) {
            // 방문했던곳, 목표 찾지못하고 순회 지점
            return false;
        }

        history.add(target);

        List<Integer> coord = graph.get(target);

        for (int coordinate : coord) {
            if (coordinate == destination) {
                return true;
            }
            else if (this.findPath(graph, coordinate, destination, history)) {
                return true;
            }
        }
        return false;
    }
}