class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int lIdx = 0;
        int rIdx = numbers.length - 1;

        while(lIdx != rIdx) {

            int sum = numbers[lIdx] + numbers[rIdx];

            // System.out.println(lIdx + " + " + rIdx + " = " + sum);

            if (sum > target) {
                rIdx--;
            } else if (sum < target) {
                lIdx++;
            } else {
                ans[0] = lIdx + 1;
                ans[1] = rIdx + 1;
                break;
            }
            
        }

        return ans;
    }
}