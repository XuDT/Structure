package com.xudt.algorithm.queue;

/**
 * @Description: 使用链表实现队列
 * @Author: XuDT
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 元素数组
     */
    private E[] data;
    /**
     * 队列大小
     */
    private int size;
    /**
     * 队头
     */
    private int front;
    /**
     * 队尾
     */
    private int tail;

    /**
     * 构造方法
     * @param capacity 容量
     */
    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    /**
     * 无参构造方法
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 获取队列中的元素个数
     * @return int 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 获取队列的容量
     * @return int 容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 判断队列是否为空
     * @return true|为空，false|不为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        //判断队列是否满了
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队
     * @return E
     */
    @Override
    public E dequeue() {

        if (isEmpty()){
            throw new IllegalArgumentException("队列为空，无法出队");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    /**
     * 获取队头元素
     * @return E 元素
     */
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    /**
     * 将队列转换为字符串
     * @return Stirng 字符串
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i+1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    /**
     * 改变队列容量
     * @param newCapacity 容量
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}

