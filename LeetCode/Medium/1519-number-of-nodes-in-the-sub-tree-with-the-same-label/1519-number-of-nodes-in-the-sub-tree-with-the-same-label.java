class Solution {
    // 극한의 똥 성능
    public int[] countSubTrees(int n, int[][] edges, String labels) {

        if( n == 0 ) return new int[0];

        int[] result = new int[n];
        char[] labelToChar = labels.toCharArray();
        
        // 하위 경로 추출
        HashSet<Integer> addedEndPoint = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> downPath = new HashMap<>();
        HashMap<Character, Integer> foundBack = new HashMap<>();
        for(int i = 0; i < edges.length; ++i) {
            // 
            if ( addedEndPoint.contains(edges[i][1]) || edges[i][1] == 0 ) {
                addedEndPoint.add(edges[i][0]);
                // 역방향 좌표
                HashSet<Integer> val = downPath.getOrDefault(edges[i][1], new HashSet<>());
                val.add(edges[i][0]);
                
                // 경로 맵 생성 / 업데이트
                downPath.put(edges[i][1], val);
            } else {
                addedEndPoint.add(edges[i][1]);
                // 정방향 좌표
                HashSet<Integer> val = downPath.getOrDefault(edges[i][0], new HashSet<>());
                val.add(edges[i][1]);
                
                // 경로 맵 생성 / 업데이트
                downPath.put(edges[i][0], val);
            }
       
        }

        for(int i = 0; i < labelToChar.length; ++i) {

        }

        // System.out.println( "아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ" );
        // for( Map.Entry<Integer, HashSet<Integer>> elem : downPath.entrySet() ){
            // System.out.print("키 : " + elem.getKey() + " / 값 ");
            // for (Integer e : elem.getValue()) {
                // System.out.print(e + "|");
            // }
            // System.out.println("");
        // }

        // System.out.println( "아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ아아아앙ㅇ" );
        System.out.println( "###################################################################################" );
        result[0]++;
        // 하위 탐색 건수
        result = findSubChar(0, result, downPath, labelToChar, foundBack);

        // 0번 직접

        System.out.println( "###################################################################################" );

        return result;
    }

    public int[] findSubChar(int i, int[] result, HashMap<Integer, HashSet<Integer>> downPath,
                            char[] labelToChar, HashMap<Character, Integer> foundBack) {
        // System.out.println("[" + i + "] 회차 탐색 / 현재 find : " + find + " / 선택된 Char : " + selectChar);

        HashSet<Integer> moveAble = downPath.get(i);

        if( moveAble == null ) {
            System.out.println(" ====== 끝자락");
            return result;
        }

        for (Integer move : moveAble) {
            HashMap<Character, Integer> innerFoundBack = new HashMap<>();

            result = findSubChar(move, result, downPath, labelToChar, innerFoundBack);
            // System.out.println("정점 : " + move + " / 단어 : " + labelToChar[move]);

            innerFoundBack.put(labelToChar[move], innerFoundBack.getOrDefault(labelToChar[move], 0) + 1);

            // result에 기록
            result[move] = innerFoundBack.get(labelToChar[move]);

 

            System.out.println("확인 : " + result[move]);
           
            innerFoundBack.forEach((key, value) -> foundBack.merge(key, value, (v1, v2) -> v1 + v2));
        }
        // 0번꺼 기록
        if(i == 0) {
            result[0] += foundBack.getOrDefault(labelToChar[0], 0);
        }
        return result;
    }
}










