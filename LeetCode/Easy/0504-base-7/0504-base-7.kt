class Solution {
    fun convertToBase7(num: Int): String {
        if(num == 0) return "0";

        val sb: StringBuilder = StringBuilder()
        val minus: Boolean = num < 0
        var absNum = Math.abs(num)

        while(absNum > 0) {
            sb.append(absNum % 7)
            absNum /= 7 
        }

        if(minus) {
            sb.append("-")
        }
  
        return sb.reverse().toString()
    }
}