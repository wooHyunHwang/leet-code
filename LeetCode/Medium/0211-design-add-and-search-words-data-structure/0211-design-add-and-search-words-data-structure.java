class WordDictionary {

    private CharData preData;
    private CharData backData;

    public WordDictionary() {
        this.preData = new CharData();
        this.backData = new CharData();
    }
    
    public void addWord(String word) {
        // System.out.println(word);
        preData.addChar(true, word.toCharArray(), 0);
        backData.addChar(false, word.toCharArray(), word.length() - 1);
    }
    
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        return preData.findExactly(word.toCharArray(), 0);
        /*
        if (word.startsWith("..")) {
            return backData.findAsterisk(false, word.toCharArray(), word.length() - 1, 1);
        }
        else if (word.endsWith("..")) {
            return preData.findAsterisk(true, word.toCharArray(), 0, word.length() - 2);
        }
        else {
            // System.out.println("========= " + word);
            return preData.findExactly(word.toCharArray(), 0);
        }
        */
    }
}

class CharData {
    public boolean haveChildren;
    public boolean endOfString;
    public CharData[] data;

    CharData() {
        // a ~ z = 0~25
        this.haveChildren = false;
        this.endOfString = false;
        this.data = new CharData[26];
    }

    public void addChar(boolean strict, char[] arr, int index) {
        if (index >= arr.length || index < 0) {
            this.endOfString = true;
            return;
        }
        this.haveChildren = true;
        CharData next = null;
        if (this.data[arr[index] - 'a'] != null) {
            next = this.data[arr[index] - 'a'];
        } else {
            next = new CharData();
            this.data[arr[index] - 'a'] = next;
        }
        next.addChar(
            strict,
            arr,
            strict ? ++index : --index
        );
    }

    public boolean findAsterisk(boolean strict, char[] arr, int start, int end) {
        if (start == end) {
            // System.out.println("끝까지 감");
            return this.haveChildren;
        }

        int next = strict ? start + 1 : start - 1;

        if (arr[start] == '.') {
            for (CharData c : this.data) {
                if (c != null && c.findAsterisk(strict, arr, next, end)) return true;
            }
            // System.out.println("못찾았는딩");
            return false;
        }
        else if (this.data[arr[start] - 'a'] != null) {
            return this.data[arr[start] - 'a'].findAsterisk(
                strict,
                arr,
                next,
                end
            );
        }
        // System.out.println("?");
        return false;
    }

    public boolean findExactly(char[] arr, int index) {
        // System.out.println("--- " + index);

        int next = index + 1;

        if (index >= arr.length) {
            // System.out.println("끝에 도달했지만 " + this.endOfString);
            return this.endOfString;
        }
        else if (arr[index] == '.') {
            for (CharData c : this.data) {
                if (c != null && c.findExactly(arr, next)) return true;
            }
            // System.out.println("못찾음");
            return false;
        }
        else if (this.data[arr[index] - 'a'] != null) {
            return this.data[arr[index] - 'a'].findExactly(arr, next);
        }
        // System.out.println("어떤것도 아님");
        return false;
    }
}



/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */