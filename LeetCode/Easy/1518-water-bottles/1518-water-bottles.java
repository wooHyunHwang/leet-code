class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        int sum = numBottles;

        while(emptyBottles > numExchange) {
            int get = emptyBottles / numExchange;
            sum += get;
            emptyBottles = emptyBottles % numExchange + get;
        }

        sum += emptyBottles / numExchange;

        return sum;
    }
}