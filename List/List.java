package com.xudt.algorithm.List;

/**
 * @Description: 线性表接口
 * @Author: XuDT
 */
public interface List<E> {
    /**
     * 清空链表
     */
    public void clear();

    /**
     * 判断链表是否为空
     * @return true|为空，false|不为空
     */
    public boolean isEmpty();

    /**
     * 在链表指定位置新增一个元素
     * @param index 指定位置
     * @param e 新增元素
     */
    public void add(int index, E e);

    /**
     * 在链表末尾添加元素
     * @param e 新增元素
     */
    public void add(E e) ;

    /**
     * 移除指定位置的元素
     * @param index 指定位置
     */
    public void remove(int index);

    /**
     * 获取指定元素的数据
     * @param index 指定位置
     * @return E 元素
     */
    public E get(int index);

    /**
     * 输出循环链表
     */
    public void print();

    /**
     * 获取指定位置的Node
     * @param index 指定位置
     * @return NOde
     */
    public Node<E> node(int index);

    /**
     * 检查index是否越界
     * @param index 下标
     * @return true|是，false|否
     */
    public boolean checkIndex(int index);

    /**
     * 检查元素是否为空
     * @param e 元素
     * @return 为空则返回true
     */
    public boolean checkElem(E e) ;
}

