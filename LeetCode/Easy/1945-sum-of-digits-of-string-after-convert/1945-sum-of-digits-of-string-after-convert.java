class Solution {
    public int getLucky(String s, int k) {

        int ans = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            sb.append((int)(c - '`'));
        }

        // System.out.println(sb.toString());

        char[] charArray = new char[sb.length()];
        sb.getChars(0, sb.length(), charArray, 0);

        for (char c : charArray) {
            ans += (int)(c - '0');
        }
        k--;

        for (; k > 0; --k) {
            // System.out.println(ans);
            int temp = ans;
            int sum = 0;
            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            ans = sum;
        }

        return ans;
    }
}
// 1
// 13
// 113
