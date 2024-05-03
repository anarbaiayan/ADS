package org.example;

public class BST <K extends Comparable<K>, V>{
    private TreeNode root;
    private int size;
    private class TreeNode {
        private K key;
        private V value;
        private TreeNode left, right;
        public TreeNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public void put(K key, V value){
        if(size == 0){
            root.key = key;
            root.value = value;
        } else{
            TreeNode NewNode = root;
            while(NewNode != null){
                if(key.compareTo(NewNode.key) < 0){
                    NewNode = NewNode.left;
                }else if(key.compareTo(NewNode.key) > 0){
                    NewNode = NewNode.right;
                }
            }
            NewNode.key = key;
            NewNode.value = value;
        }
        size++;
    }

    public V get(K key){
        TreeNode NewNode = root;
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
        TreeNode NewNode = root;

    }
    public Iterable<K> Iterator(){

    }
}
