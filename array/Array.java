package com.xudt.algorithm.array;

/**
 * @Description: 实现数组相关操作
 * @Author: XuDT
 */
public class Array<E> {
    /**
     * 保存元素的数组
     */
    private E[] data;
    /**
     * 数组中元素的个数
     */
    private int size;
    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * 初始化数组
     * @param capacity 容量
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 初始化数组
     */
    public Array() {
        this(DEFAULT_SIZE);
    }

    /**
     * 获取容量
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前数组元素个数
     * @return 数组元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组是否为空
     * @return true|为空，false|不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组的末尾添加元素
     * @param e 添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组的头部添加元素
     * @param e 添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在指定位置添加元素
     * @param index 指定位置
     * @param e     添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数组下标越界");
        }
        //如果数组满了，进行扩容两倍
        if (size == data.length) {
            resize(2 * data.length);
        }
        //判断插入的下标是否小于数组元素个数，如果小于，则将下标后的元素往后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取指定位置的元素
     * @param index 指定位置
     * @return E 数组元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标越界");
        }
        return data[index];
    }

    /**
     * 获取头部元素
     * @return E 头部元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取尾部元素
     *
     * @return E 尾部元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 替换指定位置的元素
     * @param index 指定位置
     * @param e     替换元素
     */
    public void replace(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标越界");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含该元素
     * @param e 元素
     * @return true|是 ，false|否
     */
    public boolean contains(E e) {
        for (E x : data) {
            if (x.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素e在数组中对应的索引，如果不存在则返回 -1
     * @param e 元素
     * @return int 元素索引
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中指定索引的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标越界");
        }
        E ret = data[index];
        //判断删除下标是否小于数组元素个数，如果小于，则需将下标之后的元素往前移一位
        for (int i = index + 1; i <= size - 1; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * 从数组中删除最后一个元素
     * @return E
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除第一个元素
     *
     * @return E
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中指定的元素e
     * @param e 指定元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 将数组转换为字符串
     * @return String 数组的字符串形式
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("元素个数size = %d , 容量capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 修改数组容量
     * @param newCapacity
     */
    @SuppressWarnings("unchecked")
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}

