package com.xudt.algorithm.test;

import com.xudt.algorithm.queue.LoopQueue;

/**
 * @Description: 链式队列测试类
 * @Author: XuDT
 */
public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
