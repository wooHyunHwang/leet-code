class Solution {
    public String reverseParentheses(String s) {
        
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] cAry = s.toCharArray();

        for (int i = 0; i < cAry.length; ++i) {
            if (cAry[i] == '(') {
                stack.add(sb.toString());
                sb.setLength(0);
            }
            else if (cAry[i] == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            }
            else {
                sb.append(cAry[i]);
            }
        }
        return sb.toString();
    }
    private int idx = 0;
    public String reverseParentheses2(String s) {
        char[] cAry = s.toCharArray();
        this.idx = 0;

        return this.recursive(cAry, true).toString();
    }

    // direction : true - 오른쪽, false - 왼쪽
    private StringBuilder recursive(char[] cAry, boolean direction) {

        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder right = new StringBuilder();
        boolean leftArea = true;

        for (; this.idx < cAry.length;) {
            if (cAry[this.idx] == '(') {
                if (!leftArea) {
                    left.append(mid).append(right);
                    mid = new StringBuilder();
                    right = new StringBuilder();
                }
                this.idx++;
                mid = this.recursive(cAry, !direction);
                System.out.println(mid.toString());
                leftArea = false;
            }
            else if (cAry[this.idx] == ')') {
                this.idx++;
                break;
            }
            else {
                if (leftArea) {
                    left.append(cAry[this.idx++]);
                }
                else {
                    right.append(cAry[this.idx++]);
                }
            }
        }

        if (!direction) {
            left.reverse();
            right.reverse();
            return right.append(mid).append(left);
        }
        else {
            return left.append(mid).append(right);
        }// wnb bx ey wqz eyt

        
    }
    
}

// wnb((wqzeyt)(bxey))