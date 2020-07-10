package com.zzy.structure.queue;

/**
 * @description:
 * @author: zzy
 * @time: 2020/7/10 10:39
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if((tail+1)%n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail+1)%n;
        return true;
    }
    /**
     * 出队
     * @return
     */
    public String dequeue() {
        //队空
        if(head==tail) {
            return null;
        }
        String ret = items[head];
        head = (head+1)%n;
        return ret;
    }
}

