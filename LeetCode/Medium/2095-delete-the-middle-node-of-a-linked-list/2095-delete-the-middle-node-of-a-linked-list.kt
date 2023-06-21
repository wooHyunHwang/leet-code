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
    fun deleteMiddle(head: ListNode): ListNode? {

        if (head == null || head.next == null) return null

        var back = head
        var one = head
        var two = head.next

        while(two != null && two.next != null) {
            back = one
            one = one.next
            two = two.next.next
        }

        if(two != null) {
            one.next = one.next.next
        }
        else {
            back.next = one.next
            one.next = null
        }

        return head;
    }
}