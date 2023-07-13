class Solution {

    private double[] ans = new double[0];
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // 좌표 만들기
        Map<String, Set<String>> map = new HashMap<>();
        // 좌표값 그래프 만들기
        Map<String, Double> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); ++i) {
            Set<String> temp = map.getOrDefault(equations.get(i).get(0), new HashSet<>());
            temp.add(equations.get(i).get(1));
            map.put(
                equations.get(i).get(0),
                temp
            );
            Set<String> temp2 = map.getOrDefault(equations.get(i).get(1), new HashSet<>());
            temp2.add(equations.get(i).get(0));
            map.put(
                equations.get(i).get(1),
                temp2
            );

            graph.put(equations.get(i).get(0) + "/" + equations.get(i).get(1), values[i]);
            graph.put(equations.get(i).get(1) + "/" + equations.get(i).get(0), 1D / values[i]);
        }

        ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); ++i) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            // System.out.println("====== " + start + "/" + end);

            // 그래프에서 바로 꺼낼수 있는 경우
            if(start.equals(end)) {
                // System.out.println("같은 경우");
                if(map.containsKey(start)) ans[i] = 1D;
                else ans[i] = -1D;
            }
            else if(graph.containsKey(start + "/" + end)) {
                ans[i] = graph.get(start + "/" + end);
            }
            else if (graph.containsKey(end + "/" + start)) {
                ans[i] = 1D / graph.get(end + "/" + start);
            }
            else {
                // 가는 길은 존재하는 경우
                // System.out.println("=== " + "탐색");
                ans[i] = this.findDfs(
                    map,
                    graph,
                    start,
                    end,
                    new HashSet<>(),
                    1D
                );
                if(ans[i] == -1D) {
                    // System.out.println("정방향 못찾아서 역탐지");
                    ans[i] = this.findDfs(
                        map,
                        graph,
                        end,
                        start,
                        new HashSet<>(),
                        1D
                    );
                    if(ans[i] != -1D) ans[i] = 1D / ans[i];
                }
            }
        }
        
        return ans;
    }

    private double findDfs(Map<String, Set<String>> map, Map<String, Double> graph,
                            String start, String end, Set<String> visited, double accum) {

        // System.out.println(start + " - " + end + " / " + accum);
        if(!map.containsKey(start)) {
            // System.out.println("?? 없는값");
            return -1D;
        }

        Set<String> list = map.get(start);
        visited.add(start);

        for(String next : list) {
            if(visited.contains(next)) continue;
            // System.out.println("next : " + next);
            if(graph.containsKey(start + "/" + end)) {
                // System.out.println("찾음");
                return accum * graph.get(start + "/" + end);
            } else {
                // System.out.println("못찾음");
                if(!graph.containsKey(start + "/" + next)) return -1D;
                double findPath = this.findDfs(
                    map,
                    graph,
                    next,
                    end,
                    visited,
                    accum * graph.get(start + "/" + next)
                );
                if(findPath != -1D) return findPath;
            }
        }
        return -1D;
    }






















}