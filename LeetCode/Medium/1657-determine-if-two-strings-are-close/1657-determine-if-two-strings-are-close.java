class Solution {
    public boolean closeStrings(String word1, String word2) {

        int[] left = new int[26];
        int[] right = new int[26];

        for(char c : word1.toCharArray()) left[c - 'a']++;
        for(char c : word2.toCharArray()) right[c - 'a']++;

        for(int i = 25;  i >= 0; --i) {

            if(left[i] == 0 && right[i] != 0) return false;
            if(left[i] != 0 && right[i] == 0) return false;
        }

        Arrays.sort(left);
        Arrays.sort(right);

        for(int i = 25;  i >= 0; --i) {

            //System.out.println(left[i]);
            if(left[i] != right[i]) return false;
            if(left[i] == 0) return true;
        }
        return true;
    }
}