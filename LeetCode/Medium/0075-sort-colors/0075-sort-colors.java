class Solution {
    public void sortColors(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] nums, int left, int right) {

        if (left >= right) return;

        int part = partition(nums, left, right);

        this.quickSort(nums, left, part - 1);
        this.quickSort(nums, part + 1, right);

    }

    int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;

        while(i < j) {
            while(pivot < nums[j]) j--;
            while(i < j && pivot >= nums[i]) i++;

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;

        }

        nums[left] = nums[i];
        nums[i] = pivot;
        return i;
    }


}