import java.rmi.UnexpectedException;

public class PalindromeLinkedList_234 {

    // Definition for singly-linked list.
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    1.快慢指针找到链表中点（遍历一遍得到总长也能定位到链表中点）
    2.反转后半段
    3.头结点指针和中点指针一起向后遍历，判同
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }

        //此时slow为中点（偶数为靠后一个）
        ListNode middle = reverseList(slow);
        ListNode temp = head;

        while (middle!=null){
            if (middle.val!=temp.val){
                return false;
            }
            middle = middle.next;
            temp = temp.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre =null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        PalindromeLinkedList_234 solver = new PalindromeLinkedList_234();
        System.out.println(solver.isPalindrome(n1));
    }
}
