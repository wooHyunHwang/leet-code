class Solution {
    public String removeStars(String s) {

        int idx = 0;
        char[] arr = s.toCharArray();
        
        for(char c : arr) {
            if(c == '*') idx = Math.max(idx - 1, 0);
            else arr[idx++] = c;
        }

        return new String(arr, 0, idx);
    }
}