package com.xudt.algorithm.test;

import com.xudt.algorithm.queue.ArrayQueue;

/**
 * @Description: 数组队列测试类
 * @Author: XuDT
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 5 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
