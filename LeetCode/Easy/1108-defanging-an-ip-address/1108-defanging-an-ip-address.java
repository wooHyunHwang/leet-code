class Solution {
    public String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder();
        char[] cA = address.toCharArray();

        for(char c : cA) {
            if (c == '.') sb.append('[').append(c).append(']');
            else sb.append(c);
        }

        return sb.toString();
    }
}