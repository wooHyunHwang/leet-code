class Solution {
    public int findSpecialInteger(int[] arr) {

        int last = arr[0];
        int count = 1;
        int standard = arr.length / 4;

        for (int i = 1; i < arr.length; ++i) {

            if (last == arr[i]) {
                count++;
                if (count > standard) return last;
            } else {
                count = 1;
                last = arr[i];
            }
        }

        return last;
    }
    public int findSpecialInteger2(int[] arr) {

        int[] his = new int[100000];
        int standard = arr.length * 25 / 100 ;

        for (int a : arr) {
            if (++his[a] > standard) {
                return a;
            }
        }

        return -1;
    }
}