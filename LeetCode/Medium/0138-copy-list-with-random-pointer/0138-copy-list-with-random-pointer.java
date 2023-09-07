/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Map<Integer, Integer> headMapIdx = new HashMap<>();    // hashCode / Idx
        Map<Integer, Node> headMap = new HashMap<>();       // Idx / hashCode
        Map<Integer, Integer> copyMapIdx = new HashMap<>();    // hashCode / Idx
        Map<Integer, Node> copyMap = new HashMap<>();       // Idx / hashCode

        Node start = new Node(head.val);
        Node last = null;

        Node temp = head; // 마지막엔 null 주소 들어있음
        Node temp2 = start;
        int idx = 0;

        // 맵 완성
        while(temp != null) {
            headMapIdx.put(temp.hashCode(), idx);
            headMap.put(idx, temp);
            copyMapIdx.put(temp2.hashCode(), idx);
            copyMap.put(idx, temp2);

            temp2.next = temp.next != null ? new Node(temp.next.val) : last;
            temp2 = temp2.next;
            temp = temp.next;
            idx++;
        }

        // 랜덤 주소 연결
        temp = head;
        idx = 0;
        while(temp != null) {
            if (temp.random == null) {
                copyMap.get(idx).random = last;
            } else {
                copyMap.get(idx).random = copyMap.get(
                    headMapIdx.get(temp.random.hashCode())
                );
            }
            
            temp = temp.next;
            idx++;
        }


        return start;
    }
}