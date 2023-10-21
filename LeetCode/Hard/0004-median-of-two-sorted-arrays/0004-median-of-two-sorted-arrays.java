class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int len = m + n;
        int leftCount = (len+1) / 2;
        int left = 0;
        int right = m;

        while(left <= right) {

            int mid1 = (left + right) / 2;
            int mid2 = leftCount - mid1;

            int left1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right1 = mid1 < m ? nums1[mid1] : Integer.MAX_VALUE;
            int right2 = mid2 < n ? nums2[mid2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                return len % 2 == 0 ?
                    ((double)(left1 >= left2 ? left1 : left2) + (right1 >= right2 ? right2 : right1)) / 2.0:
                    left1 > left2 ? left1 : left2;
            }
            else if (left1 > right2) {
                right = mid1 - 1;
            }
            else {
                left = mid1 + 1;
            }
        }







        return 0;
    }
}
// 3, 5
// 1, 4, 6, 7, 8
// n1 = 2, n2 = 5
// 시작
// n = 7, left = 4, low = 0, high = 2

// 1회
// mid1 = 1
// mid2 = 3

// l1 = 3, r1 = 5
// l2 = 4, r2 = 6

// low = 2


