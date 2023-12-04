class Solution {
    public String largestGoodInteger(String num) {

        char[] ca = num.toCharArray();

        char find = ca[0];
        int findCount = 1;

        char three = '0' - 1;

        for (int i = 1; i < ca.length; ++i) {

            if (find == ca[i] && three < ca[i]) {

                findCount++;
                if (findCount == 3) {
                    three = ca[i];
                }

            } else {

                find = ca[i];
                findCount = 1;

            }
        }

        return three == '0' - 1 ? "" : Character.toString(three).repeat(3);

    }
}