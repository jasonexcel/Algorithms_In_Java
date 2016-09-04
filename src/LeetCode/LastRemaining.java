package LeetCode;

/**
 * Created by Shaun on 8/27/2016.
 */
public class LastRemaining {
    public DoublyLinkedList head;
    public DoublyLinkedList end;
    class DoublyLinkedList {
        int val;
        DoublyLinkedList nextRight = null;
        DoublyLinkedList nextLeft = null;

        public DoublyLinkedList(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        LastRemaining ins = new LastRemaining();
        System.out.println(ins.lastRemaining(10000000));
    }

    public int lastRemaining(int n) {
        int remaining = n;
        int start = 1;
        int step = 2;
        boolean left = true;
        while (remaining > 1) {
            remaining = remaining / 2;
            if (left)
                start = start + step * remaining - step / 2;
            else
                start = start - step * remaining + step / 2;
            // each removal, step(gap) is timed by 2,
            step *= 2;
            left = left ? false : true;
        }

        return start;
    }

    public int lastRemainingDLL(int n) {
        if(n <= 1) {
            return n;
        }
        DoublyLinkedList list = new DoublyLinkedList(1);
        head = list;
        for(int i=2; i<=n; i++) {
            DoublyLinkedList cur = new DoublyLinkedList(i);
            list.nextRight = cur;
            cur.nextLeft = list;
            list = cur;
        }
        end = list;
        int count = n;
        while(count > 1) {
            count = removeFromHead(count);
            if(count == 1) {
                break;
            }
            count = removeFromEnd(count);
        }
        return head.val;
    }

    public int removeFromHead(int count) {
        DoublyLinkedList dummyHead = new DoublyLinkedList(0);
        DoublyLinkedList dummyEnd = new DoublyLinkedList(0);
        dummyHead.nextRight = head;
        head.nextLeft = dummyHead;
        dummyEnd.nextLeft = end;
        end.nextRight = dummyEnd;

        int total = count;
        for(int i=0; i<total; i++) {
            if(i % 2 == 0) {
                head.nextLeft.nextRight = head.nextRight;
                if(head.nextRight != null) {
                    head.nextRight.nextLeft = head.nextLeft;
                }

                count--;
            }
            head = head.nextRight;
        }
        end = dummyEnd.nextLeft;
        head = dummyHead.nextRight;
        return count;
    }
    public int removeFromEnd(int count) {
        DoublyLinkedList dummyHead = new DoublyLinkedList(0);
        DoublyLinkedList dummyEnd = new DoublyLinkedList(0);
        dummyHead.nextRight = head;
        head.nextLeft = dummyHead;
        dummyEnd.nextLeft = end;
        end.nextRight = dummyEnd;
        int total = count;
        for(int i=0; i<total; i++) {
            if(i % 2 == 0) {
                end.nextRight.nextLeft = end.nextLeft;
                if(end.nextLeft != null) {
                    end.nextLeft.nextRight = end.nextRight;
                }
                count--;
            }
            end = end.nextLeft;
        }
        end = dummyEnd.nextLeft;
        head = dummyHead.nextRight;
        return count;
    }
}
