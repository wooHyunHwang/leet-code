class Solution {
    public boolean isHappy(int n) {
        return this.isHappy(new HashSet<>(), n);
    }

    public boolean isHappy(Set<Integer> history, int n) {

        while(!history.contains(n)) {

            history.add(n);
            int sum = 0;
            int div = n / 10;
            int rest = n % 10;
            while(div != 0 || rest != 0) {

                sum += rest * rest;

                rest = div % 10;
                div /= 10;
            }
            if (sum == 1) return true;
            n = sum;
        }

        return false;
    }
}