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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    int carry = 0;
    ListNode d = new ListNode();
    ListNode cur = d;
    while (cur1 != null && cur2 != null) {
      int sum = carry + cur1.val + cur2.val;
      int dig = sum % 10;
      sum /= 10;
      carry = sum % 10;
      cur.next = new ListNode(dig);
      cur1 = cur1.next;
      cur2 = cur2.next;
      cur = cur.next;
    }
    while (cur1 != null) {
      int sum = carry + cur1.val;
      int dig = sum % 10;
      sum /= 10;
      carry = sum % 10;
      cur.next = new ListNode(dig);
      cur1 = cur1.next;
      cur = cur.next;
    }
    while (cur2 != null) {
      int sum = carry + cur2.val;
      int dig = sum % 10;
      sum /= 10;
      carry = sum % 10;
      cur.next = new ListNode(dig);
      cur2 = cur2.next;
      cur = cur.next;
    }
    if (carry != 0) {
      cur.next = new ListNode(carry);
    }
    return d.next;
  }
}
