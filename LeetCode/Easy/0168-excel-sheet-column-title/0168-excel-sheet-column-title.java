class Solution {

    StringBuilder sb = null;

    public String convertToTitle(int columnNumber) {
        sb = new StringBuilder();

        addCharacter(columnNumber - 1);

        return sb.toString();
    }

    public void addCharacter(int columnNumber) {

        int divide = columnNumber / 26;
        int remainder = columnNumber % 26;

        // System.out.println("columnNumber : " + columnNumber + " / " + divide + " / " + remainder);

        if (remainder >= 0) {
            sb.insert(0, (char)(remainder + 'A'));
        }

        if (divide > 0) {
            addCharacter(divide - 1);
        }

    }
}