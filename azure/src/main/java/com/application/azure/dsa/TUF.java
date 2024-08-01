package com.application.azure.dsa;

class Queue {

    private int array[];
    private int start;
    private int end;
    private int currentSize;
    private int maxSize;

    public Queue() {
        this.array = new int[16];
        this.start = -1;
        this.end = -1;
        this.currentSize = 0;

    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.start = -1;
        this.end = -1;
        this.currentSize = 0;
    }

    // insert : enqueue
    public void enqueue(int data) {
        if (currentSize == maxSize) {
            System.out.println("Queue is full\\nExiting...");
            System.exit(1);
        }
        if (end == -1) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % maxSize;
        }
        array[end] = data ;
        System.out.println("The element pushed is " + data);
        currentSize++ ;
    }
    // delete : dequeue
    public int dequeue() {
        if (start == -1) {
            System.out.println("Queue is Empty\\nExiting...");
            System.exit(1);
        }
        int poppedElement = array[start];
        // if queue is having only one element
        if(currentSize == 1) {
            start = -1;
            end = -1;
        }else {
            start = (start + 1) % maxSize;
        }
        currentSize-- ;
        return poppedElement ;
    }
    public int top() {
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return array[start];
    }
    public int size() {
        return currentSize;
    }
}
public class TUF {
    public static void main(String args[]) {
        Queue q = new Queue(6);
        q.enqueue(4);
        q.enqueue(14);
        q.enqueue(24);
        q.enqueue(34);
        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.dequeue());
        System.out.println("The peek of the queue after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}
