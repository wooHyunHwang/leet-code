class Solution {
    public int countKDifference(int[] nums, int k) {
        int arr[]=new int[101];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        int res=0;
        for(int i=k+1;i<101;++i){
            res+=arr[i]*arr[i-k];
        }
        return res;
    }
    public int countKDifference2(int[] nums, int k) {
        
        int ans = 0;

        for (int i = 0; i < nums.length; ++i) {
            int plus = nums[i]+k;
            int minus = nums[i]-k;
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[j] == plus || nums[j] == minus) ans++;
            }
        }

        return ans;
    }
}