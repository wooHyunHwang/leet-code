class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if(rooms == null || rooms.isEmpty()) return true;

        // 0: not visited, 1: visited
        boolean[] history = new boolean[rooms.size()];

        this.dfs(rooms, history, 0);

        for(int i = 0; i < history.length; ++i) {
            if(!history[i]) return false;
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] history, int key) {
        history[key] = true;
        for(int i = 0; i < rooms.get(key).size(); ++i) {
            if(!history[rooms.get(key).get(i)]) this.dfs(rooms, history, rooms.get(key).get(i));
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {

        if(rooms == null || rooms.isEmpty()) return true;

        // 0: not visited, 1: visited
        boolean[] history = new boolean[rooms.size()];
        Queue<Integer> keys = new LinkedList<>();

        // 0번방 처리
        history[0] = true;
        int visited = 1;
        for(Integer key : rooms.get(0)) {
            keys.add(key);
        }

        while(!keys.isEmpty()) {
            // 1. key 꺼냄
            int key = keys.poll();

            // 2.1 방문 했었으면 continue
            if(history[key]) continue;

            // 2.2 방문한거 아니면 방 방문
            for(Integer i : rooms.get(key)) {
                keys.add(i);
            }
            
            // 3. history에 방문 기록, visited에 방문 건수 증가
            history[key] = true;
            visited++;
        }

        return visited == rooms.size();
    }
}