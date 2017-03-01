public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode slow=head;
        ListNode fast= head.next;
        
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       // System.out.println(head.val);
       // System.out.println(slow.next.val);
        ListNode l2=slow.next;
        slow.next=null;
        ListNode l1=head;//sortList(head);
        return mergeTwoLists(sortList(l1),sortList(l2));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode head = new ListNode(0);
        ListNode p=head;
        ListNode p1=l1;
        ListNode p2=l2;
        while(p1!=null && p2!=null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p=p.next;
        }
     
        if(p1!=null){
            p.next = p1;
        }
     
        if(p2!=null){
            p.next = p2;
        }
     
        return head.next;
        
        
    }
}