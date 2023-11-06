package org.example;

import java.util.ArrayList;
import java.util.List;

public class LinkedListExcercise {
    public boolean hasCycle(ListNode head) {
        List<ListNode> traversedNode = new ArrayList<>();
        ListNode node = head;
        traversedNode.add(head);
        while(node.next != null) {
            if(traversedNode.contains(node.next))
                return false;
            traversedNode.add(node.next);
            node = node.next;
        }
        return true;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        return result;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode c = head.next;
        ListNode p = head;
        ListNode n = c.next;
        head.next = null;
        while(c != null){
            c.next =  p;
            p = c;
            c = n;
            if(c != null)
                n = c.next;
        }
        return p;
    }



        public int findDuplicate(int[] nums) {
        if(nums.length ==0 )
            return 0;
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast) {
            if(slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            if(slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode() {}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


}
