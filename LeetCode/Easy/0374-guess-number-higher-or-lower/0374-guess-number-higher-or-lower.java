/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int compareValue = 0;
        long ans = 0;

        if (guess(n) > 0) {
            compareValue = Integer.MAX_VALUE;
            ans = binarySearch(n, compareValue);
        } else {
            ans = binarySearch(compareValue, n);
        }

        return Long.valueOf(ans).intValue();
        
    }

    private long binarySearch(long left, long right) {

        int compare = -1;
        long ans = -1;

        while(compare != 0) {
            long sum = left + right;
            ans = sum / 2 + sum % 2;
            compare = guess((int) ans);

            // System.out.println(ans + " / " + compare + " = " + (compare != 0));

            if (compare > 0) left = ans;
            else if (compare < 0) right = ans;
        }
        return ans;
        
    }
}