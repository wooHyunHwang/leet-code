class NumArray {
    private int[] arr;
    // 누적합 문제
    private int[] sumArr;

    public NumArray(int[] nums) {
        this.arr = nums;
        sumArr = new int[this.arr.length + 1];
        sumArr[0] = 0;
        for (int i = 1; i < sumArr.length; ++i) {
            sumArr[i] = this.arr[i - 1] + sumArr[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left < 0) throw new ArrayIndexOutOfBoundsException(left);
        if (right > arr.length -1) throw new ArrayIndexOutOfBoundsException(right);

        return sumArr[right + 1] - sumArr[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */