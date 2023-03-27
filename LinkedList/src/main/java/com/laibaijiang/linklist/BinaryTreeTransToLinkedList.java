package com.laibaijiang.linklist;

import com.laibaijiang.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTransToLinkedList {
    /**
     * 本题的解答思路1：
     * 常规解法：先序遍历
     */
    private List<TreeNode> list = new ArrayList<>();
    public void flatten1(TreeNode root){
        dfs(root);
        int size = list.size();
        if (size == 0){
            return;
        }
        root = list.get(0);
        for (int i = 1; i < size; i++) {
            TreeNode node = list.get(i);
            root.left = null;
            root.right = node;
            root = root.right;
        }
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }


    /**
     * 思路2：
     * 使用栈：
     * 1. 将root入栈，记录pre = null
     * 2. 只要栈不为空，pop出栈的节点，记得将pre设值为cur(这是最后一步)
     * 3. 查看前序节点Pre是否有值，如果有，那么将记录前序节点pre的左端置为null。右端置为当前pop出来的节点
     * 4. 分别取出当前节点的左右子孩子，如果左节点不为空，那么先将右节点入栈，之后再判断右节点是否为空，再将其入栈(这一步的目的：保持每次弹出的时候先弹出左节点)
     * @param root
     */
    public void flatten2(TreeNode root){
        if (root == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        TreeNode pre = null;

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();

            if (pre != null){
                pre.left = null;
                pre.right = cur;
            }

            TreeNode left = cur.left;
            TreeNode right = cur.right;

            if (left != null){
                stack.push(right);
            }
            if (right != null){
                stack.push(left);
            }

            pre = cur;
        }
    }
}
