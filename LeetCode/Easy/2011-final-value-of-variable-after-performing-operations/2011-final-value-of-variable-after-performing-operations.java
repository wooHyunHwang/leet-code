class Solution {
    final String plus1 = "++X";
    final String plus2 = "X++";
    final String minus1 = "--X";
    final String minus2 = "X--";
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String s : operations) {
            if (plus1.equals(s) || plus2.equals(s)) {
                X++;
            } else {
                X--;
            }
        }

        return X;
    }
}