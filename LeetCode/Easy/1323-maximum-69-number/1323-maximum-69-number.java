class Solution {
    public int maximum69Number (int num) {

        int copy = num;
        int i = 4;
        int div = 1_000;

        while(copy > 0 && div > 0) {
            if (copy / div == 6) {
                break;
            }
            copy -= (copy / div) * div;
            div /= 10;
            i--;
        }

        //System.out.println(i + " ==== " + copy);

        switch (i) {
            case 4: {
                num += 3000;
                break;
            }
            case 3: {
                num += 300;
                break;
            }
            case 2: {
                num += 30;
                break;
            }
            case 1: {
                num += 3;
                break;
            }
        }

        return num;
    }
}