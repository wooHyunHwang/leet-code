class Solution {
    fun findTheDifference(s: String, t: String): Char {
        if(t.length <= 0) return '0';
        if(t.length <= 1) return t[0];
        // println("#####################");
        var dictionary = IntArray(26, {0});
        var tChar = t.toCharArray();
        tChar.sort();

        for (c in s.toCharArray()) {
            dictionary[c - 'a']++;
            // println(dictionary[c - 'a']);
        }

        var accum = 0;
        // println("#####################");
        dictionary.forEachIndexed { index, count -> 
            // print(accum);
            // print(" / ");
            // println(index);
            accum += count;
            if (tChar[accum - 1] - 'a' != index || tChar[accum] - 'a' == index)
                return tChar[accum];
        }

        return '0';
    }
}