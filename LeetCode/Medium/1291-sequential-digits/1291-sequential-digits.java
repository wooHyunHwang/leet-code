class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        int temp = low;
        int lowDigit = 0;
        while (temp > 0) {
            temp /= 10;
            lowDigit++;
        }

        List<Integer> ans = new ArrayList<>();

        int start = 0;
        int digit = 1;

        while (start <= high) {
            // System.out.println(start + " === " + digit);

            if (digit > lowDigit) {
                int num = start;
                int up = 0;
                for (int i = 1; i < digit; ++i) {
                    up *= 10;
                    up += 1;
                }
                // System.out.println(up + " BBBBBBBBBB");
                while (num <= high) {
                    if (num >= low) ans.add(num);
                    if (num % 10 == 9) break;
                    num += up;
                }
            }

            start *= 10;
            start += digit++;
        }


        return ans;
    }
}