class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        int width = image[0].length;
        int half = width / 2;
        int lastIdx = width - 1;
        boolean odd = width % 2 == 1;

        int a = 0;

        for (int i = 0; i < image.length; ++i) {

            for (int j = 0; j < half; ++j) {
                int temp = this.swap(image[i][j]);
                image[i][j] = this.swap(image[i][lastIdx - j]);
                image[i][lastIdx - j] = temp;
            }

            if (odd) image[i][half] = this.swap(image[i][half]);
        }

        return image;
    }

    private int swap(int val) {
        return val == 0 ? 1 : 0;
    }
}
