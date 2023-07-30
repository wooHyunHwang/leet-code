class Solution {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        int[] d = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<Integer, String> dictionary = new HashMap<>();

        dictionary.put(1000, "M");
        dictionary.put(900, "CM");
        dictionary.put(500, "D");
        dictionary.put(400, "CD");
        dictionary.put(100, "C");
        dictionary.put(90, "XC");
        dictionary.put(50, "L");
        dictionary.put(40, "XL");
        dictionary.put(10, "X");
        dictionary.put(9, "IX");
        dictionary.put(5, "V");
        dictionary.put(4, "IV");
        dictionary.put(1, "I");

        for(int i = 0; i < d.length; ++i) {
            int divide = num / d[i];
            num %= d[i];

            for(int j = 0; j < divide; ++j) {
                sb.append(dictionary.get(d[i]));
            }
        }

        return sb.toString();
    }
}