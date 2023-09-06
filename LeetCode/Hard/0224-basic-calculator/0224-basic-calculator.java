class Solution {
    public int calculate(String s) {
        int calc = 0;

        int i = 0;
        boolean sign = true; // true: +, false: -
        int stack = 0;
        boolean meetBracket = false;
        int meetBracketOpenIdx = 0;
        int meetBracketOpenCnt = 0;

        while(i < s.length()) {
            char c = s.charAt(i);

            if (meetBracket) {
                switch(c) {
                    case '(': {
                        meetBracketOpenCnt++;
                        break;
                    }
                    case ')': {
                        meetBracketOpenCnt--;
                        if (meetBracketOpenCnt == 0) {
                            meetBracket = false;
                            int bracketCalc = this.calculate(s.substring(meetBracketOpenIdx+1, i));
                            if (sign) {
                                calc += bracketCalc;
                            } else {
                                calc -= bracketCalc;
                            }
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } else {
                switch(c) {
                    case '+': sign = true; break;
                    case '-': sign = false; break;
                    case '(': {
                        meetBracket = true;
                        meetBracketOpenIdx = i;
                        meetBracketOpenCnt++;
                        break;
                    }
                    case ' ': break;
                    default: {
                        // 숫자인 경우
                        stack = (stack * 10) + (int)(c - '0');
                        break;
                    }
                }
                if(stack != 0 &&
                    (i == s.length() - 1 || '0' > s.charAt(i + 1) || '9' < s.charAt(i + 1))) {
                    if(sign) {
                        calc += stack;
                    } else {
                        calc -= stack;
                    }
                    stack = 0;
                }
            }
            i++;
        }

        //System.out.println(calc);

        return calc;
    }
}