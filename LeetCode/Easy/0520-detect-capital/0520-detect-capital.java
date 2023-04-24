class Solution {
    public boolean detectCapitalUse(String word) {

        char[] cAry = word.toCharArray();
        if(cAry.length <= 1) return true;

        // 첫번째 글자가 true 인 경우 대문자
        boolean first = 'A' <= cAry[0] && cAry[0] <= 'Z';
        // 두번째 글자가 true 인 경우 대문자
        boolean second = 'A' <= cAry[1] && cAry[1] <= 'Z';

        // 첫, 두 케이스
        if(!first && second) return false;

        // 두, 셋 케이스
        for(int i = 2; i < cAry.length; ++i) {
            boolean cur = 'A' <= cAry[i] && cAry[i] <= 'Z';
            if(second != cur) return false;
        }
        
        return true;
    }
}