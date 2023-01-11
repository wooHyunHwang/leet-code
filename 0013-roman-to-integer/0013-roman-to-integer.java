class Solution {
    public int romanToIntd(String s) {
        Map<String, Integer> rom = new HashMap<>();

        rom.put("M",1000);
        rom.put("CM",900);
        rom.put("D",500);
        rom.put("CD",400);
        rom.put("C",100);
        rom.put("XC",90);
        rom.put("L",50);
        rom.put("XL",40);
        rom.put("X",10);
        rom.put("IX",9);
        rom.put("V",5);
        rom.put("IV",4);
        rom.put("I",1);

        int start = 0;
        int sum = 0;

        while(s.length() > 0) {
            if ( s.length() > 1 ) {
                if(rom.containsKey(s.substring(0, 2))) {
                    sum += rom.get(s.substring(0, 2));
                    s= s.substring(2);
                } else {
                    sum += rom.get(s.substring(0, 1));
                    s= s.substring(1);
                }
            } else if ( s.length() == 1 ) {
                sum += rom.get(s.substring(0, 1));
                s= s.substring(1);
            } else {
                System.out.println("끝");
                break;
            }
        }
        return sum;
    }


    public int romanToInt(String s) {
        char prev = s.charAt(s.length()-1);
        int res = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            int cost = cost(c);
            System.out.println("cost : " + cost + ", c : " + c + ", prev : " + prev);
            if(cost < cost(prev)) {
                res -= cost;
            } else {
                res += cost;
            }
            prev = c;
        }
        return res;
    }

    private int cost(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}