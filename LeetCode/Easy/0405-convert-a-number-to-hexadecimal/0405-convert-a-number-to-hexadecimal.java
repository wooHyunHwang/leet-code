class Solution {
    public String toHex(int num) {

        if (num == 0) return "0";

        // int max hex : 7fffffff
        // > 8자리로 초기화
        char[] ans = new char[8];

        // 0으로 초기화
        for(int i = 0; i < ans.length; ++i) {
            ans[i] = '0';
        }

        long bigInt = num;
        boolean twoComplement = false;
        if (num < 0) {
            twoComplement = true;
            bigInt *= -1;
        }

        int repeat = 1;
        int repeatIdx = 0;
        String ansStr;

        while(bigInt > 15) {

            if (bigInt / repeat >= 16) {
                repeat *= 16;
                repeatIdx++;
            } else {
                // N번째 16
                ans[ans.length - 1 - repeatIdx] = changeHexa(bigInt / repeat);
                // 나머지로 초기화
                bigInt %= repeat;
                // 값 초기화
                repeat = 1;
                repeatIdx = 0;
            }
        }
        ans[ans.length - 1] = changeHexa(bigInt / repeat);

        if (twoComplement) {
            ans = changeTwoComplement(ans);
        }

        StringBuilder sb = new StringBuilder();

        boolean find = false;
        for (int i = 0; i < ans.length; ++i) {
            if (find || ans[i] != '0') {
                sb.append(ans[i]);
                find = true;
            }
        }

        return sb.toString();
    }

    // 16진수 -> 2진수 -> 1의 보수 -> 2의 보수
    private char[] changeTwoComplement(char[] ans) {
        // 2진수
        int[] temp = new int[ans.length * 4];
        for (int i = 0; i < ans.length; ++i) {
            int integer = 0;
            if (ans[i] <= '9') {
                integer = (int)(ans[i] - '0');
            } else if (ans[i] <= 'f') {
                integer = (int)(ans[i] - 'a') + 10;
            }

            // System.out.println(ans[i] + " / " + integer);
            

            int repeat = 1;
            int repeatIdx = 0;

            while(integer > 1) {

                if (integer / repeat >= 2) {
                    repeat *= 2;
                    repeatIdx++;
                } else {
                    // N번째 2
                    temp[i * 4 + (3 - repeatIdx)] = integer / repeat;
                    // 나머지로 초기화
                    integer %= repeat;
                    // 값 초기화
                    repeat = 1;
                    repeatIdx = 0;
                }
            }
            temp[i * 4 + 3] = integer / repeat;
        }

        // 2진수 출력
        // for (int i = temp.length - 1; i >= 0; --i) {
        //     System.out.print(temp[i]);
        // }
        // System.out.println();

        // 2의 보수용 boolean
        boolean plus = true;
        for (int i = temp.length - 1; i >= 0; --i) {
            // 1의 보수
            temp[i] = switchingDigit(temp[i]);

            if (plus) {
                temp[i]++;
                if (temp[i] > 1) {
                    temp[i] = 0;
                    plus = true;
                } else {
                    plus = false;
                }
            }
            
            // System.out.print(temp[i]);
        }
        // System.out.println();

        // 16 진수 다시 변환
        for (int i = 0; i < ans.length; ++i) {
            int index = temp.length - 1 - i * 4;
            int sum = temp[index] + temp[index - 1] * 2 + temp[index - 2] * 4 + temp[index - 3] * 8;

            ans[ans.length - 1 - i] = changeHexa(sum);
        }

        return ans;
    }

    private char changeHexa(long v) {
        if (v >= 10) {
            return (char)((v-10) + 'a');
        } else {
            return (char)(v + '0');
        }
    }

    private int switchingDigit(int v) {
        if (v == 1) return 0;
        return 1;
    }

}