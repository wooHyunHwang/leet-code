/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {

        if(head == null || head.next == null) return head

        val tempEvenHead = head.next
        var tempEven = tempEvenHead
        var tempOdd = head

        while(true) {
            // 2개씩 넘어감
            if(tempOdd != null && tempOdd.next != null && tempOdd.next.next != null) {
                tempOdd.next = tempOdd.next.next
                tempOdd = tempOdd.next
            }
            else break;

            
            if(tempEven != null && tempEven.next != null && tempEven.next.next != null) {
                tempEven.next = tempEven.next.next
                tempEven = tempEven.next
            }
            else break;
        }

        if(tempEven != null) tempEven.next = null
        if(tempOdd != null) tempOdd.next = tempEvenHead
        
        return head
    }
}