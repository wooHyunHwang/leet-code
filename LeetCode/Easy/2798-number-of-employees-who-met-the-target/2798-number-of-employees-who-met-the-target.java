class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0,n = hours.length;
        for(int it : hours){
            if(it>=target) count++;
        }
        return count;
    }
}