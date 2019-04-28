package com.xudt.algorithm.queue;

import java.util.Arrays;

/**
 * @Description: 使用数组实现顺序队列
 * @Author: XuDT
 */
public class SequenceQueue<E> implements Queue<E> {

    /**
     * 队列默认长度
     */
    private int DEFAULT_SIZE = 10;
    /**
     * 保存队列元素的数组
     */
    private Object[] elementData;
    /**
     * 保存数组的长度
     */
    private int capacity;
    /**
     * 队头
     */
    private int front = 0;
    /**
     * 队尾
     */
    private int rear = 0;

    /**
     * 构造方法
     */
    public SequenceQueue() {
        this.capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    /**
     * 构造方法
     * @param value 元素
     */
    public SequenceQueue(E value) {
        this();
        elementData[0] = value;
        rear++;
    }

    /**
     * 以指定长度的数组来创建队列
     * @param value    指定顺序中的第一个元素
     * @param initSize 数组长度
     */
    public SequenceQueue(E value, int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = value;
        rear++;
    }

    /**
     * 判断队列是否为空
     * @return true|为空，false|不为空
     */
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 入队
     * @param data 元素
     */
    @Override
    public void enqueue(E data) {
        //检查队列是否已经满了
        checkQueueIsFull();
        elementData[rear++] = data;
    }

    /**
     * 出队，推出元素
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public E dequeue() {
        //检查队列是否为空
        checkQueueIsEmpty();
        E oldValue = (E) elementData[front];
        //释放队列已经出栈的元素
        elementData[front++] = null;
        return oldValue;
    }

    /**
     * 清空
     */
    public void clear() {
        Arrays.fill(elementData, null);
        front = rear = 0;
    }

    /**
     * 获取顺序队列的大小
     * @return int
     */
    public int getSize() {
        return rear - front;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = front; i < rear; i++) {
                sb.append(elementData[i].toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    /**
     * 判断队列是否为空，若为空则抛出IndexOutOfBoundsException
     */
    private void checkQueueIsEmpty() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
    }

    /**
     * 判断队列是否已经满了，若满了则抛出IndexOutOfBoundsException
     */
    private void checkQueueIsFull() {
        if (rear > capacity - 1) {
            throw new IndexOutOfBoundsException("队列已经满了");
        }
    }
}