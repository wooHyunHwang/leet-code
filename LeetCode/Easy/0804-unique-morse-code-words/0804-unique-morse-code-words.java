class Solution {

    private final String[] character = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        
        Set<String> transformations = new HashSet<>();

        for (String word : words) {

            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(character[c-'a']);
            }
            transformations.add(sb.toString());
        }

        return transformations.size();
    }
}