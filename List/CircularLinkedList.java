package com.xudt.algorithm.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 实现循环链表
 * @Author: XuDT
 */
public class CircularLinkedList<E> implements List<E> {
    public static final Logger log = LoggerFactory.getLogger(CircularLinkedList.class);

    /**
     * 链表大小
     */
    int size = 0;
    /**
     * 头结点
     */
    Node<E> first;
    /**
     * 最后一个结点
     */
    Node<E> last;

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        //循环清空每个结点
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = null;
        last = null;
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
     * 在链表指定位置新增一个元素
     * @param index 指定位置
     * @param e     新增元素
     */
    @Override
    public void add(int index, E e) {
        //检查index是否越界或元素e是否为空
        if (checkIndex(index) || checkElem(e)) {
            return;
        }
        Node<E> newNode = new Node<>(e, null);
        //在头结点处插入
        if (index == 0) {
            newNode.next = first;
            first = newNode;
            last = newNode;
        } else if (index == size - 1) {
            //在尾部插入
            newNode.next = first;
            last.next = newNode;
            last = newNode;
        } else {
            //在中部插入
            //获取指定位置前一个元素
            Node<E> node = node(index - 1);
            newNode.next = node.next;
            node.next = newNode;
        }
        size++;
    }

    /**
     * 在链表末尾添加元素
     * @param e 新增元素
     */
    @Override
    public void add(E e) {
        //检查元素是否存在
        if (checkElem(e)) {
            return;
        }
        Node<E> newNode = new Node<>(e, null);
        //头结点不存在
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.next = first;
            last = newNode;
        }
        size++;
    }

    /**
     * 移除指定位置的元素
     * @param index 指定位置
     */
    @Override
    public void remove(int index) {
        //检查index是否越界
        if (checkIndex(index)) {
            return;
        }
        //移除头元素
        if (index == 0) {
            first = first.next;
            last = first;
        } else if (index == size - 1) {
            //移除尾元素
            //获取移除元素的前一个
            Node<E> node = node(index - 1);
            node.next = first;
            last = node;
        } else {
            //移除中间的元素
            //获取移除元素的前一个
            Node<E> node = node(index - 1);
            node.next = node.next.next;
        }
        size--;
    }

    /**
     * 获取指定元素的数据
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
     * 输出循环链表
     */
    @Override
    public void print() {
        if (isEmpty()) {
            log.info("链表为空");
            return;
        }
        Node<E> cur = first;
        do {
            System.out.printf(cur.item + " ");
            cur = cur.next;
        } while (cur != first);
        System.out.println();
    }

    /**
     * 判断链表有没有环
     * @return true|有，false|无
     */
    public boolean hasCycle() {
        if (first == null || first.next == null) {
            return false;
        }
        Node<E> fast = first;
        Node<E> slow = first;
        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    /**
     * 获取指定位置的Node
     * @param index 指定位置
     * @return NOde
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
     * 检查元素是否为空
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
