class Solution {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for (int n : nums) count[n + 100]++;
        this.quickSort(nums, count, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int[] count, int left, int right) {
        if (left < right) {

            // 분할한 영역을 정렬, Pivot 위치 리턴
            int pivot = partition(nums, count, left, right);

            // q 기준으로 다시 Left/Right quickSort 진행
            quickSort(nums, count, left, pivot-1);
            quickSort(nums, count, pivot+1, right);

        }
    }

    private int partition(int[] nums, int[] count, int left, int right) {

        int low = left;
        int high = right+1;
        int value = nums[left];
        int pivot = count[nums[left]+100];

        // 이번 회차 좌,우에서 좁혀지면서 피벗값의 크기를 기준으로 정렬
        do {

            do { low++; }
            while (low <= right && (count[nums[low]+100] < pivot || (count[nums[low]+100] == pivot && nums[low] > value)) );
            do { high--; }
            while (high >= left && (count[nums[high]+100] > pivot) || (count[nums[high]+100] == pivot && nums[high] < value) );

            if (low < high) swap(nums, low, high);

        } while (low < high);

        swap(nums, left, high);

        return high;
    }

    /**
     * 배열 Swap
     * @param nums 배열
     * @param i i
     * @param j j
     */
    private void swap(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}