class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] lenIdx = new int[nums.length + 1];
        List<List<Integer>> ans = new ArrayList<>();

        for (int n : nums) {

            if (lenIdx[n] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(lenIdx[n]).add(n);

            lenIdx[n]++;
        }

        return ans;
    }
    public List<List<Integer>> findMatrix2(int[] nums) {
        List<Set<Integer>> history = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int n : nums) {
            int findIdx = -1;
            for (int i = 0; i < history.size(); ++i) {
                if (!history.get(i).contains(n)) {
                    findIdx = i;
                    break;
                }
            }

            Set<Integer> curHistory = null;
            List<Integer> curAns = null;

            if (findIdx == -1) {
                curHistory = new HashSet<>();
                curAns = new ArrayList<>();
            } else {
                curHistory = history.get(findIdx);
                curAns = ans.get(findIdx);
            }

            curHistory.add(n);
            curAns.add(n);

            if (findIdx == -1) {
                history.add(curHistory);
                ans.add(curAns);
            }
        }

        return ans;
    }
}