package com.xudt.algorithm.queue;

import com.xudt.algorithm.array.Array;

/**
 * @Description: 使用数组实现队列
 * @Author: XuDT
 */
public class ArrayQueue<E> implements Queue<E> {

    /**
     * 数组对象
     */
    private Array<E> array;

    /**
     * 构造方法
     * @param capacity 容量
     */
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 无参构造方法
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 获取队列中的元素个数
     * @return int 元素个数
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * 获取队列的容量
     * @return int 队列容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 判断队列是否为空
     * @return true|为空，false|不为空
     */
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * 入队
     * @param e 元素
     */
    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    /**
     * 第一个元素出队
     * @return E
     */
    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    /**
     * 获取队头元素
     * @return E 元素
     */
    public E getFront(){
        return array.getFirst();
    }

    /**
     * 将队列转换为字符串
     * @return Stirng 字符串
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}

