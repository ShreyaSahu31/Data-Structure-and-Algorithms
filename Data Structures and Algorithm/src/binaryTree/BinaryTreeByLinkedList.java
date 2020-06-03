package binaryTree;

import java.util.*;
import node.BinaryNode;

public class BinaryTreeByLinkedList {

	protected BinaryNode root;
	
	public BinaryTreeByLinkedList() {
		this.root = null;
	}
	
	//pre-order traversal of binary tree
	public void preOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}
	
	//in-order traversal of binary tree
	public void inOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRight());
	}
	
	//post-order traversal of binary tree
	public void postOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}
	
	//level order traversal of binary tree
	public void levelOrder() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		BinaryNode presentNode = new BinaryNode();
		queue.add(root);
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if(presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if(presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}
	
	//inserting a node in binary tree
	public void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if(root == null) {
			root = node;
			System.out.println("Successfully inserted the node :" + value);
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		BinaryNode presentNode = new BinaryNode();
		queue.add(root);
		while( ! queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.getLeft() == null) {
				presentNode.setLeft(node);
				System.out.println("Successfully inserted the node :" + value);
				return;
			}
			else if(presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted the node :" + value);
				return;
			}
			else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
		}
	}
	
	//searching a node in a binary tree
	 public void search(int value) {
		BinaryNode presentNode = new BinaryNode();
		Boolean isFound = false;
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.getValue() == value) {
				System.out.println("Value :" + value + " Found in the tree.");
				isFound = true;
				return;
			}
			else {
				if(presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if(presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}
		if(!isFound)
			System.out.println("Value : " + value + " not found");
	}
	 
	 //getting last node of last level of binary tree
	 public BinaryNode getDeepestNode() {
		 BinaryNode presentNode = new BinaryNode();
		 Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				presentNode = queue.remove();
				if(presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if(presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
			return presentNode;
	 }
	 
	 // deleting the deepest node
	 public void DeleteDeepestNode(){
		 BinaryNode presentNode = new BinaryNode();
		 BinaryNode previousNode = new BinaryNode();
		 Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		 queue.add(root);
		 while(!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if(presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			}
			else if(presentNode.getRight() == null) {
				presentNode.setLeft(null);
				return;
			}
			else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}

		}
		 
	 }
	 
	 public void deleteNodeOfBinaryTree(int value) {
		 Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		 BinaryNode presentNode = new BinaryNode();
		 Boolean isDelete = false;
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 presentNode = queue.remove();
			 if(presentNode.getValue() == value) {
				 presentNode.setValue(getDeepestNode().getValue());
				 DeleteDeepestNode();
				 System.out.println("Value" + value + "is Successfully Deleted");
				 isDelete = true;
				 return;
			 }
			 else {
				if(presentNode.getLeft() != null)
					 queue.add(presentNode.getLeft());
				if(presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			 }
			 
		 }
		 if(!isDelete)
			 System.out.println("Value" + value + "not found to delete");
	 }
	 
	// Delete Tree
	void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}
	
}
