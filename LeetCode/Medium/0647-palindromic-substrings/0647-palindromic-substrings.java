class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = len;

        char[] cary = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        // 초기 홀수번째
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }
        // System.out.println(ans + " ==== ");

        // 초기 짝수번째
        for (int i = 0; i < len-1; ++i) {
            if (cary[i] == cary[i+1]) {
                dp[i][i+1] = true;
                ans++;
            }
        }
        // System.out.println(ans + " ==== ");

        int j = 2;
        while (j < len) {
            for (int i = 0; i < len-j; ++i) {
                // System.out.print(i + " // " + (j+i) + " !!! ");
                if (dp[i+1][j+i-1] && cary[i] == cary[j+i]) {
                    dp[i][j+i] = true;
                    ans++;
                }
            }
            // System.out.println();
            // System.out.println(ans + " ==== ");
            j++;
        }

        return ans;
    }

    // Brute Force
    public int countSubstrings2(String s) {
        int ans = 0;
        char[] cary = s.toCharArray();

        for (int i = 0; i < cary.length; ++i) {
            for (int j = i; j < cary.length; ++j) {

                int left = i;
                int right = j;

                boolean check = true;

                while(left <= right) {
                    if (cary[left++] != cary[right--])  {
                        check = false;
                        break;
                    }
                }
                if (check) ans++;
            }
        }

        return ans;
    }
}
// 6 a a b b a a
// 3 aa ab bb ba aa
// 0 aab abb bba baa
// 1 aabb abba bbaa
// 0 aabba abbaa
// 1 aabbaa


// 6 a a a a a a
// 5 aa aa aa aa aa
// 4 aaa aaa aaa aaa
// 3 aaaa aaaa aaaa
// 2 aaaaa aaaaa
// 1 aaaaaa

// a b c