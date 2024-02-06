class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        char[] no1 = num1.toCharArray();
        char[] no2 = num2.toCharArray();
        char[] string = new char[40_001];

        // System.out.println(string[0] == '\0');

        int cIdx = 40_000;
        for (int i = no1.length-1; i >= 0; --i) {
            int cur = cIdx--;
            for (int j = no2.length-1; j >= 0; --j) {

                this.addCharString(
                    string,
                    (int) (no1[i]-'0') * (int) (no2[j]-'0'),
                    cur--
                );

            }
            // System.out.println(new String(string).trim());
        }

        return new String(string).trim();
    }

    private void addCharString(char[] string, int multi, int curIndex) {

        // System.out.println("Multi > " + multi);

        string[curIndex] = (char)(multi % 10 + (string[curIndex] == '\0' ? '0' : (int) string[curIndex]));
        this.increaseCalc(string, curIndex);

        if (multi > 9) {
            string[curIndex - 1] = (char)(multi / 10 + (string[curIndex - 1] == '\0' ? '0' : (int) string[curIndex - 1]));
            if (string[curIndex - 1] > '9') {
                this.increaseCalc(string, curIndex - 1);
            }
        }
    }

    private void increaseCalc(char[] string, int index) {
        int temp = (int)(string[index] - '0');
        string[index] = (char)((temp % 10) + (int) '0');
        if (temp > 9) {
            string[index-1] = (char)(temp / 10 + (string[index-1] == '\0' ? '0' : (int)string[index-1]));
            if (string[index-1] > '9') {
                this.increaseCalc(string, index - 1);
            }
        }
    }



    public String multiply2(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        double result = this.stringToChar(num1) * this.stringToChar(num2);
        StringBuilder sb = new StringBuilder();

        while(result >= 1) {
            System.out.println(result);
            sb.append((int)(result % 10));
            result /= 10;
        }
        sb.reverse();
        return sb.toString();
    }

    private double stringToChar(String num) {
        double no = 0;
        for (char c : num.toCharArray()) {
            no = no * 10 + (int)(c - '0');
        }
        return no;
    }
}