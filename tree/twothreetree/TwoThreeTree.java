package com.xudt.algorithm.structure.tree.twothreetree;

/**
 * @Description: 实现B树
 * @Author: XuDT
 */
public class TwoThreeTree {
    private TwoThreeTreeNode root = new TwoThreeTreeNode() ;

    /**
     * 查找关键字值
     * @param key 关键字
     * @return
     */
    public int find(long key){
        TwoThreeTreeNode curNode = root;
        int childNumber ;
        while(true){
            if((childNumber = curNode.findItem(key)) != -1){
                return childNumber;
            }else if(curNode.isLeaf()){//结点是叶结点
                return -1;
            }else{
                curNode = getNextChild(curNode,key);
            }
        }
    }

    /**
     * 获取下一个子结点
     * @param node
     * @param value
     * @return
     */
    public TwoThreeTreeNode getNextChild(TwoThreeTreeNode node,long value){
        int j;
        int numItems = node.getNumItems();
        for(j = 0 ; j < numItems ; j++){
            if(value < node.getItem(j).data){
                return node.getChild(j);
            }
        }
        return node.getChild(j);
    }

    /**
     * 插入数据项
     * @param value
     */
    public void insert(long value){
        TwoThreeTreeNode curNode = root;
        Data tempItem = new Data(value);
        while(true){
            //如果结点满数据项了，则分裂结点
            if(curNode.isFull()){
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, value);
            }else if(curNode.isLeaf()){//当前结点是叶结点
                break;
            }else{
                curNode = getNextChild(curNode, value);
            }
        }
        curNode.insertItem(tempItem);
    }

    /**
     * 结点分裂
     * @param node 结点
     */
    public void split(TwoThreeTreeNode node){
        Data itemB,itemC;
        TwoThreeTreeNode parent,child2,child3;
        int itemIndex;
        //itemC = node.removeItem();
        itemB = node.removeItem();
        child2 = node.disconnectChild(2);
        //child3 = node.disconnectChild(3);
        TwoThreeTreeNode newRight = new TwoThreeTreeNode();
        //如果当前结点是根结点，执行根分裂
        if(node == root){
            root = new TwoThreeTreeNode();
            parent = root;
            root.connectChild(0, node);
        }else{
            parent = node.getParent();
        }
        //处理父结点
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        for(int j = n-1; j > itemIndex ; j--){
            TwoThreeTreeNode temp = parent.disconnectChild(j);
            parent.connectChild(j+1, temp);
        }
        parent.connectChild(itemIndex+1, newRight);
        //处理新建的右结点
        //newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        //newRight.connectChild(1, child3);
    }

    /**
     * 输出树结点
     */
    public void displayTree(){
        recDisplayTree(root,0,0);
    }

    private void recDisplayTree(TwoThreeTreeNode node,int level,int childNumber){
        System.out.println("levle="+level+" child="+childNumber+" ");
        node.displayNode();
        int numItems = node.getNumItems();
        for(int j = 0; j < numItems+1 ; j++){
            TwoThreeTreeNode nextNode = node.getChild(j);
            if(nextNode != null){
                recDisplayTree(nextNode, level+1, j);
            }else{
                return;
            }
        }
    }
}

