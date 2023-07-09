class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        
        if(rooms.isEmpty()) return true

        val history = BooleanArray(rooms.size)

        this.dfs(rooms, history, 0)

        for(i in 0 .. history.size - 1) {
            if(!history[i]) return false
        }
        return true
    }

    fun dfs(rooms: List<List<Int>>, history: BooleanArray, key: Int) {
        history[key] = true
        for(i in 0 .. rooms[key].size - 1) {
            if(!history[rooms[key][i]]) this.dfs(rooms, history, rooms[key][i])
        }
    }
}