package com.datastructure.tree;

public class MyTree {
	
	/**
	 * A complete binary tree is a binary tree in which all the levels are completely filled 
	 * except possibly the lowest one, which is filled from the left.
	 * 
	 *              A
	 *             / \
	 *            B   c
	 *           / \
	 *          D   E
	 * 
	 * 
	 * -------------------------- A B C D E 0-1-2-3-4 <= index
	 * 
	 * Left Node = 2*n + 1 Right Node = 2*n + 2 Root Node = n/2
	 * 
	 * Where n = index
	 * 
	 * 1. Find the total no. of nodes 2. Index value equal to total no of nodes.
	 * 
	 */
	public static void isCompleteBinaryTree(Node root) {
		int totalNoOfNodes = findTotalNodes(root);
		System.out.println(totalNoOfNodes);
		
		if(check(root, 0 , totalNoOfNodes)) {
			System.out.println("Complete");
		}else {
			System.out.println("Not Complete");
		}

	}

	public static int findTotalNodes(Node root) {

		if (root == null)
			return 0;

		return (1 + findTotalNodes(root.left) + findTotalNodes(root.right));

	}

	public static boolean check(Node root, int index, int totalNodes) {

		if (root == null)
			return true;

		System.out.println("Index:" + index);
		if (index >= totalNodes)
			return false;

		return (check(root.left, 2 * index + 1, totalNodes) && check(root.right, 2 * index + 2, totalNodes));

	}

	private static class Node {
		String data;
		Node left = null, right = null;

		public Node(String data, Node left, Node right) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String args[]) {
		Node node1 = new Node("A", null, null);

		node1.left = new Node("B", null, null);

		node1.right = new Node("C", null, null);
		
		node1.right.left = new Node("F", null, null);

		node1.left.left = new Node("D", null, null);

		node1.left.right = new Node("E", null, null);

		isCompleteBinaryTree(node1);
	}

}
