class Solution {

    private final String fifth = "FizzBuzz";
    private final String three = "Fizz";
    private final String five = "Buzz";

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for(int i = 1; i <= n; ++i) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    ans.add(fifth);
                } else {
                    ans.add(three);
                }
            } else if (i % 5 == 0) {
                ans.add(five);
            } else {
                ans.add(Integer.toString(i));
            }
        }


        return ans;
    }
}