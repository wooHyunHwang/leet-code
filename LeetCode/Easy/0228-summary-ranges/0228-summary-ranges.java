class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();

        if(nums.length == 0) return ans;

        int start = nums[0];
        int pre = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            // 이전 항목과 차이가 -1 (연속인지 확인)
            if (pre == nums[i] - 1) {
                // 연속이면 다음 회차로
            } else {
                // 연속이 아님, 범위를 기록, start 갱신
                ans = recordString(ans, start, pre);
                start = nums[i];
            }

            pre = nums[i];
        }

        // 마지막 항목 처리
        ans = recordString(ans, start, pre);

        return ans;
    }

    private List<String> recordString(List<String> ans, int start, int pre) {
        if (start == pre) {
            ans.add(start + "");
        } else {
            ans.add(String.format("%d->%d", start, pre));
        }
        return ans;
    }
}