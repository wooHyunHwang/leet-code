class Solution {
    public int findLHS(int[] nums) {

        Arrays.sort(nums);
        
        int ans = 0;
        int x = nums[0];
        int xCnt = 0;
        int yCnt = 1;

        for(int i = 1; i < nums.length; ++i) {

            if(nums[i] != nums[i - 1]) {
                x = nums[i - 1];
                xCnt = yCnt;
                yCnt = 0;
            }

            yCnt++;

            if(nums[i] - 1 == x) {
                xCnt++;
                ans = Math.max(ans, xCnt);
            }
        }
        return ans;
    }

    public int findLHS2(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> temp = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int n : nums) {
            temp.put(
                n,
                temp.getOrDefault(n, 0) + 1
            );
            priorityQueue.add(n);
        }

        while (!priorityQueue.isEmpty()) {
            Integer firstKey = priorityQueue.poll();
            Integer nextKey = priorityQueue.peek();

            if (nextKey == null) break;
            if(nextKey - firstKey != 1) continue;

            ans = Math.max(
                ans,
                temp.get(firstKey) + temp.get(nextKey)
            );
            
        }

        return ans;
    }
}