public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
         if(head==null || head.next==null) return null;
        ListNode slow=head;
        ListNode fast= head;
        boolean isCycle=false;
        while(fast!=null &&slow!=null){
            slow=slow.next;
            if(fast.next==null) return null;
            fast=fast.next.next;
            if(fast==slow) {isCycle=true;break;}
            
            
        }
        if(!isCycle) return null;
        
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        
        return slow;
    }
}