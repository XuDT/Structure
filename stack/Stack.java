package com.xudt.algorithm.stack;

/**
 * @Description: 栈接口
 * @Author: XuDT
 */
public interface Stack<E> {

    /**
     * 判断栈是否为空
     * @return true|为空，false|不为空
     */
    public boolean isEmpty();

    /**
     * 入栈
     * @param data E 元素
     */
    public void push(E data);

    /**
     * 出栈
     * @return E
     */
    public E pop();

    /**
     * 查询栈顶元素
     * @return E 元素
     */
    public E peek();

    /**
     * 获取栈的长度
     * @return int 长度
     */
    public int length();

    /**
     * 清空栈
     */
    public void clear();
}
