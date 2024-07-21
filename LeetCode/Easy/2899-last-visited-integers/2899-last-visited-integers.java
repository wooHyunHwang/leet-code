class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        int kConsecutive = 0;
        LinkedList<Integer> seen = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int n : nums) {
            if (n != -1) {
                kConsecutive = 0;
                seen.addFirst(n);
            }
            else {
                if (kConsecutive < seen.size()) {
                    ans.add(seen.get(kConsecutive));
                }
                else {
                    ans.add(-1);
                }
                kConsecutive++;
            }
        }

        return ans;
    }
}