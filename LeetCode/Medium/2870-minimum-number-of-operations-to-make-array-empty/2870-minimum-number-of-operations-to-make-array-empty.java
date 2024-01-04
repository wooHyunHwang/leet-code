class Solution {
    public int minOperations(int[] nums) {

        Arrays.sort(nums);

        int ans = 0;

        for (int i = 0; i < nums.length; ++i) {

            int add = i;

            for (; add < nums.length && nums[i] == nums[add]; ++add) {

            }

            int calc = add - i;
            //System.out.println(i + " ~ " + add + " = " + calc);

            if (calc == 1) return -1;
            ans += calc / 3;
            if (calc % 3 > 0) ans++;
            i = add - 1;
        }

        return ans;
    }
    public int minOperations2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = 0;
        for( Integer n : map.keySet() ){
            int count = map.get(n);
            if (count == 1) return -1;

            ans += count / 3;
            if (count % 3 > 0) ans++;
        }
        return ans;
    }
    // 9 8 7 6
    // 3 2%2 2%1 2
}