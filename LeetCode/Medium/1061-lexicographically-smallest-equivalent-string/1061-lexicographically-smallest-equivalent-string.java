class Solution {

    char[] dic;

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        // 알파벳 순서에 맞춰 26개의 가장 작은 char가 입력될 사전 배열
        createDictionary(s1, s2);

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < baseStr.length() ; ++i) {
            sb.append(dic[(int) check(baseStr.charAt(i)) - 97]);
        }

        return sb.toString();
    }

    public char[] createDictionary(String s1, String s2) {

        // char, 알파벳 26자를 이용해 사전 배열 만들기
        // System.out.println((int)'a' - 97);
        // System.out.println((int)'z' - 97);

        // 0은 빈값
        dic = new char[26];

        // 사전 초기화
        for (int i = 0; i < 26; ++i) {
            dic[i] = (char)(i + 'a');
        }

        // HashMap<Integer, ArrayList<Integer>> group = new HashMap<>();

        for (int i = 0; i < s1.length(); ++i) {
            char a = check(s1.charAt(i));
            char b = check(s2.charAt(i));

            // System.out.println("a: " + a + " / b : " + b);

            if(a < b) {
                dic[(int)b - 97] = a;
                // System.out.println(b + "뒤 변경 : " + dic[(int)b - 97]);
            } else {
                dic[(int)a - 97] = b;
                // System.out.println(a + "뒤 변경 : " + dic[(int)a - 97]);
            }


            
            /*
            System.out.println("===================");
            System.out.println("s1 : " + ((int) s1.charAt(i) - 97) + " / s2 : " + (int) s2.charAt(i));
            System.out.println("s2 : " + ((int) s2.charAt(i) - 97) + " / s1 : " + (int) s1.charAt(i));

            ArrayList<Integer> sa1 = group.getOrDefault((int) s1.charAt(i) - 97, new ArrayList<>());
            ArrayList<Integer> sa2 = group.getOrDefault((int) s2.charAt(i) - 97, new ArrayList<>());

            sa1.add((int)s1.charAt(i));
            sa1.add((int)s2.charAt(i));
            sa2.add((int)s2.charAt(i));
            sa2.add((int)s1.charAt(i));

            group.put(
                (int) s1.charAt(i) - 97,
                sa1
            );
            group.put(
                (int) s2.charAt(i) - 97,
                sa2
            );
            */
            
            //dic[(int) s1.charAt(i) - 97];
            /*
            if (dic[(int) s1.charAt(i) - 97] > s2.charAt(i)) {
                dic[(int) s1.charAt(i) - 97] = s2.charAt(i);
            }
            if (dic[(int) s2.charAt(i) - 97] > s1.charAt(i)) {
                dic[(int) s2.charAt(i) - 97] = s1.charAt(i);
            }
            */
        }

        // for (int i = 0; i < 26; ++i) {
        //     if (group.containsKey(i)) {
        //         System.out.print(((char)(i + 'a')) + ") - ");
        //         for (int a : group.get(i)) {
        //             System.out.print(((char)a) + " / ");
        //         }
        //         System.out.println();
        //     }
        // }
        return dic;
    }

    public char check(char c) {
        if (dic[(int)c - 97] == c) {
            return c;
            
        } else {
            // System.out.println("최소 변경 대상 : " + c);
            // System.out.println("최소 변경 : " + dic[(int)c - 97]);
            dic[(int)c - 97] = check(dic[(int)c - 97]);
            // System.out.println("최소 변경 후 : " + dic[(int)c - 97]);
            return dic[(int)c - 97];
        }
    }
}





















