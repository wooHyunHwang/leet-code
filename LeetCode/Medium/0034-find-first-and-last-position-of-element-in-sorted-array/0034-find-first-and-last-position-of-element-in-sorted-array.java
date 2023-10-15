class Solution {
    int l = 0;
    int r = 0;
    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[2];

        l = 0;
        r = nums.length - 1;

        // System.out.println("===============");
        ans[0] = this.findLeft(nums, target);
        // System.out.println("===============");
        ans[1] = ans[0] == -1 ? -1 : this.findRight(nums, target);

        return ans;
    }

    private int findLeft(int[] nums, int target) {

        int l = this.l;
        int r = this.r;

        int result = -1;
        
        while(l <= r) {
            int mid = (l + r) / 2;

            // this.print(l, mid, r);

            if (nums[mid] == target) {
                // System.out.println("찾찾");
                result = result == -1 || result > mid ? mid : result;
                r--;
                continue;
            }
            else if (result != -1) {
                this.l = result;
                return result;
            }

            if (nums[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }

        return result;
    }

    private int findRight(int[] nums, int target) {

        int l = this.l;
        int r = this.r;

        int result = -1;
        
        while(l <= r) {
            int mid = (l + r) / 2;

            // this.print(l, mid, r);

            if (nums[mid] == target) {
                // System.out.println("찾찾");
                result = result < mid ? mid : result;
                l++;
                continue;
            }
            else if (result != -1) {
                return result;
            }

            if (nums[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }

        return result;
    }



    void print(int l, int m, int r) {
        
        System.out.print(l);
        System.out.print(" - ");
        System.out.print(m);
        System.out.print(" - ");
        System.out.println(r);
    }
}