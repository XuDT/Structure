package com.xudt.algorithm.string;

/**
 * @Description: 实现串的匹配
 * @Author: XuDT
 */
public class StringMatch {
    public static void main(String[] args){
        String str = "helloworld";
        String subStr = "world";
        for (int i = 0; i < str.length(); i++){
            for (int j = 0; j < subStr.length(); j++){
                if (str.charAt(i) == subStr.charAt(j)){
                    if (j == subStr.length() - 1){
                        System.out.println(i-j);
                    }
                    ++i;
                }else {
                    break;
                }
            }
        }
    }
}
