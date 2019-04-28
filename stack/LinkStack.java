package com.xudt.algorithm.stack;

import com.xudt.algorithm.List.Node;

/**
 * @Description: 使用链表实现栈
 * @Author: XuDT
 */
public class LinkStack<E> implements Stack<E> {

    /**
     * 栈的大小
     */
    private int size;

    /**
     * 栈顶
     */
    private Node<E> top;

    /**
     * 构造方法
     */
    public LinkStack() {
        top = null;
        size = 0;
    }

    /**
     * 构造方法
     * @param data 元素
     */
    public LinkStack(E data) {
        this();
        Node<E> newNode = new Node<>(data, null);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * 判断栈是否为空
     * @return true|为空，false|不为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入栈
     * @param data
     */
    @Override
    public void push(E data) {
        Node<E> newNode = new Node<>(data, null);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * 出栈，并删除栈顶元素
     * @return
     */
    @Override
    public E pop() {
        //检查栈是否为空
        checkIsEmpty();
        Node<E> node = top;
        //top指针移动
        top = top.next;
        //删除栈顶元素
        node.next = null;
        size--;
        return node.item;
    }

    /**
     * 查询栈顶元素
     * @return 元素
     */
    @Override
    public E peek() {
        //检查栈是否为空
        checkIsEmpty();
        return top.item;
    }

    /**
     * 清空栈
     */
    @Override
    public void clear() {
        for (Node<E> node = top; node != null; ) {
            Node<E> next = node.next;
            node.item = null;
            node = next;
        }
        size = 0;
    }

    /**
     * 获取栈的长度
     * @return
     */
    @Override
    public int length() {
        return size;
    }

    /**
     * 将栈转换为字符串
     * @return String 字符串
     */
    @Override
    public String toString() {
        //链栈为空链栈时
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = top; current != null
                    ; current = current.next) {
                sb.append(current.item.toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    /**
     * 栈为空则抛出异常
     */
    private void checkIsEmpty() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("当前栈为空");
        }
    }
}
