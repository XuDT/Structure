package com.xudt.algorithm.test;

import com.xudt.algorithm.tree.binarytree.BinaryTree;
import com.xudt.algorithm.tree.binarytree.BinaryTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二叉树测试类
 * @Author: XuDT
 */
public class BinaryTreeTest {
    private static final Logger log = LoggerFactory.getLogger(BinaryTree.class);
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        createBinaryTree();
        int height = binaryTree.getHeight();
        log.info("二叉树高度:{}", height);
        int size = binaryTree.getSize();
        log.info("二叉树结点:{}", size);
        binaryTree.preOrder(binaryTree.root);
        binaryTree.midOrder(binaryTree.root);
        binaryTree.postOrder(binaryTree.root);
        BinaryTreeNode copy = binaryTree.copy(binaryTree.root);
        binaryTree.preOrder(copy);
        boolean euqal = binaryTree.euqal(binaryTree.root, copy);
        String[] strs = new String[]{"A", "B", "D", "#", "#", "E", "#", "#", "C", "F", "#", "#", "#"};
        List<String> data = new ArrayList<>();
        for (String s : strs) {
            data.add(s);
        }
        binaryTree.preOrderNonRecursive(binaryTree.root);
        binaryTree.midOrderNonRecursive(binaryTree.root);
        binaryTree.postOrderNonRecursive(binaryTree.root);
        List<List<String>> levelOrder = binaryTree.levelOrder(binaryTree.root);
        for (List<String> list : levelOrder) {
            log.info(list.toString());
        }
    }
    /**
     * 构建二叉树
     *         A
     *       /  \
     *      B    C
     *     / \  /
     *    D  E F
     */
    public static void createBinaryTree() {
        BinaryTreeNode root = null;
        BinaryTreeNode nodeB = new BinaryTreeNode(2, "B");
        BinaryTreeNode nodeC = new BinaryTreeNode(3, "C");
        BinaryTreeNode nodeD = new BinaryTreeNode(4, "D");
        BinaryTreeNode nodeE = new BinaryTreeNode(5, "E");
        BinaryTreeNode nodeF = new BinaryTreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.leftChild = nodeF;
    }
}
