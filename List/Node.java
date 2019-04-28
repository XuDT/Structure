package com.xudt.algorithm.List;

/**
 * @Description: 结点类
 * @Author: XuDT
 */
public class Node<E> {
    /**
     * 结点
     */
    public E item;
    /**
     * 下一个结点
     */
    public Node<E> next;
    /**
     * 上一个结点
     */
    public Node<E> prev;

    /**
     * 构造方法
     * @param item 结点
     * @param next 下一个结点
     */
    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    public <E> Node(E e, Object obj1, Object obj2) {
        this.item = item;
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
