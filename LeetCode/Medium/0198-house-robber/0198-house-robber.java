class Solution {
    public int rob(int[] nums) {
        int sum = 0;
        int cache = 0;
        // 2,7,9,3,1
        for(int i = 0; i < nums.length; ++i) {
            int temp = sum > cache + nums[i] ? sum : cache + nums[i];
            cache = sum;
            sum = temp;
        }

        return sum;
    }

    // idiot solution
    public int idiotRob(int[] nums) {

        int len = nums.length;
        int lastIdx = len - 1;
        int i = 3;
        int sum = 0;

        switch(len) {
            case 0: return 0;
            case 1: return nums[0];
            case 2: return nums[0] > nums[1] ? nums[0] : nums[1];
            case 3: return nums[0] + nums[2] > nums[1] ? nums[0] + nums[2] : nums[1];
        }

        // 4개씩 꺼냄
        while(true) {
            System.out.print("비교 : " + i + " / " + sum);

            int case1 = nums[i - 3] + nums[i - 1];
            int case2 = nums[i - 2] + nums[i];
            int case3 = nums[i - 3] + nums[i];

            if (case1 > case2 && case1 > case3) {
                System.out.println("                - 1  += " + case1);
                sum += case1;
                i += 4;
            }
            else if (case2 > case1 && case2 > case3) {
                System.out.println("                - 2  += " + nums[i - 2]);
                sum += nums[i - 2];
                i += 3;
            }
            else {
                System.out.println("                - 3  += " + nums[i - 3]);
                sum += nums[i - 3];
                i += 2;
            }

            System.out.println("합 : " + sum);
            System.out.println("///////////////");

            // 끝에 닿았을 경우
            if (i > lastIdx) {
                System.out.println("i : " + i);
                System.out.println("lastIdx : " + lastIdx);

                if (i - 1 == lastIdx) {
                    // 3개 남음
                    if (nums[lastIdx] + nums[lastIdx - 2] > nums[lastIdx - 1])
                        sum += nums[lastIdx] + nums[lastIdx - 2];
                    else
                        sum +=  nums[lastIdx - 1];
                }
                else if (i - 2 == lastIdx) {
                    // 2개 남음
                    sum += nums[lastIdx] > nums[lastIdx - 1] ? nums[lastIdx] : nums[lastIdx - 1];
                }
                else if (i - 3 == lastIdx) {
                    // 1개 남음
                    sum += nums[lastIdx];
                }
                break;
            }

        }

        return sum;
    }
    // [2,7,9,3,1, , , ]
}