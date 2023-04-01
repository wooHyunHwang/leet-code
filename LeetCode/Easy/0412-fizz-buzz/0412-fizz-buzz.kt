class Solution {

    val fifth = "FizzBuzz";
    val three = "Fizz";
    val five = "Buzz";

    fun fizzBuzz(n: Int): List<String> {
        val ans: ArrayList<String> = arrayListOf<String>()
        
        for(i in 1..n) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    ans.add(fifth)
                } else {
                    ans.add(three)
                }
            } else if (i % 5 == 0) {
                ans.add(five)
            } else {
                ans.add("$i")
            }
        }

        return ans
        
    }
}
