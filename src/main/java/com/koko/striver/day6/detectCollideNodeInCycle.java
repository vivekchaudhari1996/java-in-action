package com.koko.striver.day6;

/**
 * Initially take two pointers, fast and slow. The fast pointer takes two steps ahead while the slow pointer will take a single step ahead for each iteration.
 * We know that if a cycle exists, fast and slow pointers will collide.
 * If the cycle does not exist, the fast pointer will move to NULL
 * Else, when both slow and fast pointer collides, it detects a cycle exists.
 * Take another pointer, say entry. Point to the very first of the linked list.
 * Move the slow and the entry pointer ahead by single steps until they collide.
 * Once they collide we get the starting node of the linked list.
 */

public class detectCollideNodeInCycle {
    public ListNode head;
    public static void main(String[] args) {
        detectCollideNodeInCycle list1 = new detectCollideNodeInCycle();
        detectCollideNodeInCycle list2 = new detectCollideNodeInCycle();

        list1.addToTheLast(new ListNode(1));
        list1.addToTheLast(new ListNode(2));
        list1.addToTheLast(new ListNode(3));
        list1.addToTheLast(new ListNode(4));
        list1.addToTheLast(new ListNode(5));
        list1.addToTheLast(new ListNode(6));
        list1.addToTheLast(list1.head.next.next); // making the cycle
        System.out.println("list");
        //list1.printList(list1.head);
        System.out.println("collide point:" + list1.cycleDetect(list1.head).data);

    }

    private ListNode cycleDetect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
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

