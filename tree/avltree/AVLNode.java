package com.xudt.algorithm.tree.avltree;

/**
 * @Description: 平衡二叉树结点
 * @Author: XuDT
 */
public class AVLNode<T> {
    /**
     * 指向左边结点的分支
     */
    public AVLNode<T> leftChild;
    /**
     * 指向右边结点的分支
     */
    public AVLNode<T> rightChild;
    /**
     * 数据域
     */
    public T data;
    /**
     * 当前结点的高度
     */
    public int height;

    public AVLNode(T data) {
        this(null,null,data);
    }

    public AVLNode(AVLNode<T> leftChild, AVLNode<T> rightChild, T data) {
        this(leftChild,rightChild,data,0);
    }

    public AVLNode(AVLNode<T> leftChild, AVLNode<T> rightChild, T data, int height) {
        this.leftChild=leftChild;
        this.rightChild=rightChild;
        this.data=data;
        this.height = height;
    }

    public AVLNode<T> getLeft() {
        return leftChild;
    }

    public void setLeft(AVLNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public AVLNode<T> getRight() {
        return rightChild;
    }

    public void setRight(AVLNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
