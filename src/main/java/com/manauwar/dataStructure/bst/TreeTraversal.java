package com.manauwar.dataStructure.bst;

import com.manauwar.dataStructure.bst.BinaryTree;
import com.manauwar.dataStructure.bst.BinaryTree.TreeNode;

/*
 * Java Program to traverse a binary tree using PreOrder traversal. 
 * In PreOrder the node value is printed first, followed by visit
 * to left and right subtree. 
 * input:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 
 * output: 1 2 3 4 5 6 
 */

public class TreeTraversal {

	public static void main(String[] args) throws Exception {

		// construct the binary tree given in question
		BinaryTree bt = new BinaryTree();
		BinaryTree.TreeNode root = new BinaryTree.TreeNode("1");
		bt.root = root;
		bt.root.left = new BinaryTree.TreeNode("2");
		bt.root.left.left = new BinaryTree.TreeNode("3");

		bt.root.left.right = new BinaryTree.TreeNode("4");
		bt.root.right = new BinaryTree.TreeNode("5");
		bt.root.right.right = new BinaryTree.TreeNode("6");

		// printing nodes in recursive preOrder traversal algorithm
		bt.preOrder();

		System.out.println();

		// traversing binary tree in PreOrder without using recursion
		bt.preOrderWithoutRecursion();

		// In order Traversal
		BinaryTree btree = create();

		btree.inOrder();
		System.out.println();
		btree.inOrderWithoutRecursion();

		// printing all leaf nodes

		BinaryTree bt3 = create();
		System.out.println();
		bt3.printLeaves();

	}

	public static BinaryTree create() {
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode("4");
		tree.root = root;
		tree.root.left = new TreeNode("2");
		tree.root.left.left = new TreeNode("1");

		tree.root.left.right = new TreeNode("3");
		tree.root.right = new TreeNode("5");
		tree.root.right.right = new TreeNode("6");

		return tree;
	}

}
