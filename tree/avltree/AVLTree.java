package com.xudt.algorithm.tree.avltree;


/**
 * @Description: 实现平衡二叉树
 * @Author: XuDT
 */
public class AVLTree<T extends Comparable>{
    /**
     * 根结点
     */
    public AVLNode<T> root;

    /**
     * 当前树是否为空
     * @return true|为空，false|不为空
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 当前树的大小
     * @return int 树的大小
     */
    public int size() {
        return size(root);
    }

    /**
     * 获取当前树的大小
     * @param subtree
     * @return int 树的大小
     */
    public int size(AVLNode<T> subtree){
        if(subtree == null){
            return 0;
        }else {
            return size(subtree.leftChild) + 1 + size(subtree.rightChild);
        }
    }

    /**
     * 当前树的高度
     * @return int 树的高度
     */
    public int height() {
        return height(root);
    }


    /**
     * 获取当前树的高度
     * @param p 结点
     * @return int 树的高度
     */
    public int height(AVLNode<T> p){
        return p == null ? -1 : p.height;
    }

    /**
     * 先序遍历
     * @param subtree
     * @return String
     */
    public String preOrder(AVLNode<T> subtree){
        StringBuilder sb = new StringBuilder();
        if (subtree != null) {
            //先访问根结点
            sb.append(subtree.data).append(" ");
            //访问左子树
            sb.append(preOrder(subtree.leftChild));
            //访问右子树
            sb.append(preOrder(subtree.rightChild));
        }
        return sb.toString();
    }

