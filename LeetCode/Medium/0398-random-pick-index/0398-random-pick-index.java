class Solution {
    private Random random = new Random();
    int[] nums = null;
    int length = 0;
    public Solution(int[] nums) {
        this.nums = nums;
        this.length = this.nums.length;
    }
    
    public int pick(int target) {
        int pick = -1;
        while (pick == -1) {
            int rnd = random.nextInt(length);
            if (nums[rnd] == target) pick = rnd;
        }
        return pick;
    }
    /*
    Map<Integer, Queue<Integer>> map = new HashMap<>();
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            Queue<Integer> q = map.getOrDefault(nums[i], new LinkedList<>());
            q.add(i);
            map.put(nums[i], q);
        }
    }
    
    public int pick(int target) {
        int poll = map.get(target).poll();
        map.get(target).add(poll);
        return poll;
    }
    */
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */