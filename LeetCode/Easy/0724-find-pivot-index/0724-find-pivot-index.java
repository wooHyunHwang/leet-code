class Solution {
    public int pivotIndex(int[] nums) {
        int TOTAL = 0;
        int leftSum = 0;

        for(int i = 0; i < nums.length; ++i) {
            TOTAL += nums[i];
        }


        for(int i = 0; i < nums.length; ++i) {
            if(i != 0) {
                leftSum += nums[i - 1];
            }

            if(TOTAL - leftSum - nums[i] == leftSum) {
                return i;
            }
        }
        return -1;

    }


    // 낭비 심함
    public int pivotIndex3(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for(int i = 1; i < nums.length; ++i) {
            int rIdx = nums.length - 1 - i;
            left[i] = left[i - 1] + nums[i - 1];
            right[rIdx] = right[rIdx + 1] + nums[rIdx + 1];
        }

        for(int i = 0; i < nums.length; ++i) {
            if(left[i] == right[i]) return i;
        }

        return -1;
    }

    // 틀린 방식
    public int pivotIndex2(int[] nums) {

        // Left Sum
        Map<Integer, Integer> leftSumIdx = new HashMap<>();
        int left = 0;
        int right = 0;

        for(int i = 0; i < nums.length; ++i) {
            left += nums[i];
            if(!leftSumIdx.containsKey(left)) leftSumIdx.put(left, i);
        }

        int findIdx = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; ++i) {
            int rIdx = nums.length - i - 1;
            right += nums[rIdx];
            // System.out.println(rIdx);
            if (right == 0) return 0;
            if(leftSumIdx.containsKey(right)) {
                if (leftSumIdx.get(right) + 1 < rIdx) {
                    // System.out.println("찾음");
                    findIdx = Math.min(findIdx, leftSumIdx.get(right) + 1);
                }

            }

        }

        if(findIdx != Integer.MAX_VALUE) return findIdx;
        else return -1;
    }
}