    /**
     * 中序遍历
     * @param subtree
     * @return String
     */
    public String inOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree != null) {
            //访问左子树
            sb.append(inOrder(subtree.leftChild));
            //访问根结点
            sb.append(subtree.data).append(" ");
            //访问右子树
            sb.append(inOrder(subtree.rightChild));
        }
        return sb.toString();
    }


    /**
     * 后序遍历
     * @param subtree
     * @return String
     */
    public String postOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree != null){
            //访问左子树
            sb.append(postOrder(subtree.leftChild));
            //访问右子树
            sb.append(postOrder(subtree.rightChild));
            //访问根结点
            sb.append(subtree.data).append(" ");
        }
        return sb.toString();
    }

    /**
     * 插入
     * @param data
     */
    public void add(T data) {
        if (data == null){
            throw new RuntimeException("插入数据不能为空");
        }
        this.root = add(data, root);
    }

    /**
     * 插入结点
     * @param data
     * @param p
     * @return
     */
    public AVLNode<T> add(T data , AVLNode<T> p){
        //p为空说明没有孩子结点,可以创建新结点插入
        if(p == null){
            p = new AVLNode<T>(data);
        }
        int result = data.compareTo(p.data);
        //向左子树寻找插入位置
        if(result < 0){
            p.leftChild = add(data,p.leftChild);
            //插入后计算子树的高度,等于2则需要重新恢复平衡,由于是左边插入,左子树的高度肯定大于等于右子树的高度
            if(height(p.leftChild) - height(p.rightChild) == 2){
                //判断data是插入点的左孩子还是右孩子
                if(data.compareTo(p.leftChild.data) < 0){
                    //进行LL旋转
                    p = singleRotateLeft(p);
                }else {
                    //进行左右旋转
                    p = doubleRotateWithLeft(p);
                }
            }
        }else if (result > 0){
            //向右子树寻找插入位置
            p.rightChild = add(data,p.rightChild);
            if(height(p.rightChild) - height(p.leftChild) == 2){
                if (data.compareTo(p.rightChild.data) < 0){
                    //进行右左旋转
                    p = doubleRotateWithRight(p);
                }else {
                    p = singleRotateRight(p);
                }
            }
        } else{
            //重新计算各个结点的高度
            p.height = Math.max( height( p.leftChild ), height( p.rightChild ) ) + 1;
        }
        return p;
    }

    /**
     * 删除
     * @param data
     */
    public void remove(T data) {
        if (data == null){
            throw new RuntimeException("删除数据不能为空");
        }
        this.root = remove(data,root);
    }

    /**
     * 删除结点
     * @param data
     * @param p
     * @return
     */
    public AVLNode<T> remove(T data,AVLNode<T> p){
        if(p == null){
            return null;
        }
        int result = data.compareTo(p.data);
        //从左子树查找需要删除的元素
        if(result < 0){
            p.leftChild=remove(data,p.leftChild);
            //检测是否平衡
            if(height(p.rightChild) - height(p.leftChild) == 2){
                AVLNode<T> currentNode = p.rightChild;
                //判断需要哪种旋转
                if(height(currentNode.leftChild) > height(currentNode.rightChild)){
                    //RL
                    p = doubleRotateWithRight(p);
                }else{
                    //RR
                    p = singleRotateRight(p);
                }
            }
        }
        //从右子树查找需要删除的元素
        else if(result > 0){
            p.rightChild = remove(data,p.rightChild);
            //检测是否平衡
            if(height(p.leftChild)-height(p.rightChild) == 2){
                AVLNode<T> currentNode = p.leftChild;
                //判断需要那种旋转
                if(height(currentNode.rightChild)>height(currentNode.leftChild)){
                    //LR
                    p = doubleRotateWithLeft(p);
                }else{
                    //LL
                    p = singleRotateLeft(p);
                }
            }
        }
        //已找到需要删除的元素,并且要删除的结点拥有两个子节点
        else if(p.rightChild != null&&p.leftChild != null){
            //寻找替换结点
            p.data = findMin(p.rightChild).data;
            //移除用于替换的结点
            p.rightChild = remove( p.data, p.rightChild );
        } else {
            //只有一个孩子结点或者只是叶子结点的情况
            p = (p.leftChild!=null) ? p.leftChild : p.rightChild;
        }
        //更新高度
        if(p != null)
            p.height = Math.max( height( p.leftChild), height( p.rightChild)) + 1;
        return p;
    }

    /**
     * 查找最小值结点
     * @return
     */
    public T findMin() {
        return findMin(root).data;
    }

    /**
     * 查找最小值结点
     * @param p
     * @return
     */
    public AVLNode<T> findMin(AVLNode<T> p){
        if (p == null){
            return null;
        }
        //如果没有左结点,那么t就是最小的
        else if (p.leftChild == null){
            return p;
        }
        return findMin(p.leftChild);
    }

    /**
     * 查找最大值结点
     * @return
     */
    public T findMax() {
        return findMax(root).data;
    }

    /**
     * 查找最大值结点
     * @param p
     * @return
     */
    public AVLNode<T> findMax(AVLNode<T> p){
        if (p == null){
            return null;
        }
        //如果没有右结点,那么p就是最大的
        else if (p.rightChild == null){
            return p;
        }
        return findMax(p.rightChild);
    }

    /**
     * 是否包含该数据
     * @param data
     * @return
     */
    public boolean contains(T data) {
        return data != null && contain(data, root);
    }

    public boolean contain(T data , AVLNode<T> subtree){
        if (subtree == null){
            return false;
        }
        int result = data.compareTo(subtree.data);
        if (result < 0){
            return contain(data,subtree.leftChild);
        }else if(result > 0){
            return contain(data,subtree.rightChild);
        }else {
            return true;
        }
    }

    /**
     * 清空树
     */
    public void clear() {
        this.root=null;
    }

    /**
     * 左左单旋转(LL旋转)，y变为x的根结点, x变为y的右子树
     * @param x 结点
     * @return
     */
    public AVLNode<T> singleRotateLeft(AVLNode<T> x){
        //把w结点旋转为根结点
        AVLNode<T> y = x.leftChild;
        //同时w的右子树变为x的左子树
        x.leftChild = y.rightChild;
        //x变为w的右子树
        y.rightChild = x;
        //重新计算x/w的高度
        x.height = Math.max(height(x.leftChild), height(x.rightChild)) + 1;
        y.height = Math.max(height(y.leftChild), x.height) + 1;
        return y;//返回新的根结点
    }

    /**
     * 右右单旋转(RR旋转)，x变为y的根结点, y变为x的左子树
     * @return
     */
    public AVLNode<T> singleRotateRight(AVLNode<T> y){
        AVLNode<T> x = y.rightChild;
        y.rightChild = x.leftChild;
        x.leftChild = y;
        //重新计算x/w的高度
        x.height = Math.max(height(x.leftChild), y.height) + 1;
        y.height = Math.max(height(y.leftChild), height(y.rightChild)) + 1;
        //返回新的根结点
        return x;
    }

    /**
     * 左右旋转(LR旋转)，x(根)变为y结点，把y变成根结点
     * @return
     */
    public AVLNode<T> doubleRotateWithLeft(AVLNode<T> x){
        //w先进行RR旋转
        x.leftChild = singleRotateRight(x.leftChild);
        //再进行x的LL旋转
        return singleRotateLeft(x);
    }

    /**
     * 右左旋转(RL旋转)
     * @param y
     * @return
     */
    public AVLNode<T> doubleRotateWithRight(AVLNode<T> y){
        //先进行LL旋转
        y.rightChild = singleRotateLeft(y.rightChild);
        //再进行RR旋转
        return singleRotateRight(y);
    }

    /**
     * 输出树
     * @param t
     */
    public void printTree( AVLNode<T> t ) {
        if( t != null ) {
            printTree(t.leftChild );
            System.out.print(t.data + " ");
            printTree(t.rightChild );
        }
    }

}
