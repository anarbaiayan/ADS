package org.example;
import java.util.Iterator;

public class BST<K extends Comparable<K> , V> implements Iterable<K>{
    private TreeNode root;
    private int size;
    private class TreeNode {
        private K key;
        private V value;
        private int length = 1;
        private TreeNode left, right;
        public TreeNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public BST() {
        root = null;
        size = 0;
    }
    public void put(K key, V value){
        if(root == null){
            root = new TreeNode(key, value);
            size++;
            return;
        }
        TreeNode current = root;
        while(true){
            if(key.compareTo(current.key) < 0){
                if(current.left != null) current = current.left;
                else{
                    current.left = new TreeNode(key, value);
                    size++;
                    return;
                }
            }else if(key.compareTo(current.key) > 0){
                if(current.right != null) current = current.right;
                else{
                    current.right = new TreeNode(key, value);
                    size++;
                    return;
                }
            } else{
                current.value = value;
                current.length--;
                return;
            }
        }
    }

    public V get(K key) {
        return get(root , key);
    }

    public V get(TreeNode NewNode, K key){
        if(NewNode == null){
            return null;
        }
        while(NewNode != null){
            if(NewNode.key.equals(key)){
                return NewNode.value;
            }
            if(key.compareTo(NewNode.key) < 0){
                NewNode = NewNode.left;
            }else if(key.compareTo(NewNode.key) > 0){
                NewNode = NewNode.right;
            }
        }
        return null;
    }

    public void delete(K key){
        if(root == null){
            return;
        }
        TreeNode parent = null;
        TreeNode current = root;
        boolean child = false;

        while(current != null){
            current.length--;
            if(key.compareTo(current.key)<0){
                parent = current;
                current = current.left;
            }else if(key.compareTo(current.key)>0){
                parent = current;
                current = current.right;
            }else{
                if(current.left != null && current.right != null){
                    child = true;
                    TreeNode temp = current;
                    parent = current;
                    current = current.right;
                    while(current.left != null){
                        parent = current;
                        current = current.left;
                    }
                    temp.key = current.key;
                    temp.value = current.value;
                    current.length++;
                }
                break;
            }
        }
        if (current == null){
            return;
        }
        TreeNode temp;
        if(current.left != null){
            temp = current.left;
        }else if(current.right != null){
            temp = current.right;
        }else{
            temp = null;
        }

        if(parent == null){
            root = temp;
        }else if(parent.left == current){
            parent.left = temp;
        }else{
            parent.right = temp;
        }
        if(!child){
            size--;
        }
    }

    public Iterator<K> iterator(){
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<K> {
        private MyQueue<K> queue = new MyQueue<>();
        public BSTIterator() {
            inOrder(root);
        }

        private void inOrder(TreeNode node) {
            if(node == null) return;
            inOrder(node.left);
            queue.enqueue(node.key);
            inOrder(node.right);
        }
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        public K next() {
            return queue.dequeue();
        }

    }

}
