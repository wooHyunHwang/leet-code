class Solution {
    public int numDecodings(String s) {

        int last = s.length() - 1;
        int[] calc = new int[s.length() + 1];
        calc[s.length()] = 1;

        for (int i = last; i >= 0; --i) {

            if (s.charAt(i) == '0') {
                calc[i] = 0;
            }
            else {
                if (i < last && (s.charAt(i) - 48) * 10 + (s.charAt(i+1) - 48) <= 26) {
                    calc[i] = calc[i+1] + calc[i+2];
                } else {
                    calc[i] = calc[i+1];
                }
            }

        }

        return calc[0];
    }
    public int numDecodings2(String s) {

        if (s.startsWith("0")) return 0;

        int[] calc = new int[s.length()];

        calc[0] = 1;

        if (1 < s.length()) {
            int tens = (s.charAt(0) - 48) * 10 + (s.charAt(1) - 48);
            if (10 < tens && tens <= 26) calc[1] = 2;
            else calc[1] = 1;
        }

        for (int i = 2; i < s.length(); ++i) {
            int tens = (s.charAt(i-1) - 48) * 10 + (s.charAt(i) - 48);
            if (10 < tens && tens <= 26) {
                calc[i] = calc[i-1] + calc[i-2];
            } else if (10 == tens) {
                calc[i] = calc[i-1] - 1;
            } else {
                calc[i] = calc[i-1];
            }

        }

        for (int c : calc) {
            System.out.print(c + " - ");
        }
        
        return calc[s.length()-1];
    }
}