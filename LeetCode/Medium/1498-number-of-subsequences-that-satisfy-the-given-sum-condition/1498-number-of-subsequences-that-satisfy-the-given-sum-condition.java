class Solution {
    public int numSubseq(int[] nums, int target) {

        int ans = 0;
        int M = 1_000_000_007;

        Arrays.sort(nums);

        // printArray(nums);

        int[] pow = new int[nums.length + 1];
        pow[0] = 1;
        for (int i = 1; i <= nums.length; ++i) {
            pow[i] = (pow[i - 1] << 1) % M;
        }

        // 1. 0번값을 이용해서 나올수 있는 최대 idx를 구함
        int minIdx = 0;
        int maxIdx = nums.length - 1;

        while(minIdx <= maxIdx) {
            int sum = nums[minIdx] + nums[maxIdx];
            if(sum > target) {
                maxIdx--;
            } else {
                ans = (ans + pow[maxIdx - minIdx]) % M;
                minIdx++;
            }
        }


        return ans;
        /*
        // 1. 0번값을 이용해서 나올수 있는 최대 idx를 구함
        int minIdx = 0;
        int maxIdx = nums.length / 2;
        // 1.1 방향, 큰경우 true / - 방향으로, 작은경우 false / + 방향
        boolean upDown = nums[0] + nums[maxIdx] > target;

        while(true) {
            if(upDown) {
                // 빼기 방향
                if(maxIdx == 0) break;
                if(nums[0] + nums[maxIdx - 1] > target) {
                    maxIdx--;
                } else {
                    maxIdx--;
                    break;
                }
            } else {
                // 더하기 방향
                if(maxIdx == nums.length - 1) break;
                if(nums[0] + nums[maxIdx + 1] <= target) {
                    maxIdx++;
                } else {
                    break;
                }
            }
        }

        // System.out.println("MAX IDX : " + maxIdx);
        
        // 경우의 수
        for(int i = 0; i <= maxIdx; ++i) {
            // 좌표 i의 최대 index
            int curMaxIdx = i;
            if(nums[i] + nums[curMaxIdx] > target) break;
            
            for(; curMaxIdx <= maxIdx; ++curMaxIdx) {
                int sum = nums[i] + nums[curMaxIdx];
                // System.out.println("cur : " + curMaxIdx + " / sum : " + sum);
                if(sum > target) {
                    // System.out.println("큰거 발견 후퇴");
                    curMaxIdx--;
                    break;
                } else if (curMaxIdx == maxIdx) {
                    // System.out.println("같은거 발견 브뤡");
                    break;
                }
            }
            // System.out.println(i + " ] 시작 / " + curMaxIdx + "] 끝 / " + Math.pow(2, curMaxIdx - i) + "] 결과");
            ans = (ans + pow[curMaxIdx - i]) % M;
        }

        if (ans > M) return (int)(ans % M);
        return (int)ans;
        */
    }

    private void printArray(int[] nums) {
        for(int i = 1; i <= nums.length; ++i) {
            System.out.print(nums[i-1] + ",");
            if(i % 5 == 0) System.out.println("     ======= " + (i - 1));
            // 1,2,3,3,4,4,4,5,5,6,7,9,9,9,10,10,10,11,11,11,12,12,12,12,13,15,16,16,16,16,17,17,17,17,19,19,20,20,21,21,21,21,22,22,22,23,23,23,24,24,24,24,24,25,25,26,26,26,27,27,27,29,30
        }
        System.out.println();
    }
}
































