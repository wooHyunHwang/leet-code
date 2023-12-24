class Solution {
    public int minOperations(String s) {

        char[] c = s.toCharArray();
        int cnt = 0;
        char next = '0';

        for (int i = 0; i < c.length; ++i) {

            if (c[i] != next) cnt++;
            next = next == '0' ? '1' : '0';
        }

        return Math.min(cnt, c.length - cnt);

        // char a[]=s.toCharArray();
        // int cnt=0;
        // char next=a[0]=='0'?'1':'0';
        // for(int i=1;i<a.length;i++)
        // {
        //    if(a[i]!=next) cnt++;

        //    next=next=='0'?'1':'0';
        // }
        // return Math.min(cnt,a.length-cnt);
    }

    public int minOperations2(String s) {
        int odd = 0; // 홀
        int even = 0; // 짝

        // 홀수가 1인 경우와 짝수가 1인 경우

        for (int i = 0; i < s.length(); ++i) {

            int remain = i % 2;

            if (s.charAt(i) == '1') {
                if (remain == 1) { // 홀
                    even++;
                } else { // 짝
                    odd++;
                }
            } else {
                if (remain == 1) { // 홀
                    odd++;
                } else { // 짝
                    even++;
                }
            }
            
        }

        return odd > even ? even : odd;
    }
}