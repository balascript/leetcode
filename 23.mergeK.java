public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return helper(lists,0,lists.length-1);
    }
    public ListNode helper(ListNode[] lists, int start,int end){
        if(start==end)
            return lists[start];
        if(start+1==end)
            return mergeTwoLists(lists[start],lists[end]);
        int mid= (start+end)/2;
        ListNode left= helper(lists,start,mid);
        ListNode right= helper(lists,mid+1,end);
        return mergeTwoLists(left,right);
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