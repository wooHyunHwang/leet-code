class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> zxc = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            if(zxc.containsKey(target - nums[i])) {
                result[0] = zxc.get(target - nums[i]);
                result[1] = i;
                return result;
            } 
            zxc.put(nums[i], i);
        }
        return result;
    }
}