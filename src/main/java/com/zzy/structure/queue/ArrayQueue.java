package com.zzy.structure.queue;

/**
 * @description:数组实现队列，顺序队列
 * @author: zzy
 * @time: 2020/7/10 10:33
 */

public class ArrayQueue {
    private String[] items;
    private int n = 0;
    //队头
    private int head = 0;
    //队尾
    private int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队列
     * @param item 入队列的元素
     * @return 入队成功返回true
     */
    public boolean enqueue(String item) {
        if(tail==n){
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 由于每次出队都相当于移除第一个元素（数组下标为0的），多次以后，导致空间的利用率不高，优化
     * @param item
     * @param flag 是否优化
     * @return
     */
    public boolean enqueue(String item,boolean flag) {
        if(!flag) {
            enqueue(item);
            return true;
        }
        //tail=n表示队列没有空间
        if(tail ==n) {
            //tail=n&&head=0 表示整个队列没有空间了
            if(head==0){
                return false;
            }
            for(int i=head;i<tail;++i) {
                items[i - head] = items[i];
            }
            //搬移完以后，重新更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;

    }

    /**
     * 出队列
     * @return
     */
    public String dequeue() {
        //head=tail 表示队列为空
        if(head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }

}

