public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        int length=0;
        for(ListNode t= head;t!=null;){
            length++;
            t=t.next;
        }
        
        if(k<=0 || length==0 || k%length==0) return head;
        k=k%length;
        ListNode fast=head.next;
        while(fast!=null && k-- >0)
            fast=fast.next;
            
        ListNode slow= head;
        while(slow!=null && fast!=null){
            slow=slow.next;
            fast=fast.next;
        }

        ListNode Head= slow.next;
        slow.next=null;
        slow= Head;
        while(slow!=null && slow.next!=null)
            slow=slow.next;
        
       if(slow!=null) slow.next=head;
        return Head;
        
    }
}