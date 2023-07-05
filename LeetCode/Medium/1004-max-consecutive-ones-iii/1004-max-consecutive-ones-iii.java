class Solution {
    public int longestOnes(int[] nums, int k) {

        int max = 0;
        int startIdx = 0;
        Queue<Integer> queue = new LinkedList<>(); // 1이 설정된 Index

        if(k == 0) {
            int stack = nums[0];
            for(int i = 1; i < nums.length; ++i) {
                if(nums[i] == 1) {
                    if(nums[i - 1] == 1) {
                        stack++;
                    } else {
                        stack = 1;
                    }
                } else {
                    max = Math.max(max, stack);
                }
            }
            max = Math.max(max, stack);
            return max;
        }

        for(int i = 0; i < nums.length; ++i) {

            if(nums[i] == 0) {
                if(k == 0) {
                    // 0을 만났는데 1의 재고가 없으면 이번 회차 최대 길이
                    // 길이 기록하고,
                    max = Math.max(max, i - startIdx);
                    // 큐에서 맨 앞에꺼 뺄 수 있으면 뺌
                    if(queue.isEmpty()) startIdx = i;
                    else startIdx = queue.poll() + 1;
                } else {
                    k--;
                }
                queue.add(i);
            }
        }

        max = Math.max(max, nums.length - startIdx);

        return max;
    }
}