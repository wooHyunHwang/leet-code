class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; ++i) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }

            }
        }

        return ans;

    }

    // Fail Solution
    public List<List<Integer>> threeSum2(int[] nums) {

        Set<String> history = new HashSet<>();

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;
        boolean recover = false;

        while(left != right - 1) {

            if (nums[left] > 0) break;
            if (nums[right] < 0) break;

            int sum = nums[left] + nums[right];

            System.out.print("left : " + left + " / right : " + right);
            System.out.println(" ### leftVal : " + nums[left] + " / rightVal : " + nums[right] + " ### sum : " + sum);

            if (sum >= 0) {
                for (int i = right - 1; i > left; --i) {
                    System.out.println(i);
                    int last = sum + nums[i];
                    if (last < 0) break;
                    if (last == 0) {
                        System.out.println("찾음 : " + nums[i]);
                        String key = "" + nums[left] + nums[i] + nums[right];
                        if (history.contains(key)) break;
                        
                        List<Integer> data = new ArrayList<>();
                        data.add(nums[left]);
                        data.add(nums[i]);
                        data.add(nums[right]);
                        ans.add(data);

                        history.add(key);
                        break;
                    }
                }

                if (recover) {
                    left++;
                    right++;
                    recover = false;
                } else {
                    right--;
                    if (sum == 0) recover = true;
                }

            } else {
                for (int i = left + 1; i < right; ++i) {
                    System.out.println(i);
                    int last = sum + nums[i];
                    if (last > 0) break;
                    if (last == 0) {
                        System.out.println("찾음 : " + nums[i]);
                        String key = "" + nums[left] + nums[i] + nums[right];
                        if (history.contains(key)) break;
                        
                        List<Integer> data = new ArrayList<>();
                        data.add(nums[left]);
                        data.add(nums[i]);
                        data.add(nums[right]);
                        ans.add(data);

                        history.add(key);
                        break;
                    }
                }

                if (recover) {
                    left++;
                    right++;
                    recover = false;
                } else {
                    left++;
                }
            }

            
        }

        return ans;
    }
}// -4 -1 -1 0 1 2