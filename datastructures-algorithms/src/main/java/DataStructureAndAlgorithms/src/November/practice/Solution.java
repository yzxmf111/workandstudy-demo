package November.practice;

import java.util.LinkedList;

class CQueue {
    LinkedList<Integer> A;
    LinkedList<Integer> B;

    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();//这就是栈.implment Deque
    }

    @Override
    public String toString() {
        return "CQueue{" +
                "A=" + A +
                ", B=" + B +
                '}';
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        if (A.isEmpty()) {
            return -1;
        }
        if (!A.isEmpty()) {
            while (!A.isEmpty()) {
                B.addLast(A.removeLast());
            }
        }
        return B.removeLast();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(5);
        cQueue.appendTail(4);
        cQueue.appendTail(3);
        System.out.println(cQueue);
        cQueue.deleteHead();
        System.out.println(cQueue);
    }
}