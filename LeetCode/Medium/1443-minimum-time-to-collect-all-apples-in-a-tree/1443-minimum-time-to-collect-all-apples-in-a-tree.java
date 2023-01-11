class Solution {
    /**
     * 풀지 못해서 정답 솔루션 확인...ㅜㅜ
     *
     */
    // Function to find the minimum time to collect all apples
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Create an adjacency list to represent the tree
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        // populate the adjacency list
        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }
        // call to helper function to find the minimum time
        return minTimeToCollectApples(0, adj, hasApple, 0);
    }
    // Helper function
    int minTimeToCollectApples(int index, List<List<Integer>> adj, List<Boolean> hasApple, int parent){
        // variable to keep track of total time
        int total = 0;
        // for each neighbor of current node
        for(int nbr : adj.get(index)){
            // if the neighbor is the parent node, then we skip
            if (nbr == parent)
             continue;
            // we recursively call the helper function for each neighbor
            total += minTimeToCollectApples(nbr, adj, hasApple, index);
        }
        // If current node is not the root (0th) node, and it has an apple or any of its descendant has
        //  then we need to add 2 time for moving to and from it
        if( index != 0 && (hasApple.get(index) || total > 0))
          total += 2;
        return total;
    }

    /**
     * 시도해본 방식...
     * 재귀 반복은 잘 돌았으나... 값을 추출하지 못했음

    // 탐색 시작 위치
    int currentPosition = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        
        currentPosition = 0;

        // 모든 경로
        HashMap<Integer, HashSet<Integer>> path = new HashMap<>();

        for(int i = 0; i < edges.length; ++i) {
            // [1] 추출
            HashSet<Integer> val = path.getOrDefault(edges[i][0], new HashSet<>());
            val.add(edges[i][1]);
            
            // 경로 맵 생성 / 업데이트
            path.put(edges[i][0], val);

            // 역방향도 생성

            // [0] 추출
            val = path.getOrDefault(edges[i][1], new HashSet<>());
            val.add(edges[i][0]);
            
            // 경로 맵 생성 / 업데이트
            path.put(edges[i][1], val);
        }

        System.out.println( "아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ" );
        for( Map.Entry<Integer, HashSet<Integer>> elem : path.entrySet() ){

            System.out.print("키 : " + elem.getKey() + " / 값 ");

            for (Integer e : elem.getValue()) {
                System.out.print(e + "|");
            }

            System.out.println("");
        }
        System.out.println( "아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ" );


        int routeCount = 0;

        // 사과 추출
        for(int endPosition = 0; endPosition < hasApple.size(); ++endPosition) {
            // 사과 위치 찾음
            if( hasApple.get(endPosition) ) {
                System.out.println("@@@@@@@@@@@@@@@@ 사과 찾음... : " + endPosition);
                // currentPosition부터 endPosition(목적지 좌표) 까지의 최적의 path 경로 탐색
                boolean[] visited = new boolean[n];
                visited[currentPosition] = true;

                int check = 0;

                routeCount += minRoute(check, endPosition, path, visited);

                System.out.println("@@@@@@@@@@@@@@@@ 경로 건수 계산 : " + check);
            }

        }

        return routeCount;
    }

    public int minRoute(int check, int endPosition, HashMap<Integer, HashSet<Integer>> path, boolean[] visited) {
        // 재귀
        // 0
        System.out.println("====== 이번 시작 위치 : " + currentPosition);
        HashSet<Integer> moveAble = path.get(currentPosition);
        int st = currentPosition;
        for (Integer move : moveAble) { // 1, 2
            System.out.println("이번에 체크할 좌표 : [" + st + "->" + move + "]");
            if(endPosition == move) {
                System.out.println("====== 목적지 찾음");
                // 도착) + 1
                currentPosition = move;
                check++;
                System.out.println("====== 이번 경로 탐색 끝 : " + check);
                return check;
            } else if (visited[move]) {
                System.out.println("====== 방문 했던 경로 버림 : -1");
                // 갈 수 없는 경로
            } else {
                System.out.println("====== &&&&&&&&&&&&&& 다음경로를 찾는다");
                visited[move] = true;
                currentPosition = move;
                check++;
                // 이동)
                int next = minRoute(check, endPosition, path, visited);
                if (next != -1) {
                    check = next;
                }
            }
        }

        System.out.println("====== 이번 경로 탐색 끝 : " + check);

        return -1;

    }

     */

        

}


















