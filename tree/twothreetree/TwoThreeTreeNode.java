package com.xudt.algorithm.structure.tree.twothreetree;

/**
 * @Description: 2-3树结点操作类
 * @Author: XuDT
 */
public class TwoThreeTreeNode {
    private static final int ORDER = 3;
    /**
     * 该结点数据项个数
     */
    private int numItems;
    /**
     * 父结点
     */
    private TwoThreeTreeNode parent;
    /**
     * 存储子结点的数组，最多有3个子结点
     */
    private TwoThreeTreeNode childArray[] = new TwoThreeTreeNode[ORDER];
    /**
     * 存放数据项的数组，一个结点最多有2个数据项
     */
    private Data itemArray[] = new Data[ORDER-1];

    /**
     * 连接子结点
     * @param childNum 子结点个数
     * @param child 子结点
     */
    public void connectChild(int childNum, TwoThreeTreeNode child){
        childArray[childNum] = child;
        if(child != null){
            child.parent = this;
        }
    }

    /**
     * 断开与子结点的连接，并返回该子结点
     * @param childNum 结点个数
     * @return
     */
    public TwoThreeTreeNode disconnectChild(int childNum){
        TwoThreeTreeNode tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    /**
     * 获取结点的某个子结点
     * @param childNum 结点个数
     * @return
     */
    public TwoThreeTreeNode getChild(int childNum){
        return childArray[childNum];
    }

    /**
     * 获取父结点
     * @return
     */
    public TwoThreeTreeNode getParent(){
        return parent;
    }

    /**
     * 判断是否为叶子结点
     * @return
     */
    public boolean isLeaf(){
        return (childArray[0] == null) ? true : false;
    }

    /**
     * 获取结点数据项个数
     * @return
     */
    public int getNumItems(){
        return numItems;
    }

    /**
     * 获取结点的某个数据项
     * @param index
     * @return
     */
    public Data getItem(int index){
        return itemArray[index];
    }

    /**
     * 判断结点的数据项是否满了（最多2个）
     * @return
     */
    public boolean isFull(){
        return (numItems == ORDER-1) ? true:false;
    }

    /**
     * 找到数据项在结点中的位置
     * @param key 数据项
     * @return
     */
    public int findItem(long key){
        for(int j = 0 ; j < ORDER-1 ; j++){
            if(itemArray[j]==null){
                break;
            }else if(itemArray[j].data == key){
                return j;
            }
        }
        return -1;
    }

    /**
     * 将数据项插入到结点
     * @param newItem
     * @return
     */
    public int insertItem(Data newItem){
        numItems++;
        long newKey = newItem.data;
        for(int j = ORDER-2 ; j >= 0 ; j--){
            //如果为空，继续向前循环
            if(itemArray[j] == null){
                continue;
            }else{
                //保存结点某个位置的数据项
                long itsKey = itemArray[j].data;
                //如果比新插入的数据项大
                if(newKey < itsKey){
                    //将大数据项向后移动一位
                    itemArray[j+1] = itemArray[j];
                }else{
                    //如果比新插入的数据项小，则直接插入
                    itemArray[j+1] = newItem;
                    return j+1;
                }
            }
        }
        //如果都为空，或者都比待插入的数据项大，则将待插入的数据项放在结点第一个位置
        itemArray[0] = newItem;
        return 0;
    }

    /**
     * 移除结点的数据项
     * @return
     */
    public Data removeItem(){
        Data temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }

    /**
     * 输出结点的所有数据项
     */
    public void displayNode(){
        for(int j = 0 ; j < numItems ; j++){
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }

}
