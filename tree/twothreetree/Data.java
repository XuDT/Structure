package com.xudt.algorithm.structure.tree.twothreetree;

/**
 * @Description: 数据项
 * @Author: XuDT
 */
public class Data {
    public long data;
    public Data(long data){
        this.data = data;
    }
    public void displayItem(){
        System.out.println("/" + data);
    }
}
