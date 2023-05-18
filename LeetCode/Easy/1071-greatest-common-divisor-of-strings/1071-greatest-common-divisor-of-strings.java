class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";

        int len1 = str1.length();
        int len2 = str2.length();

        while(len2 != 0) {
            int temp = len1 % len2;
            len1 = len2;
            len2 = temp;
        }

        return str1.substring(0, len1);
    }


    public String gcdOfStrings2(String str1, String str2) {

        String bigStr;
        String smallStr;

        int max = 0;
        int min = 0;

        if(str1.length() > str2.length()) {
            bigStr = str1;
            smallStr = str2;
            max = str1.length();
            min = str2.length();
        } else {
            smallStr = str1;
            bigStr = str2;
            max = str2.length();
            min = str1.length();
        }

        if(min % 2 == 0) {
            while(true) {
                if(!smallStr.substring(0, smallStr.length() / 2).equals(smallStr.substring(smallStr.length() / 2))) {
                    break;
                }
                smallStr = smallStr.substring(0, smallStr.length() / 2);
            }
            min = smallStr.length();
        }
        
        if(max % min != 0) return "";
        for(int i = 0; i < max;) {

            for(int j = 0; j < min;) {
                if(bigStr.charAt(i++) != smallStr.charAt(j++)) return "";
            }
        }

        return smallStr;
    }
}