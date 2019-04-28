package com.xudt.algorithm.queue;

/**
 * @Description: 队列接口
 * @Author: XuDT
 */
public interface Queue<E> {

    /**
     * 获取队列中的元素个数
     * @return int 元素个数
     */
    public int getSize();

    /**
     * 判断队列是否为空
     * @return true|为空，false|不为空
     */
    public boolean isEmpty();

    /**
     * 入队
     * @param e 元素
     */
    public void enqueue(E e);

    /**
     * 出队
     * @return E
     */
    public E dequeue();
}