class Solution {
    public boolean isPalindrome(int x) {
        
        StringBuffer sb = new StringBuffer(x + "");

        String 일일 = sb.toString();
        String 이이 = sb.reverse().toString();

        return 일일.equals(이이);
    }
}