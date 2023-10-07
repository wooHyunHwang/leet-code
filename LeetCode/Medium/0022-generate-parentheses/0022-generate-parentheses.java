class Solution {

    private void dfs(List<String> ans, char[] sb, int max, int n, int left, int right) {
        // System.out.println(sb.toString());
        if (left + right == max) {
            ans.add(new String(sb));
        }
        if (left < n) {
            sb[left+right] = '(';
            this.dfs(ans, sb, max, n, left + 1, right);
        }
        if (right < left) {
            sb[left+right] = ')';
            this.dfs(ans, sb, max, n, left, right + 1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        this.dfs(ans, new char[n * 2], n * 2, n, 0, 0);
        
        return ans;
    }
}