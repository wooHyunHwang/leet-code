class Solution {
    public String longestPalindrome(String s) {
        
        char[] c = s.toCharArray();

        int findLeft = 0;
        int findRight = 1;

        for(int i = 0; i < c.length - 1; ++i) {
            int left = i-1;
            int right = i+1;

            // 홀수
            while(left >= 0 && right < c.length && c[left] == c[right]) {

                //System.out.println(left + " - " + right);

                if (right - left + 1 > findRight - findLeft) {
                    findLeft = left;
                    findRight = right+1;
                }

                left--;
                right++;
            }

            left = i;
            right = i+1;

            // 짝수
            while(left >= 0 && right < c.length && c[left] == c[right]) {

                //System.out.println(left + " - " + right);

                if (right - left + 1 > findRight - findLeft) {
                    findLeft = left;
                    findRight = right+1;
                }

                left--;
                right++;
            }
        }

        return s.substring(findLeft, findRight);
    }
}
// 홀수 = 중간을 기준
// 짝수 = 같은 단어 반복