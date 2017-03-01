public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length=0;
        if(k<2) return head;
        for(ListNode t= head;t!=null;){
            length++;
            t=t.next;
        }
        if(length==0 || k>length) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode ptr=dummy;
     
        int count= length/k;
        while(count-->0){
            ListNode next=ptr.next;
            ListNode temp=ptr.next;
            ListNode[] arr=reverse(temp,k);
            ptr.next=arr[0];
            temp.next=arr[1];
            ptr=temp;
            
        }
       
        return dummy.next;
        
    }
    public ListNode[] reverse(ListNode node,int k){
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        
        while (current != null && k>0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        ListNode[] arr={prev,next};
        return arr;
    }
}