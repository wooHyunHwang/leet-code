class Solution {
    public int[][] imageSmoother(int[][] img) {
        int lastHeight = img.length - 1;
        boolean twoHeight = lastHeight >= 1;
        int[][] ans = new int[img.length][img[0].length];

        // 조건이 필요한 껍데기 부분, 뚜껑, 발
        // i == 0, j 반복
        // i == length-1, j 반복
        for (int j = 0; j < img[0].length; ++j) {
            
            int headCalc = 0;
            int footCalc = 0;

            int headCount = twoHeight ? 2 : 1;
            int footCount = 2;

            if (j > 0) {
                headCalc += img[0][j-1];

                if (twoHeight) {
                    headCount += 2;
                    footCount += 2;
                    headCalc += img[1][j-1];
                    footCalc = img[lastHeight][j-1] + img[lastHeight-1][j-1];
                } else {
                    headCount++;
                }
            }


            headCalc += (twoHeight ? img[0][j] + img[1][j] : img[0][j]);
            if (twoHeight) footCalc += img[lastHeight][j] + img[lastHeight-1][j];


            if (j < img[0].length-1) {
                headCalc += img[0][j+1];

                if (twoHeight) {
                    headCount += 2;
                    footCount += 2;
                    headCalc += img[1][j+1];
                    footCalc += img[lastHeight][j+1] + img[lastHeight-1][j+1];
                } else {
                    headCount++;
                }
            }

            // System.out.println(footCalc + " / " + footCount);

            ans[0][j] = headCalc / headCount;
            if (twoHeight) ans[lastHeight][j] = footCalc / footCount;

        }

        if (img.length >= 2) {

            int firstJ = 0;
            int lastJ = img[0].length - 1;
            boolean twoWidth = lastJ >= 1;

            for (int i = 1; i < img.length - 1; ++i) {

                ans[i][firstJ] = (
                    img[i-1][firstJ] +
                    (twoWidth ? img[i-1][firstJ+1] : 0) +
                    img[i][firstJ] +
                    (twoWidth ? img[i][firstJ+1] : 0) +
                    img[i+1][firstJ] +
                    (twoWidth ? img[i+1][firstJ+1] : 0)
                ) / (twoWidth ? 6 : 3);

                if (twoWidth) {
                    ans[i][lastJ] = (
                        img[i-1][lastJ] +
                        img[i-1][lastJ-1] +
                        img[i][lastJ] +
                        img[i][lastJ-1] +
                        img[i+1][lastJ] +
                        img[i+1][lastJ-1]
                    ) / 6;
                }

            }
        }

        // 단순 계산
        for (int i = 1; i < img.length - 1; ++i) {
            for (int j = 1; j < img[i].length - 1; ++j) {

                ans[i][j] = (
                    img[i-1][j-1] +
                    img[i][j-1] +
                    img[i+1][j-1] +
                    img[i-1][j] +
                    img[i][j] +
                    img[i+1][j] +
                    img[i-1][j+1] +
                    img[i][j+1] +
                    img[i+1][j+1]
                ) / 9;
                
            }
        }

        return ans;
    }
}