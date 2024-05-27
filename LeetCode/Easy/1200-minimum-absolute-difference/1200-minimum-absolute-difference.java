class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = null;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; ++i) {
            int calc = arr[i] - arr[i-1];
            if (calc < min) {
                // 더 작은거 발견, 리스트 초기화
                ans = new ArrayList<>();
                this.addList(ans, arr[i-1], arr[i]);
                min = calc;
            }
            else if (calc == min) {
                this.addList(ans, arr[i-1], arr[i]);
            }
        }

        return ans;
 
    }

    private void addList(List<List<Integer>> ans, int l, int r) {
        List<Integer> element = new ArrayList<>();
        element.add(l);
        element.add(r);
        ans.add(element);
    }
}