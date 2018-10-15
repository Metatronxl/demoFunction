package com.example.demo.TrieDemo;


import com.google.common.base.CharMatcher;
import org.apache.commons.lang.StringUtils;


/**
 * @author lei.X
 * @date 2018/8/23
 */
public class Trie {

    //各个节点的子树数目即字符串中的字符出现的最多种类
    private final int SIZE = 26;
    //除根节点外其他所有子节点的数目
    private int numNode;
    //树的深度即最长字符串的长度
    private int depth;
    //字典树的根
    private TrieNode root;


    public Trie() {
        this.numNode = 0;
        this.depth = 0;
        this.root = new TrieNode();
    }


    /**
     * 字典树节点类，为私有内部类
     */
    private class TrieNode {

        // 所有的儿子节点或者一级子节点
        private TrieNode[] son;
        // 有多少字符串经过或到达这个节点,即节点字符出现的次数
        private int numPass;
        // 有多少字符串通过这个节点并到此结束的数量
        private int numEnd;
        // 是否有结束节点
        private boolean isEnd;
        // 节点的值
        private char value;

        /**
         * 初始化节点类
         */
        public TrieNode() {
            this.numPass = 0;
            this.numEnd = 0;
            this.son = new TrieNode[SIZE];
            this.isEnd = false;
        }
    }

    private boolean isStrOfLetter(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        if (!CharMatcher.javaLetter().matchesAllOf(str)) {
            return false;
        }
        return true;
    }

    /**
     * 构建树的过程
     *
     * @param str
     * @return
     */
    public boolean insertStr(String str) {
        if (!isStrOfLetter(str)) {
            return false;
        }

        str = str.toLowerCase();
        char[] letters = str.toCharArray();
        TrieNode node = this.root;
        for (char c : letters) {
            int pos = c - 'a';
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].value = c;
                node.son[pos].numPass = 1;
                this.numNode++;
            } else {
                node.son[pos].numPass++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
        node.numEnd++;
        if (letters.length > this.depth) {
            this.depth = letters.length;
        }

        return true;
    }

    /**
     * 查找是否存在以某前缀开头的字符串方法出现
     *
     * @param str
     * @return
     */

    public boolean isContainPrefix(String str) {
        if (!isStrOfLetter(str)) return false;
        str = str.toLowerCase();
        char[] letters = str.toCharArray();
        TrieNode node = this.root;
        for (char c : letters) {
            int pos = c - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }
        return true;
    }




}
