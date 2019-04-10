package com.manauwar.dataStructure.bst;

import java.util.Stack;

public class BinaryTree {
	
	
	static class TreeNode
	{
		String data;
		TreeNode left, right;
		
		public TreeNode(String value) {
			
			this.data = value;
			this.left = this.right = null;
			
		}
		
		boolean isLeaf() {
			
			return left == null ? right == null : false;
						
		}
	}
	
	
	TreeNode root;
	
	
	public void preOrder()
	{
		System.out.println("PreOrder Traversal");
		preOrder(root);
	}
	
	
	
	/* Preorder traversal with recursion   */
	private void preOrder(TreeNode node)
	{
		if(node == null)
		{
			return;
		}
		
		System.out.printf("%s ", node.data);
		
		preOrder(node.left);
		preOrder(node.right);
		
	}
	
	
	/*  preorder traversal without recursion       */
	
	
	public void preOrderWithoutRecursion()
	{
		Stack<TreeNode> nodes = new Stack<>();
		
		nodes.push(root);
		
		while(!nodes.isEmpty())
		{
			TreeNode current = nodes.pop();
			System.out.printf("%s ", current.data);
			
			
			if(current.right != null)
			{
				nodes.push(current.right);
			}
			
			if(current.left != null)
			{
				nodes.push(current.left);
			}
		}
				
	}
	
	
	
	public void inOrder()
	{
		System.out.println();
		System.out.println("In order traversal");
		inOrder(root);
	}
	
	private void inOrder(TreeNode node)
	{
		if(node == null)
		{
			return;
		}
		
		inOrder(node.left);
		System.out.printf("%s ",node.data);
		inOrder(node.right);
		
	}
	
	public void inOrderWithoutRecursion() {
	    Stack<TreeNode> nodes = new Stack<>();
	    TreeNode current = root;

	    while (!nodes.isEmpty() || current != null) {

	      if (current != null) {
	        nodes.push(current);
	        current = current.left;
	      } else {
	        TreeNode node = nodes.pop();
	        System.out.printf("%s ", node.data);
	        current = node.right;
	      }

	    }
	  }

	
	public void printLeaves()
	{
		printLeaves(root);
	}
	

	private static void printLeaves(TreeNode node) {
	    // base case
	    if (node == null) {
	      return;
	    }

	    if (node.isLeaf()) {
	      System.out.printf("%s ", node.data);
	    }

	    printLeaves(node.left);
	    printLeaves(node.right);

	  }



		
}
