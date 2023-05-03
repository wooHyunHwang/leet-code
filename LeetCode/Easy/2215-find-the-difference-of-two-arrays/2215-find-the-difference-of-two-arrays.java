class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ansLeft = new ArrayList<>();
        List<Integer> ansRight = new ArrayList<>();

        boolean[] dicLeft = new boolean[2001];
        boolean[] dicRight = new boolean[2001];

        // 1. Left 채움
        for(int i : nums1) {
            dicLeft[i + 1000] = true;
        }

        // 2. Right 체크와 동시에 dicRight 채움
        for(int i : nums2) {
            dicRight[i + 1000] = true;
            if(!dicLeft[i + 1000]) {
                dicLeft[i + 1000] = true;
                ansRight.add(i);
            }
        }

        // 3. Left 체크
        for(int i : nums1) {
            if(!dicRight[i + 1000]) {
                dicRight[i + 1000] = true;
                ansLeft.add(i);
            }
        }

        ans.add(ansLeft);
        ans.add(ansRight);

        return ans;
    }

    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ansLeft = new ArrayList<>();
        List<Integer> ansRight = new ArrayList<>();

        Set<Integer> dicLeft = new HashSet<>();
        Set<Integer> dicRight = new HashSet<>();

        // 1. Left 채움
        for(int i : nums1) {
            dicLeft.add(i);
        }

        // 2. Right 체크와 동시에 dicRight 채움
        for(int i : nums2) {
            dicRight.add(i);
            if(!dicLeft.contains(i)) {
                dicLeft.add(i);
                ansRight.add(i);
            }
        }

        // 3. Left 체크
        for(int i : nums1) {
            if(!dicRight.contains(i)) {
                dicRight.add(i);
                ansLeft.add(i);
            }
        }

        ans.add(ansLeft);
        ans.add(ansRight);

        return ans;
    }
}