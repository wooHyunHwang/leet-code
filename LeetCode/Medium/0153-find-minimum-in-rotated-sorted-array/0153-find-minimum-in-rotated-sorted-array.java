class Solution {
    public int findMin(int[] nums) {

        int standard = nums[0];
        int l = 0;
        int r = nums.length - 1;

        int find = -5001;
        // System.out.println("==============");
        while(l <= r) {
            int mid = (l + r) / 2;

            // this.print(l, mid, r);

            if (standard <= nums[mid]) {
                // 미드보다 우측으로
                l = mid + 1;
            } else {
                // System.out.println("찾");
                // 찾았지만 미드보다 좌측으로
                find = find == -5001 || find > nums[mid] ? nums[mid] : find;
                r = mid - 1;
            }

        }

        return find == -5001 ? standard : find;
    }

    void print(int l, int m, int r) {
        System.out.print(l);
        System.out.print(" - ");
        System.out.print(m);
        System.out.print(" - ");
        System.out.println(r);
    }
}