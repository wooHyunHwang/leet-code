/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        return binarySolution(0, n);
    }

    private int binarySolution(long start, long end) {

        int center = (int)((end + start) / 2);

        // System.out.println(start + " / " + end);

        if (isBadVersion(center)) {
            return binarySolution(start, center);
        } else {
            if (isBadVersion(center + 1)) {
                return center + 1;
            } else {
                return binarySolution(center, end);
            }
        }
    }
}