class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                // 이미 발견된 값이므로 거리를 비교
                int preIdx = map.get(nums[i]);

                if (i - preIdx <= k) return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}