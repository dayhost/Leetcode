public class reverseHalfList{
	public static void main(String[] args){
//		ListNode n10 = new ListNode(null,10);
//		ListNode n9 = new ListNode(null,9);
//		ListNode n8 = new ListNode(n9,8);
//		ListNode n7 = new ListNode(n8,7);
//		ListNode n6 = new ListNode(n7,6);
//		ListNode n5 = new ListNode(n6,5);
		ListNode n4 = new ListNode(null,4);
		ListNode n3 = new ListNode(n4,3);
		ListNode n2 = new ListNode(n3,2);
		ListNode n1 = new ListNode(n2,1);
		
		ListNode result = reverseSecondHalfList(n1);
		
		System.out.println();
	}
	
	public static ListNode reverseSecondHalfList(ListNode head) {
	    if (head == null || head.next == null)      return head;
	    ListNode fast = head;
	    ListNode slow = head;
	    while (fast.next != null && fast.next.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    ListNode start = null;
	    ListNode pre = null;
	    ListNode then = null;
	    if(fast.next!=null&&fast.next.next==null){
	    	start = slow.next;
	    	pre = slow;
	    }else{
	    	start = slow;
	    	pre = head;
	    	while(pre.next!=slow){
	    		pre = pre.next;
	    	}
	    }
	    then = start.next;
	    while(start.next!=null){
	    	start.next = then.next;
	    	then.next = pre.next;
	    	pre.next = then;
	    	then = start.next;
	    }
	    
	    return head;
	    
	}
}

class ListNode{
	public ListNode next;
	public int value;
	public ListNode(ListNode next,int value){
		this.next = next;
		this.value = value;
	}
}