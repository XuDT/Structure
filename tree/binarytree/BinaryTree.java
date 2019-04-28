package com.xudt.algorithm.tree.binarytree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 实现二叉树
 * @Author: XuDT
 */
public class BinaryTree {
    private static final Logger log = LoggerFactory.getLogger(BinaryTree.class);

    /**
     * 根结点
     */
    public BinaryTreeNode root = null;

    /**
     * 初始化根结点
     */
    public BinaryTree() {
        root = new BinaryTreeNode(1, "A");
    }


    /**
     * 获取二叉树的深度
     * @return int 深度
     */
    public int getHeight() {
        return getHeight(root);
    }

    /**
     * 获取二叉树的深度
     * @param root
     * @return
     */
    private int getHeight(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int i = getHeight(root.leftChild);
            int j = getHeight(root.rightChild);
            return i >= j ? i + 1 : j + 1;
        }
    }

    /**
     * 获取二叉树的结点数
     * @return
     */
    public int getSize() {
        return getSize(root);
    }

    /**
     * 获取二叉树的结点数
     * @param root
     * @return
     */
    private int getSize(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getSize(root.leftChild) + getSize(root.rightChild);
        }
    }

    /**
     * 前序遍历（中左右）
     * @param root
     */
    public void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    /**
     * 中序遍历（左中右）
     * @param root
     */
    public void midOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            midOrder(root.leftChild);
            midOrder(root.rightChild);
        }
    }

    /**
     * 后序遍历（左右中）
     * @param root
     */
    public void postOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
        }
    }

    /**
     * 前序遍历非递归算法
     * @param root
     */
    public void preOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        nodeStack.push(null);
        while (root != null) {
            //访问根结点
            if (root.rightChild != null)
                //当前结点右子树不为空则放入栈中
                nodeStack.push(root.rightChild);
            //访问左子树
            if (root.leftChild != null)
                root = root.leftChild;
            else root = nodeStack.pop();
        }
    }

    /**
     * 中序遍历非递归算法
     * @param root
     */
    public void midOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        do {
            while (root != null) {
                nodeStack.push(root);
                root = root.leftChild;
            }
            if (!nodeStack.empty()) {
                root = nodeStack.pop();
                root = root.rightChild;
            }
        } while (root != null || !nodeStack.empty());
    }

    /**
     * 后序遍历非递归算法
     * @param root
     */
    public void postOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        //上一个结点
        BinaryTreeNode prev = root;
        do {
            while (root != null) {
                nodeStack.push(root);
                root = root.leftChild;
            }
            //访问当前结点的右结点
            if (!nodeStack.empty()) {
                //获取右子树
                BinaryTreeNode temp = nodeStack.peek().rightChild;
                //不存在右子树或右子树已经访问过，访问父结点
                if (temp == null || temp == prev) {
                    root = nodeStack.pop();
                    //记录访问过的结点
                    prev = root;
                    //当前结点置空
                    root = null;
                } else {
                    //存在右子树，需要优先访问右子树
                    root = temp;
                }
            }
        } while (root != null || !nodeStack.empty());
    }

    /**
     * 层序遍历
     * @param root
     */
    public List<List<String>> levelOrder(BinaryTreeNode root) {
        List<List<String>> reList = new ArrayList<>();
        Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
        //压入根结点
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            List<String> subList = new ArrayList<>();
            while (levelSize != 0) {
                BinaryTreeNode temp = nodeQueue.poll();
                subList.add(temp.getData() + "");
                if (temp.leftChild != null) nodeQueue.offer(temp.leftChild);
                if (temp.rightChild != null) nodeQueue.offer(temp.rightChild);
                levelSize--;
            }
            reList.add(subList);
        }
        return reList;
    }

    /**
     * 复制二叉树
     * @param parent
     * @return
     */
    public BinaryTreeNode copy(BinaryTreeNode parent) {
        if (parent == null)
            return null;
        //构造根结点
        BinaryTreeNode temp = new BinaryTreeNode(parent.getIndex(), parent.getData());
        //递归构造左子树
        temp.leftChild = copy(parent.leftChild);
        //递归构造右子树
        temp.rightChild = copy(parent.rightChild);
        return temp;
    }

    /**
     * 判断两棵树是否相等
     * @param s
     * @param t
     * @return
     */
    public boolean euqal(BinaryTreeNode s, BinaryTreeNode t) {
        if (s == null && t == null)
            return true;
        if (s != null && t != null && s.data == t.data &&
                euqal(s.leftChild, t.leftChild) &&
                euqal(s.rightChild, t.rightChild))
            return true;
        else
            return false;
    }
}
