class Solution {
    public int[] plusOne(int[] digits) {

        if (digits.length == 0) return digits;
        
        boolean checked = false;
        int no = digits.length - 1;

        while(no >= 0) {
            
            if (digits[no] == 9) {
                digits[no] = 0;
                no--;
            } else {
                digits[no]++;
                checked = true;
                break;
            }

        }

        if (!checked) {
            // 첫번째까지 9인 경우
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for(int i = 0; i < digits.length; ++i) {
                ans[i + 1] = digits[i];
            }
            return ans;
        } else {
            return digits;
        }
    }
}