class Solution {
    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int max = n - 1;
        int[] ans = new int[n];
        
        if (k > 0) {
            int slow = 0;
            int fast = 0;
            int sum = 0;

            for(int i = 0; i < k; ++i) {
                fast = this.next(max, fast);
                sum += code[fast];
            }
            ans[0] = sum;

            for(int i = 1; i < code.length; ++i) {
                fast = this.next(max, fast);
                slow = this.next(max, slow);
                //System.out.println(code[slow] + "- // +" + code[fast]);
                sum = sum - code[slow] + code[fast];
                ans[i] = sum;
            }

        }
        else if (k < 0) {
            int slow = 0;
            int fast = 0;
            int sum = 0;

            for(int i = 0; i > k; --i) {
                fast = this.previous(max, fast);
                sum += code[fast];
            }
            ans[0] = sum;

            for(int i = max; i >= 0; --i) {
                fast = this.previous(max, fast);
                slow = this.previous(max, slow);
                //System.out.println(code[slow] + "- // +" + code[fast]);
                sum = sum - code[slow] + code[fast];
                ans[i] = sum;
            }

        }

        return ans;
    }

    private int next(int max, int i) {
        return max == i ? 0 : ++i;
    }
    private int previous(int max, int i) {
        return 0 == i ? max : --i;
    }
}