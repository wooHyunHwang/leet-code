class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            //System.out.println("==== " + word);
            // char[] cAry = word.toCharArray();
            int l = 0;
            int r = word.length() - 1;
            if (r == 0) return word;
            while(l <= r) {
                //System.out.print(cAry[l] + " - " + cAry[r] + " / ");
                if (word.charAt(l++) != word.charAt(r--)) {
                    break;
                }
                //System.out.print("(" + l + "," + r + ")");
                if (l >= r) return word;
            }
            //System.out.println();
        }
        return "";
    }
    public String firstPalindrome2(String[] words) {
        for (String word : words) {
            //System.out.println("==== " + word);
            char[] cAry = word.toCharArray();
            int l = 0;
            int r = cAry.length - 1;
            if (r == 0) return word;
            while(l <= r) {
                //System.out.print(cAry[l] + " - " + cAry[r] + " / ");
                if (cAry[l++] != cAry[r--]) {
                    break;
                }
                //System.out.print("(" + l + "," + r + ")");
                if (l >= r) return word;
            }
            //System.out.println();
        }
        return "";
    }
}