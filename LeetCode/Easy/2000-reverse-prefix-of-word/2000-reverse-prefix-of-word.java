class Solution {
    public String reversePrefix(String word, char ch) {
        
        StringBuilder sb = new StringBuilder();
        boolean reverse = false;
        
        for (char c : word.toCharArray()) {

            sb.append(c);

            if (!reverse && c == ch) {
                reverse = true;
                sb.reverse();
            }
        }

        return sb.toString();
    }
}