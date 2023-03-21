class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return find(nums1, nums2);
        } else {
            return find(nums2, nums1);
        }

    }

    private int[] find(int[] longAry, int[] shortAry) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> find = new HashSet<>();

        for(int i = 0; i < longAry.length; ++i) {
            set.add(longAry[i]);
        }

        for(int i = 0; i < shortAry.length; ++i) {
            if (set.contains(shortAry[i])) {
                find.add(shortAry[i]);
            }
        }

        int i = 0;
        int[] ans = new int[find.size()];

        for(Integer key : find) {
            ans[i] = key;
            i++;
        }

        return ans;

    }

}