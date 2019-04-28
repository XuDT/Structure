package com.xudt.algorithm.test;

import com.xudt.algorithm.tree.avltree.AVLTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: AVL树测试类
 * @Author: XuDT
 */
public class AVLTreeTest {
    private static final Logger log = LoggerFactory.getLogger(ArrayTest.class);
    public  static void main(String arg[]){
        AVLTree<Integer> avlTree=new AVLTree<>();
        //构建一棵AVL树
        for (int i = 1; i < 10 ; i++) {
            avlTree.add(i);
        }
        avlTree.printTree(avlTree.root);
        //删除3,8，触发旋转平衡操作
        avlTree.remove(8);
        avlTree.remove(3);
        avlTree.printTree(avlTree.root);
        log.info("最小值结点为：{}:", avlTree.findMin());
        log.info("最大值结点为：{}", avlTree.findMax());
        log.info("是否包含数据为5的结点：{} ", avlTree.contains(5) );
        log.info("当前树的先序遍历为：{}", avlTree.preOrder(avlTree.root));
        log.info("当前树的中序遍历为：{}", avlTree.inOrder(avlTree.root));
        log.info("当前树的后序遍历为：{}", avlTree.postOrder(avlTree.root));

    }
}
