package com.xudt.algorithm.test;

import com.xudt.algorithm.array.Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 数组测试类
 * @Author: XuDT
 */
public class ArrayTest {
    private static final Logger log = LoggerFactory.getLogger(ArrayTest.class);
    public static void main(String[] args){
        Array arr = new Array();
        arr.add(0,1);
        arr.add(1,2);
        arr.add(2,3);
        arr.add(1,4);
        log.info("当前数组:{}",arr.toString());
        log.info("当前数组长度:{}",arr.getSize());
        arr.replace(1,5);
        arr.addFirst(6);
        arr.addLast(7);
        log.info("当前数组:{}",arr.toString());
        arr.resize(30);
        log.info("当前数组容量:{}",arr.getCapacity());
        log.info("当前数组是否包含元素5:{}",arr.contains(5));
        arr.removeFirst();
        log.info("删除数组第一个元素后:{}",arr.toString());
    }
}
