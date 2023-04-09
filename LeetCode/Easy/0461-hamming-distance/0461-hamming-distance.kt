class Solution {
    fun hammingDistance2(x: Int, y: Int): Int = Integer.bitCount(x xor y)
    fun hammingDistance(x: Int, y: Int): Int {

        var ans:Int = 0;
        val parse = Integer.toBinaryString(x xor y);

        for (i in 0..parse.length - 1) {
            if(parse[i] == '1') ans++
        }

        return ans
    }
}