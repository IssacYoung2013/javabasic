package com.interview.javabasic.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author:  ywy
 * date:    2019-02-26
 * desc:
 */
public class BST<Key extends Comparable, Value> {

    private class Node {
        private Key key;
        private Value value;

        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int count;

    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Key key, Value value) {

        root = BST.this.insert(root, key, value);
    }

    public boolean contains(Key key) {
        return contains(root, key);
    }

    private boolean contains(Node node, Key key) {
        if (node == null) {
            return false;
        }
        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    public Value search(Key key) {
        return search(root, key);
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }


    /**
     * 以node 为根的二叉搜索树中 插入节点 （key,value ）
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, Key key, Value value) {

        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");

        }
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.print(node.key + " ");
            
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }
        
    }


    public static void main(String[] args) {
        int N = 15;
        Integer[] arr = SortTestHelper.generateNearlyOrderArray(N,100);

        BST<Integer,String> bst = new BST<>();
        for (int i = 0; i < N; i++) {
            bst.insert(new Integer(arr[i]),Integer.toString(arr[i]));
        }

        bst.levelOrder();
        System.out.println();
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();

        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(new Integer(i));
            if(i < N) {
                assert res.equals(Integer.toString(i));
            }
            else {
                assert res == null;
            }
        }
    }
}
