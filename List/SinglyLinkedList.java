package com.xudt.algorithm.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 实现单链表
 * @Author: XuDT
 */
public class SinglyLinkedList<E> implements List<E>{
    public static final Logger log = LoggerFactory.getLogger(SinglyLinkedList.class);

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
     * 为链表添加一个元素
     * @param index 指定位置
     * @param e 元素
     */
    @Override
    public void add(int index, E e) {
        //检查index是否越界或元素e是否为空
        if (checkIndex(index) || checkElem(e)) {
            return;
        }
        Node<E> newNode = new Node<>(e, null);
        //在头结点插入
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> node = node(index - 1);
            //在中间和末尾结点插入
            newNode.next = node.next;
            //获取index的前一个元素
            node.next = newNode;
        }
        size++;
    }

    /**
     * 在链表尾添加一个元素
     * @param e 新增元素
     */
    @Override
    public void add(E e) {
        //检查元素e是否为空
        if (checkElem(e)) {
            return;
        }
        Node<E> newNode = new Node<>(e, null);
        //获取当前末尾结点
        //如果头结点不存在则创建
        if (isEmpty()) {
            first = newNode;
        } else {
            //获取到需要添加的头一个
            Node<E> node = node(size - 1);
            node.next = newNode;
        }
        size++;
    }

    /**
     * 移除一个指定位置的元素
     * @param index 指定位置
     */
    @Override
    public void remove(int index) {

        if (checkIndex(index)) {
            return;
        }
        //移除头元素
        if (index == 0) {
            first = first.next;
        } else {
            //移除中间或者尾部元素
            Node<E> delNode = node(index - 1);
            //获取index的前一个元素
            delNode.next = delNode.next.next;
        }
        size--;
    }

    /**
     * 获取指定位置的元素
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
            System.out.print(cur.item + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 反转一个单链表
     */
    public void reverse() {

        Node<E> cur = first;
        Node<E> prev = null;
        while (cur != null) {
            Node<E> temp = prev;
            prev = cur;
            cur = cur.next;
            prev.next = temp;
        }
        first = prev;
    }

    /**
     * 检查index是否越界
     * @param index
     * @return true|是，false|否
     */
    public boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("index越界");
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
            System.out.println("元素不能为空");
            return true;
        } else {
            return false;
        }
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
}
