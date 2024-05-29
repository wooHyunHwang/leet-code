class Solution {
    public int numSteps(String s) {
        int l = s.length() - 1;
        int carry = 0;
        int count = 0;
        
        while (l > 0) {
            // even number with carry = 0, result even
            if (Character.getNumericValue(s.charAt(l)) + carry == 0) {
                carry = 0;
                count++;
            // odd number with carry = 1, result even
            } else if (Character.getNumericValue(s.charAt(l)) + carry == 2) {
                carry = 1;
                count++;
            // even number with carry = 1, result odd
            // odd number with carry = 0, result odd
            } else {
                carry = 1;
                count += 2;
            }
            l--;
        }
        
        // last digit 1 needs to add a carried over digit 1, which gives 10.
        // So need one more divide to make it 1 (one more step)
        if (carry == 1) {
            count++;
        }
        
        return count;
    }

    public int numSteps2(String s) {
        int si = s.length() - 1;
        long value = 0;
        long sec = 1;
        while (si > -1) {
            if (s.charAt(si--) == '1') {
                value += sec;
            }
            // System.out.println(value);
            sec *= 2;
        }
        // System.out.println(" ================================== ");
        int step = 0;
        while (value > 1) {
            // System.out.println(value);
            System.out.println(Long.toBinaryString(value));
            step++;
            if (value % 2 == 1) value++;
            else value /= 2;
        }
        return step;
    }
}