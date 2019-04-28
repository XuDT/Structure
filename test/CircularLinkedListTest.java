package com.xudt.algorithm.test;

import com.xudt.algorithm.List.CircularLinkedList;
import com.xudt.algorithm.tree.binarytree.BinaryTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 循环链表测试类
 * @Author: XuDT
 */
public class CircularLinkedListTest {
    private static final Logger log = LoggerFactory.getLogger(BinaryTree.class);
    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        log.info(" 链表是否为空:");
        log.info("链表是否为空:", list.isEmpty());
        log.info(" 向链表中插入元素（A-B-C-D-E）:");
        String[] str = new String[]{"A", "B", "C", "D", "E"};
        for (String s : str){
            list.add(s);
        }
        log.info(" 在指定位置C插入一条数据F:");
        list.add(2, "F");
        list.print();
        log.info(" 获取指定位置2的数据:");
        String data = list.get(2);
        log.info("index为2的数据为：", data);
        log.info(" 移除指定位置2的数据:");
        list.remove(4);
        list.print();
        log.info(" 判断链表是否存在环:");
        log.info("链表list是否存在环:", list.hasCycle());

    }
}
