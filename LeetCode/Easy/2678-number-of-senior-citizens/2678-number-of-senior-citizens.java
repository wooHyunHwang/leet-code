class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String passenger : details) {
            int age = ( (passenger.charAt(11) - '0') * 10) + (passenger.charAt(12) - '0');
            if (age > 60) count++;
        }
        return count;
    }
}