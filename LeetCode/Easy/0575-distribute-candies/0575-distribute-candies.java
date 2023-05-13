class Solution {
    public int distributeCandies(int[] candyType) {
        int M = 100_100;
        int eatable = candyType.length / 2;
        int eat = 0;
        boolean[] check = new boolean[M * 2 + 1];

        for(int c : candyType) {
            int idx = c + M;
            if(!check[idx]) {
                check[idx] = true;
                eat++;
                if(eat == eatable) return eat;
            }
        }

        return eat;
    }
}