class Solution {
    public boolean judgeCircle(String moves) {
        int[] ans=new int[128];
        for(char c:moves.toCharArray()){
            ans[c]++;
        }
        return ans['U']==ans['D']&&ans['R']==ans['L'];
    }
}