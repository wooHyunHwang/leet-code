class Solution {
    public String decodeMessage(String key, String message) {

        char[] ciper = new char[123];
        char val = 'a';

        ciper[' '] = ' ';
        for (char c : key.toCharArray()) {
            if (c > 96 && ciper[c] == 0) {
                ciper[c] = val++;
            }
        }
        
        char[] messageAry = message.toCharArray();
        for (int i = 0; i < messageAry.length; ++i) {
            messageAry[i] = ciper[messageAry[i]];
        }
        return new String(messageAry);
    }
}