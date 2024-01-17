class Solution {
    public boolean checkIfExist(int[] arr) {
        
        for (int i = 0; i < arr.length; ++i) {

            if (arr[i] % 2 != 0) continue;
            int divide = arr[i] / 2;

            for (int j = 0; j < arr.length; ++j) {
                // System.out.println(divide + " === " + 2*arr[j]);
                if (i == j) continue;
                if (divide == arr[j]) return true;
            }
        }
        return false;
    }
}