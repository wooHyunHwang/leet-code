class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        int i1 = 0;
        int i2 = 0;

        if (nums1[nums1.length-1] < nums2[0] || nums2[nums2.length-1] < nums1[0]) {
            return -1;
        }

        while(i1 < nums1.length && i2 < nums2.length) {

            if (nums1[i1] == nums2[i2]) {
                return nums1[i1];
            }
            else if (nums1[i1] > nums2[i2]) {
                i2++;
            }
            else {
                i1++;
            }
        }


        return -1;
    }
}