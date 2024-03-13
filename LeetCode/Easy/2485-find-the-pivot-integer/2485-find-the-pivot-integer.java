class Solution {

    public int pivotInteger(int n) {
        
        int temp = n * (n+1) / 2;

        double temp2 = Math.sqrt(temp);
        int temp3 = (int)temp2;

        return temp2 == temp3 ? temp3 : -1;
    }

    public int pivotInteger2(int n) {
        
        int l = 1 , r = n;
        int lSum = 0, rSum = 0;

        while(l < r) {
            if (lSum < rSum) {
                lSum += l++;
            } else {
                rSum += r--;
            }
        }

        return lSum == rSum ? l : -1;
    }
    
}