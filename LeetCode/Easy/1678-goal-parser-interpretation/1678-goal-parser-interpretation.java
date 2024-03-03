class Solution {
    public String interpret(String command) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length();) {

            char c = command.charAt(i);

            if (command.charAt(i) == '(') {
                switch(command.charAt(i+1)) {
                    case ')': {
                        sb.append("o");
                        i += 2;
                        break;
                    }
                    case 'a': {
                        sb.append("al");
                        i += 4;
                        break;
                    }
                }
            }
            else {
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }
}