/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    public boolean isPalindrome(ListNode head) {
        // 반으로 자르기 위한 반복?
        ListNode fp=head;
        ListNode sp=head;

        ListNode rev=null;
        ListNode temp=head;

        while(fp!=null && fp.next!=null){
            fp=fp.next.next;
            sp=sp.next;
            temp.next=rev;
            rev=temp;
            temp=sp;
        }
        printNode(head);
        printNode(fp);
        printNode(sp);
        printNode(rev);
        printNode(temp);
        if(fp==null){
            while(sp!=null){
                if(rev.val!=sp.val){
                    return false;
                }
                sp=sp.next;
                rev=rev.next;
            }
            return true;
        }
        else if(fp.next==null){
            sp=sp.next;
            while(sp!=null){
                if(rev.val!=sp.val){
                    return false;
                }
                sp=sp.next;
                rev=rev.next;
            }
            return true;
        }
        return false;
    }
    */

    void printNode(ListNode n) {
        if (n == null) return;

        System.out.print(n.val);
        System.out.print(" - ");

        if (n.next == null) {
            System.out.println("");
            System.out.println("=======");
            return;
        }
        printNode(n.next);
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        int cnt = 0;
        ListNode temp = head;

        while(temp != null) {
            stk.push(temp.val);
            temp = temp.next;
            cnt++;
        }

        while(!stk.isEmpty()) {
            if (head.val != stk.pop()) return false;
            head = head.next;
        }

        /*
        int odd = cnt % 2;
        int half = cnt / 2 - 1 ;
        int[] arr = new int[cnt];

        for (int i = 0; i < cnt; ++i) {
            arr[i] = stk.pop();
            if (half + odd < i) { // 1 3 1
                if (arr[i] != arr[half]) return false;
                half--;
            }
        }
        */
        return true;
    }

}