class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> graph = new HashMap<>();

        for (List<String> path : paths) {
            graph.put(path.get(0), path.get(1));
        }

        String place = paths.get(0).get(0);

        while(graph.containsKey(place)) {
            place = graph.get(place);
        }

        return place;
    }
    public String destCity2(List<List<String>> paths) {
        Map<String, String> graph = new HashMap<>();

        for (List<String> path : paths) {
            graph.put(path.get(0), path.get(1));
        }

        for (List<String> path : paths) {
            Set<String> visited = new HashSet<>();

            visited.add(path.get(0));
            String start = path.get(1);

            while(!visited.contains(start)) {
                visited.add(start);
                if (!graph.containsKey(start)) return start;
                start = graph.get(start);
            }
        }
        return "";
    }
}