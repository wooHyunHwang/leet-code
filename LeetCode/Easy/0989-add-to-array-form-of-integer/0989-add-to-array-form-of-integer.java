class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < num.length; ++i) {
            ans.add(num[i]);
        }

        String kStr = k + "";
        // printArray(ans);
        for(int i = kStr.length() - 1; i >= 0; --i) {
            // System.out.print((int) (kStr.charAt(i) - '0'));

            // System.out.println(" / " + (kStr.length() - i - 1));

            ans = calculater(ans, (int) (kStr.charAt(i) - '0'), (kStr.length() - i - 1));

            // printArray(ans);
        }

        return ans;

        /* 숫자로는 표현 자리수가 부족
        long numToInt = 0;

        for(int i = 0; i < num.length; ++i) {
            numToInt += (num[i] * Math.pow(10, num.length - i - 1));
        }

        String sum = numToInt + k + "";

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < sum.length(); ++i) {
            ans.add(
                (int) (sum.charAt(i) - '0')
            );
        }

        return ans;
        */
    }

    public List<Integer> calculater(List<Integer> ans, int add, int idx) {

        if(ans.size() <= idx) {
            ans.add(0, add);
            return ans;
        }

        int sum = ans.get(ans.size() - 1 - idx) + add;
        
        if(sum > 9) {
            ans.set(ans.size() - 1 - idx, sum % 10);
            ans = calculater(ans, 1, idx + 1);
        } else {
            ans.set(ans.size() - 1 - idx, sum);
        }

        return ans;

    }

    public void printArray(List<Integer> num) {

        for(int i = 0; i < num.size(); ++i) {
            System.out.print(num.get(i));
        }

        System.out.println();

    }


















}