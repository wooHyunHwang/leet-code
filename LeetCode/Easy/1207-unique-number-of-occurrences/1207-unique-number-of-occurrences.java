class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        Set<Integer> key = new HashSet<>();
        Set<Integer> dup = new HashSet<>();
        int[] count = new int[2_001];

        for(int i = 0; i < arr.length; ++i) {
            count[arr[i] + 1000]++;
            key.add(arr[i] + 1000);
        }

        for(int k : key) {
            if(dup.contains(count[k])) return false;
            dup.add(count[k]);
        }

        return true;
    }
}