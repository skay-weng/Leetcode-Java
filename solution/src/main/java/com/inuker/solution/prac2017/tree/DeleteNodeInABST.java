package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/24.
 */

public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            root.val = node.val;
            root.right = deleteNode(root.right, node.val);
        }
        return root;
    }
}
