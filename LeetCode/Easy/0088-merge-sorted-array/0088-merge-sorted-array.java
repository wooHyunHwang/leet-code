class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int lastSeq = nums1.length - 1;

        m--;
        n--;

        for(int i = 0; i < nums1.length; ++i) {
            // System.out.println("============== " + lastSeq);
            // System.out.println("m : " + m + " / n : " + n);
            

            if(m >= 0 && n >= 0) {
                // System.out.println("m : " + nums1[m] + " / n : " + nums2[n]);
                if (nums1[m] >= nums2[n]) {
                    // System.out.println("m pop : " + nums1[m]);
                    nums1[lastSeq] = nums1[m];
                    m--;
                } else {
                    // System.out.println("n pop : " + nums2[n]);
                    nums1[lastSeq] = nums2[n];
                    n--;
                }
            } else {
                if (m >= 0) {
                    // System.out.println("m pop : " + nums1[m]);
                    nums1[lastSeq] = nums1[m];
                    m--;
                } else if (n >= 0) {
                    // System.out.println("n pop : " + nums2[n]);
                    nums1[lastSeq] = nums2[n];
                    n--;
                }
            }


            

            lastSeq--;
        }
        
    }
}