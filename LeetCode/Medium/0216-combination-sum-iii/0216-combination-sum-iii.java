class Solution {
    List<List<Integer>> ans = null;
    int endIdx = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        int count = 0;
        int minSum = 0;
        endIdx = n > 9 ? 9 : n;
        for(int i = 1; i <= endIdx; ++i) {
            if (count < k) {
                minSum += i;
            } else {
                int end = minSum + i;
                if(end == n) {
                    endIdx = i;
                    break;
                } else if (end > n) {
                    break;
                }
            }
        }

        //System.out.println(endIdx);

        this.dfs(new ArrayList<>(), k, n, 1, 0, 1);

        return ans;
    }

    private void dfs(ArrayList<Integer> arr, int k, int n, int start, int sum, int depth) {

        //System.out.println(start + " / " + sum);

        if (arr.size() >= k) {
            //System.out.println("리턴 : " + arr.size() + " / " + sum);
            if (!arr.isEmpty() && sum == n) this.ans.add(arr);
            return;
        }

        if(k >= depth) {
            for(int i = start; i <= endIdx; ++i) {

                ArrayList<Integer> copy = (ArrayList<Integer>) arr.clone();

                copy.add(i);
                int currentSum = sum + i;

                if(currentSum > n) return;
                
                this.dfs(copy, k, n, i+1, currentSum, depth + 1);
            }
        }
    }
}