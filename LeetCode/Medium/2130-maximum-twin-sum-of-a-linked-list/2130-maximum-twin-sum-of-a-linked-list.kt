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
    fun pairSum(head: ListNode?): Int {

        if(head == null) return 0

        var ans = 0

        var fast = head
        var slow = head
        var curr = head
        var prev: ListNode? = null

        while(fast != null) {
            fast = fast.next.next
            slow = slow!!.next
            curr!!.next = prev
            prev = curr
            curr = slow
            
        }

        while(slow != null) {
            ans = Math.max(ans, prev!!.`val` + slow!!.`val`)
            prev = prev.next
            slow = slow.next
        }

        return ans
        
    }
}