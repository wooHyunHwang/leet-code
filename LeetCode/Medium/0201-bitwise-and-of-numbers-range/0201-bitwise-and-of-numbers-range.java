class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int i = 0;
        for (; left != right; ++i) {
            left = left >> 1;
            right = right >> 1;
        }

        left = left << i;

        return left;

        /*

        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(13));

        if (left == right) return left;

        // right 범위 줄이기
        long max = 1;
        while(left >= max) {
            max = max << 1;
        }

        if (left == max) return left;
        else if (right >= max) return 0;

        char[] l = Integer.toBinaryString(left).toCharArray();

        int i = 0;
        for (; i < l.length; ++i) {
            left = left >> 1;
            right = left >> 1;
            if (left == right) break;
        }

        for (; i >= 0; --i) {
            left = left << 1;
        }

        return left;

        /*

        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(12));

        if (left == right) return left;

        // right 범위 줄이기
        long max = 1;
        while(left >= max) {
            max = max << 1;
        }

        if (left == max) return left;
        else if (right >= max) return 0;
        else return left & (left + 1);
        */
    }
}