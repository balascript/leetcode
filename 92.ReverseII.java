public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || m==n) return head;
        ListNode dummy= new ListNode(0);
        dummy.next=head;
       head=dummy;
        int k=n-m+1;
        while(m-->1)
            head=head.next;
        ListNode prev = null;
        ListNode current = head.next;
        ListNode next = null;
        while (k-->0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next.next=next;
        head.next=prev;

 
        return dummy.next;
    }
}