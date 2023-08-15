class Solution {
    public int trap(int[] height) {

        if(height.length <= 1) return 0;

        int sum = 0;

        int preApex = height[0];
        int preApexIdx = 0;

        // 최고점 탐색
        for (int i = 1; i < height.length; ++i) {

            int preDiv = height[i] - height[i - 1];
            int sufDiv = i == height.length - 1 ? -1 : height[i + 1] - height[i];

            if (preDiv > 0 && sufDiv <= 0) {
                // 이번 i는 꼭지점
                if (height[i] >= preApex) {
                    // 제일 높은 꼭지점을 만남
                    // System.out.println("높 : " + i);

                    // TOP을 preApex 로 잡고 preApex 에서 i까지의 너비를 계산
                    for (int j = preApexIdx + 1; j < i; ++j) {
                        sum += Math.max(0, preApex - height[j]);
                    }

                    // System.out.println("넓 : " + sum);

                    // 제일 높은 꼭지점을 기록
                    preApex = height[i];
                    preApexIdx = i;
                }
            }
        }

        // 이후 변동 처리
        if (preApexIdx != height.length - 1) {
            int newPreApex = height[height.length - 1];
            int newPreApexIdx = height.length - 1;

            // 하양식으로 남아있는 너비가 존재
            // System.out.println("남은거 정리, " + newPreApexIdx + "부터 " + preApexIdx + " 까지");
            for(int i = newPreApexIdx; i >= preApexIdx; --i) {
                // System.out.println(i);
                int preDiv = i == 0 ? 1 : height[i] - height[i - 1];
                int sufDiv = i == height.length - 1 ? -1 : height[i + 1] - height[i];

                if (preDiv >= 0 && sufDiv < 0) {
                    // 꼭지점을 만남
                    if (height[i] >= newPreApex) {
                        // 제일 높은 꼭지점을 만남
                        // System.out.println("높 : " + i);

                        // TOP을 preApex 로 잡고 preApex 에서 i까지의 너비를 계산
                        for (int j = newPreApexIdx - 1; j >= i; --j) {
                            sum += Math.max(0, newPreApex - height[j]);
                        }

                        // System.out.println("넓 : " + sum);

                        // 제일 높은 꼭지점을 기록
                        newPreApex = height[i];
                        newPreApexIdx = i;
                    }
                }
            }

        }

        return sum;
    }
}
