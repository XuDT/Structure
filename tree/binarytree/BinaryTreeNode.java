package com.xudt.algorithm.tree.binarytree;

/**
 * @Description: 树结点类
 * @Author: XuDT
 */
public class BinaryTreeNode<T> {
    /**
     * 结点
     */
    public int index;
    /**
     * 数据域
     */
    public T data;
    /**
     * 指向左孩子的分支
     */
    public BinaryTreeNode leftChild;
    /**
     * 指向右孩子的分支
     */
    public BinaryTreeNode rightChild;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode(int index, T data) {
        this.index = index;
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}