package com.xudt.algorithm.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 实现双向链表
 * @Author: XuDT
 */
public class DoubleLinkedList<E> implements List<E> {

    public static final Logger log = LoggerFactory.getLogger(DoubleLinkedList.class);

    /**
     * 链表大小
     */
    int size = 0;
    /**
     * 头结点
     */
    Node<E> first;

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = null;
        size = 0;
    }

    /**
     * 判断链表是否为空
     * @return true|为空，false|不为空
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在链表的指定位置添加一个元素
     * @param index 指定位置
     * @param e     新增元素
     */
    @Override
    public void add(int index, E e) {
        //检查index是否越界或元素e是否为空
        if (checkIndex(index) || checkElem(e)) {
            return;
        }
        Node<E> newNode = new Node<>(e, null, null);
        //表头为空，添加一个头元素
        if (index == 0) {
            //表头为空
            if (isEmpty()) {
                first = newNode;
            }
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        } else if (index == size - 1) {
            //在末尾添加
            Node<E> node = node(index - 1);
            node.next = newNode;
            newNode.prev = node;
        } else {
            //在中部添加
            //获取添加元素的前一个
            Node<E> node = node(index - 1);
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
            newNode.prev = node;
        }
    }

    /**
     * 在链表中添加一个元素
     * @param e 新增元素
     */
    @Override
    public void add(E e) {
        //检查元素e是否为空
        if (checkElem(e)) {
            return;
        }
        Node<E> newNode = new Node<>(e, null, null);
        //头结点不存在
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<E> node = node(size - 1);
            //在尾部新增
            node.next = newNode;
            //获取新增元素的前一个
            newNode.prev = node;
        }
        size++;
    }

    /**
     * 移除链表中指定位置的元素
     * @param index 指定位置
     */
    @Override
    public void remove(int index) {
        //检查下标是否越界
        if (checkIndex(index)) {
            return;
        }
        //移除头结点
        if (index == 0) {
            first.next.prev = null;
            first = first.next;
        } else if (index == size - 1) {
            //移除尾部元素
            Node<E> node = node(index - 1);
            node.next = null;
        } else {
            //移除中部元素
            Node<E> node = node(index - 1);
            node.next = node.next.next;
            node.next.next.prev = node;
        }
        size--;
    }

    /**
     * 获取指定位置元素
     * @param index 指定位置
     * @return E 元素
     */
    @Override
    public E get(int index) {
        //检查下标是否越界
        if (checkIndex(index)) {
            return null;
        }
        return node(index).item;
    }

    /**
     * 输出链表
     */
    @Override
    public void print() {
        Node<E> cur = first;
        while (cur != null) {
            System.out.printf(cur.item + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 获取指定位置的Node
     * @param index 指定位置
     * @return Node
     */
    public Node<E> node(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    /**
     * 检查index是否越界
     * @param index 下标
     * @return true|是，false|否
     */
    public boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            log.info("数组下标越界");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 元素是否为空
     * @param e 元素
     * @return true|为空，false|不为空
     */
    public boolean checkElem(E e) {
        if (e == null) {
            log.info("元素不能为空");
            return true;
        } else {
            return false;
        }
    }
}


