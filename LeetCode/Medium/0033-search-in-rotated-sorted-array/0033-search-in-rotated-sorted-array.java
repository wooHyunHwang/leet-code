class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            // this.print(nums[left], nums[mid], nums[right]);

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
    // wrong answer
    public int search2(int[] nums, int target) {

        int search = 0;

        int left = 0;
        int right = nums.length - 1;
        int mid = nums.length / 2 - 1;

        if ((nums[left] < target && target < nums[right]) || 
            (nums[left] > target && target < nums[right])
        ) return -1;

        if (Math.abs(nums[left] - target) < Math.abs(nums[right] - target)) {
            System.out.println("좌탐");
            print(left, mid, right);
            // 좌측에서 탐색
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            }
            print(left, mid, right);
            System.out.println("===========");
            for (; left < nums.length; ++left) {
                print(left, mid, right);
                if (nums[left] == target) return left;
            }
        } else {
            System.out.println("우탐");
            print(left, mid, right);
            // 우측에서 탐색
            if (nums[mid] > target) {
                left = mid;
            } else if (nums[mid] < target) {
                right = mid;
            } else {
                return mid;
            }
            print(left, mid, right);
            System.out.println("===========");
            for (; right >= 0; --right) {
                print(left, mid, right);
                if (nums[right] == target) return right;
            }
        }
        

        return -1;
    }

    void print(int left, int mid, int right) {
        System.out.print(left);
        System.out.print(" / ");
        System.out.print(mid);
        System.out.print(" / ");
        System.out.println(right);
    }
}