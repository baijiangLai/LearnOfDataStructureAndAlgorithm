package com.laibaijiang;

import java.util.HashMap;
import java.util.Map;

/**
 * 理解题意：
 * 1. 只会调用两个两个函数：get、put
 *  1.1： get如果在cache中，那么久返回对应数
 *  1.2： put向里面放；前提：cache中有该数，那么该数将被更新值且置顶；如果put的数在cache中没有，那么判断此时cache中的数有没有超过cache大小，超过了，那么删除最久没有使用的数
 *
 *
 *
 *  思路：
 *  1. 根据题意的理解，那么就使用map + 双向链表的方式解决
 *  2. map的key：当前数，value：该数对应的node
 *
 *  问题：
 *  1. 为什么使用map？（map可以很好的用来模拟cache，根据题目描述，其特点与map的put、get相似）
 */
public class LRUCache {
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> cache = new HashMap<>();
    int capacity;
    int size = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null){
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        //看cache中是否存在该节点
        Node node = cache.get(key);
        if (node == null) {
            //新增加的数
            Node newNode = new Node(key, value);
            cache.put(key,newNode);
            add2Head(newNode);
            ++size;
            if (size > capacity){
                Node tailNode = removeTail();
                --size;
                cache.remove(tailNode.key);
            }
        }else {
            node.value = value;
            move2Head(node);
        }
    }

    private void add2Head(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void move2Head(Node node) {
        removeNode(node);
        add2Head(node);
    }

    private Node removeTail() {
        Node tailNode = tail.pre;
        removeNode(tailNode);
        return tailNode;
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
