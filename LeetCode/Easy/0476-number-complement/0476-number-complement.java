class Solution {
    public int findComplement(int num) {

        char[] c = new char[32];

        // 2진수 최대
        int div = 1073741824;
        int i = 0;
        int idx = 0;

        for (; i < 32; ++i) {
            if (div <= num) break;
            div /= 2;
        }

        for (; i < 31; ++i) {
            // System.out.println(num + " === " + div);
            if (div <= num) {
                num -= div;
                c[idx] = '0';
            }
            else c[idx] = '1';
            // System.out.println("c > " + c[idx]);

            div /= 2;
            
            idx++;
        }

        // System.out.println("=====\n=====\n=====");

        int ans = 0;
        div = 1;
        for (int j = idx - 1; j >= 0; --j) {
            // System.out.println(c[j] + "  -  " + div);
            if (c[j] == '1') {
                ans += div;
                // System.out.println(" !!! " + ans);
            }
            div *= 2;
        }

        return ans;
    }
}
