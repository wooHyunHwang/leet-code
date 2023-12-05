class Solution {

    public int numberOfMatches(int n) { return n-1; }

    public int numberOfMatches2(int n) {

        int matchesSum = 0;
        
        while (n > 1) {

            if (n % 2 == 1) {
                n /= 2;
                matchesSum += n;
                n++;
            } else {
                n /= 2;
                matchesSum += n;
            }
        }

        return matchesSum;

    }
}