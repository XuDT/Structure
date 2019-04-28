package com.xudt.algorithm.test;

import com.xudt.algorithm.List.SinglyLinkedList;
import com.xudt.algorithm.tree.binarytree.BinaryTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 单向链表测试类
 * @Author: XuDT
 */
public class SinglyLinkedListTest {
    private static final Logger log = LoggerFactory.getLogger(BinaryTree.class);
    public static void main(String[] args){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        log.info(" 链表是否为空:");
        log.info("链表是否为空:", list.isEmpty());
        log.info(" 向链表中插入元素（A-B-C-D-E）:");
        String[] str = new String[]{"A", "B", "C", "D", "E"};
        for (String s : str){
            list.add(s);
        }
        list.print();
        log.info(" 在指定位置C插入一条数据F:");
        list.add(2, "F");
        list.print();
        log.info(" 获取指定位置2的数据:");
        String data = list.get(2);
        log.info("index为2的数据为：", data);
        log.info(" 移除指定位置2的数据:");
        list.remove(2);
        list.print();
        log.info(" 反转一个链表:");
        list.reverse();
        list.print();
    }
}
