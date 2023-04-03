class Solution {
    public String addStrings(String num1, String num2) {

        boolean over = false;

        StringBuilder ans = new StringBuilder();

        char[] longChar;
        char[] shortChar;
        if(num1.length() > num2.length()) {
            longChar = num1.toCharArray();
            shortChar = num2.toCharArray();
        } else {
            longChar = num2.toCharArray();
            shortChar = num1.toCharArray();
        }

        int longIdx = longChar.length - 1;
        int shortIdx = shortChar.length - 1;

        while(longIdx >= 0) {

            char temp1 = longChar[longIdx];
            
            if(shortIdx >= 0) {
                char temp2 = shortChar[shortIdx];
                char sum = (char)(temp1 + temp2 - '0');

                if(over) sum = (char)((int)sum + 1);
                over = false;

                if(sum > '9') {
                    over = true;
                    sum = (char)((int)sum - 10);
                }

                ans.insert(0, sum);
            } else {

                if(over) temp1 = (char)((int)temp1 + 1);
                over = false;
                
                if(temp1 > '9') {
                    over = true;
                    temp1 = (char)((int)temp1 - 10);
                }

                ans.insert(0, temp1);
            }

            longIdx--;
            shortIdx--;
        }

        if(over) ans.insert(0, '1');

        return ans.toString();
    }
}