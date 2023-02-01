package com.koko.striver.day6;

/**
 * slow reach to mid and then reverse the remaining and then compare
 */

public class checkPalindrome {
    public ListNode head;
    public static void main(String[] args) {
        checkPalindrome list1 = new checkPalindrome();
        checkPalindrome list2 = new checkPalindrome();

        list1.addToTheLast(new ListNode(1));
        list1.addToTheLast(new ListNode(2));
        list1.addToTheLast(new ListNode(3));
        list1.addToTheLast(new ListNode(4));
        list1.addToTheLast(new ListNode(4));
        list1.addToTheLast(new ListNode(3));
        list1.addToTheLast(new ListNode(2));
        list1.addToTheLast(new ListNode(1));
        System.out.println("list");
        list1.printList(list1.head);
        System.out.println("isPalindrome" + list1.isPalindrome(list1.head));

    }

    private boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next; // ye bhi add karna hai
        ListNode dummy = head;

        while(slow!=null) {
            if(slow.data != dummy.data) return false;
            slow = slow.next;
            dummy = dummy.next;
        }
        return true;

    }

    static ListNode reverse(ListNode head) {
        if(head== null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // yha prev hota hai not head
    }


    private void printList(ListNode head) {
        while(head!=null) {
            if(head.next!= null) System.out.print(head.data + "->");
            else System.out.print(head.data);
            head = head.next;
        }
    }

    private void addToTheLast(ListNode listNode) {
        if (head == null) {
            head = listNode;
        } else {
            ListNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = listNode;
        }
    }
}

